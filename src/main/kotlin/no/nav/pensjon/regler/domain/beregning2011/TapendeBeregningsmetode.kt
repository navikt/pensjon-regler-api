package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.BeregningsmetodeEnum
import no.nav.pensjon.regler.domain.kode.BeregningMetodeTypeCti
import java.io.Serializable

class TapendeBeregningsmetode : Serializable {
    var beregningMetodeTypeCti: BeregningMetodeTypeCti? = null
    var beregningMetodeTypeEnum: BeregningsmetodeEnum? = null
    var tapendeBeregningsmetodeId: Long = 0
}