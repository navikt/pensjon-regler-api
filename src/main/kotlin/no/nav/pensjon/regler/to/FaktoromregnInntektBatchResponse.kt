package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.gomregning.KravFaktoromregningResultat

import java.util.*

class FaktoromregnInntektBatchResponse : ServiceResponse() {
    var kravFaktoromregningResultatListe = Vector<KravFaktoromregningResultat>()
}