package no.nav.domain.pensjon.regler.util;

import no.nav.domain.pensjon.regler.beregning2011.OpptjeningUT;
import no.nav.domain.pensjon.regler.util.OmsorgspoengCompareUtil.StorrelseOgLeksikografiskArstallComparator;
import no.nav.domain.pensjon.regler.util.OmsorgspoengCompareUtil.SynkendeArstallComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static no.nav.domain.pensjon.regler.util.OmsorgspoengCompareUtil.OriginaltOmfangComparator;
import static no.nav.domain.pensjon.regler.util.OmsorgspoengCompareUtil.UtvidetOmfangComparator;

public class OmsorgspoengTrygdeavtaleKombinasjon implements Comparable<OmsorgspoengTrygdeavtaleKombinasjon> {
    private double nasjonaltSnitt;
    private double beregningsgrunnlagUavrundet;
    private double sumAvJusterteBelopIBG;
    private LinkedList<OpptjeningUT> kombinasjon;
    private OmsorgspoengTrygdeavtaleKombinasjon utvidetOmfangKombinasjon;
    private int antallValgteIal;
    private int antallPlasser;
    private boolean harNorskOpptjening;
    private List<OpptjeningUT> relevanteArForUtvidetOmfang;
    private boolean erUtvidetOmfang;

    /**
     * Merk at denne kopikonstruktøren ikke er fullverdig da den ikke kopierer OpptjeningUT.
     *
     * @param kombinasjon
     */
    public OmsorgspoengTrygdeavtaleKombinasjon(OmsorgspoengTrygdeavtaleKombinasjon kombinasjon) {
        this.nasjonaltSnitt = kombinasjon.nasjonaltSnitt;
        this.beregningsgrunnlagUavrundet = kombinasjon.beregningsgrunnlagUavrundet;
        this.sumAvJusterteBelopIBG = kombinasjon.sumAvJusterteBelopIBG;
        this.kombinasjon = new LinkedList<OpptjeningUT>();
        for (OpptjeningUT o : kombinasjon.kombinasjon) {
            this.kombinasjon.add(o);
        }
        if (kombinasjon.utvidetOmfangKombinasjon != null) {
            this.utvidetOmfangKombinasjon = new OmsorgspoengTrygdeavtaleKombinasjon(kombinasjon.utvidetOmfangKombinasjon);
        }
        this.antallValgteIal = kombinasjon.antallValgteIal;
        this.antallPlasser = kombinasjon.antallPlasser;
        this.harNorskOpptjening = kombinasjon.harNorskOpptjening;
        this.relevanteArForUtvidetOmfang = kombinasjon.relevanteArForUtvidetOmfang;
        this.erUtvidetOmfang = kombinasjon.erUtvidetOmfang;
    }

    /**
     * Brukes for å initialisere kombinasjon med et gitt antall plasser.
     *
     * @param antallPlasser
     */
    public OmsorgspoengTrygdeavtaleKombinasjon(int antallPlasser, boolean erUtvidetOmfang) {
        nasjonaltSnitt = 0.0;
        beregningsgrunnlagUavrundet = 0.0;
        sumAvJusterteBelopIBG = 0.0;
        kombinasjon = new LinkedList<OpptjeningUT>();
        antallValgteIal = 0;
        this.antallPlasser = antallPlasser;
        harNorskOpptjening = false;
        this.erUtvidetOmfang = erUtvidetOmfang;
    }

    /**
     * Legg til opptjeningUT til kombinasjon.
     * Setter flagg om norsk opptjening hvis avkortetBeløp er over 0.0.
     * Minsker antall plasser.
     **/
    public void leggTilOpptjeningUT(OpptjeningUT o) {
        if (o.getVerdi() > 0.0) {
            harNorskOpptjening = true;
        }
        if (o.isInntektIAvtaleland()) {
            antallValgteIal++;
        }
        antallPlasser--;
        kombinasjon.add(o);
    }

    /**
     * Legg til flere OpptjeningUT ved iterativt kall til leggTilOpptjeningUT(OpptjeningUT)
     *
     * @param os
     */
    public void leggTilOpptjeningUTer(List<OpptjeningUT> os) {
        for (OpptjeningUT o : os) {
            leggTilOpptjeningUT(o);
        }
    }

