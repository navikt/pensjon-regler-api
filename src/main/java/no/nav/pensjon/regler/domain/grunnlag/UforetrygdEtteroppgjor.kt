package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable
import java.util.*

/**
 * @author Tatyana Lochehina PK-13673
 * @author Swiddy de Louw (Capgemini) PK-13673
 */
class UforetrygdEtteroppgjor : Serializable {
    /**
     * Angir om det har vært arbeidsforsøk i etteroppgjørsåret.
     */
    var isArbeidsforsok = false

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