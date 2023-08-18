package no.nav.pensjon.regler.domain.util;

import no.nav.pensjon.regler.domain.Omsorgsopptjening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static no.nav.pensjon.regler.domain.util.OmsorgspoengCompareUtil.PoengtallComparator;
import static no.nav.pensjon.regler.domain.util.OmsorgspoengCompareUtil.SynkendeArstallComparator;

/**
 * "Brute Force" alternativ til klassen Omsorgspoeng.
 * Beregn snitt av 3 beste �r av alle lovlige utvalg p� 3 eller 5 siste �r.
 * �r med omsorg kan enten tas med i utvalget ved at faktisk opptjening
 * brukes i snittberegningen, eller �ret kan brukes som "binde�r" ved
 * at man hopper over �ret.
 * Det er lagt inn en optimalisering som g�r ut p� at �r med omsorg og
 * faktisk opptjening lik 0 fjernes fra opptjeningslisten f�r beregning starter.
 * Slike �r vil uansett ikke kunne bidra til et snitt over 0 men kan bare brukes
 * som "binde�r".
 *
 * @author Steinar Hjellvik, Decisive
 */
public class OmsorgspoengBF {
    private boolean DEBUG = false;

    // Antall permutasjoner beregnet
    private int permutasjoner = 0;

    //St�rrelse p� utvalg. Settes til 3 eller 5.
    private int sett_storrelse;

    //St�rste snitt som er funnet.
    private double storste_snitt = 0;

    // Utvalg som gir det st�rste snitt
    private Omsorgsopptjening[] snitt_utvalg;

    // Stack som holder p� utvalg som skal beregnes
    private LinkedList<Omsorgsopptjening> utvalg_stack;

    /**
     * Snitt av 3 st�rste verdier i utvalg.
     * Runder av til 2 desimaler.
     */
    public double beregnSnitt(Omsorgsopptjening[] utvalg) {
        if (utvalg == null || (utvalg != null && utvalg.length == 0)) {
            return 0.0;
        }

        Arrays.sort(utvalg, new PoengtallComparator());
        double sum = 0.0;
        for (int i = 0; i < 3 && i < utvalg.length; i++) {
            sum += utvalg[i].getVerdi();
        }
        double snitt = Avrunding.avrund2Desimaler(sum / 3);
        return snitt;
    }

    /**
     * Finn alle lovlige utvalg.
     * Bruker rekursjon:
     * Hvis utvalg har �nsket st�rrelse s� beregn snitt og returner
     * Ellers
     * 1. Legger aktuellOpptjening til utvalg.
     * 2. Rekursivt kall for � finne alle lovlige utvalg videre fra neste posisjon i liste.
     * 3. Har n� fors�kt alle lovlige utvalg hvor aktuellOpptjening inng�r. Fjerner derfor aktuellOpptjening fra utvalget.
     * 4. Hvis aktuellOpptjening er omsorg s� hopp over denne og finn alle lovlige utvalg videre fra neste posisjon i liste
     */
    private void finnLovligUtvalg(Omsorgsopptjening[] liste, int pos) {
        if (utvalg_stack.size() == sett_storrelse) {
            Omsorgsopptjening[] nyttUtvalg = utvalg_stack.toArray(new Omsorgsopptjening[utvalg_stack.size()]);
            double snitt = beregnSnitt(nyttUtvalg);
            if (snitt > storste_snitt || snitt_utvalg == null) {
                storste_snitt = snitt;
                snitt_utvalg = nyttUtvalg;
                if (DEBUG) {
                    dbg_utvalg(nyttUtvalg, snitt);
                }
            }
            permutasjoner++;
        } else if (utvalg_stack.size() < sett_storrelse && pos < liste.length) {
            Omsorgsopptjening aktuellOpptjening = liste[pos];
            utvalg_stack.push(aktuellOpptjening);
            finnLovligUtvalg(liste, pos + 1);
            utvalg_stack.pop();
            if (aktuellOpptjening.isOmsorg()) {
                finnLovligUtvalg(liste, pos + 1);
            }
        }
    }

    /**
     * Skriv ut utvalg for debugging.
     */
    private void dbg_utvalg(Omsorgsopptjening[] utvalg, double snitt) {
        //System.out.print("[OmsorgspoengBF] ");
        for (Omsorgsopptjening o : utvalg) {
            //System.out.print(o.getOpptjeningsar() + " ");
        }
        //System.out.println("snitt = " + snitt);
    }