    /**
     * Regn ut det nasjonale snittet for kombinasjonen.
     * Antar at utvidet omfang ikke finnes.
     */
    public void regnNasjonaltSnitt() {
        int antallIkkeNull = 0;
        int antallIAL = 0;
        double nasjonalt = 0.0;
        for (OpptjeningUT o : kombinasjon) {
            if (o.getVerdi() > 0.0) {
                antallIkkeNull++;
                nasjonalt += o.getVerdi();
            }
            if (o.isInntektIAvtaleland()) {
                antallIAL++;
            }
        }
        double nasjonaltSnitt = 0.0;

//        IKKE (originalt omfang OG (antall PGI = 5 ELLER antall IAL = 0))
        if (antallIkkeNull > 0 && !(!erUtvidetOmfang && (antallIkkeNull == 5 || antallIAL == 0))) {
//        if ( antallIkkeNull > 0 ) {
            nasjonaltSnitt = nasjonalt / antallIkkeNull;
        }

        this.nasjonaltSnitt = nasjonaltSnitt;
    }

    /**
     * Regner uavrundet beregningsgrunnlag.
     * Funksjonalitet for å arve fra kombinasjon fra utvidet omfang hvis denne finnes.
     */
    public void regnBeregningsgrunnlagUavrundet() {
        if (utvidetOmfangKombinasjon != null) {
            beregningsgrunnlagUavrundet = utvidetOmfangKombinasjon.beregningsgrunnlagUavrundet;
        } else {
            double sumAvTreBeste = 0.0;
            //Sorterer OpptjeningUTer i synkende rekkefølge. Måten det sorteres på er avhengig av om vi behandler utvidet omfang eller ikke.
            if (this.erUtvidetOmfang) {
                Collections.sort(kombinasjon, new UtvidetOmfangComparator(nasjonaltSnitt));
                for (int i = 0; i < 3 && i < kombinasjon.size(); i++) {
                    if (kombinasjon.get(i).getVerdi() == 0) {
                        sumAvTreBeste += nasjonaltSnitt;
                    } else {
                        sumAvTreBeste += kombinasjon.get(i).getVerdi();
                    }
                    sumAvJusterteBelopIBG += kombinasjon.get(i).getJustertBelop();
                }
            } else {
                Collections.sort(kombinasjon, new OriginaltOmfangComparator(nasjonaltSnitt));
                for (int i = 0; i < 3 && i < kombinasjon.size(); i++) {
                    if (kombinasjon.get(i).isInntektIAvtaleland() && kombinasjon.get(i).getVerdi() < nasjonaltSnitt) {
                        sumAvTreBeste += nasjonaltSnitt;
                    } else {
                        sumAvTreBeste += kombinasjon.get(i).getVerdi();
                    }
                    sumAvJusterteBelopIBG += kombinasjon.get(i).getJustertBelop();
                }
            }

            this.beregningsgrunnlagUavrundet = sumAvTreBeste / 3;
        }
    }

    //    @Override
    public int compareTo(OmsorgspoengTrygdeavtaleKombinasjon k) {
        if (k.getBeregningsgrunnlagUavrundet() > beregningsgrunnlagUavrundet) {
            return 1;
        } else if (k.getBeregningsgrunnlagUavrundet() < beregningsgrunnlagUavrundet) {
            return -1;
        }
        //Kombinasjonene kunne ikke distingveres på beregningsgrunnlagUavrundet.
        //Forsøker å sortere på beste sum av justertBelop for årene som inngår i snittet beregningsgrunnlaget i stedet.
        else if (k.getSumAvJusterteBelopIBG() > sumAvJusterteBelopIBG) {
            return 1;
        } else if (k.getSumAvJusterteBelopIBG() < sumAvJusterteBelopIBG) {
            return -1;
        }
        //OpptjeningUT kunne ikke distingveres på justertBelop heller. Sorter disse leksikografisk på årene til OpptjeningUT.
        List<OpptjeningUT> valgteArK = new ArrayList<OpptjeningUT>(k.getKombinasjon());
        if (k.getUtvidetOmfang() != null) {
            valgteArK.addAll(k.getUtvidetOmfang().getKombinasjon());
        }
        List<OpptjeningUT> valgteArDenne = new ArrayList<OpptjeningUT>(kombinasjon);
        if (utvidetOmfangKombinasjon != null) {
            valgteArDenne.addAll(utvidetOmfangKombinasjon.getKombinasjon());
        }
        Collections.sort(valgteArK, new SynkendeArstallComparator());
        Collections.sort(valgteArDenne, new SynkendeArstallComparator());
        return new StorrelseOgLeksikografiskArstallComparator().compare(valgteArDenne, valgteArK);
    }

