package no.nav.pensjon.regler.domain.util;

import no.nav.pensjon.regler.domain.Omsorgsopptjening;
import no.nav.pensjon.regler.domain.beregning.Poengtall;
import no.nav.pensjon.regler.domain.beregning2011.OpptjeningUT;
import no.nav.pensjon.regler.domain.kode.PoengtallTypeCti;
import no.nav.pensjon.regler.domain.util.OmsorgspoengCompareUtil.SynkendeArstallComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static no.nav.pensjon.regler.domain.util.OmsorgspoengCompareUtil.PoengtallComparator;
import static no.nav.pensjon.regler.domain.util.OmsorgspoengLogUtil.*;

/**
 * Klasse for � ta hensyn til omsorgspoeng ved beregning av FPP.
 * 
 * @author Dag Brenna (Accenture), �rnulf Moen (Decisive), Pensjonsprogrammet
 * @author Lars Hartviksen (Decisive), PK-6782, PK-9695
 * @author Magnus Bakken (Accenture), PK-9695
 * @version $Id$
 */
public class Omsorgspoeng extends AbstractOmsorgspoeng {
    // Logging
    private static final Logger log = LoggerFactory.getLogger(Omsorgspoeng.class);

    /*
     * BeregnFPPHalvparten beregner fpp etter alternativ 2 i Gunnar Sletners Beregningsregler, side 91
     * BeregnFPPHalvparten tar inn en poengrekke. Sorterer poengtallene i en rekke for omsorgs�r hvor pp > 0
     * og en rekke for ikke omsorgs�r. Begge sorteres etter synkende poengtall.
     * Fra rekka uten omsorgs�r beregner man summen for den beste halvparten av poeng�rene og deler p� antall �r,
     * halvpartenrundet, opp til et liketall.
     * Dette er i utgangspunktet beste_fpp.
     * Deretter legger man til pp fra et og et omsorgs�r, sorterer p� synkende pp og foretar beregningen p� nytt.
     * Dette gj�re s� lenge beste_fpp blir bedre. P� grunn av at halvparten rundes opp til et liketall vil man
     * m�tte kj�re noen ekstra runder for � ta h�yde for effekten av halvparten.
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
        long halvparten; // antall �r i beste halvpart
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

        // loop, legger til pp fra rekka med omsorgs�r og beregner fpp p� nytt
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
     * Fjerner �r som er senere enn til�r f�r kallet til beregnFPPHalvparten gj�res.
     * 
     * @param poengtallliste: listen av opptjeninger / poengtall
     * @param tilAr: Enten UFT eller siste �r med inntekt i norge.
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
     * o1 er et sett med det max ett st�rste omsorgspoenget mellom i1 og i2
     * o2 er et sett av de max to st�rste omsorgspoengene mellom i2 og i3
     * o3 er et sett av de max tre st�rste omsorgspoengene etter i3
     * i4 er nest siste ikke-omsorgs�r.
     * i5 er siste ikke-omsorgs�r.
     * Det finnes alltid en utgave av "de fem beste siste" som i4 og i5 inng�r i.
     */
    @SuppressWarnings("unchecked")
    private void konstruerMinstePoengrekke() {
        // Sorterer lista slik at den er sortert p� synkende �r.
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
        // Det er �tte mulige utfall

        // Rekke : i1 {o1} i2 {o2} i3 {o3}
        vurderUtfall(i1, i2, i3, i4, i5);  // Utfall 0: summen av de 3 siste PI �rene, selv om pp = 0
        vurderUtfall(o3.get(0), o3.get(1), o3.get(2), i4, i5);  // Utfall 1: Summen av de  3 h�yeste pp for omsorgs�rene f�r f�rste PI �r
        vurderUtfall(o3.get(0), o3.get(1), i3, i4, i5);  // Utfall 2: Summen av de 2 st�rste pp for omsorgs�rene f�r f�rste PI �r og f�rste PI �r
        vurderUtfall(o3.get(0), i3, o2.get(0), i4, i5);  // Utfall 3: Summen av det  st�rste pp for omsorgs�rene f�r f�rste PI �r og f�rste PI �r og det st�rste pp for omsorgs�rene f�r andre PI �r
        vurderUtfall(i3, o2.get(0), o2.get(1), i4, i5);  // Utfall 4: Summen av f�rste PI �r og de 2  st�rste pp for omsorgs�rene f�r andre PI �r
        vurderUtfall(i3, o2.get(0), i2, i4, i5);  // Utfall 5: Summen av f�rste PI �r og det  st�rste pp for omsorgs�rene f�r andre PI �r og andre PI �r
        vurderUtfall(i3, o3.get(0), i2, i4, i5);  // Utfall 6: Summen av det  st�rste pp for omsorgs�rene f�r f�rste PI �r  og f�rste PI �r  og andre PI �r
        vurderUtfall(i3, o1.get(0), i2, i4, i5);  // Utfall 7: Summen av det  st�rste pp for omsorgs�rene f�r tredje PI �r  og f�rste PI �r  og andre PI �r

        return hvilketUtfallErBest();
    }

