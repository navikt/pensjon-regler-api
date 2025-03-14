package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.JustertPeriodeEnum
import java.io.Serializable
import java.util.*

/**
 * Objektet inneholder informasjon om perioder der person har institusjonsopphold som kan medfåre reduksjon av pensjon.
 */
class InstOpphReduksjonsperiode : Serializable {
    /**
     * Unik identifikasjon av objektet.
     */
    var instOpphReduksjonsperiodeId: Long = 0

    /**
     * Fra og med dato
     */
    var fom: Date? = null

    /**
     * Til og med dato
     */
    var tom: Date? = null

    /**
     * Angir om reduksjon er grunnet varighet.
     */
    var reduksjonGrunnetVarighet = false

    /**
     * Angir om institusjonsoppholdsperioden medfører en økning eller reduksjon av pensjonsytelsen.
     */
    var justertPeriodeTypeEnum: JustertPeriodeEnum? = null

    /**
     * Angir om bruker har forsørgeransvar ved institusjonsopphold
     */
    var forsorgeransvar = false

}