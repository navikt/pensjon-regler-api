package no.nav.pensjon.regler.domain.vedtak;


import no.nav.pensjon.regler.domain.kode.EtteroppgjorResultatCti;
import no.nav.pensjon.regler.domain.util.ToStringUtil;

import java.io.Serializable;

/**
 * @author Tatyana Lochehina PK-13673
 */
public class EtteroppgjorResultat implements Serializable {
    /**
     * Totalbeløp for ytelsene uføretrygd og gjenlevendetillegg basert på tidligere vedtak, som var gjeldende (løpende eller i iverksettelsesløpet) i etteroppgjørsåret ved
     * beregning
     */
    private int tidligereBelopUT;

    /**
     * Totalbeløp for ytelsen barnetillegg fellesbarn basert på tidligere vedtak, som var gjeldende (løpende eller i iverksettelsesløpet) i etteroppgjørsåret ved beregning
     */
    private int tidligereBelopTFB;

    /**
     * Totalbeløp for ytelsen barnetillegg særkullsbarn basert på tidligere vedtak, som var gjeldende (løpende eller i iverksettelsesløpet) i etteroppgjørsåret ved beregning
     */
    private int tidligereBelopTSB;

    /**
     * Totalbeløp for delytelsene uføretrygd, gjenlevendetillegg, barnetillegg særkullsbarn og barnetillegg fellesbarn (sum av tidligereBelopUT, tidligereBelopTFB,
     * tidligereBelopTSB)
     */
    private int tidligereBelop;

    /**
     * Total beregnet uføretrygd og gjenlevendetillegg i etteroppgjørsåret
     */
    private int totalBelopUT;

    /**
     * Totalt beregnet barnetillegg fellesbarn i etteroppgjørsåret
     */
    private int totalBelopTFB;

    /**
     * Totalt beregnet barnetillegg særkullsbarn i etteroppgjørsåret
     */
    private int totalBelopTSB;

    /**
     * Totalt beregnet uføretrygd, gjenlevendetillegg, barnetillegg særkullsbarn og barnetillegg fellesbarn i etteroppgjørsåret (sum av totalBelopUT, totalBelopTFB, totalBelopTSB)
     */
    private int totalBelop;

    public int getTidligereBelopUT() {
        return tidligereBelopUT;
    }

    public void setTidligereBelopUT(int tidligereBelopUT) {
        this.tidligereBelopUT = tidligereBelopUT;
    }

    public int getTidligereBelopTFB() {
        return tidligereBelopTFB;
    }

    public void setTidligereBelopTFB(int tidligereBelopTFB) {
        this.tidligereBelopTFB = tidligereBelopTFB;
    }

    public int getTidligereBelopTSB() {
        return tidligereBelopTSB;
    }

    public void setTidligereBelopTSB(int tidligereBelopTSB) {
        this.tidligereBelopTSB = tidligereBelopTSB;
    }

    public int getTidligereBelop() {
        return tidligereBelop;
    }

    public void setTidligereBelop(int tidligereBelop) {
        this.tidligereBelop = tidligereBelop;
    }

    public int getTotalBelopUT() {
        return totalBelopUT;
    }

    public void setTotalBelopUT(int totalBelopUT) {
        this.totalBelopUT = totalBelopUT;
    }

    public int getTotalBelopTFB() {
        return totalBelopTFB;
    }

    public void setTotalBelopTFB(int totalBelopTFB) {
        this.totalBelopTFB = totalBelopTFB;
    }

    public int getTotalBelopTSB() {
        return totalBelopTSB;
    }

    public void setTotalBelopTSB(int totalBelopTSB) {
        this.totalBelopTSB = totalBelopTSB;
    }

    public int getTotalBelop() {
        return totalBelop;
    }

    public void setTotalBelop(int totalBelop) {
        this.totalBelop = totalBelop;
    }

    private static final long serialVersionUID = -1051052378612998480L;

    /**
     * Angir kronebeløp for et helt rettsgebyr
     */

    private int rettsgebyr;

    /**
     * Resultatet av etteroppgjøret.
     */

    private EtteroppgjorResultatCti etteroppgjorResultatType;

    /**
     * Toleransegrense for etterbetaling.
     */

    private int toleransegrensePositiv;

    /**
     * Toleransegrense for tilbakekreving.
     */

    private int toleransegrenseNegativ;

    /**
     * Representerer inntekten som legges til grunn for beregningen av etteroppgjøret for uføretrygden.
     */

    private int inntektUT;

    /**
     * Inntekten som legges til grunn for beregningen av etteroppgjøret for barnetillegget for fellesbarn
     */

    private int inntektTFB;

    /**
     * Inntekten som legges til grunn for beregningen av etteroppgjøret for barnetillegget for særkullsbarn
     */

    private int inntektTSB;

