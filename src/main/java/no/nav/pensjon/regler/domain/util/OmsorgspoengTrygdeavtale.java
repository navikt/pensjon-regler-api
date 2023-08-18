package no.nav.pensjon.regler.domain.util;

import no.nav.pensjon.regler.domain.Omsorgsopptjening;
import no.nav.pensjon.regler.domain.beregning2011.OpptjeningUT;
import no.nav.pensjon.regler.domain.util.OmsorgspoengCompareUtil.IalRefppComparator;
import no.nav.pensjon.regler.domain.util.OmsorgspoengCompareUtil.PoengtallComparator;
import no.nav.pensjon.regler.domain.util.OmsorgspoengCompareUtil.SynkendeArstallComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static no.nav.pensjon.regler.domain.util.OmsorgspoengLogUtil.printOmsorgsopptjeningListe;
import static no.nav.pensjon.regler.domain.util.OmsorgspoengLogUtil.printRekke;

/**
 * Klasse for å ta hensyn til omsorgspoeng ved valg av år til bruk i beregningsgrunnlag
 * for uføretrygd når det er trygdeavtale.
 *
 * @author Lars Hartviksen (Decisive), PK-9695
 *         Date: 02.05.14
 *         Time: 11:54
 */
public class OmsorgspoengTrygdeavtale extends AbstractOmsorgspoeng {
    // Logging
    private static final Logger log = LoggerFactory.getLogger(OmsorgspoengTrygdeavtale.class);

    // Rekursiv "ytre løkke"
    /**
     * Tre-dimensjonal array som holder styr på om det har noe for seg å generere
     * alle utvalg herifra, eller om permutasjoner herifra kan beskjæres (pruning).
     */
    private boolean[][][] alleUtvalgFinnes;
    /**
     * To-dimensjonal array som holder styr på om det har noe for seg å finne
     * substitusjoner av et gitt antall år med inntekt avtaleland herifra.
     */
    private boolean[][] eksisterendeUtvalg;

    public List<Omsorgsopptjening> finnBeste3Av5_trygdeavtale(List<Omsorgsopptjening> poengrekke) {
        List<List<Omsorgsopptjening>> beste = new ArrayList<List<Omsorgsopptjening>>();
        if (log.isDebugEnabled()) {
            log.debug("****************************************");
            log.debug("*** Start finnBeste3Av5_trygdeavtale ***");
            log.debug("****************************************");
        }
        printRekke("Input: ", poengrekke, log);
        beste.add(finnBesteNSisteTrygdeavtale(poengrekke, 5));
        beste.addAll(finnBesteIalUtvalg(poengrekke, 5));

        if (log.isDebugEnabled()) {
            log.debug("Resultatalternativliste :");
            for (List<Omsorgsopptjening> l : beste) {
                printOmsorgsopptjeningListe(l, log);
            }
            log.debug("-------------------------");
        }

        List<Omsorgsopptjening> allerBest = bestAvForsteFem(beste);

        if (log.isDebugEnabled()) {
            log.debug("Resultat fra finnBeste3Av5_trygdeavtale:");
            printOmsorgsopptjeningListe(allerBest, log);
            log.debug("-------------------------");
        }
        return allerBest;
    }

    public List<OpptjeningUT> finnBeste3Av5_trygdeavtale_blaze(List<OpptjeningUT> poengrekke) {
        List<Omsorgsopptjening> svarListe = finnBeste3Av5_trygdeavtale(new ArrayList<Omsorgsopptjening>(poengrekke));
        List<OpptjeningUT> returListe = new ArrayList<OpptjeningUT>();
        for (Omsorgsopptjening o : svarListe) {
            returListe.add((OpptjeningUT) o);
        }
        return returListe;
    }

