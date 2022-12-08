package no.nav.domain.pensjon.regler.beregning2011;

import java.io.Serializable;

/**
 * Angir detaljer rund avkortingen av uføretrygd.
 */
public class AvkortingsinformasjonUT extends AbstraktAvkortingsinformasjon implements Serializable {



    /**
     * Beløpsgrense.
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
     * Inntektsgrense nest år settes når neste års inntektsgrense beregnes
     */
    private int inntektsgrenseNesteAr;

    /**
     * Inntektstaket for påfølgende år fastsatt på bakgrunn av siste gjeldende OIFU i året. Feltet er kun angitt dersom inntektstak neste år avviker fra gjeldende inntektstak.
     */
    private int inntektstakNesteAr;
    /**
     * Angir dekningsgrad av tapt arbeidsevne.
     */
    private double kompensasjonsgrad;

    /**
     * Oppjustert inntekt etter uførhet.
     */
    private int oieu;

    /**
     * Oppjustert inntekt før uførhet.
     */
    private int oifu;

    /**
     * Den OIFU som er angitt i beregningsperioden. Denne er ikke nødvendigvis den høyeste i året og skal benyttes for beregning av brutto barnetillegg.
     */
    private int oifuForBarnetillegg;

    /**
     * Beregnet årlig bruttobeløp etter full uføregrad.
     */
    private int ugradertBruttoPerAr;

    /**
     * Utbetalingsgrad etter inntektsavkorting.
     */
    private int utbetalingsgrad;

    /**
     * Beløpet som skal legges til avkortningsbeløpet for å få fradraget som er nødvendig for å kompensere for tidligere for lite eller mye avkortet.
     */
    private int differansebelop;

}
