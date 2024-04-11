package no.nav.pensjon.regler.domain.beregning2011

import java.io.Serializable

abstract class AbstraktBarnetilleggUT : AbstraktBarnetillegg, Serializable, UforetrygdYtelseskomponent {
    /**
     * Detaljer rundt avkortning av netto barnetillegg.
     */
    var avkortingsinformasjon: AvkortingsinformasjonBT? = null

    /**
     * Inntektsavkortningsbeløp per år, før justering med differansebeløp
     */
    var avkortningsbelopPerAr = 0

    /**
     * Inntekt som fører til at barnetillegget ikke blir utbetalt
     */
    var inntektstak = 0

    /**
     * Akkumulert netto hittil i året eksklusiv måned for beregningsperiodens fomDato.
     */
    var nettoAkk = 0

    /**
     * Gjenstående beløp brukeren har rett på for året som beregningsperioden starter, og inkluderer måneden det beregnes fra.
     */
    var nettoRestAr = 0

    /**
     * Uttrykker avviket mellom ytelseskomponenten basert på løpende inntektsavkorting og ytelseskomponenten basert på lignet inntekt.
     */
    var periodisertAvvikEtteroppgjor = 0.0

    /**
     * Detaljer rundt reduksjon av brutto barnetillegg.
     */
    var reduksjonsinformasjon: Reduksjonsinformasjon? = null

    /**
     * årsbeløp for delytelsen fra tidligere vedtak (fra tilsvarende beregningsperiode)
     */
    override var tidligereBelopAr = 0

    /**
     * Brukers uføretrygd før justering
     */
    var brukersUforetrygdForJustering = 0

    constructor()

    constructor(ab: AbstraktBarnetilleggUT) : super(ab) {
        inntektstak = ab.inntektstak
        nettoAkk = ab.nettoAkk
        nettoRestAr = ab.nettoRestAr
        reduksjonsinformasjon = ab.reduksjonsinformasjon
        avkortingsinformasjon = ab.avkortingsinformasjon
        periodisertAvvikEtteroppgjor = ab.periodisertAvvikEtteroppgjor
        tidligereBelopAr = ab.tidligereBelopAr
        brukersUforetrygdForJustering = ab.brukersUforetrygdForJustering
    }

}