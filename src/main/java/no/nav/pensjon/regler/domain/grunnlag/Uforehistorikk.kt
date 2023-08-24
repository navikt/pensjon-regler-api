package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable
import java.util.*

class Uforehistorikk : Serializable {
    /**
     * Liste av Uføreperioder.
     */
    var uforeperiodeListe: List<Uforeperiode> = mutableListOf()

    /**
     * Uføregraden pensjonen er blitt fryst fra.
     */
    var garantigrad = 0

    /**
     * Yrkesskadegraden pensjonen er blitt fryst fra.
     */
    var garantigradYrke = 0

    /**
     * Dato for sist innmeldt i Folketrygden- for fremtidig trygdetid.
     * Lagt inn ifm PENPORT-2222
     */
    var sistMedlITrygden: Date? = null

}