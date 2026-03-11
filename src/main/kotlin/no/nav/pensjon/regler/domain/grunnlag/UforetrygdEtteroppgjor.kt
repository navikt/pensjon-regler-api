package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable
import java.util.*
import java.time.LocalDate

class UforetrygdEtteroppgjor : Serializable {
    /**
     * Angir om det har vært arbeidsforsøk i etteroppgjørsåret.
     */
    var arbeidsforsok = false

    /**
     * Angir start av arbeidsforsøk.
     */
    @Deprecated("Use arbeidsforsokFomLd instead")
    var arbeidsforsokFom: Date? = null
    var arbeidsforsokFomLd: LocalDate? = null

    /**
     * Angir slutt av arbeidsforsøk.
     */
    @Deprecated("Use arbeidsforsokTomLd instead")
    var arbeidsforsokTom: Date? = null
    var arbeidsforsokTomLd: LocalDate? = null
    var detaljer: List<UforetrygdEtteroppgjorDetalj> = mutableListOf()

    /**
     * Angir start av uføretrygd i etteroppgjørsåret.
     */
    @Deprecated("Use periodeFomLd instead")
    var periodeFom: Date? = null
    var periodeFomLd: LocalDate? = null

    /**
     * Angir slutt av uføretrygd i etteroppgjørsåret.
     */
    @Deprecated("Use periodeTomLd instead")
    var periodeTom: Date? = null
    var periodeTomLd: LocalDate? = null
}