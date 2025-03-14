package no.nav.pensjon.regler.domain

import no.nav.pensjon.regler.domain.enum.GrunnlagkildeEnum
import no.nav.pensjon.regler.domain.enum.LandkodeEnum
import java.io.Serializable
import java.util.*

open class TTPeriode : Serializable {
    /**
     * Fra-og-med dato for perioden.
     */
    var fom: Date? = null

    /**
     * Til-og-med dato for perioden.
     */
    var tom: Date? = null

    /**
     * Skal bruker ha poeng for hele året i fom-datoen
     */
    var poengIInnAr = false

    /**
     * Skal bruker ha poeng for hele året i tom-datoen
     */
    var poengIUtAr = false

    /**
     * Hvilket land perioden er opptjent i.
     */
    var landEnum: LandkodeEnum? = null

    /**
     * Om det skal regnes pro rata. Gjelder ved utenlandssaker.
     */
    var ikkeProRata = false

    /**
     * Angir om trygdetidsperioden brukes somm grunnlag på kravet.
     */
    var bruk: Boolean = true

    /**
     * Kilden til trygdetidsperioden.
     */
    var grunnlagKildeEnum: GrunnlagkildeEnum? = null

}