    public double getNasjonaltSnitt() {
        return nasjonaltSnitt;
    }

    public void setNasjonaltSnitt(double nasjonaltSnitt) {
        //Ingen funksjonalitet her. Metoden finnes så Blaze ikke tolker beregningsgrunnlagUavrundet som read only. Feltet kan forandre seg.
    }

    public double getBeregningsgrunnlagUavrundet() {
        return beregningsgrunnlagUavrundet;
    }

    public void setBeregningsgrunnlagUavrundet(double beregningsgrunnlagUavrundet) {
        //Ingen funksjonalitet her. Metoden finnes så Blaze ikke tolker beregningsgrunnlagUavrundet som read only. Feltet kan forandre seg.
    }

    public double getSumAvJusterteBelopIBG() {
        return sumAvJusterteBelopIBG;
    }

    public void setSumAvJusterteBelopIBG(double setSumAvJusterteBelopIBG) {
        //Ingen funksjonalitet her. Metoden finnes så Blaze ikke tolker beregningsgrunnlagUavrundet som read only. Feltet kan forandre seg.
    }

    public LinkedList<OpptjeningUT> getKombinasjon() {
        return kombinasjon;
    }

    public void setKombinasjon(LinkedList<OpptjeningUT> kombinasjon) {
        this.kombinasjon = kombinasjon;
    }

    public LinkedList<OpptjeningUT> getKombinasjonSortert() {
        if ( !this.erUtvidetOmfang ) {
            Collections.sort(kombinasjon, new OriginaltOmfangComparator(nasjonaltSnitt));
        } else {
            Collections.sort(kombinasjon, new UtvidetOmfangComparator(nasjonaltSnitt));
        }
        return kombinasjon;
    }

    public OpptjeningUT[] getKombinasjonSortertAsArray() {
        return kombinasjon != null ? getKombinasjonSortert().toArray(new OpptjeningUT[kombinasjon.size()]) : new OpptjeningUT[0];
    }

    public OmsorgspoengTrygdeavtaleKombinasjon getUtvidetOmfang() {
        return utvidetOmfangKombinasjon;
    }

    /**
     * Setter kombinasjon fra utvidet omfang. Merk at sum av justerte beløp, nasjonalt snitt arves.
     *
     * @param kombinasjon
     */
    public void setUtvidetOmfang(OmsorgspoengTrygdeavtaleKombinasjon kombinasjon) {
        this.nasjonaltSnitt = kombinasjon.nasjonaltSnitt;
        this.sumAvJusterteBelopIBG = kombinasjon.sumAvJusterteBelopIBG;
        this.utvidetOmfangKombinasjon = kombinasjon;
    }

    public int getAntallValgteIal() {
        return antallValgteIal;
    }

    public void setAntallValgteIal(int antallValgteIal) {
        this.antallValgteIal = antallValgteIal;
    }

    public int getAntallPlasser() {
        return antallPlasser;
    }

    public void setAntallPlasser(int antallPlasser) {
        this.antallPlasser = antallPlasser;
    }

    public boolean isHarNorskOpptjening() {
        return harNorskOpptjening;
    }

    public void setHarNorskOpptjening(boolean harNorskOpptjening) {
        this.harNorskOpptjening = harNorskOpptjening;
    }

    public List<OpptjeningUT> getRelevanteArForUtvidetOmfang() {
        return relevanteArForUtvidetOmfang;
    }

    public void setRelevanteArForUtvidetOmfang(List<OpptjeningUT> relevanteArForUtvidetOmfang) {
        this.relevanteArForUtvidetOmfang = relevanteArForUtvidetOmfang;
    }
}