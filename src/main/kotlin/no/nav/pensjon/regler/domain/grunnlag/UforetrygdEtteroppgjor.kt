package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable
import java.util.*

class UforetrygdEtteroppgjor : Serializable {
    /**
     * Angir om det har vært arbeidsforsøk i etteroppgjørsåret.
     */
    var arbeidsforsok = false

    /**
     * Angir start av arbeidsforsøk.
     */
    var arbeidsforsokFom: Date? = null

    /**
     * Angir slutt av arbeidsforsøk.
     */
    var arbeidsforsokTom: Date? = null
    var detaljer: List<UforetrygdEtteroppgjorDetalj> = mutableListOf()

    /**
     * Angir start av uføretrygd i etteroppgjørsåret.
     */
    var periodeFom: Date? = null

    /**
     * Angir slutt av uføretrygd i etteroppgjørsåret.
     */
    var periodeTom: Date? = null
}