    /**
     * Skriv ut resultat for debugging.
     */
    private void dbg_resultat() {
        //System.out.println("[OmsorgspoengBF] Antall permutasjoner = " + permutasjoner);
        //System.out.println("[OmsorgspoengBF] Max snitt = " + storste_snitt);
        if (snitt_utvalg != null) {
            for (Omsorgsopptjening o : snitt_utvalg) {
                //System.out.print(o.getOpptjeningsar() + " ");
            }
            //System.out.println("");
        }
    }

    /**
     * Optimalisering: Hopper over omsorgs�r med verdi lik 0.
     */
    private Omsorgsopptjening[] fjernOmsorgsarUtenVerdi(Omsorgsopptjening[] opptjeningsliste) {
        ArrayList<Omsorgsopptjening> nyListe = new ArrayList<Omsorgsopptjening>();
        for (Omsorgsopptjening o : opptjeningsliste) {
            if (o.isOmsorg() && o.getVerdi() == 0.0) {
//                System.out.println("Hoppet over omsorgs�r med verdi 0: " + o.getOpptjeningsar());
            } else {
                nyListe.add(o);
            }
        }
        return nyListe.toArray(new Omsorgsopptjening[nyListe.size()]);
    }

    /**
     * Fjerner �r etter til�r
     */
    private Omsorgsopptjening[] fjernArEtterTilAr(Omsorgsopptjening[] opptjeningsliste, int tilAr) {
        ArrayList<Omsorgsopptjening> nyListe = new ArrayList<Omsorgsopptjening>();
        for (Omsorgsopptjening o : opptjeningsliste) {
            if (o.getOpptjeningsar() <= tilAr) {
                nyListe.add(o);
            }
        }
        return nyListe.toArray(new Omsorgsopptjening[nyListe.size()]);
    }

    /**
     * Beregn beste snitt av 3 fra et utvalg lik sett_storrelse (3 eller 5).
     *
     * @param opptjeningsliste
     * @return
     */
    private Omsorgsopptjening[] beregnBesteSnitt(Omsorgsopptjening[] opptjeningsliste) {
        if (opptjeningsliste == null
                || (opptjeningsliste != null && opptjeningsliste.length <= sett_storrelse)) {
            return opptjeningsliste;
        }

        permutasjoner = 0;
        storste_snitt = 0;
        utvalg_stack = new LinkedList<Omsorgsopptjening>();
        snitt_utvalg = null;

        // Sikre at opptjeningsliste er sortert med seneste �r f�rst.
        Arrays.sort(opptjeningsliste, new SynkendeArstallComparator());

        Omsorgsopptjening[] listeOptimalisert = fjernOmsorgsarUtenVerdi(opptjeningsliste);
        if (listeOptimalisert.length == 0) {
            // Grensetilfelle hvor alle �r er hoppet over pga. omsorg og verdi lik 0.
            // Returnerer utvalg lik f�rste 5 fra opptjeningsliste.
            return Arrays.copyOf(opptjeningsliste, 5);
        } else if (listeOptimalisert.length <= sett_storrelse) {
            return listeOptimalisert;
        }

        // Finn lovlige utvalg og beregn beste snitt.
        finnLovligUtvalg(listeOptimalisert, 0);

        if (DEBUG) {
            dbg_resultat();
        }

        return snitt_utvalg;
    }

    /**
     * Finn lovlig utvalg p� 5 omsorgsoopptjening som gir det beste snitt av 3.
     *
     * @param opptjeningsliste
     * @return
     */
    public Omsorgsopptjening[] beregnBesteSnitt3av5(Omsorgsopptjening[] opptjeningsliste) {
        sett_storrelse = 5;
        return beregnBesteSnitt(opptjeningsliste);
    }

    /**
     * Finn lovlig utvalg p� 3 omsorgsopptjening som gir det beste snitt av 3.
     *
     * @param opptjeningsliste
     * @return
     */
    public Omsorgsopptjening[] beregnBesteSnitt3av3(Omsorgsopptjening[] opptjeningsliste) {
        sett_storrelse = 3;
        return beregnBesteSnitt(opptjeningsliste);
    }

    /**
     * For bakoverkompatibilitet.
     *
     * @param poengtallliste
     * @return
     */
    public double beregnFPP3Beste(Omsorgsopptjening[] poengtallliste) {
        Omsorgsopptjening[] vinner = beregnBesteSnitt3av3(poengtallliste);
        return beregnSnitt(vinner);
    }

    public double beregnFPP3Beste(Omsorgsopptjening[] poengtallliste, int tilAr) {
        Omsorgsopptjening[] listeRedusert = fjernArEtterTilAr(poengtallliste, tilAr);
        Omsorgsopptjening[] vinner = beregnBesteSnitt3av3(listeRedusert);
        return beregnSnitt(vinner);
    }
}
