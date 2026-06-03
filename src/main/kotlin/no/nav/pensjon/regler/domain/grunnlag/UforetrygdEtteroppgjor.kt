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
    var arbeidsforsokFomLd: LocalDate? = null

    /**
     * Angir slutt av arbeidsforsøk.
     */
    var arbeidsforsokTomLd: LocalDate? = null
    var detaljer: List<UforetrygdEtteroppgjorDetalj> = mutableListOf()

    /**
     * Angir start av uføretrygd i etteroppgjørsåret.
     */
    var periodeFomLd: LocalDate? = null

    /**
     * Angir slutt av uføretrygd i etteroppgjørsåret.
     */
    var periodeTomLd: LocalDate? = null
}