    /*
     * Finn beste N siste opptjeninger i en liste av Omsorgsopptjeninger årene fram til index
     * og ta hensyn til om årene har inntekt i avtaleland. Inntekt i avtaleland settes til gjennomsnittet av
     * nasjonal opptjening i utvalget av år.
     * fullPoengtallliste : alle omsorgsopptjeninger
     * n : antall opptjeninger å plukke ut
     */
    private List<Omsorgsopptjening> finnBesteNSisteTrygdeavtale(List<Omsorgsopptjening> poengtallliste, int antall) {
        Collections.sort(poengtallliste, new SynkendeArstallComparator());
        nullstillResultat();

        int sisteArIRekken = 0;
        if (!poengtallliste.isEmpty()) {
            sisteArIRekken = poengtallliste.get(0).getOpptjeningsar();
        }
        log.debug("*** finnBesteNSisteTrygdeavtale " + antall + " fram til " + sisteArIRekken + "***");
        sisteAr = sisteArIRekken;

        int n = antall;
        while (n++ < 5) {
            poengtallliste.add(new OpptjeningUT(++sisteArIRekken, 0.0, IKKE_OMSORG, IKKE_INNTEKT_I_AVTALELAND));
        }

        konstruerMinstePoengrekkerIal(true, poengtallliste);

        List<List<Ref_pp>> kombinasjonerAvIal = new ArrayList<List<Ref_pp>>();
        List<Double> kombinasjonersNasjonaleSnitt = new ArrayList<Double>();
        List<Double> kombinasjonersResultat = new ArrayList<Double>();

        // Prøver alternativet som bare inneholder de fem inntektsårene
        vurderUtfallMedIal(
                ikkeOmsorgsar.get(0),
                ikkeOmsorgsar.get(1),
                ikkeOmsorgsar.get(2),
                ikkeOmsorgsar.get(3),
                ikkeOmsorgsar.get(4));  // Utfall 0: summen av de 3 siste PI årene, selv om pp = 0
        if (!alleUtfall.isEmpty()) {
            kombinasjonerAvIal.add(alleUtfall.get(0));
            kombinasjonersNasjonaleSnitt.add(nasjonaltSnitt[0]);
            kombinasjonersResultat.add(resultat[0]);
        }
        nullstillResultat();

        for (List<Ref_pp> r1 : os[0]) {
            o[0] = r1;
            for (List<Ref_pp> r2 : os[1]) {
                o[1] = r2;
                for (List<Ref_pp> r3 : os[2]) {
                    o[2] = r3;
                    nullstillResultat();
                    int besteUtfall = besteFemBasertPaMinstePoengrekkeMedIal();
                    if (!alleUtfall.isEmpty()) {
                        kombinasjonerAvIal.add(alleUtfall.get(besteUtfall));
                        kombinasjonersNasjonaleSnitt.add(nasjonaltSnitt[besteUtfall]);
                        kombinasjonersResultat.add(resultat[besteUtfall]);
                    }
                }
            }
        }
        // Prøver kombinasjonen hvor man ikke tar med i4
        for (List<Ref_pp> r4 : os[3]) {
            nullstillResultat();
            vurderUtfallMedIal(r4.get(0), r4.get(1), r4.get(2), r4.get(3), ikkeOmsorgsar.get(4));  // Utfall 8: O4 + I5
            kombinasjonerAvIal.add(alleUtfall.get(0));
            kombinasjonersNasjonaleSnitt.add(nasjonaltSnitt[0]);
            kombinasjonersResultat.add(resultat[0]);
        }

        // Prøver kombinasjonen hvor man ikke tar med i5
        for (List<Ref_pp> r5 : os[4]) {
            nullstillResultat();
            vurderUtfallMedIal(r5.get(0), r5.get(1), r5.get(2), r5.get(3), r5.get(4));  // Utfall 9: O5
            kombinasjonerAvIal.add(alleUtfall.get(0));
            kombinasjonersNasjonaleSnitt.add(nasjonaltSnitt[0]);
            kombinasjonersResultat.add(resultat[0]);
        }

        int vinner = 0;
        double besteScoreHittil = 0.0;
        int besteArstallscoreBrukt = Integer.MIN_VALUE;
        for (int i = 0; i < kombinasjonerAvIal.size(); i++) {
            int arstallscore = 0;
            for (Ref_pp r : kombinasjonerAvIal.get(i)) {
                if (r.pt.getOpptjeningsar() <= sisteAr) {
                    arstallscore += r.pt.getOpptjeningsar();
                }
            }
            if (kombinasjonersResultat.get(i) > besteScoreHittil
                    || kombinasjonersResultat.get(i) == besteScoreHittil && arstallscore > besteArstallscoreBrukt) {
                vinner = i;
                besteScoreHittil = kombinasjonersResultat.get(i);
                besteArstallscoreBrukt = arstallscore;
            }
        }

        ArrayList<Omsorgsopptjening> gullreka = new ArrayList<Omsorgsopptjening>();
        ArrayList<Omsorgsopptjening> svaret = new ArrayList<Omsorgsopptjening>();
        List<Ref_pp> gullrekka = kombinasjonerAvIal.get(vinner);
        for (Ref_pp r : gullrekka) {
            if (r.pt.getOpptjeningsar() <= sisteAr) {
                if (r.pt.isInntektIAvtaleland() && kombinasjonersNasjonaleSnitt.get(vinner) > r.pt.getVerdi()) {
                    gullreka.add(new OpptjeningUT(r.pt.getOpptjeningsar(), kombinasjonersNasjonaleSnitt.get(vinner), r.pt.isOmsorg(), r.pt.isInntektIAvtaleland()));
                } else {
                    gullreka.add(new OpptjeningUT(r.pt.getOpptjeningsar(), r.pt.getVerdi(), r.pt.isOmsorg(), r.pt.isInntektIAvtaleland()));
                }
            }
        }
        Collections.sort(gullreka, new PoengtallComparator());

        for (int i = 0; i < antall; i++) {
            svaret.add(gullreka.get(i));
        }

        if (log.isDebugEnabled()) {
            log.debug("Liste fra Utvidet Omfang(" + antall + "):");
            printOmsorgsopptjeningListe(svaret, log);
        }
        return svaret;
    }

