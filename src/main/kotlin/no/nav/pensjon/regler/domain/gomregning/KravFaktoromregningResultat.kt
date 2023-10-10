package no.nav.pensjon.regler.domain.gomregning

import no.nav.pensjon.regler.domain.BatchStatus
import java.io.Serializable

class KravFaktoromregningResultat : Serializable {
    var kravId: Long? = null
    var batchStatus: BatchStatus? = null
    var persongrunnlagOmregningResultatListe: List<PersongrunnlagOmregningResultat> = mutableListOf()
}