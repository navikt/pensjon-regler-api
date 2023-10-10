package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable
import java.util.*

// TODO Skriv om compare-funksjonen
class Uttaksgrad : Serializable, Comparable<Uttaksgrad> {
    var fomDato: Date? = null
    var tomDato: Date? = null
    var uttaksgrad = 0

    override fun compareTo(other: Uttaksgrad): Int {
        return DateCompareUtil.compareTo(fomDato, other.fomDato)
    }

}

object DateCompareUtil {
    const val BEFORE = -1
    const val EQUAL = 0
    const val AFTER = 1

    /**
     * Returnerer resultat i forhold til compareTo standard
     *
     * @param first - dato fra kallende klasse
     * @param second - dato fra argument til compareTo
     * @return
     */
    fun compareTo(first: Date?, second: Date?): Int {
        // null sorteres foran
        if (first == null) {
            return if (second == null) {
                EQUAL
            } else {
                BEFORE
            }
        } else if (second == null) {
            return AFTER
        }
        return first.compareTo(second)
    }
}