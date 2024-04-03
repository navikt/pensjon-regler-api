package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAfpPrivat

class BeregnAfpPrivatResponse : ServiceResponse() {
    var beregningsResultatAfpPrivat: BeregningsResultatAfpPrivat? = null
}