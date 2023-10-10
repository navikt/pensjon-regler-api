package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.gomregning.BeregningerFaktoromregningResultat
import java.io.Serializable
import java.util.*

class FaktoromregnBeregningBatchResponse : Serializable {
    var beregningerFaktoromregningResultatListe = Vector<BeregningerFaktoromregningResultat>()

}