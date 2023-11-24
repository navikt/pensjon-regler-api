package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.gomregning.KravFaktoromregningResultat
import java.io.Serializable
import java.util.*

class FaktoromregnInntektBatchResponse : Serializable {
    var kravFaktoromregningResultatListe = mutableListOf<KravFaktoromregningResultat>()
}