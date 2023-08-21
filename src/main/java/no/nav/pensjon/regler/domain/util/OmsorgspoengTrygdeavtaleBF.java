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
 * Oppfyller reglene for omsorgsår: År med omsorg kan enten tas med i utvalget
 * ved at faktisk opptjening brukes i snittberegningen, eller året kan brukes
 * som "bindeår" ved at man hopper over året.
 *
 * Oppfyller i tillegg reglene gitt av forskrift om beregning av uføretrygd etter EØS avtalen §2.
 * Med regler gitt av forskriften kan beregningsgrunnlag isteden baseres på et utvalg som starter
 * med det seneste år med pensjonsgivende inntekt i Norge før uføretidspunktet. Dessuten kan år
 * uten inntekt i Norge tilordnes en inntekt lik gjennomsnittet av inntekten i de år i utvalget
 * hvor det finnes pensjonsgivende inntekt i Norge.
 *
 * @author Steinar Hjellvik, Decisive
 */
public class OmsorgspoengTrygdeavtaleBF {

    private boolean DEBUG = true;

    //Standard størrelse på utvalg.
    private final int sett_storrelse = 5;

    /**
     * Holder på status ved brute-force søking gjennom alle mulige utvalg av
     * opptjeningsår i opptjeningslisten.
     */
    class UtvalgStatus {
        // Antall permutasjoner beregnet
        int permutasjoner = 0;

        //Største snitt som er funnet.
        private double storste_snitt = 0;

        // Utvalg som gir det største snitt
        private OpptjeningUT[] største_snitt_utvalg = null;

        // Stack som holder på utvalg som skal beregnes
        private LinkedList<OpptjeningUT> utvalg = new LinkedList<OpptjeningUT>();

        // Angir om utvalg er originalt eller utvidet omfang.
        boolean erOriginaltOmfang = true;

        // Utvalg størrelse
        int utvalg_størrelse = sett_storrelse;
    }

    /**
     * Snitt av 3 største verdier i utvalg.
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
     * Finn antall år av utvalg med inntekt i Norge.
     */
    private int antallÅrInntektNorge(OpptjeningUT[] utvalg){
        int i = 0;
        for (OpptjeningUT o : utvalg) {
            if (o.getVerdi() > 0){
                i++;
            }
        }
        return i;
    }

    /**
     * Finn antall år av utvalg med inntekt i Norge.
     */
    private int antallÅrInntektAvtaleland(OpptjeningUT[] utvalg){
        int i = 0;
        for (OpptjeningUT o : utvalg) {
            if (o.isInntektIAvtaleland()){
                i++;
            }
        }
        return i;
    }

    /**
     * Forskrift om beregning av uføretrygd etter EØS avtalen, §2 første ledd:
     *
     * For personer som har pensjonsgivende inntekt i Norge i alle de fem siste kalenderårene før uføretidspunktet,
     * se folketrygdloven § 12-8, fastsettes grunnlaget etter bestemmelsene i folketrygdloven § 12-11.
     *
     */
    private boolean forskriftFørsteLeddAnvendes(int antallÅrInntektNorge, int antallÅrInntektAvtaleland){
        boolean anvendes = (antallÅrInntektNorge == sett_storrelse);
        if (anvendes && DEBUG)
            { //System.out.println("Forskrift ledd 1");
			}
        return anvendes;
    }

    /**
     *  Forskrift om beregning av uføretrygd etter EØS avtalen, §2 andre ledd:
     *
     * For personer som verken har pensjonsgivende inntekt i Norge eller arbeidsinntekt i annet EØS-land
     * i de fem siste kalenderårene før uføretidspunktet, se folketrygdloven § 12-8,
     * fastsettes grunnlaget til 0 kroner.
     *
     */
    private boolean forskriftAndreLeddAnvendes(int antallÅrInntektNorge, int antallÅrInntektAvtaleland){
        boolean anvendes = (antallÅrInntektNorge == 0 && antallÅrInntektAvtaleland == 0);
        if (anvendes && DEBUG)
            { //System.out.println("Forskrift ledd 2");
			}
        return anvendes;
    }

