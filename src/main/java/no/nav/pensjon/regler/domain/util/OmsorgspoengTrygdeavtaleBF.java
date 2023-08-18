package no.nav.pensjon.regler.domain.util;

import no.nav.pensjon.regler.domain.beregning2011.OpptjeningUT;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static no.nav.pensjon.regler.domain.util.OmsorgspoengCompareUtil.PoengtallComparator;
import static no.nav.pensjon.regler.domain.util.OmsorgspoengCompareUtil.SynkendeArstallComparator;

/**
 * "Brute Force" alternativ til klassen OmsorgspoengTrygdeavtaleRek.
 *
 * Oppfyller reglene for omsorgs�r: �r med omsorg kan enten tas med i utvalget
 * ved at faktisk opptjening brukes i snittberegningen, eller �ret kan brukes
 * som "binde�r" ved at man hopper over �ret.
 *
 * Oppfyller i tillegg reglene gitt av forskrift om beregning av uf�retrygd etter E�S avtalen �2.
 * Med regler gitt av forskriften kan beregningsgrunnlag isteden baseres p� et utvalg som starter
 * med det seneste �r med pensjonsgivende inntekt i Norge f�r uf�retidspunktet. Dessuten kan �r
 * uten inntekt i Norge tilordnes en inntekt lik gjennomsnittet av inntekten i de �r i utvalget
 * hvor det finnes pensjonsgivende inntekt i Norge.
 *
 * @author Steinar Hjellvik, Decisive
 */
public class OmsorgspoengTrygdeavtaleBF {

    private boolean DEBUG = true;

    //Standard st�rrelse p� utvalg.
    private final int sett_storrelse = 5;

    /**
     * Holder p� status ved brute-force s�king gjennom alle mulige utvalg av
     * opptjenings�r i opptjeningslisten.
     */
    class UtvalgStatus {
        // Antall permutasjoner beregnet
        int permutasjoner = 0;

        //St�rste snitt som er funnet.
        private double storste_snitt = 0;

        // Utvalg som gir det st�rste snitt
        private OpptjeningUT[] st�rste_snitt_utvalg = null;

        // Stack som holder p� utvalg som skal beregnes
        private LinkedList<OpptjeningUT> utvalg = new LinkedList<OpptjeningUT>();

        // Angir om utvalg er originalt eller utvidet omfang.
        boolean erOriginaltOmfang = true;

        // Utvalg st�rrelse
        int utvalg_st�rrelse = sett_storrelse;
    }

    /**
     * Snitt av 3 st�rste verdier i utvalg.
     * Runder av til 2 desimaler.
     */
    public double beregnSnitt(OpptjeningUT[] utvalg, int antall) {
        if (utvalg == null || (utvalg != null && utvalg.length == 0)) {
            return 0.0;
        }

        Arrays.sort(utvalg, new PoengtallComparator());
        double sum = 0.0;
        for (int i = 0; i < antall && i < utvalg.length; i++) {
            sum += utvalg[i].getVerdi();
        }
        double snitt = Avrunding.avrund2Desimaler(sum / antall);
        return snitt;
    }

    /**
     * Finn antall �r av utvalg med inntekt i Norge.
     */
    private int antall�rInntektNorge(OpptjeningUT[] utvalg){
        int i = 0;
        for (OpptjeningUT o : utvalg) {
            if (o.getVerdi() > 0){
                i++;
            }
        }
        return i;
    }

    /**
     * Finn antall �r av utvalg med inntekt i Norge.
     */
    private int antall�rInntektAvtaleland(OpptjeningUT[] utvalg){
        int i = 0;
        for (OpptjeningUT o : utvalg) {
            if (o.isInntektIAvtaleland()){
                i++;
            }
        }
        return i;
    }

    /**
     * Forskrift om beregning av uf�retrygd etter E�S avtalen, �2 f�rste ledd:
     *
     * For personer som har pensjonsgivende inntekt i Norge i alle de fem siste kalender�rene f�r uf�retidspunktet,
     * se folketrygdloven � 12-8, fastsettes grunnlaget etter bestemmelsene i folketrygdloven � 12-11.
     *
     */
    private boolean forskriftF�rsteLeddAnvendes(int antall�rInntektNorge, int antall�rInntektAvtaleland){
        boolean anvendes = (antall�rInntektNorge == sett_storrelse);
        if (anvendes && DEBUG)
            { //System.out.println("Forskrift ledd 1");
			}
        return anvendes;
    }

