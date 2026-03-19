package no.nav.pensjon.regler.domain.beregning2011

import java.io.Serializable

/**
 * Angir detaljer rund avkortingen av uføretrygd.
 */
class AvkortingsinformasjonUT : AbstraktAvkortingsinformasjon(), Serializable {
    /**
     * beløpsgrense.
     */
    @Deprecated("PL-8188 Erstattes av fribeløp", ReplaceWith("fribeløp"))
    var belopsgrense = 0

    /**
     * beløpsgrense.
     */
    var fribeløp = 0

    /**
     * Sum av inntektskomponentene som ble lagt til grunn.
     */
    var forventetInntekt = 0

    /**
     * Inntekt under denne grensen gir ikke utslag i avkorting.
     */
    @Deprecated("PL-8188 Erstattes av bunnfradrag", ReplaceWith("bunnfradrag"))
    var inntektsgrense = 0

    /**
     * Inntekt under denne grensen gir ikke utslag i avkorting.
     */
    var bunnfradrag = 0

    /**
     * Inntektsgrense nest år settes når neste års inntektsgrense beregnes
     */
    @Deprecated("PL-8188 Erstattes av bunnfradragNesteAr", ReplaceWith("bunnfradragNesteAr"))
    var inntektsgrenseNesteAr = 0

    /**
     * Inntektsgrense nest år settes når neste års inntektsgrense beregnes
     */
    var bunnfradragNesteAr = 0

    /**
     * Inntektstaket for påfålgende år fastsatt på bakgrunn av siste gjeldende OIFU i året. Feltet er kun angitt dersom inntektstak neste år avviker fra gjeldende inntektstak.
     */
    var inntektstakNesteAr = 0

    /**
     * Angir dekningsgrad av tapt arbeidsevne.
     */
    @Deprecated("PL-8188 Erstattes av kompensasjonsgrad", ReplaceWith("kompensasjonsgrad"))
    var kompensasjonsgrad = 0.0

    /**
     * Angir dekningsgrad av tapt arbeidsevne.
     */
    var reduksjonsprosent = 0.0

    /**
     * Oppjustert inntekt etter uførhet.
     */
    var oieu = 0

    /**
     * Oppjustert inntekt før uførhet.
     */
    var oifu = 0

    /**
     * Den OIFU som er angitt i beregningsperioden. Denne er ikke nødvendigvis den Høyeste i året og skal benyttes for beregning av brutto barnetillegg.
     */
    var oifuForBarnetillegg = 0

    /**
     * Beregnet årlig bruttobeløp etter full Uføregrad.
     */
    var ugradertBruttoPerAr = 0

    /**
     * Utbetalingsgrad etter inntektsavkorting.
     */
    var utbetalingsgrad = 0

    /**
     * beløpet som skal legges til avkortningsbeløpet for å få fradraget som er nødvendig for å kompensere for tidligere for lite eller mye avkortet.
     */
    var differansebelop = 0

}