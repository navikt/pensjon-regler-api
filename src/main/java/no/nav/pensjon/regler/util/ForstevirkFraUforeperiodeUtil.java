package no.nav.pensjon.regler.util;

import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2011;
import no.nav.pensjon.regler.domain.grunnlag.PersonDetalj;
import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag;
import no.nav.pensjon.regler.domain.grunnlag.Uforeperiode;
import no.nav.pensjon.regler.domain.krav.Kravhode;
import no.nav.pensjon.regler.domain.krav.Kravlinje;
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak;
import no.nav.pensjon.regler.to.TrygdetidRequest;

import java.util.*;

/**
 * Samling av metoder som brukes for � gjennomf�re CR81364.
 * Trukket ut i egen klasse siden de b�de brukes av BlazeService og DefaultRegelservice,
 * og bare b�r vedlikeholdes ett sted.
 *
 * @author oma2812/and2812
 */

public class ForstevirkFraUforeperiodeUtil {


    /**
     * Kopierer et Kravhode, m� finnes et krav som er BP,GJP eller GJR, en uf�reperiode med uforetype "VIRK_IKKE_UFOR"
     * og en grunnlagsrolle MOR,FAR ellerAVDOD.
     *
     * @param kravhode
     * @return en kopi av kravhode eller null hvis ikke kriteria er tilfredsstilt.
     */
    public static Kravhode kopierKravhodeKonverteringsHack(Kravhode kravhode) {
        boolean funnet = false;
        if (kravhode != null) {
            for (Kravlinje kravlinje : kravhode.getKravlinjeListe()) {
				if ((kravlinje.getKravlinjeType().getKode().equals("GJP") && kravlinje.getKravlinjeType().isHovedKravlinje())
						|| (kravlinje.getKravlinjeType().getKode().equals("GJR") && !kravlinje.getKravlinjeType().isHovedKravlinje())
						|| (kravlinje.getKravlinjeType().getKode().equals("BP") && kravlinje.getKravlinjeType().isHovedKravlinje())) {
					funnet = true;
					break;
				}
            }
        }
        if (!funnet)
            return null;

        funnet = false;
        for (Persongrunnlag p : kravhode.getPersongrunnlagListe()) {
            if (p.getUforeHistorikk() != null) {
                for (Uforeperiode up : p.getUforeHistorikk().getUforeperiodeListe()) {
					if (up.getUforeType().getKode().equals("VIRK_IKKE_UFOR")) {
						funnet = true;
						break;
					}
                }
            }
        }
        if (!funnet)
            return null;

        for (Persongrunnlag p : kravhode.getPersongrunnlagListe()) {
            for (PersonDetalj pd : p.getPersonDetaljListe()) {
                if (pd.getGrunnlagsrolle().getKode().equals("AVDOD")
                        || pd.getGrunnlagsrolle().getKode().equals("MOR")
                        || pd.getGrunnlagsrolle().getKode().equals("FAR")
                ) {
                    return new Kravhode(kravhode);
                }
            }
        }
        return null;
    }