    /**
     *  Forskrift om beregning av uf�retrygd etter E�S avtalen, �2 andre ledd:
     *
     * For personer som verken har pensjonsgivende inntekt i Norge eller arbeidsinntekt i annet E�S-land
     * i de fem siste kalender�rene f�r uf�retidspunktet, se folketrygdloven � 12-8,
     * fastsettes grunnlaget til 0 kroner.
     *
     */
    private boolean forskriftAndreLeddAnvendes(int antall�rInntektNorge, int antall�rInntektAvtaleland){
        boolean anvendes = (antall�rInntektNorge == 0 && antall�rInntektAvtaleland == 0);
        if (anvendes && DEBUG)
            { //System.out.println("Forskrift ledd 2");
			}
        return anvendes;
    }

    /**
     * Forskrift om beregning av uf�retrygd etter E�S avtalen, �2 tredje ledd:
     *
     * For personer som ikke har pensjonsgivende inntekt i Norge i noen av de fem siste kalender�rene f�r uf�retidspunktet,
     * se folketrygdloven � 12-8, men som har arbeidsinntekt i annet E�S-land i disse fem �rene, skal grunnlaget
     * fastsettes etter bestemmelsene i leddet her.
     *
     */
    private boolean forskriftTredjeLeddAnvendes(int antall�rInntektNorge, int antall�rInntektAvtaleland){
        boolean anvendes = (antall�rInntektNorge == 0 && antall�rInntektAvtaleland == sett_storrelse);
        if (anvendes && DEBUG)
            { //System.out.println("Forskrift ledd 3");
			}
        return anvendes;
    }

    /**
     * Forskrift om beregning av uf�retrygd etter E�S avtalen, �2 fjerde ledd:
     *
     * For personer som ikke har pensjonsgivende inntekt i Norge i noen av de fem siste kalender�rene f�r
     * uf�retidspunktet, se folketrygdloven � 12-8, men som har arbeidsinntekt i annet E�S-land i ett, to, tre
     * eller fire av disse fem �r, skal grunnlaget fastsettes etter bestemmelsene i leddet her.
     *
     */
    private boolean forskriftFjerdeLeddAnvendes(int antall�rInntektNorge, int antall�rInntektAvtaleland){
        boolean anvendes = (antall�rInntektNorge == 0 && antall�rInntektAvtaleland > 0 &&  antall�rInntektAvtaleland < sett_storrelse);
        if (anvendes && DEBUG)
            { //System.out.println("Forskrift ledd 4");
			}
        return anvendes;
    }

    /**
     * Forskrift om beregning av uf�retrygd etter E�S avtalen, �2 femte ledd:
     *
     * For personer som har b�de pensjonsgivende inntekt i Norge og arbeidsinntekt i annet E�S-land i de
     * fem siste kalender�rene f�r uf�retidspunktet, se folketrygdloven � 12-8, skal grunnlaget fastsettes
     * etter bestemmelsene i leddet her.
     *
     */
    private boolean forskriftFemteLeddAnvendes(int antall�rInntektNorge, int antall�rInntektAvtaleland){
        boolean anvendes = (antall�rInntektNorge > 0 && antall�rInntektAvtaleland > 0);
        if (anvendes && DEBUG)
            { //System.out.println("Forskrift ledd 5");
			}
        return anvendes;
    }

    /**
     * Finn siste �r f�r uf�retidspunkt med pensjonsgivende inntekt i Norge.
     */
    private int finnSisteInntekts�rNorge(OpptjeningUT[] liste){
        for (int i = 0; i < liste.length; i++){
            if (liste[i].getVerdi() > 0){
                return i;
            }
        }
        return -1;
    }

