package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.AvtaleLandEnum
import java.io.Serializable

class OppfyltVedSammenlegging : Serializable {
    /**
     * Angir om kriteriet er oppfylt eller ikke.
     */
    var oppfylt = false

    /**
     * Angir avtaleland.
     */
    var avtalelandEnum: AvtaleLandEnum? = null
}