    /**
     * Returnerer en kopi av vedtakslisten dersom:
     * - det finnes et krav som er GJP eller GJR og
     * - det finnes en uf�reperiode med uforetype "VIRK_IKKE_UFOR" og
     * - det finnes en grunnlagsrolle AVDOD.
     *
     * @return en kopi av vlist eller null hvis ikke alle kriteria er tilfredsstilt.
     */
    public static List<VilkarsVedtak> kopierVilkarsVedtakKonverteringsHack(List<Persongrunnlag> pglist, List<VilkarsVedtak> vlist) {
        boolean funnet = false;
        for (VilkarsVedtak vedtak : vlist) {
            Kravlinje kravlinje = vedtak.getKravlinje();
			if ((kravlinje.getKravlinjeType().getKode().equals("GJP") && kravlinje.getKravlinjeType().isHovedKravlinje())
					|| (kravlinje.getKravlinjeType().getKode().equals("GJR") && !kravlinje.getKravlinjeType().isHovedKravlinje())
					|| (kravlinje.getKravlinjeType().getKode().equals("BP") && kravlinje.getKravlinjeType().isHovedKravlinje())) {
				funnet = true;
				break;
			}
        }
        if (!funnet)
            return null;

        funnet = false;
        if (pglist != null) {
            for (Persongrunnlag p : pglist) {
                if (p.getUforeHistorikk() != null) {
                    for (Uforeperiode up : p.getUforeHistorikk().getUforeperiodeListe()) {
						if (up.getUforeType().getKode().equals("VIRK_IKKE_UFOR")) {
							funnet = true;
							break;
						}
                    }
                }
            }
        }
        if (!funnet)
            return null;

        for (Persongrunnlag p : pglist) {
            for (PersonDetalj pd : p.getPersonDetaljListe()) {
                if (pd.getGrunnlagsrolle().getKode().equals("AVDOD")
                        || pd.getGrunnlagsrolle().getKode().equals("MOR")
                        || pd.getGrunnlagsrolle().getKode().equals("FAR")
                ) {
                    List<VilkarsVedtak> vedtakliste = new ArrayList<VilkarsVedtak>();
                    for (VilkarsVedtak vedtak : vlist)
                        vedtakliste.add(vedtak);
                    return vedtakliste;
                }
            }
        }
        return null;
    }