    /**
     * Beregner beste snitt ved utvidet omfang.
     * Leter bakover i listen og finner f�rste �r med inntekt i Norge.
     * N�r dette �ret er funnet lages en liste av dette �ret pluss et antall foreg�ende �r
     * bestemt av antall �r med inntekt i avtaleland i originalt omfang.
     *
     */
    private OpptjeningUT[] besteSnittUtvidetOmfang(OpptjeningUT[] liste, int �rIAL){
        OpptjeningUT[] utvidetOmfang = null;
        int sisteInntekts�rNorge = finnSisteInntekts�rNorge(liste);
        if (sisteInntekts�rNorge >= 0) {
            OpptjeningUT[] listeMedStartSisteInntekts�r = Arrays.copyOfRange(liste, sisteInntekts�rNorge, liste.length);
            UtvalgStatus status = new UtvalgStatus();
            status.erOriginaltOmfang = false;
            status.utvalg_st�rrelse = Math.min(�rIAL, listeMedStartSisteInntekts�r.length);
            finnLovligUtvalg(status, listeMedStartSisteInntekts�r);
            utvidetOmfang = status.st�rste_snitt_utvalg;

            if (DEBUG) {
                //System.out.println("Beste snitt utvidet omfang = " + status.storste_snitt);
                //System.out.println("Antall permutasjoner = " + status.permutasjoner);
                dbg_utvalg(status.st�rste_snitt_utvalg);
            }
        }
        return utvidetOmfang;
    }

    /**
     * Beregn nasjonalt snitt i henhold til Forskrift om beregning av uf�retrygd etter E�S avtalen �2.
     *
     */
    private OpptjeningUT[] finnUtvalgEtterTrygdeavtale(OpptjeningUT[] originaltOmfang, OpptjeningUT[] liste){
        OpptjeningUT[] omfang = originaltOmfang;
        int �rInntektNorge = antall�rInntektNorge(originaltOmfang);
        int �rInntektAvtaleland = antall�rInntektAvtaleland(originaltOmfang);

        if (forskriftF�rsteLeddAnvendes(�rInntektNorge, �rInntektAvtaleland)
                || forskriftAndreLeddAnvendes(�rInntektNorge, �rInntektAvtaleland)){
            // Ingen nasjonalt snitt aktuelt.
        } else if (forskriftTredjeLeddAnvendes(�rInntektNorge, �rInntektAvtaleland)
                || forskriftFjerdeLeddAnvendes(�rInntektNorge, �rInntektAvtaleland)) {
            // Nasjonalt snitt utvidet omfang.
            OpptjeningUT[] utvidetOmfang = besteSnittUtvidetOmfang(liste, �rInntektAvtaleland);
            if (utvidetOmfang != null){
                omfang = utvidetOmfang;
            }
        } else if (forskriftFemteLeddAnvendes(�rInntektNorge, �rInntektAvtaleland)){
            // Nasjonalt snitt originalt omfang.
            double nasjonaltSnitt = beregnSnitt(originaltOmfang, �rInntektNorge);
            for (OpptjeningUT o : originaltOmfang) {
                if (o.getVerdi() < nasjonaltSnitt && o.isInntektIAvtaleland()){
                    if (DEBUG) {
                        //System.out.println("Anvender nasjonalt snitt for �r " + o.getAr() + ", ny verdi = " + nasjonaltSnitt);
                    }
                    o.setAvkortetBelop(nasjonaltSnitt);
                }
            }
        }
        return omfang;
    }

    /**
     * Lager en deep copy av liste av OpptjeningUT.
     */
    private OpptjeningUT[] kopierListe(List<OpptjeningUT> origListe){
        OpptjeningUT[] kopiListe = new OpptjeningUT[origListe.size()];
        int i = 0;
        for (OpptjeningUT o : origListe) {
            kopiListe[i++] = new OpptjeningUT(o);
        }
        return kopiListe;
    }

