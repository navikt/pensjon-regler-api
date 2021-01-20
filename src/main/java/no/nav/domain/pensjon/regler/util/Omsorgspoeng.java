package no.nav.domain.pensjon.regler.util;

import no.nav.domain.pensjon.regler.Omsorgsopptjening;
import no.nav.domain.pensjon.regler.beregning.Poengtall;
import no.nav.domain.pensjon.regler.beregning2011.OpptjeningUT;
import no.nav.domain.pensjon.regler.kode.PoengtallTypeCti;
import no.nav.domain.pensjon.regler.util.OmsorgspoengCompareUtil.SynkendeArstallComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static no.nav.domain.pensjon.regler.util.OmsorgspoengCompareUtil.PoengtallComparator;
import static no.nav.domain.pensjon.regler.util.OmsorgspoengLogUtil.*;

/**
 * Klasse for å ta hensyn til omsorgspoeng ved beregning av FPP.
 * 
 * @author Dag Brenna (Accenture), Ørnulf Moen (Decisive), Pensjonsprogrammet
 * @author Lars Hartviksen (Decisive), PK-6782, PK-9695
 * @author Magnus Bakken (Accenture), PK-9695
 * @version $Id$
 */
public class Omsorgspoeng extends AbstractOmsorgspoeng {
    // Logging
    private static final Logger log = LoggerFactory.getLogger(Omsorgspoeng.class);

    /*
     * BeregnFPPHalvparten beregner fpp etter alternativ 2 i Gunnar Sletners Beregningsregler, side 91
     * BeregnFPPHalvparten tar inn en poengrekke. Sorterer poengtallene i en rekke for omsorgsår hvor pp > 0
     * og en rekke for ikke omsorgsår. Begge sorteres etter synkende poengtall.
     * Fra rekka uten omsorgsår beregner man summen for den beste halvparten av poengårene og deler på antall år,
     * halvpartenrundet, opp til et liketall.
     * Dette er i utgangspunktet beste_fpp.
     * Deretter legger man til pp fra et og et omsorgsår, sorterer på synkende pp og foretar beregningen på nytt.
     * Dette gjøre så lenge beste_fpp blir bedre. På grunn av at halvparten rundes opp til et liketall vil man
     * måtte kjøre noen ekstra runder for å ta høyde for effekten av halvparten.
     */
    public double beregnFPPHalvparten(Vector<Poengtall> poengtallliste) {
        double beste_fpp = 0.0;
        if (poengtallliste.isEmpty()) {
            if (log.isDebugEnabled()) {
                System.out.println("beregnFPPHalvparten tom liste => fpp " + beste_fpp);
            }
            return beste_fpp;
        }

        //debug = System.getProperty("PREG_DEBUG", "false").equals("true");
        if (log.isDebugEnabled()) {
            printRekke("beregnFPPHalvparten ", new Vector<Omsorgsopptjening>(poengtallliste), log);
        }

        Vector<Poengtall> uten_omsorg = new Vector<Poengtall>();
        Vector<Poengtall> med_omsorg = new Vector<Poengtall>();
        long halvparten; // antall år i beste halvpart
        double fpp_uten = 0.0;

        int ar_med_omsorg; // implisitt = 0

        // sett opp poengtall-listene med og uten omsorgspoeng
        for (Poengtall pt : poengtallliste) {
            boolean omsorg = false;
            if (pt.getPoengtallType() != null) {
                if (pt.isPREG_omsorg()) {
                    omsorg = true;
                }
            }
            if ((pt.isPREG_omsorg() || omsorg) && pt.getPp() > 0.0) {
                med_omsorg.add(pt);
            } else if (!omsorg) {
                uten_omsorg.add(pt);
            }
        }
        ar_med_omsorg = med_omsorg.size();

        //		if (log.isDebugEnabled()) printRekke("Poengtall uten omsorg", uten_omsorg);
        //		if (log.isDebugEnabled()) printRekke("Poengtall med omsorg", med_omsorg);

        halvparten = Math.round(uten_omsorg.size() * 0.5);
        if (uten_omsorg.isEmpty()) {
            if (log.isDebugEnabled()) {
                log.debug("beregnFPPHalvparten ingen poengtall uten omsorg => fpp " + beste_fpp);
            }
            return beste_fpp;
        }
        //if (log.isDebugEnabled()) System.out.println("halvparten " + halvparten + " " +uten_omsorg.size());

        Collections.sort(med_omsorg, new PoengtallComparator());
        Collections.sort(uten_omsorg, new PoengtallComparator());
        // finn fpp uten omsorgspoeng
        for (int i = 0; i < halvparten; i++) {
            fpp_uten += uten_omsorg.get(i).getPp();
            //String ssum = String.format("%1$20.17f", uten_omsorg.get(i).getPp());
            //System.out.println("sum + " + uten_omsorg.get(i).getPp() + " sum="+fpp_uten + " " + ssum);
        }
        fpp_uten = Avrunding.avrundSpt(fpp_uten, 1.0); // ocm
        fpp_uten = Avrunding.avrundSpt(fpp_uten, halvparten);
        fpp_uten = Avrunding.avrundSpt(fpp_uten, 1.0);
        //if (log.isDebugEnabled()) System.out.println("fpp_uten avrundet" + fpp_uten + " halvparten " + halvparten + " uavrundet "+d + " fpp/halv " + d/halvparten);

        if (fpp_uten == 0) {
            if (log.isDebugEnabled()) {
                log.debug("beregnFPPHalvparten ingen poengtall uten omsorg > 0  => fpp " + beste_fpp);
            }
            return 0.0;
        }
        // starter med en poengtall-liste som er lik uten_omsorg
        Vector<Poengtall> tmp_list = new Vector<Poengtall>(uten_omsorg);

        beste_fpp = fpp_uten;
        int mindre = 0;

        // loop, legger til pp fra rekka med omsorgsår og beregner fpp på nytt
        for (int i = 0; i < ar_med_omsorg; i++) {
            double tmp_fpp = 0.0;
            tmp_list.add(med_omsorg.get(i));
            Collections.sort(tmp_list, new PoengtallComparator());
            long halve = Math.round(tmp_list.size() * 0.5);
            for (int j = 0; j < halve; j++) {
                tmp_fpp += tmp_list.get(j).getPp();
            }
            tmp_fpp = Avrunding.avrundSpt(tmp_fpp, halve);
            tmp_fpp = Avrunding.avrundSpt(tmp_fpp, 1.0);

            if (tmp_fpp > beste_fpp) {
                beste_fpp = tmp_fpp;
                mindre = 0;
            } else {
                mindre += 1;
            }
            if (mindre > 2) {
                break;
            }
        }
        if (log.isDebugEnabled()) {
            log.debug("beregnFPPHalvparten fpp ferdig " + beste_fpp);
        }
        return beste_fpp;
    }

