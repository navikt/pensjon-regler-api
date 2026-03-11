package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable
import java.util.*
import java.time.LocalDate

/**
 * Objektet inneholder informasjon om den månedlige faste utgiften en bruker har hatt i forbindelse med
 * opphold på en institusjon. Det inneholder også tidsrommet brukeren var innlagt.
 */
class InstOpphFasteUtgifterperiode : Serializable {
    //	instOpphFasteUtgifterperiodeId	long	Unik identifikasjon av objektet.
    //	fomDato	Date	Dato bruker ble innlagt
    //	tomDato	Date	Dato bruker ble skrevet ut.
    //	fasteUtgifter	int	månedlig fast utgift bruker hadde på 
    /**
     * Unik identifikasjon av objektet
     */
    var instOpphFasteUtgifterperiodeId: Long = 0

    /**
     * Dato bruker ble innlagt
     */
    @Deprecated("Use fomLd instead")
    var fom: Date? = null
    var fomLd: LocalDate? = null

    /**
     * Dato bruker ble skrevet ut
     */
    @Deprecated("Use tomLd instead")
    var tom: Date? = null
    var tomLd: LocalDate? = null

    /**
     * månedlig fast utgift bruker hadde på institusjonen
     */
    var fasteUtgifter = 0

}