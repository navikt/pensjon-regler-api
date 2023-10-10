package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.beregning2011.BeregningsresultatUforetrygd
import java.io.Serializable

class BeregnUforetrygdResponse : Serializable {
    var beregningsresultatUforetrygd: BeregningsresultatUforetrygd? = null
    var pakkseddel: Pakkseddel? = null
}