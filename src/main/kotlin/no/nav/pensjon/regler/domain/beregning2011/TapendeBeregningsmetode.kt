package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.BeregningsmetodeEnum
import java.io.Serializable

class TapendeBeregningsmetode : Serializable {
    var beregningMetodeTypeEnum: BeregningsmetodeEnum? = null
}