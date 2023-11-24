package no.nav.pensjon.regler.domain.gomregning

import no.nav.pensjon.regler.domain.BatchStatus
import no.nav.pensjon.regler.domain.beregning.Beregning
import java.io.Serializable

class BeregningerFaktoromregningResultat : Serializable {
    var vedtakId: Long? = null
    var batchStatus: BatchStatus? = null
    var beregningResultatListe: MutableList<Beregning> = mutableListOf()
}