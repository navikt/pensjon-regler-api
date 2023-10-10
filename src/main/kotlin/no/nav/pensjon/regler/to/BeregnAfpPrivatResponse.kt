package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAfpPrivat
import java.io.Serializable

class BeregnAfpPrivatResponse : Serializable {
    var beregningsResultatAfpPrivat: BeregningsResultatAfpPrivat? = null
    var pakkseddel: Pakkseddel? = null
}