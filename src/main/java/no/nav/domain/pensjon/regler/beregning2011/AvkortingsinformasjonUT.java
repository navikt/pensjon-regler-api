package no.nav.domain.pensjon.regler.beregning2011;

import java.io.Serializable;

/**
 * Angir detaljer rund avkortingen av uf�retrygd.
 */
public class AvkortingsinformasjonUT extends AbstraktAvkortingsinformasjon implements Serializable {



    /**
     * Bel�psgrense.
     */
    private int belopsgrense;

    /**
     * Sum av inntektskomponentene som ble lagt til grunn.
     */
    private int forventetInntekt;

    /**
     * Inntekt under denne grensen gir ikke utslag i avkorting.
     */
    private int inntektsgrense;

    /**
     * Inntektsgrense nest �r settes n�r neste �rs inntektsgrense beregnes
     */
    private int inntektsgrenseNesteAr;

    /**
     * Inntektstaket for p�f�lgende �r fastsatt p� bakgrunn av siste gjeldende OIFU i �ret. Feltet er kun angitt dersom inntektstak neste �r avviker fra gjeldende inntektstak.
     */
    private int inntektstakNesteAr;
    /**
     * Angir dekningsgrad av tapt arbeidsevne.
     */
    private double kompensasjonsgrad;

    /**
     * Oppjustert inntekt etter uf�rhet.
     */
    private int oieu;

    /**
     * Oppjustert inntekt f�r uf�rhet.
     */
    private int oifu;

    /**
     * Den OIFU som er angitt i beregningsperioden. Denne er ikke n�dvendigvis den h�yeste i �ret og skal benyttes for beregning av brutto barnetillegg.
     */
    private int oifuForBarnetillegg;

    /**
     * Beregnet �rlig bruttobel�p etter full uf�regrad.
     */
    private int ugradertBruttoPerAr;

    /**
     * Utbetalingsgrad etter inntektsavkorting.
     */
    private int utbetalingsgrad;

    /**
     * Bel�pet som skal legges til avkortningsbel�pet for � f� fradraget som er n�dvendig for � kompensere for tidligere for lite eller mye avkortet.
     */
    private int differansebelop;

}
