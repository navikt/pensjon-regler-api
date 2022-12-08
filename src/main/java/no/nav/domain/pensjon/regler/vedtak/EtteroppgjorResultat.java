package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.kode.EtteroppgjorResultatCti;


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

}