    /**
     * Fjerner år som er senere enn tilår før kallet til beregnFPPHalvparten gjøres.
     * 
     * @param poengtallliste: listen av opptjeninger / poengtall
     * @param tilAr: Enten UFT eller siste år med inntekt i norge.
     * @return
     */
    public double beregnFPPHalvparten(Vector<Poengtall> poengtallliste, int tilAr) {
        @SuppressWarnings("unchecked")
        Vector<Poengtall> tempPoengtallListe = (Vector<Poengtall>) poengtallliste.clone();
        for (Poengtall poengtall : poengtallliste) {
            if (poengtall.getAr() > tilAr) {
                tempPoengtallListe.remove(poengtall);
            }
        }
        return beregnFPPHalvparten(tempPoengtallListe);
    }

    /**
     * Dokumentasjon BER-4000 kapittel 3.5 beskriver metoden som er brukt.
     * Alle poengrekker for beregning av tre beste kan forkortes til:
     * i1 {o1} i2 {o2} i3 {o3} i4 i5
     * der
     * o1 er et sett med det max ett største omsorgspoenget mellom i1 og i2
     * o2 er et sett av de max to største omsorgspoengene mellom i2 og i3
     * o3 er et sett av de max tre største omsorgspoengene etter i3
     * i4 er nest siste ikke-omsorgsår.
     * i5 er siste ikke-omsorgsår.
     * Det finnes alltid en utgave av "de fem beste siste" som i4 og i5 inngår i.
     */
    @SuppressWarnings("unchecked")
    private void konstruerMinstePoengrekke() {
        // Sorterer lista slik at den er sortert på synkende år.
        Collections.sort(poengtallliste, new SynkendeArstallComparator());

        ikkeOmsorgsar = finnDeSenesteFemInntektsarIListen(poengtallliste);
        o = new List[5];

        o[0] = finnNStorsteOmsorgsarMellom(poengtallliste, 1, ikkeOmsorgsar.get(0), ikkeOmsorgsar.get(1));
        o[1] = finnNStorsteOmsorgsarMellom(poengtallliste, 2, ikkeOmsorgsar.get(1), ikkeOmsorgsar.get(2));
        o[2] = finnNStorsteOmsorgsarMellom(poengtallliste, 3, ikkeOmsorgsar.get(2), null);

        for (int i = o[2].size(); i < 3; i++) {
            o[2].add(new Ref_pp(dummy, 0.0, 0, OMSORG, true));
        }
        for (int i = o[1].size(); i < 2; i++) {
            o[1].add(new Ref_pp(dummy, 0.0, 0, OMSORG, true));
        }
        if (o[0].size() == 0) {
            o[0].add(new Ref_pp(dummy, 0.0, 0, OMSORG, true));
        }
    }