    /*
     * BeregnFPP3Beste beregner fpp etter alternativ 1 i Gunnar Sletners Beregningsregler side 91.
     * BeregnFPP3Beste tar inn en poengrekke og sorterer den p� synkende �rstall.
     * Deretter s�kes det gjennom poengrekken til man har funnet 3 �r med PI eller rekken er tom. �rene med PI
     * legges i vektoren infoF�rPPI. Her lagrer man pongtallet, peker til poeng�ret og antall omsorgs�r f�r dette ikke omsorgs�ret.
     * Mens man filtrer lista med poeng�r, sorterer man ut inntil de 3 omsorgs�rene f�r det f�rste PI-�ret med h�yest
     * pp sortert i synkende rekke f�lge. F�r det andre PI-�ret filtrer man ut inntil 2 omsorgs�r med h�yest pp og
     * 1 f�r det 3. PI �ret. Om pp er null i PI �rene betyr ingen ting.
     * N�r man har gjort dette har man f�lgende mulige utfall:
     * Summen av:
     * 0. de 3 PI �rene er st�rst (grunnberegningen)
     * 1. de 3 omsorgs�rene (om de finnes) f�r f�rste PI �r er st�rst
     * 2. de 2 st�rste omsorgs�rene + f�rste PI �r er st�rst
     * 3. det st�rste omsorgs�ret f�r f�rste PI �r og PI �ret og det st�rste omsorgs�ret mellom f�rste og andre PI �r er st�rst
     * 4. det f�rste PI �ret og de 2 st�rste omsorgs�rene f�r det �ndre PI �ret er st�rst
     * 5. det f�rste PI �ret , det st�rste av omsorgs�rene f�r det andre PI �ret og det andre PI �ret er st�rst
     * 6. det st�rste omsorgs�ret f�r f�rste PI �r og det f�rste og andre PI �ret er st�rst
     * 7. det f�rste og andre PI �ret og det st�rste omsoregs�ret mellom de 2 siste PI �rene er st�rst.
     * Den st�rste av disse alternativene deles p� 3 og returneres som fpp.
     */
    private List<Ref_pp> finnBesteFemSiste(List<Omsorgsopptjening> poengtallliste) {
        // Debug settes n� p� Logger-objektet.
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
            log.debug("Vinnende tre �r:" + refArListString(alleUtfall.get(besteUtfall)));
            log.debug("Vinnende tre pp:" + refppListString(alleUtfall.get(besteUtfall)));
            log.debug("Sum :" + resultat[besteUtfall]);
        }
        return alleUtfall.get(besteUtfall);
    }

    /**
     * @param poengtallliste: Listen av opptjeninger
     * @return De fem omsorgsopptjeningene som b�r velges for � f� det beste snittet av 3
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
     * @return De fem omsorgsopptjeningene som b�r velges for � f� det beste snittet av 3
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
     * @return De fem omsorgsopptjeningene som b�r velges for � f� det beste snittet av 3
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
     * @return Det beste bel�pet man kan f�
     */
    public double beregnFPP3Beste(Vector<Omsorgsopptjening> poengtallliste) {
        //Setter inn to ikke-omsorgs�r p� slutten av listen. Disse er 0.0 og vil alltid tape i sammenligningene.
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
     * Denne funksjonen kan eventuelt refaktoreres til � heller ta inn en liste.
     */
    private void vurderUtfall(Ref_pp i1, Ref_pp i2, Ref_pp i3, Ref_pp i4, Ref_pp i5) {
        Vector<Ref_pp> detteUtfall = new Vector<Ref_pp>();
        detteUtfall.add(i1);
        detteUtfall.add(i2);
        detteUtfall.add(i3);
        detteUtfall.add(i4);
        detteUtfall.add(i5);
        // Sorterer de fem opptjeningene basert p� poengtalet som er oppgitt i
        // Ref_pp.poengtall. Dette er satt til nasjonalt snitt hvis det er mulig
        // og hvis det er st�rre.
        Collections.sort(detteUtfall);
        // �rstallsummen settes til summen av alle FEM i utvalget.
        // Det er med hensikt slik at de to senest mulige �rene velges
        // som fjerde og femte �r i utvalget.
        arstallsum[alleUtfall.size()] =
                i1.pt.getOpptjeningsar()
                        + i2.pt.getOpptjeningsar()
                        + i3.pt.getOpptjeningsar()
                        + i4.pt.getOpptjeningsar()
                        + i5.pt.getOpptjeningsar();
        // Resultatet skal gjenspeile hva som gir best sum av tre beste
        // Derfor summeres bare de tre st�rste.
        resultat[alleUtfall.size()] =
                detteUtfall.get(0).poengtall
                        + detteUtfall.get(1).poengtall
                        + detteUtfall.get(2).poengtall;
        // Resultater som er like p� tre beste sin sum av avkortede bel�p (ved OpptjeningUT / beregningsgrunnlag uf�retrygd)
        // skal sorteres p� sum av tre beste sine justerte bel�p for � sikre h�yest mulig antatt inntekt faktor.
        // Ref: PKPYTON-1214
        justerteBelop[alleUtfall.size()] =
                detteUtfall.get(0).pt.getJustertBelop()
                        + detteUtfall.get(1).pt.getJustertBelop()
                        + detteUtfall.get(2).pt.getJustertBelop();
        alleUtfall.add(detteUtfall);
    }

    /**
     * Fjerner �r etter til�r f�r kallet til beregnFPP3Beste gj�res.
     * Sikrer bakoverkompatibilitet for typen Vector.
     * 
     * @param poengtallliste: Listen av poengtall som Vector
     * @param tilAr: UFT eller siste �r med inntekt i Norge
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