    /**
     * Metoden setter forsteVirk p� vedtak og fjerner uf�reperioder fra persongrunnlag dersom kriteriene under er tifredsstilt.
     * 1. kravet m� v�re GJP, GJR eller BP.
     * 2. uf�reperioden m� v�re av type VIRK_IKKE_UFOR.
     * Hvis GJP forsteVirk p� soker.vedtak.forsteVirk er tidligste dato av uf�reperioden.uft og soker.vedtak.forsteVirk
     * Hvis GJR forsteVirk p� avdod.vedtak er tidligste dato av uf�reperioden.uft og avdod.vedtak.forsteVirk.
     * Hvis BP settes persongrunnlag.PREG_forsteVirk for MOR og FAR.
     */
    public static void settForsteVirkHack(List<Persongrunnlag> plist, List<VilkarsVedtak> vlist) {
        VilkarsVedtak vedtakToChange = null;
        VilkarsVedtak hovedVedtak = null;
        Hashtable<Date, Persongrunnlag> ht = new Hashtable<Date, Persongrunnlag>();

        //List<Uforeperiode> fjerneperioder = new ArrayList<Uforeperiode>();
        // finn uft i aktuell uf�reperiode(r)
        for (Persongrunnlag p : plist) {
            if (p.getPersonDetaljListe() != null) {
                for (PersonDetalj pd : p.getPersonDetaljListe()) {
                    if (pd.getGrunnlagsrolle().getKode().equals("AVDOD")
                            || pd.getGrunnlagsrolle().getKode().equals("MOR")
                            || pd.getGrunnlagsrolle().getKode().equals("FAR")) {
                        if (p.getUforeHistorikk() != null) {
                            List<Uforeperiode> uplist = p.getUforeHistorikk().getUforeperiodeListe();
                            for (Uforeperiode up : uplist) {
                                if (up.getUforeType().getKode().equals("VIRK_IKKE_UFOR")) {
                                    ht.put(up.getUft(), p);
                                }
                            }
                        }
                    }
                }
            }
        }

        // Avslutt dersom ingen tilfeller.
        if (ht.isEmpty()) {
            return;
        }

        // finn hovedvedtaket
        for (VilkarsVedtak v : vlist) {
            if (v.getKravlinje().getKravlinjeType().isHovedKravlinje()) {
                hovedVedtak = v;
                break;
            }
        }

        // h�ndterer BP, alle persongrunnlag med rolle MOR eller FAR skal f� satt PREG_forsteVirk
        if (hovedVedtak != null && hovedVedtak.getKravlinjeType().getKode().equals("BP")) {
            //System.out.println(">>>>>>>>>>>> settF�rsteVirkKonverteringsHack BP  ");
//			if ( ht.size() == 0 && log.isDebugEnabled()) {
//				//log.debug("settF�rsteVirkKonverteringsHack BP, VIRK_IKKE_UFOR: tom hashtable skal ikke kunne skje ");
//			}
            for (Enumeration<Date> e = ht.keys(); e.hasMoreElements(); ) {
                Date uft = e.nextElement();
                Persongrunnlag p = ht.get(uft);
                p.setPREG_forsteVirk(uft);
                //if (log.isDebugEnabled() && p.getPenPerson() != null)
                //	log.debug("settF�rsteVirkKonverteringsHack BP setter forsteVirk for person " + p.getPenPerson().getPenPersonId()+" " + uft);
            }
            ht.clear();
            return;
        }

        // h�ndterer GJP og GJR
        // JSA2812 20.04.2009: Satte tidligere kun f�rsteVirk dersom listen av UFT/Persongrunnlag kombinasjoner inneholdt SOKER.
        // Setter n� f�rsteVirk dersom VIRK_IKKE_UFOR perioden ble oppdaget ogs� p� AVDOD. SOKER selv har eget GJP vedtak hvor
        // f�rsteVirk ikke m� p�virkes av avd�des VIRK_IKKE_UFOR perioder (GP regelsett m� vite s�kers egen f�rsteVirk, selv om avd�de har tidligere dato).
        Date uft = ht.keys().nextElement(); // kun ett element i tabellen
        for (VilkarsVedtak v : vlist) {
            if (v.getKravlinje().getKravlinjeType().getKode().equals("GJP")) {
                Persongrunnlag p = ht.get(uft);
                if (p.getPersonDetaljListe() != null) {
                    for (PersonDetalj pd : p.getPersonDetaljListe()) {
                        if (pd.getGrunnlagsrolle().getKode().equals("AVDOD")) {
                            p.setPREG_forsteVirk(uft);
//							if (log.isDebugEnabled())
//								log.debug("settF�rsteVirkKonverteringsHack GJP-AVDOD uft: " + uft);
                        }
                        if (pd.getGrunnlagsrolle().getKode().equals("SOKER") && v.getForsteVirk().getTime() > uft.getTime()) {
                            v.setForsteVirk(uft);
//							if (log.isDebugEnabled())
//								log.debug("settF�rsteVirkKonverteringsHack GJP-SOKER uft minst: " + uft);
                        }
                    }
                }
                vedtakToChange = v;
                break;
            }
            if (v.getKravlinje().getKravlinjeType().getKode().equals("GJR")) {
                vedtakToChange = v;
                break;
            }
        }
        // Sett forsteVirk p� vedtaket - bruk den tidligste datoen av uf�reperioden.uft og vedtaket sin forsteVirk
        if (vedtakToChange != null && vedtakToChange.getForsteVirk().getTime() > uft.getTime()
                && !vedtakToChange.getKravlinje().getKravlinjeType().getKode().equals("GJP")) {
            vedtakToChange.setForsteVirk(uft);
            {
//			if (log.isDebugEnabled())
//				log.debug("settF�rsteVirkKonverteringsHack uft minst ");
            }
        }
//		else {
//			if (log.isDebugEnabled())
//				log.debug("settF�rsteVirkKonverteringsHack opprinnelig forsteVirk minst ");
//		}
        ht.clear();
    }

    public static void fjernSykeUforeperioder(List<Persongrunnlag> pgliste) {
        if (pgliste != null) {
            for (Persongrunnlag pg : pgliste) {
                fjernSykeUforeperioder(pg);
            }
        }
    }