    private int besteFemBasertPaMinstePoengrekke() {
        Ref_pp i1 = ikkeOmsorgsar.get(0);
        List<Ref_pp> o1 = o[0];
        Ref_pp i2 = ikkeOmsorgsar.get(1);
        List<Ref_pp> o2 = o[1];
        Ref_pp i3 = ikkeOmsorgsar.get(2);
        List<Ref_pp> o3 = o[2];
        Ref_pp i4 = ikkeOmsorgsar.get(3);
        Ref_pp i5 = ikkeOmsorgsar.get(4);
        // Det er åtte mulige utfall

        // Rekke : i1 {o1} i2 {o2} i3 {o3}
        vurderUtfall(i1, i2, i3, i4, i5);  // Utfall 0: summen av de 3 siste PI årene, selv om pp = 0
        vurderUtfall(o3.get(0), o3.get(1), o3.get(2), i4, i5);  // Utfall 1: Summen av de  3 høyeste pp for omsorgsårene før første PI år
        vurderUtfall(o3.get(0), o3.get(1), i3, i4, i5);  // Utfall 2: Summen av de 2 største pp for omsorgsårene før første PI år og første PI år
        vurderUtfall(o3.get(0), i3, o2.get(0), i4, i5);  // Utfall 3: Summen av det  største pp for omsorgsårene før første PI år og første PI år og det største pp for omsorgsårene før andre PI år
        vurderUtfall(i3, o2.get(0), o2.get(1), i4, i5);  // Utfall 4: Summen av første PI år og de 2  største pp for omsorgsårene før andre PI år
        vurderUtfall(i3, o2.get(0), i2, i4, i5);  // Utfall 5: Summen av første PI år og det  største pp for omsorgsårene før andre PI år og andre PI år
        vurderUtfall(i3, o3.get(0), i2, i4, i5);  // Utfall 6: Summen av det  største pp for omsorgsårene før første PI år  og første PI år  og andre PI år
        vurderUtfall(i3, o1.get(0), i2, i4, i5);  // Utfall 7: Summen av det  største pp for omsorgsårene før tredje PI år  og første PI år  og andre PI år

        return hvilketUtfallErBest();
    }

    /*
     * BeregnFPP3Beste beregner fpp etter alternativ 1 i Gunnar Sletners Beregningsregler side 91.
     * BeregnFPP3Beste tar inn en poengrekke og sorterer den på synkende årstall.
     * Deretter søkes det gjennom poengrekken til man har funnet 3 år med PI eller rekken er tom. Årene med PI
     * legges i vektoren infoFørPPI. Her lagrer man pongtallet, peker til poengåret og antall omsorgsår før dette ikke omsorgsåret.
     * Mens man filtrer lista med poengår, sorterer man ut inntil de 3 omsorgsårene før det første PI-året med høyest
     * pp sortert i synkende rekke følge. Før det andre PI-året filtrer man ut inntil 2 omsorgsår med høyest pp og
     * 1 før det 3. PI året. Om pp er null i PI årene betyr ingen ting.
     * Når man har gjort dette har man følgende mulige utfall:
     * Summen av:
     * 0. de 3 PI årene er størst (grunnberegningen)
     * 1. de 3 omsorgsårene (om de finnes) før første PI år er størst
     * 2. de 2 største omsorgsårene + første PI år er størst
     * 3. det største omsorgsåret før første PI år og PI året og det største omsorgsåret mellom første og andre PI år er størst
     * 4. det første PI året og de 2 største omsorgsårene før det åndre PI året er størst
     * 5. det første PI året , det største av omsorgsårene før det andre PI året og det andre PI året er størst
     * 6. det største omsorgsåret før første PI år og det første og andre PI året er størst
     * 7. det første og andre PI året og det største omsoregsåret mellom de 2 siste PI årene er størst.
     * Den største av disse alternativene deles på 3 og returneres som fpp.
     */
    private List<Ref_pp> finnBesteFemSiste(List<Omsorgsopptjening> poengtallliste) {
        // Debug settes nå på Logger-objektet.
        // debug =System.getProperty("PREG_DEBUG", "false").equals("true");
        // satstabeller_debug = System.getProperty("SATSTABELLER_DEBUG", "false").equals("true");
        this.poengtallliste = poengtallliste;

        //Reduserer poengrekken til formen "i1 {o1} i2 {o2} i3 {o3} i4 i5"
        konstruerMinstePoengrekke();

        if (log.isDebugEnabled()) {
            printRekke("finnBesteFemSiste ", poengtallliste, log);
            printRedusertRekke(ikkeOmsorgsar, o, log);
        }

        int besteUtfall = besteFemBasertPaMinstePoengrekke();

        if (log.isDebugEnabled()) {
            log.debug("Vinnende tre år:" + refArListString(alleUtfall.get(besteUtfall)));
            log.debug("Vinnende tre pp:" + refppListString(alleUtfall.get(besteUtfall)));
            log.debug("Sum :" + resultat[besteUtfall]);
        }
        return alleUtfall.get(besteUtfall);
    }

