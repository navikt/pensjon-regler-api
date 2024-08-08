package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.AvtaleLandEnum
import no.nav.pensjon.regler.domain.kode.AvtalelandCti
import java.io.Serializable

class OppfyltVedSammenlegging : Serializable {
    /**
     * Angir om kriteriet er oppfylt eller ikke.
     */
    var oppfylt = false

    /**
     * Angir avtaleland.
     */
    var avtaleland: AvtalelandCti? = null
    var avtalelandEnum: AvtaleLandEnum? = null
}