    /**
     * Her blir alle uforeperioder av type VIRK_IKKE_UFOR fjernet fra et persongrunnlag.
     *
     * @param pg persongrunnlag
     */
    public static void fjernSykeUforeperioder(Persongrunnlag pg) {
        List<Uforeperiode> fjerneperioder = new ArrayList<Uforeperiode>();
        if (pg != null) {
            if (pg.getUforeHistorikk() != null && pg.getUforeHistorikk().getUforeperiodeListe() != null) {
                List<Uforeperiode> uplist = pg.getUforeHistorikk().getUforeperiodeListe();
                for (Uforeperiode up : uplist) {
                    if (up.getUforeType() != null && up.getUforeType().getKode() != null && up.getUforeType().getKode().equals("VIRK_IKKE_UFOR")) {
                        fjerneperioder.add(up);
                    }
                }
                // fjern periodene
//				if (log.isDebugEnabled())
//					log.debug("<<<<<<<<<<<<<<<<< fjernSykeUf�reperioder fjerner " + fjerneperioder.size());
                if (fjerneperioder.size() > 0) {
                    uplist.removeAll(fjerneperioder);
                    fjerneperioder.clear();
                }
            }
        }
    }

    /**
     * @param kravhode
     * @param vilkarsvedtakListe
     * @return Kravhode eller null
     * <p>
     * Samlemetode for Hacket p�tvunget av CR81364
     */
    public static Kravhode forsteVirkHack(Kravhode kravhode, List<VilkarsVedtak> vilkarsvedtakListe) {
        Kravhode kopiKravhode = null;
        if (kravhode != null) {
            kopiKravhode = kopierKravhodeKonverteringsHack(kravhode);
        }

        if (kopiKravhode != null) {
            if (vilkarsvedtakListe != null) {
                settForsteVirkHack(kravhode.getPersongrunnlagListe(), vilkarsvedtakListe);
            }

        }

        //Fjern syke uf�reperioder.
        if (kravhode != null && kravhode.getPersongrunnlagListe() != null) {
            fjernSykeUforeperioder(kravhode.getPersongrunnlagListe());
        }

        return kopiKravhode;
    }

    /**
     * Setter uf�retidspunkt i uf�reperioden p� brukerForsteVirk i request-objektet.
     * Kravet m� v�re GJP, GJR eller BP.
     *
     * @param req
     */
    public static void settBrukerForsteVirk(TrygdetidRequest req) {
        String ytelse = req.getYtelsesType().getKode();
        if (ytelse.compareTo("GJP") != 0
                && ytelse.compareTo("GJR") != 0
                && ytelse.compareTo("BP") != 0) {
            return;
        }
        if (req.getPersongrunnlag().getUforeHistorikk() != null) {
            for (Uforeperiode up : req.getPersongrunnlag().getUforeHistorikk().getUforeperiodeListe()) {
                if (up.getUforeType().getKode().equals("VIRK_IKKE_UFOR")) {
                    Date uft = up.getUft();
                    if (req.getBrukerForsteVirk() != null && (uft.getTime() < req.getBrukerForsteVirk().getTime()))
                        req.setBrukerForsteVirk(uft);
                    if (req.getBrukerForsteVirk() == null)
                        req.setBrukerForsteVirk(uft);
                    break;
                }
            }
        }
    }

    /**
     * Returnerer en kopi av persongrunnlaget dersom det finnes en fiktiv uf�reperiode av type VIRK_IKKE_UFOR.
     *
     * @param pg persongrunnlaget.
     */
    public static Persongrunnlag kopierPersongrunnlag(Persongrunnlag pg) {
        Persongrunnlag kopi = null;
        if (pg != null) {
            if (pg.getUforeHistorikk() != null) {
                for (Uforeperiode up : pg.getUforeHistorikk().getUforeperiodeListe()) {
                    if (up.getUforeType().getKode().equals("VIRK_IKKE_UFOR")) {
                        kopi = new Persongrunnlag(pg);
                        break;
                    }
                }
            }
        }
        return kopi;
    }