    /**
     * @param i1 Ett av fem år
     * @param i2 Ett av fem år
     * @param i3 Ett av fem år
     * @param i4 Ett av fem år
     * @param i5 Ett av fem år
     */
    private void vurderUtfallMedIal(Ref_pp i1, Ref_pp i2, Ref_pp i3, Ref_pp i4, Ref_pp i5) {
        Vector<Ref_pp> detteUtfall = new Vector<Ref_pp>();
        detteUtfall.add(i1);
        detteUtfall.add(i2);
        detteUtfall.add(i3);
        detteUtfall.add(i4);
        detteUtfall.add(i5);
        int antDummyAr = 0;
        double snitt = bestemNasjonaltSnitt(detteUtfall);
        for (Ref_pp r : detteUtfall) {
            if (r.pt.isInntektIAvtaleland() && snitt > r.pt.getVerdi()) {
                r.poengtall = snitt;
            } else {
                r.poengtall = r.pt.getVerdi();
            }
            if (r.erDummy) {
                antDummyAr++;
            }
        }
        Collections.sort(detteUtfall);
        antallDummyAr[alleUtfall.size()] = antDummyAr;
        nasjonaltSnitt[alleUtfall.size()] = snitt;
        arstallsum[alleUtfall.size()] = i1.pt.getOpptjeningsar() + i2.pt.getOpptjeningsar() + i3.pt.getOpptjeningsar() + i4.pt.getOpptjeningsar()
                + i5.pt.getOpptjeningsar();
        resultat[alleUtfall.size()] = detteUtfall.get(0).poengtall + detteUtfall.get(1).poengtall + detteUtfall.get(2).poengtall;
        alleUtfall.add(detteUtfall);
    }

