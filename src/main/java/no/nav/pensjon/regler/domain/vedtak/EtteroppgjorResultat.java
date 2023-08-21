package no.nav.pensjon.regler.domain.vedtak;


import no.nav.pensjon.regler.domain.kode.EtteroppgjorResultatCti;
import no.nav.pensjon.regler.domain.util.ToStringUtil;

import java.io.Serializable;

/**
 * @author Tatyana Lochehina PK-13673
 */
public class EtteroppgjorResultat implements Serializable {
    /**
     * Totalbel�p for ytelsene uf�retrygd og gjenlevendetillegg basert p� tidligere vedtak, som var gjeldende (l�pende eller i iverksettelsesl�pet) i etteroppgj�rs�ret ved
     * beregning
     */
    private int tidligereBelopUT;

    /**
     * Totalbel�p for ytelsen barnetillegg fellesbarn basert p� tidligere vedtak, som var gjeldende (l�pende eller i iverksettelsesl�pet) i etteroppgj�rs�ret ved beregning
     */
    private int tidligereBelopTFB;

    /**
     * Totalbel�p for ytelsen barnetillegg s�rkullsbarn basert p� tidligere vedtak, som var gjeldende (l�pende eller i iverksettelsesl�pet) i etteroppgj�rs�ret ved beregning
     */
    private int tidligereBelopTSB;

    /**
     * Totalbel�p for delytelsene uf�retrygd, gjenlevendetillegg, barnetillegg s�rkullsbarn og barnetillegg fellesbarn (sum av tidligereBelopUT, tidligereBelopTFB,
     * tidligereBelopTSB)
     */
    private int tidligereBelop;

    /**
     * Total beregnet uf�retrygd og gjenlevendetillegg i etteroppgj�rs�ret
     */
    private int totalBelopUT;

    /**
     * Totalt beregnet barnetillegg fellesbarn i etteroppgj�rs�ret
     */
    private int totalBelopTFB;

    /**
     * Totalt beregnet barnetillegg s�rkullsbarn i etteroppgj�rs�ret
     */
    private int totalBelopTSB;

    /**
     * Totalt beregnet uf�retrygd, gjenlevendetillegg, barnetillegg s�rkullsbarn og barnetillegg fellesbarn i etteroppgj�rs�ret (sum av totalBelopUT, totalBelopTFB, totalBelopTSB)
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
     * Angir kronebel�p for et helt rettsgebyr
     */

    private int rettsgebyr;

    /**
     * Resultatet av etteroppgj�ret.
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
     * Representerer inntekten som legges til grunn for beregningen av etteroppgj�ret for uf�retrygden.
     */

    private int inntektUT;

    /**
     * Inntekten som legges til grunn for beregningen av etteroppgj�ret for barnetillegget for fellesbarn
     */

    private int inntektTFB;

    /**
     * Inntekten som legges til grunn for beregningen av etteroppgj�ret for barnetillegget for s�rkullsbarn
     */

    private int inntektTSB;

    /**
     * Det totale avviksbel�pet i UT, TFB og TSB.
     */

    private int avviksbelop;

    /**
     * Bel�pet som utgj�r differansen mellom uf�retrygd og ev. gjenlevendetillegg basert p� forventet og uf�retrygd og ev. gjenlevendetillegg basert p� lignet inntekt.
     */

    private int avviksbelopUT;

    /**
     * Bel�pet som utgj�r differansen mellom barnetillegget for fellesbarn basert p� forventet og barnetillegget for fellesbarn basert p� lignet inntekt
     */

    private int avviksbelopTFB;

    /**
     * Bel�pet som utgj�r differansen mellom barnetillegget for s�rkullsbarn basert p� forventet og barnetillegget for s�rkullsbarn basert p� lignet inntekt
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
