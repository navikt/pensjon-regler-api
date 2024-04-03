package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.gomregning.BeregningerFaktoromregningResultat

import java.util.*

class FaktoromregnBeregningBatchResponse : ServiceResponse() {
    var beregningerFaktoromregningResultatListe = Vector<BeregningerFaktoromregningResultat>()

}