    /**
     * Metode som forbereder kall til rekursiv metode som finner beste utvalg av år med verdi = 0 som har minst ett år med opptjening i avtaleland.
     * For disse utvalgene kan man erstatte år med inntekt i avtaleland med et nasjonalt snitt.
     * Se PK-9695
     *
     * @param vindu Hvor store skal utvalgene være?
     */
    private List<List<Omsorgsopptjening>> finnBesteIalUtvalg(List<Omsorgsopptjening> liste, int vindu) {
        eksisterendeUtvalg = new boolean[liste.size() + 1][vindu + 1];
        alleUtvalgFinnes = new boolean[liste.size() + 1][vindu + 1][vindu + 1];
        Collections.sort(liste, new SynkendeArstallComparator());
        int aar = liste.get(0).getOpptjeningsar();
        return finnBesteIalUtvalgHjelper(liste,
                new LinkedList<Omsorgsopptjening>(),
                aar,
                vindu,
                0,
                aar);
    }

    private List<Omsorgsopptjening> bestAvForsteFem(List<List<Omsorgsopptjening>> beste) {
        double current, currentMax = -1.0;
        List<Omsorgsopptjening> currentMaxList = null;
        for (List<Omsorgsopptjening> l : beste) {
            Collections.sort(l, new PoengtallComparator());
            current = 0.0;
            for (int i = 0; i < 3; i++) {
                current += l.get(i).getVerdi();
            }
            if (current > currentMax) {
                currentMax = current;
                currentMaxList = l;
            }
        }
        return currentMaxList;
    }