    /**
     * @param sisteAldersberegning2011
     * @return SisteAldersberegning2011 eller null
     * <p>
     * VIRK_IKKE_UFOR Hacket p�tvunget av CR81364.
     * Denne varianten h�ndterer tilfeller hvor det i SisteAldersberegning finnes EPS, EPS' Vilkarsvedtak, avd�d og avd�de's Vilk�rsvedtak.
     * Kombinasjoner av disse variantene m� h�nderes dersom det i persongrunnlaget eksisterer
     */
    public static SisteAldersberegning2011 forsteVirkHack(SisteAldersberegning2011 sisteAldersberegning2011) {


        // Kall til metoden uten en instans av SisteAldersberegning2011 gir returverdi null.
        if (sisteAldersberegning2011 == null)
            return null;

        // Behandler EPS
        if (sisteAldersberegning2011.getEps() != null) {
            Persongrunnlag pg = sisteAldersberegning2011.getEps();
            // Sjekk at EPS har uf�rehistorikk og en liste med Uforeperioder.
            if (pg.getUforeHistorikk() != null && pg.getUforeHistorikk().getUforeperiodeListe() != null) {
                List<Uforeperiode> uplist = pg.getUforeHistorikk().getUforeperiodeListe();
                // Iterer og finn aktuelle perioder.
                for (Uforeperiode up : uplist) {
                    if (up.getUforeType() != null && up.getUforeType().getKode() != null && up.getUforeType().getKode().equals("VIRK_IKKE_UFOR")) {
                        // Setter F�rsteVirk p� persongrunnlag.
                        pg.setPREG_forsteVirk(up.getUft());
                    }
                }
            }
            fjernSykeUforeperioder(pg);
        }

        // Behandler Avd�d
        if (sisteAldersberegning2011.getAvdodesPersongrunnlag() != null) {
            Persongrunnlag pg = sisteAldersberegning2011.getAvdodesPersongrunnlag();
            // Sjekk at Avd�d har uf�rehistorikk og en liste med Uforeperioder.
            if (pg.getUforeHistorikk() != null && pg.getUforeHistorikk().getUforeperiodeListe() != null) {
                List<Uforeperiode> uplist = pg.getUforeHistorikk().getUforeperiodeListe();
                // Iterer og finn aktuelle perioder.
                for (Uforeperiode up : uplist) {
                    if (up.getUforeType() != null && up.getUforeType().getKode() != null && up.getUforeType().getKode().equals("VIRK_IKKE_UFOR")) {
                        if (sisteAldersberegning2011.getAnvendtGjenlevenderettVedtak() != null) {
                            if (sisteAldersberegning2011.getAnvendtGjenlevenderettVedtak().getForsteVirk() != null) {
                                // Sjekker om man allerede har en tidligere f�rsteVirk.
                                if (sisteAldersberegning2011.getAnvendtGjenlevenderettVedtak().getForsteVirk().getTime() > up.getUft().getTime()) {
                                    // Ta kopi av vilkarsvedtak da dette skal endres.
                                    sisteAldersberegning2011.setAnvendtGjenlevenderettVedtak(new VilkarsVedtak(sisteAldersberegning2011.getAnvendtGjenlevenderettVedtak()));
                                    sisteAldersberegning2011.getAnvendtGjenlevenderettVedtak().setForsteVirk(up.getUft());
                                    pg.setPREG_forsteVirk(up.getUft());
                                } else {
                                    pg.setPREG_forsteVirk(sisteAldersberegning2011.getAnvendtGjenlevenderettVedtak().getForsteVirk());
                                }
                            } else {
                                sisteAldersberegning2011.setAnvendtGjenlevenderettVedtak(new VilkarsVedtak(sisteAldersberegning2011.getAnvendtGjenlevenderettVedtak()));
                                sisteAldersberegning2011.getAnvendtGjenlevenderettVedtak().setForsteVirk(up.getUft());
                                pg.setPREG_forsteVirk(up.getUft());
                            }
                        } else {
                            // Setter F�rsteVirk p� persongrunnlag.
                            pg.setPREG_forsteVirk(up.getUft());
                        }
                    }
                }
            }
            fjernSykeUforeperioder(pg);
        }

        return sisteAldersberegning2011;
    }

}