    /**
     * @param poengtallliste: Listen av opptjeninger
     * @return De fem omsorgsopptjeningene som bør velges for å få det beste snittet av 3
     */
    public List<Omsorgsopptjening> finnBeste3Av5(List<Omsorgsopptjening> poengtallliste) {
        List<Ref_pp> resultat = finnBesteFemSiste(poengtallliste);
        List<Omsorgsopptjening> arene = new ArrayList<Omsorgsopptjening>();
        for (Ref_pp p : resultat) {
            if (p.pt instanceof OpptjeningUT) {
                arene.add(p.pt);
            } else {
                arene.add(new OpptjeningUT(p.pt.getOpptjeningsar(), p.pt.getVerdi(), p.pt.isOmsorg(), p.pt.isInntektIAvtaleland()));
            }
        }
        return arene;
    }

    /**
     * @param poengtallliste: Listen av opptjeninger
     * @return De fem omsorgsopptjeningene som bør velges for å få det beste snittet av 3
     * Spesialutgave som Blaze kan bruke
     */
    public List<OpptjeningUT> finnBeste3Av5_blaze(List<OpptjeningUT> poengtallliste) {
        List<Ref_pp> resultat = finnBesteFemSiste(new ArrayList<Omsorgsopptjening>(poengtallliste));
        List<OpptjeningUT> arene = new ArrayList<OpptjeningUT>();
        for (Ref_pp p : resultat) {
            if (p.pt instanceof OpptjeningUT) {
                arene.add((OpptjeningUT) p.pt);
            } else {
                arene.add(new OpptjeningUT(p.pt.getOpptjeningsar(), p.pt.getVerdi(), p.pt.isOmsorg(), p.pt.isInntektIAvtaleland()));
            }
        }
        return arene;
    }

    /**
     * @param poengtallliste: Array av opptjeninger
     * @return De fem omsorgsopptjeningene som bør velges for å få det beste snittet av 3
     * Spesialutgave som tar imot og returnerer et array
     */
    public Omsorgsopptjening[] finnBeste3Av5_array(Omsorgsopptjening[] poengtallliste) {
        List<Omsorgsopptjening> liste = Arrays.asList(poengtallliste);
        List<Ref_pp> resultat = finnBesteFemSiste(liste);

        liste = new ArrayList<Omsorgsopptjening>();
        for (Ref_pp o : resultat) {
            if (o.pt instanceof OpptjeningUT) {
                liste.add(o.pt);
            }
        }

        Omsorgsopptjening[] o = new Omsorgsopptjening[liste.size()];
        for (int i = 0; i < liste.size(); i++) {
            o[i] = liste.get(i);
        }
        return o;
    }

    /**
     * @param poengtallliste: Listen av poengtall
     * @return Beregnet fpp
     */
    public double beregnFPPBeste3Av5(List<Omsorgsopptjening> poengtallliste) {
        List<Ref_pp> resultat = finnBesteFemSiste(poengtallliste);
        double sum = 0.0;
        Ref_pp pt;
        Collections.sort(resultat);
        for (int i = 0; i < 3; i++) {
            pt = resultat.get(i);
            sum += pt.poengtall;
        }
        return Avrunding.avrund2Desimaler(sum / 3);
    }