    /**
     * Finn beste år hvor alle år har inntekt = 0, finnes år med inntekt avtaleland ved rekursjon.
     * I både partielle og komplette utvalg generert av metoden er det slik at alle opptjeninger har verdi = 0.
     * Dette er en forutsetning for at det skal være mulig å bytte ut årene med inntekt i avtaleland.
     * Metoden skiller seg fra brute-force generering av alle slike kombinasjoner på følgende vis:
     * - Hjelpemetoden som finner substitusjoner av n år med inntekt i avtaleland fra en indeks i med siste verdi > 0 kalles ikke unødig.
     * Tabellen eksisterendeUtvalg holder styr på om metoden allerede har generert et utvalg hvor n år har inntekt i avtaleland, og vi fant erstatninger for disse årene fra indeks
     * i.
     * - Metoden unngår å utvide delvis genererte utvalg når den vet at ingen utvidelser av disse utvalgene vil lede til nye utvalg.
     * Tabellen alleUtvalgFinnes holder styr på om vi har generert alle utvalg som resulterer når man står i en posisjon i, har n ledige plasser, og har valgt m år med inntekt i
     * avtaleland.
     * Dersom vi på ny står i en slik posisjon i, har n ledige plasser og har valgt m år med inntekt i avtaleland vil ikke utvidelser av utvalget lede til utvalg hvor vi skal
     * erstatte et
     * nytt antall år med ial eller posisjonen j hvor det utvidede omfanget starter. Slike utvalg har allerede ha blitt generert.
     * Om man hadde fortsatt likevel fra dette punktet hadde man kun fått utvalg som var forskjellige fra allerede genererte utvalg i form av at årene som skulle erstattes var
     * forskjellige.
     * Det returnerte utvalget vil være det utvalget med erstatninger av n år med inntekt avtaleland som skal erstattes med år i utvidet omfang fra indeks i som er først generert.
     * Det innebærer at det returnerte utvalget vil være først i den leksikografiske sorteringen av slike utvalg:
     * For alle andre utvalg hvor n år med inntekt avtaleland skal erstattes av med år i utvidet omfang fra indeks i så vil:
     * - Første år på det returnerte utvalget være tidligere, eller hvis første år er samme år:
     * - Neste år vil være tidligere, eller hvis neste år er samme år,...
     * ...
     * - Siste år er tidligere.
     *
     * @param liste Listen med OpptjeningUT.
     * @param op_stack Stabel som holder på et utvalg som er i ferd med å genereres.
     * @param ar Nåværende posisjon i liste.
     * @param antallPlasser Antall plasser i utvalget som det gjenstår å fylle.
     * @param antallValgteIal Antall plasser i utvalget som er fylt av år med inntekt i avtaleland.
     */
    private List<List<Omsorgsopptjening>> finnBesteIalUtvalgHjelper(
            List<Omsorgsopptjening> liste,
            LinkedList<Omsorgsopptjening> op_stack,
            int ar,
            int antallPlasser,
            int antallValgteIal,
            int uft) {
        //hvis condition gjelder så består op_stack utelukkende av opptjeninger med verdi 0.
        List<List<Omsorgsopptjening>> returListeListe = new ArrayList<List<Omsorgsopptjening>>();
        if (antallPlasser == 0) {
            if (antallValgteIal > 0) {
                Integer forrigeInntektAr = finnForrigeOpptjeningArIkkeZero(liste, ar);
                if (forrigeInntektAr != null) {
                    if (!eksisterendeUtvalg[uft - forrigeInntektAr][antallValgteIal]) {
                        eksisterendeUtvalg[uft - forrigeInntektAr][antallValgteIal] = true;

                        List<Omsorgsopptjening> nyListe = new ArrayList<Omsorgsopptjening>();
                        for (Omsorgsopptjening o : liste) {
                            if (o.getOpptjeningsar() <= forrigeInntektAr) {
                                nyListe.add(o);
                            }
                        }

                        List<Omsorgsopptjening> beste = finnBesteNSisteTrygdeavtale(nyListe, antallValgteIal);

                        List<Omsorgsopptjening> returListe = new ArrayList<Omsorgsopptjening>();
                        returListe.addAll(op_stack);
                        returListe.addAll(beste);
                        returListeListe.add(returListe);
                    }
                }
            }
        }
        Omsorgsopptjening o = hentOpptjeningsArFraListe(liste, ar);
        if (o != null && antallPlasser > 0 && !alleUtvalgFinnes[uft - ar][antallPlasser][antallValgteIal]) {
            if (o.getVerdi() == 0.0) {
                op_stack.push(o);
                int nyttAntallValgteIal = antallValgteIal;
                if (o.isInntektIAvtaleland()) {
                    nyttAntallValgteIal = antallValgteIal + 1;
                }
                returListeListe.addAll(finnBesteIalUtvalgHjelper(liste, op_stack, ar - 1, antallPlasser - 1, nyttAntallValgteIal, uft));
                op_stack.pop();
            }
            if (o.isOmsorg()) {
                returListeListe.addAll(finnBesteIalUtvalgHjelper(liste, op_stack, ar - 1, antallPlasser, antallValgteIal, uft));
            }
            alleUtvalgFinnes[uft - ar][antallPlasser][antallValgteIal] = true;
        }
        return returListeListe;
    }

    private Omsorgsopptjening hentOpptjeningsArFraListe(List<Omsorgsopptjening> liste, int aar) {
        for (Omsorgsopptjening o : liste) {
            if (o.getOpptjeningsar() == aar) {
                return o;
            }
        }
        return null;
    }

    private Integer finnForrigeOpptjeningArIkkeZero(List<Omsorgsopptjening> liste, int senesteAr) {
        boolean notNull = true;
        Omsorgsopptjening op;
        while (notNull) {
            op = hentOpptjeningsArFraListe(liste, senesteAr);
            notNull = op != null;
            if (notNull && op.getVerdi() > 0.0) {
                return senesteAr;
            }
            senesteAr--;
        }
        return null;
    }

