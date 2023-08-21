package no.nav.pensjon.regler.domain.util;

import no.nav.pensjon.regler.domain.Omsorgsopptjening;
import no.nav.pensjon.regler.domain.beregning2011.OpptjeningUT;

import java.util.*;

import static no.nav.pensjon.regler.domain.util.OmsorgspoengCompareUtil.PoengtallComparator;
import static no.nav.pensjon.regler.domain.util.OmsorgspoengCompareUtil.StigendeArstallComparator;

/**
 * Klasse som Omsorgspoeng og OmsorgspoengTrygdeavtale arver fra
 *
 * @author Lars Hartviksen (Decisive), PK-9695
 *         Date: 02.05.14
 *         Time: 11:54
 */
abstract class AbstractOmsorgspoeng {
    protected static final boolean IKKE_OMSORG = false;
    protected static final boolean OMSORG = true;
    protected static final boolean IKKE_INNTEKT_I_AVTALELAND = false;
    protected static final boolean INNTEKT_I_AVTALELAND = true;
    protected static boolean debug = false, satstabeller_debug = false;
    protected static final int VELDIG_LAVT_TALL = -1000;
    protected static OpptjeningUT dummy = new OpptjeningUT(VELDIG_LAVT_TALL, 0.0, IKKE_OMSORG, IKKE_INNTEKT_I_AVTALELAND);

    List<Ref_pp> ikkeOmsorgsar;
    List<Ref_pp>[] o;
    List<List<Ref_pp>>[] os;
    List<Omsorgsopptjening> poengtallliste = new Vector<Omsorgsopptjening>();
    List<List<Ref_pp>> alleUtfall = new ArrayList<List<Ref_pp>>();
    double[] resultat = new double[10];
    double[] justerteBelop = new double[10];
    int[] arstallsum = new int[10];
    double[] nasjonaltSnitt = new double[10];
    int sisteAr;
    int[] antallDummyAr = new int[10];

    protected void nullstillResultat() {
        resultat = new double[10];
        justerteBelop = new double[10];
        alleUtfall = new ArrayList<List<Ref_pp>>();
        arstallsum = new int[10];
        nasjonaltSnitt = new double[10];
        antallDummyAr = new int[10];
    }

    /**
     * @param poengtallliste
     * @return: En liste med 5 Ref_pp som ikke er omsorgs�r
     */
    protected List<Ref_pp> finnDeSenesteFemInntektsarIListen(List<Omsorgsopptjening> poengtallliste) {
        List<Ref_pp> deFemInntektsArene = new ArrayList<Ref_pp>();
        for (Omsorgsopptjening noenPoengtall : poengtallliste) {
            if (!noenPoengtall.isOmsorg()) {
                deFemInntektsArene.add(new Ref_pp(noenPoengtall, noenPoengtall.getVerdi(), 0, IKKE_OMSORG, false));
            }
            if (deFemInntektsArene.size() == 5) {
                break;
            }
        }
        for (int i = deFemInntektsArene.size(); i < 5; i++) {
            deFemInntektsArene.add(new Ref_pp(dummy, 0.0, dummy.getAr(), IKKE_OMSORG, true));
        }
        Collections.sort(deFemInntektsArene, new StigendeArstallComparator());
        return deFemInntektsArene;
    }

    /**
     * @param poengtallliste
     * @param antall: Antall omsorgs�r som skal returneres
     * @param forste: �ret f�r omsorgs�rene
     * @param siste: �ret etter omsorgs�rene
     * @return: de (antall) st�rste omsorgs�rene mellom �r (forste) og �r (siste)
     * St�tter ikke mer enn 63 omsorgs�r. ( Teoretisk maksimum er 50 )
     * Hvis siste ikke er satt, vil man finne alle omsorgs�r etter forste og sjekke at de ikke er inntekts�r
     * slik at man unng�r � plukke opp i4 og i5.
     */
    protected List<Ref_pp> finnNStorsteOmsorgsarMellom(List<Omsorgsopptjening> poengtallliste, int antall, Ref_pp forste, Ref_pp siste) {
        PriorityQueue<Omsorgsopptjening> storsteOar = new PriorityQueue<Omsorgsopptjening>(63, new PoengtallComparator());
        List<Ref_pp> deNStorsteOmsorgsarene = new ArrayList<Ref_pp>();
        //Legger alle omsorgs�rene mellom forste og siste �r inn i en prioritetsk� som er sortert p� h�yeste pp
        for (Omsorgsopptjening noenPoengtall : poengtallliste) {
            if (!noenPoengtall.isInntektIAvtaleland() && noenPoengtall.getOpptjeningsar() > forste.pt.getOpptjeningsar()) {
                if (siste == null && noenPoengtall.isOmsorg()) {
                    storsteOar.add(noenPoengtall);
                }
                if (siste != null && noenPoengtall.getOpptjeningsar() < siste.pt.getOpptjeningsar()) {
                    storsteOar.add(noenPoengtall);
                }
            }
        }
        // Tar ut de (antall) st�rste omsorgs�rene og legger disse inn i deNStorsteOmsorgsarene
        for (int i = 0; i < antall && !storsteOar.isEmpty(); i++) {
            deNStorsteOmsorgsarene.add(new Ref_pp(storsteOar.peek(), storsteOar.peek().getVerdi(), 0, OMSORG, false));
            storsteOar.poll();
        }
        return deNStorsteOmsorgsarene;
    }

    protected int hvilketUtfallErBest() {
        double storste = -Double.MAX_VALUE;
        double storsteJusterteBelop = -Double.MAX_VALUE;
        int storstearstallsum = Integer.MIN_VALUE;
        int vinner = 0;
        for (int i = 0; i < alleUtfall.size(); i++) {
            //Sorter f�rst p� sum av tre beste, deretter p� sum av tre beste sine justerte bel�p (kun effektivt hvis OpptjeningUT), deretter p� �rstallsum.
            if (antallDummyAr[i] == 0 && (
                    resultat[i] > storste
                            ||
                            resultat[i] == storste && justerteBelop[i] > storsteJusterteBelop
                            ||
                            resultat[i] == storste && justerteBelop[i] == storsteJusterteBelop && arstallsum[i] > storstearstallsum)) {
                storste = resultat[i];
                storsteJusterteBelop = justerteBelop[i];
                storstearstallsum = arstallsum[i];
                vinner = i;
            }
        }
        return vinner;
    }

    protected boolean finnesArIListe(int ar, List<Ref_pp> liste) {
        for (Ref_pp r : liste) {
            if (r.pt.getOpptjeningsar() == ar) {
                return true;
            }
        }
        return false;
    }
}