    /**
     * @param poengtallliste: Listen av opptjeninger
     * @return Det beste beløpet man kan få
     */
    public double beregnFPP3Beste(Vector<Omsorgsopptjening> poengtallliste) {
        //Setter inn to ikke-omsorgsår på slutten av listen. Disse er 0.0 og vil alltid tape i sammenligningene.
        Collections.sort(poengtallliste, new SynkendeArstallComparator());
        int sisteArIRekken = 0;
        if (!poengtallliste.isEmpty()) {
            sisteArIRekken = poengtallliste.get(0).getOpptjeningsar();
        }
        poengtallliste.add(new Poengtall(0.0, 0, 0, sisteArIRekken + 1, false, 0, new PoengtallTypeCti("PI"), 0));
        poengtallliste.add(new Poengtall(0.0, 0, 0, sisteArIRekken + 2, false, 0, new PoengtallTypeCti("PI"), 0));

        List<Ref_pp> resultat = finnBesteFemSiste(poengtallliste);
        double sum = 0.0;
        Ref_pp pt;
        Collections.sort(resultat);
        for (int i = 0; i < 3; i++) {
            pt = resultat.get(i);
            sum += pt.poengtall;
        }
        return Avrunding.avrund2Desimaler(sum / 3);
    }

    /**
     * @param i1: opptjening
     * @param i2: opptjening
     * @param i3: opptjening
     * @param i4: opptjening
     * @param i5: opptjening
     * Denne funksjonen kan eventuelt refaktoreres til å heller ta inn en liste.
     */
    private void vurderUtfall(Ref_pp i1, Ref_pp i2, Ref_pp i3, Ref_pp i4, Ref_pp i5) {
        Vector<Ref_pp> detteUtfall = new Vector<Ref_pp>();
        detteUtfall.add(i1);
        detteUtfall.add(i2);
        detteUtfall.add(i3);
        detteUtfall.add(i4);
        detteUtfall.add(i5);
        // Sorterer de fem opptjeningene basert på poengtalet som er oppgitt i
        // Ref_pp.poengtall. Dette er satt til nasjonalt snitt hvis det er mulig
        // og hvis det er større.
        Collections.sort(detteUtfall);
        // Årstallsummen settes til summen av alle FEM i utvalget.
        // Det er med hensikt slik at de to senest mulige årene velges
        // som fjerde og femte år i utvalget.
        arstallsum[alleUtfall.size()] =
                i1.pt.getOpptjeningsar()
                        + i2.pt.getOpptjeningsar()
                        + i3.pt.getOpptjeningsar()
                        + i4.pt.getOpptjeningsar()
                        + i5.pt.getOpptjeningsar();
        // Resultatet skal gjenspeile hva som gir best sum av tre beste
        // Derfor summeres bare de tre største.
        resultat[alleUtfall.size()] =
                detteUtfall.get(0).poengtall
                        + detteUtfall.get(1).poengtall
                        + detteUtfall.get(2).poengtall;
        // Resultater som er like på tre beste sin sum av avkortede beløp (ved OpptjeningUT / beregningsgrunnlag uføretrygd)
        // skal sorteres på sum av tre beste sine justerte beløp for å sikre høyest mulig antatt inntekt faktor.
        // Ref: PKPYTON-1214
        justerteBelop[alleUtfall.size()] =
                detteUtfall.get(0).pt.getJustertBelop()
                        + detteUtfall.get(1).pt.getJustertBelop()
                        + detteUtfall.get(2).pt.getJustertBelop();
        alleUtfall.add(detteUtfall);
    }

    /**
     * Fjerner år etter tilår før kallet til beregnFPP3Beste gjøres.
     * Sikrer bakoverkompatibilitet for typen Vector.
     * 
     * @param poengtallliste: Listen av poengtall som Vector
     * @param tilAr: UFT eller siste år med inntekt i Norge
     * @return beregnet fpp
     */
    public double beregnFPP3Beste(Vector<Omsorgsopptjening> poengtallliste, int tilAr) {
        Vector<Omsorgsopptjening> tempPoengtallListe = new Vector<Omsorgsopptjening>(poengtallliste);
        for (Omsorgsopptjening poengtall : poengtallliste) {
            if (poengtall.getOpptjeningsar() > tilAr) {
                tempPoengtallListe.remove(poengtall);
            }
        }
        return beregnFPP3Beste(tempPoengtallListe);
    }
}
