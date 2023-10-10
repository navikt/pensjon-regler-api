package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.kode.OppholdTypeCti
import no.nav.pensjon.regler.domain.kode.VarighetTypeCti
import java.io.Serializable
import java.util.*

/**
 * En periode for et opphold på institusjon
 */
class InstOpphPeriodegrunnlag : Serializable {
    /**
     * Kun brukt i PEN
     */
    var instOppholdId: Long = 0

    /**
     * Kode som angir type opphold.
     */
    var oppholdType: OppholdTypeCti? = null

    /**
     * Varighetstypen på institusjonsoppholdet.
     */
    var varighetType: VarighetTypeCti? = null

    /**
     * Fradato for oppholdet
     */
    var fom: Date? = null

    /**
     * Tildato for oppholdet
     */
    var tom: Date? = null

    /**
     * Forventet tildato for oppholdet - oppholdet pågår.
     */
    var forventetTom: Date? = null

    /**
     * Kun brukt i PEN
     */
    var registerOpprettetAv: String? = null

    /**
     * Kun brukt i PEN
     */
    var registerEndretAv: String? = null

    /**
     * Kun brukt i PEN
     */
    var registerOpprettetDato: Date? = null

    /**
     * Kun brukt i PEN
     */
    var registerEndretDato: Date? = null

    /**
     * Kun brukt i PEN
     */
    var registerKilde: String? = null

    /**
     * Angir om institusjonsoppholdet er overfårt til en annen institusjon.
     */
    var overfort = false

    /**
     * Kun brukt i PEN
     */
    var bruk: Boolean = true

}