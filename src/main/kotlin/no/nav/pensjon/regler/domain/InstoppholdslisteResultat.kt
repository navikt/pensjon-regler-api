package no.nav.pensjon.regler.domain

import no.nav.pensjon.regler.domain.grunnlag.InstOpphPeriodegrunnlag
import java.io.Serializable

class InstoppholdslisteResultat : Serializable {
    /**
     * Merknaden innholder feilkoden fra regeltjenesten.
     */
    private var merknad: Merknad? = null

    /**
     * Returlisten av periodegrunnlagene. Utfylt når merknad er null.
     */
    var instOpphPeriodegrunnlagListe: MutableList<InstOpphPeriodegrunnlag> = mutableListOf()
}