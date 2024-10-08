package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.OpptjeningPOPPTypeEnum
import no.nav.pensjon.regler.domain.kode.OpptjeningPOPPTypeCti
import java.io.Serializable

class OpptjeningTypeMapping : Serializable {
    var opptjeningPOPPTypeCti: OpptjeningPOPPTypeCti? = null
    var opptjeningPOPPTypeEnum: OpptjeningPOPPTypeEnum? = null
}