    /*
     * Konstruer minste poengrekker
     * incrementalMode: indikerer at o3 også inneholder o4 og at o4 igjen inneholder o5
     * incrementalMode satt til false betyr at rekkefølgen er akkurat slik: i1 o1 i2 o2 i3 o3 i4 o4 i5 o5
     * incrementalMode satt til true betyr at o3 inneholder alle omsorgsår etter i3 og o4 alle omsorgsår etter i4
     * : i1 o1 i2 o2 i3 o3={o3+o4+o5} i4 o4={o4+o5} i5 o5
     */
    @SuppressWarnings("unchecked")
    private void konstruerMinstePoengrekkerIal(boolean incrementalMode, List<Omsorgsopptjening> poengtallliste) {
        // Sorterer lista slik at den er sortert på synkende år.
        Collections.sort(poengtallliste, new SynkendeArstallComparator());

        ikkeOmsorgsar = finnDeSenesteFemInntektsarIListen(poengtallliste);

        os = new List[5];
        o = new List[5];

        for (int i = 1; i <= 5; i++) {
            populerOmsorgsArene(i, incrementalMode, poengtallliste);
        }
    }

    private int besteFemBasertPaMinstePoengrekkeMedIal() {
        List<Ref_pp> o1 = o[0];
        Ref_pp i2 = ikkeOmsorgsar.get(1);
        List<Ref_pp> o2 = o[1];
        Ref_pp i3 = ikkeOmsorgsar.get(2);
        List<Ref_pp> o3 = o[2];
        Ref_pp i4 = ikkeOmsorgsar.get(3);
        Ref_pp i5 = ikkeOmsorgsar.get(4);
        // Det er ti mulige utfall. 
        // "Basisutfallet" med kun alle fem inntektsårene blir ikke aktuell her.
        // O4 + I5 blir ikke aktuell
        // Det kan heller ikke være kun omsorgsår i denne situasjonen. Vi starter alltid på et inntektsår.

        // Rekke : i1 {o1} i2 {o2} i3 {o3} i4 {o4} i5 {o5}

        if (!o3.get(0).erDummy) {
            vurderUtfallMedIal(o3.get(0), o3.get(1), o3.get(2), i4, i5);  // Utfall 1: Summen av de  3 høyeste pp for omsorgsårene før første PI år
            vurderUtfallMedIal(o3.get(0), o3.get(1), i3, i4, i5);  // Utfall 2: Summen av de 2 største pp for omsorgsårene før første PI år og første PI år
            vurderUtfallMedIal(o3.get(0), i3, o2.get(0), i4,
                    i5);  // Utfall 3: Summen av det  største pp for omsorgsårene før første PI år og første PI år og det største pp for omsorgsårene før andre PI år
            vurderUtfallMedIal(i3, o3.get(0), i2, i4, i5);  // Utfall 6: Summen av det  største pp for omsorgsårene før første PI år  og første PI år  og andre PI år
        }
        if (!o2.get(0).erDummy) {
            vurderUtfallMedIal(i3, o2.get(0), o2.get(1), i4, i5);  // Utfall 4: Summen av første PI år og de 2  største pp for omsorgsårene før andre PI år
            vurderUtfallMedIal(i3, o2.get(0), i2, i4, i5);  // Utfall 5: Summen av første PI år og det  største pp for omsorgsårene før andre PI år og andre PI år
        }
        if (!o1.get(0).erDummy) {
            vurderUtfallMedIal(i3, o1.get(0), i2, i4, i5);  // Utfall 7: Summen av det  største pp for omsorgsårene før tredje PI år  og første PI år  og andre PI år
        }

        //vurderUtfallMedIal(o4.get(0), o4.get(1), o4.get(2), o4.get(3), i5, param);  // Utfall 8: O4 + I5
        //vurderUtfallMedIal(o5.get(0), o5.get(1), o5.get(2), o5.get(3), o5.get(4), param);  // Utfall 9: O5

        return hvilketUtfallErBest();
    }

    private double bestemNasjonaltSnitt(List<Ref_pp> deFem) {
        double sum = 0.0;
        int antallTall = 0;
        for (Ref_pp r : deFem) {
            if (r.pt.getVerdi() > 0.0) {
                antallTall++;
                sum += r.pt.getVerdi();
            }
        }
        if (antallTall > 0) {
            return sum / antallTall;
        }
        return 0.0;
    }