    /**
     * Ved utvidet omfang skal �r uten pensjonsgivende inntekt ha en inntekt lik gjennomsnittet
     * av inntekten i �rene med pensjonsgivende inntekt.
     *
     */
    private void anvendGjennomsnittVedUtvidetOmfang(OpptjeningUT[] utvidetOmfang){
        int �rInntektNorge = antall�rInntektNorge(utvidetOmfang);
        double nasjonaltSnitt = beregnSnitt(utvidetOmfang, �rInntektNorge);
        for (OpptjeningUT o : utvidetOmfang) {
            if (o.getVerdi() == 0 && nasjonaltSnitt > 0) {
                if (DEBUG) {
                    //System.out.println("Anvender nasjonalt snitt for �r " + o.getAr() + ", ny verdi = " + nasjonaltSnitt);
                }
                o.setAvkortetBelop(nasjonaltSnitt);
            }
        }
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
    private void finnLovligUtvalg(UtvalgStatus status, OpptjeningUT[] liste) {
        if (status.utvalg.size() == status.utvalg_st�rrelse) {
            OpptjeningUT[] nyttUtvalg = kopierListe(status.utvalg);

            if (status.erOriginaltOmfang){
                if (DEBUG){
                    //System.out.print("Originalt omfang " + status.permutasjoner + " = ");
                    dbg_utvalg(nyttUtvalg);
                }
                nyttUtvalg = finnUtvalgEtterTrygdeavtale(nyttUtvalg, liste);
            } else {
                if (DEBUG){
                    //System.out.print("Utvidet omfang " + status.permutasjoner + " = ");
                    dbg_utvalg(nyttUtvalg);
                }
                anvendGjennomsnittVedUtvidetOmfang(nyttUtvalg);
            }
            double snitt = beregnSnitt(nyttUtvalg, 3);
            if (snitt > status.storste_snitt || status.st�rste_snitt_utvalg == null) {
                status.storste_snitt = snitt;
                status.st�rste_snitt_utvalg = nyttUtvalg;
                if (DEBUG) {
                    //System.out.print("Beste snitt = " + status.storste_snitt + " ved utvalg ");
                    dbg_utvalg(nyttUtvalg);
                }
            }
            status.permutasjoner++;
        } else if (status.utvalg.size() < status.utvalg_st�rrelse && liste.length > 0) {
            OpptjeningUT aktuellOpptjening = new OpptjeningUT(liste[0]);
            status.utvalg.push(aktuellOpptjening);
            finnLovligUtvalg(status, Arrays.copyOfRange(liste, 1, liste.length));
            status.utvalg.pop();
            if (aktuellOpptjening.isOmsorg()) {
                finnLovligUtvalg(status, Arrays.copyOfRange(liste, 1, liste.length));
            }
        }
    }

    /**
     * Skriv ut utvalg for debugging.
     *
     */
    private void dbg_utvalg(OpptjeningUT[] utvalg){
        if (utvalg != null) {
            //System.out.print("[");
            for (OpptjeningUT o : utvalg) {
               // System.out.print(o.getOpptjeningsar() + ", ");
            }
            //System.out.println("]");
        }
    }

    /**
     * Skriv ut resultat for debugging.
     */
    private void dbg_resultat(UtvalgStatus status) {
        //System.out.println("[OmsorgspoengTrygdeavtaleBF] Antall permutasjoner = " + status.permutasjoner);
        //System.out.println("[OmsorgspoengTrygdeavtaleBF] Max snitt = " + status.storste_snitt);
        if (status.st�rste_snitt_utvalg != null) {
            for (OpptjeningUT o : status.st�rste_snitt_utvalg) {
                //System.out.print(o.getOpptjeningsar() + " ");
            }
            //System.out.println("");
        }
    }

    /**
     * Finn lovlig utvalg p� 5 omsorgsoopptjening som gir det beste snitt av 3.
     * Tar hensyn til inntekt i avtaleland ved trygdeavtale, ref. �2 i
     * F12.02.2015 nr 130 Forskrift om beregning av uf�retrygd etter E�S-avtalen.
     *
     * @param opptjeningsliste
     * @return
     */
    public OpptjeningUT[] beregnBesteSnitt3av5_trygdeavtale(List<OpptjeningUT> opptjeningsliste){
        if (opptjeningsliste == null){
            return null;
        } else if (opptjeningsliste != null && opptjeningsliste.size() <= sett_storrelse) {
            return opptjeningsliste.toArray(new OpptjeningUT[opptjeningsliste.size()]);
        }

        UtvalgStatus status = new UtvalgStatus();

        // Sikre at opptjeningsliste er sortert med seneste �r f�rst.
        Collections.sort(opptjeningsliste, new SynkendeArstallComparator());
        OpptjeningUT[] opptjeningArray = opptjeningsliste.toArray(new OpptjeningUT[opptjeningsliste.size()]);

        // Finn lovlige utvalg og beregn beste snitt.
        finnLovligUtvalg(status, opptjeningArray);

        if (DEBUG) {
            dbg_resultat(status);
        }

        return status.st�rste_snitt_utvalg;
    }
}