    /**
     * Forskrift om beregning av uføretrygd etter EØS avtalen, §2 tredje ledd:
     *
     * For personer som ikke har pensjonsgivende inntekt i Norge i noen av de fem siste kalenderårene før uføretidspunktet,
     * se folketrygdloven § 12-8, men som har arbeidsinntekt i annet EØS-land i disse fem årene, skal grunnlaget
     * fastsettes etter bestemmelsene i leddet her.
     *
     */
    private boolean forskriftTredjeLeddAnvendes(int antallÅrInntektNorge, int antallÅrInntektAvtaleland){
        boolean anvendes = (antallÅrInntektNorge == 0 && antallÅrInntektAvtaleland == sett_storrelse);
        if (anvendes && DEBUG)
            { //System.out.println("Forskrift ledd 3");
			}
        return anvendes;
    }

    /**
     * Forskrift om beregning av uføretrygd etter EØS avtalen, §2 fjerde ledd:
     *
     * For personer som ikke har pensjonsgivende inntekt i Norge i noen av de fem siste kalenderårene før
     * uføretidspunktet, se folketrygdloven § 12-8, men som har arbeidsinntekt i annet EØS-land i ett, to, tre
     * eller fire av disse fem år, skal grunnlaget fastsettes etter bestemmelsene i leddet her.
     *
     */
    private boolean forskriftFjerdeLeddAnvendes(int antallÅrInntektNorge, int antallÅrInntektAvtaleland){
        boolean anvendes = (antallÅrInntektNorge == 0 && antallÅrInntektAvtaleland > 0 &&  antallÅrInntektAvtaleland < sett_storrelse);
        if (anvendes && DEBUG)
            { //System.out.println("Forskrift ledd 4");
			}
        return anvendes;
    }

    /**
     * Forskrift om beregning av uføretrygd etter EØS avtalen, §2 femte ledd:
     *
     * For personer som har både pensjonsgivende inntekt i Norge og arbeidsinntekt i annet EØS-land i de
     * fem siste kalenderårene før uføretidspunktet, se folketrygdloven § 12-8, skal grunnlaget fastsettes
     * etter bestemmelsene i leddet her.
     *
     */
    private boolean forskriftFemteLeddAnvendes(int antallÅrInntektNorge, int antallÅrInntektAvtaleland){
        boolean anvendes = (antallÅrInntektNorge > 0 && antallÅrInntektAvtaleland > 0);
        if (anvendes && DEBUG)
            { //System.out.println("Forskrift ledd 5");
			}
        return anvendes;
    }

    /**
     * Finn siste år før uføretidspunkt med pensjonsgivende inntekt i Norge.
     */
    private int finnSisteInntektsårNorge(OpptjeningUT[] liste){
        for (int i = 0; i < liste.length; i++){
            if (liste[i].getVerdi() > 0){
                return i;
            }
        }
        return -1;
    }

    /**
     * Beregner beste snitt ved utvidet omfang.
     * Leter bakover i listen og finner første år med inntekt i Norge.
     * Når dette året er funnet lages en liste av dette året pluss et antall foregående år
     * bestemt av antall år med inntekt i avtaleland i originalt omfang.
     *
     */
    private OpptjeningUT[] besteSnittUtvidetOmfang(OpptjeningUT[] liste, int årIAL){
        OpptjeningUT[] utvidetOmfang = null;
        int sisteInntektsårNorge = finnSisteInntektsårNorge(liste);
        if (sisteInntektsårNorge >= 0) {
            OpptjeningUT[] listeMedStartSisteInntektsår = Arrays.copyOfRange(liste, sisteInntektsårNorge, liste.length);
            UtvalgStatus status = new UtvalgStatus();
            status.erOriginaltOmfang = false;
            status.utvalg_størrelse = Math.min(årIAL, listeMedStartSisteInntektsår.length);
            finnLovligUtvalg(status, listeMedStartSisteInntektsår);
            utvidetOmfang = status.største_snitt_utvalg;

            if (DEBUG) {
                //System.out.println("Beste snitt utvidet omfang = " + status.storste_snitt);
                //System.out.println("Antall permutasjoner = " + status.permutasjoner);
                dbg_utvalg(status.største_snitt_utvalg);
            }
        }
        return utvidetOmfang;
    }