    private void populerOmsorgsArene(int n, boolean incrementalMode, List<Omsorgsopptjening> poengtallliste) {
        Ref_pp iCurrent, iNext;
        iCurrent = ikkeOmsorgsar.get(n - 1);
        iNext = n > 2 && incrementalMode ? null : ikkeOmsorgsar.get(n);

        o[n - 1] = finnNStorsteOmsorgsarMellom(poengtallliste, n, iCurrent, iNext);
        PriorityQueue<Ref_pp> omsorgsarMedIal = finnOmsorgsarMedIalMellom(poengtallliste, iCurrent, iNext, o[n - 1]);
        for (int i = o[n - 1].size(); i < n; i++) {
            o[n - 1].add(new Ref_pp(dummy, 0.0, 0, OMSORG, INNTEKT_I_AVTALELAND));
        }
        for (int i = omsorgsarMedIal.size(); i < 1; i++) {
            omsorgsarMedIal.add(new Ref_pp(dummy, 0.0, 0, OMSORG, INNTEKT_I_AVTALELAND));
        }
        os[n - 1] = genererIalalternativerRekursivt(new LinkedList<Ref_pp>(o[n - 1]), omsorgsarMedIal, n);
    }

    protected List<List<Ref_pp>> genererIalalternativerRekursivt(
            LinkedList<Ref_pp> olok,
            PriorityQueue<Ref_pp> ial,
            int antallPlasser) {
        if (antallPlasser == 0) {
            List<List<Ref_pp>> kombs = new ArrayList<List<Ref_pp>>();
            kombs.add(new ArrayList<Ref_pp>());
            return kombs;
        } else {
            Ref_pp opptj = olok.pop();
            List<List<Ref_pp>> kombs1 = genererIalalternativerRekursivt(olok, ial, antallPlasser - 1);
            for (List<Ref_pp> komb : kombs1) {
                komb.add(0, opptj);
            }
            olok.push(opptj);

            if (!ial.isEmpty()) {
                Ref_pp tempial = ial.poll();
                List<List<Ref_pp>> kombs2 = genererIalalternativerRekursivt(olok, ial, antallPlasser - 1);
                for (List<Ref_pp> komb : kombs2) {
                    komb.add(0, tempial);
                }
                ial.add(tempial);
                kombs1.addAll(kombs2);
            }

            return kombs1;
        }
    }

    private PriorityQueue<Ref_pp> finnOmsorgsarMedIalMellom(
            List<Omsorgsopptjening> poengtallliste, Ref_pp forste, Ref_pp siste, List<Ref_pp> storste) {
        // Oppretter prioritetskø med ial-år mellom forste og siste år.
        PriorityQueue<Ref_pp> senesteOarMedIal =
                new PriorityQueue<Ref_pp>(63, new IalRefppComparator());

        for (Omsorgsopptjening noenPoengtall : poengtallliste) {
            if (noenPoengtall.getOpptjeningsar() > forste.pt.getOpptjeningsar()) {
                if (siste == null && noenPoengtall.isOmsorg()
                        && noenPoengtall.isInntektIAvtaleland()
                        && !finnesArIListe(noenPoengtall.getOpptjeningsar(), storste)) {
                    senesteOarMedIal.add(new Ref_pp(noenPoengtall, noenPoengtall.getVerdi(), 0, noenPoengtall.isOmsorg(), false));
                }
                if (siste != null && noenPoengtall.isInntektIAvtaleland()
                        && noenPoengtall.getOpptjeningsar() < siste.pt.getOpptjeningsar()
                        && !finnesArIListe(noenPoengtall.getOpptjeningsar(), storste)) {
                    senesteOarMedIal.add(new Ref_pp(noenPoengtall, noenPoengtall.getVerdi(), 0, noenPoengtall.isOmsorg(), false));
                }
            }
        }
        return senesteOarMedIal;
    }
}