    /**
     * Det totale avviksbeløpet i UT, TFB og TSB.
     */

    private int avviksbelop;

    /**
     * Beløpet som utgjør differansen mellom uføretrygd og ev. gjenlevendetillegg basert på forventet og uføretrygd og ev. gjenlevendetillegg basert på lignet inntekt.
     */

    private int avviksbelopUT;

    /**
     * Beløpet som utgjør differansen mellom barnetillegget for fellesbarn basert på forventet og barnetillegget for fellesbarn basert på lignet inntekt
     */

    private int avviksbelopTFB;

    /**
     * Beløpet som utgjør differansen mellom barnetillegget for særkullsbarn basert på forventet og barnetillegget for særkullsbarn basert på lignet inntekt
     */

    private int avviksbelopTSB;

    public EtteroppgjorResultat() {
        super();
    }

    public EtteroppgjorResultat(EtteroppgjorResultat etteroppgjorResultat) {
        this();
        tidligereBelop = etteroppgjorResultat.tidligereBelop;
        tidligereBelopTFB = etteroppgjorResultat.tidligereBelopTFB;
        tidligereBelopTSB = etteroppgjorResultat.tidligereBelopTSB;
        tidligereBelopUT = etteroppgjorResultat.tidligereBelopUT;
        totalBelop = etteroppgjorResultat.totalBelop;
        totalBelopTFB = etteroppgjorResultat.totalBelopTFB;
        totalBelopTSB = etteroppgjorResultat.totalBelopTSB;
        totalBelopUT = etteroppgjorResultat.totalBelopUT;
        rettsgebyr = etteroppgjorResultat.rettsgebyr;
        inntektUT = etteroppgjorResultat.inntektUT;
        inntektTFB = etteroppgjorResultat.inntektTFB;
        inntektTSB = etteroppgjorResultat.inntektTSB;
        avviksbelop = etteroppgjorResultat.avviksbelop;
        avviksbelopUT = etteroppgjorResultat.avviksbelopUT;
        avviksbelopTFB = etteroppgjorResultat.avviksbelopTFB;
        avviksbelopTSB = etteroppgjorResultat.avviksbelopTSB;
        if (etteroppgjorResultat.etteroppgjorResultatType != null) {
            etteroppgjorResultatType = new EtteroppgjorResultatCti(etteroppgjorResultat.etteroppgjorResultatType);
        }

        toleransegrensePositiv = etteroppgjorResultat.toleransegrensePositiv;
        toleransegrenseNegativ = etteroppgjorResultat.toleransegrenseNegativ;
    }

    public int getRettsgebyr() {
        return rettsgebyr;
    }

    public void setRettsgebyr(int rettsgebyr) {
        this.rettsgebyr = rettsgebyr;
    }

    public EtteroppgjorResultatCti getEtteroppgjorResultatType() {
        return etteroppgjorResultatType;
    }

    public void setEtteroppgjorResultatType(EtteroppgjorResultatCti etteroppgjorResultatType) {
        this.etteroppgjorResultatType = etteroppgjorResultatType;
    }

    public int getToleransegrensePositiv() {
        return toleransegrensePositiv;
    }

    public void setToleransegrensePositiv(int toleransegrensePositiv) {
        this.toleransegrensePositiv = toleransegrensePositiv;
    }

    public int getToleransegrenseNegativ() {
        return toleransegrenseNegativ;
    }

    public void setToleransegrenseNegativ(int toleransegrenseNegativ) {
        this.toleransegrenseNegativ = toleransegrenseNegativ;
    }

    public int getInntektUT() {
        return inntektUT;
    }

    public void setInntektUT(int inntektUT) {
        this.inntektUT = inntektUT;
    }

    public int getInntektTFB() {
        return inntektTFB;
    }

    public void setInntektTFB(int inntektTFB) {
        this.inntektTFB = inntektTFB;
    }

    public int getInntektTSB() {
        return inntektTSB;
    }

    public void setInntektTSB(int inntektTSB) {
        this.inntektTSB = inntektTSB;
    }

    public int getAvviksbelop() {
        return avviksbelop;
    }

    public void setAvviksbelop(int avviksbelop) {
        this.avviksbelop = avviksbelop;
    }

    public int getAvviksbelopUT() {
        return avviksbelopUT;
    }

    public void setAvviksbelopUT(int avviksbelopUT) {
        this.avviksbelopUT = avviksbelopUT;
    }

    public int getAvviksbelopTFB() {
        return avviksbelopTFB;
    }

    public void setAvviksbelopTFB(int avviksbelopTFB) {
        this.avviksbelopTFB = avviksbelopTFB;
    }

    public int getAvviksbelopTSB() {
        return avviksbelopTSB;
    }

    public void setAvviksbelopTSB(int avviksbelopTSB) {
        this.avviksbelopTSB = avviksbelopTSB;
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }
}