    /**
     * Beregn nasjonalt snitt i henhold til Forskrift om beregning av uføretrygd etter EØS avtalen §2.
     *
     */
    private OpptjeningUT[] finnUtvalgEtterTrygdeavtale(OpptjeningUT[] originaltOmfang, OpptjeningUT[] liste){
        OpptjeningUT[] omfang = originaltOmfang;
        int årInntektNorge = antallÅrInntektNorge(originaltOmfang);
        int årInntektAvtaleland = antallÅrInntektAvtaleland(originaltOmfang);

        if (forskriftFørsteLeddAnvendes(årInntektNorge, årInntektAvtaleland)
                || forskriftAndreLeddAnvendes(årInntektNorge, årInntektAvtaleland)){
            // Ingen nasjonalt snitt aktuelt.
        } else if (forskriftTredjeLeddAnvendes(årInntektNorge, årInntektAvtaleland)
                || forskriftFjerdeLeddAnvendes(årInntektNorge, årInntektAvtaleland)) {
            // Nasjonalt snitt utvidet omfang.
            OpptjeningUT[] utvidetOmfang = besteSnittUtvidetOmfang(liste, årInntektAvtaleland);
            if (utvidetOmfang != null){
                omfang = utvidetOmfang;
            }
        } else if (forskriftFemteLeddAnvendes(årInntektNorge, årInntektAvtaleland)){
            // Nasjonalt snitt originalt omfang.
            double nasjonaltSnitt = beregnSnitt(originaltOmfang, årInntektNorge);
            for (OpptjeningUT o : originaltOmfang) {
                if (o.getVerdi() < nasjonaltSnitt && o.isInntektIAvtaleland()){
                    if (DEBUG) {
                        //System.out.println("Anvender nasjonalt snitt for år " + o.getAr() + ", ny verdi = " + nasjonaltSnitt);
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
     * Ved utvidet omfang skal år uten pensjonsgivende inntekt ha en inntekt lik gjennomsnittet
     * av inntekten i årene med pensjonsgivende inntekt.
     *
     */
    private void anvendGjennomsnittVedUtvidetOmfang(OpptjeningUT[] utvidetOmfang){
        int årInntektNorge = antallÅrInntektNorge(utvidetOmfang);
        double nasjonaltSnitt = beregnSnitt(utvidetOmfang, årInntektNorge);
        for (OpptjeningUT o : utvidetOmfang) {
            if (o.getVerdi() == 0 && nasjonaltSnitt > 0) {
                if (DEBUG) {
                    //System.out.println("Anvender nasjonalt snitt for år " + o.getAr() + ", ny verdi = " + nasjonaltSnitt);
                }
                o.setAvkortetBelop(nasjonaltSnitt);
            }
        }
    }

    /**
     * Finn alle lovlige utvalg.
     * Bruker rekursjon:
     * Hvis utvalg har ønsket størrelse så beregn snitt og returner
     * Ellers
     * 1. Legger aktuellOpptjening til utvalg.
     * 2. Rekursivt kall for å finne alle lovlige utvalg videre fra neste posisjon i liste.
     * 3. Har nå forsøkt alle lovlige utvalg hvor aktuellOpptjening inngår. Fjerner derfor aktuellOpptjening fra utvalget.
     * 4. Hvis aktuellOpptjening er omsorg så hopp over denne og finn alle lovlige utvalg videre fra neste posisjon i liste
     */
    private void finnLovligUtvalg(UtvalgStatus status, OpptjeningUT[] liste) {
        if (status.utvalg.size() == status.utvalg_størrelse) {
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
            if (snitt > status.storste_snitt || status.største_snitt_utvalg == null) {
                status.storste_snitt = snitt;
                status.største_snitt_utvalg = nyttUtvalg;
                if (DEBUG) {
                    //System.out.print("Beste snitt = " + status.storste_snitt + " ved utvalg ");
                    dbg_utvalg(nyttUtvalg);
                }
            }
            status.permutasjoner++;
        } else if (status.utvalg.size() < status.utvalg_størrelse && liste.length > 0) {
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
        if (status.største_snitt_utvalg != null) {
            for (OpptjeningUT o : status.største_snitt_utvalg) {
                //System.out.print(o.getOpptjeningsar() + " ");
            }
            //System.out.println("");
        }
    }

    /**
     * Finn lovlig utvalg på 5 omsorgsoopptjening som gir det beste snitt av 3.
     * Tar hensyn til inntekt i avtaleland ved trygdeavtale, ref. §2 i
     * F12.02.2015 nr 130 Forskrift om beregning av uføretrygd etter EØS-avtalen.
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

        // Sikre at opptjeningsliste er sortert med seneste år først.
        Collections.sort(opptjeningsliste, new SynkendeArstallComparator());
        OpptjeningUT[] opptjeningArray = opptjeningsliste.toArray(new OpptjeningUT[opptjeningsliste.size()]);

        // Finn lovlige utvalg og beregn beste snitt.
        finnLovligUtvalg(status, opptjeningArray);

        if (DEBUG) {
            dbg_resultat(status);
        }

        return status.største_snitt_utvalg;
    }
}
