package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.BorMedTypeEnum
import no.nav.pensjon.regler.domain.enum.MinsteytelseNivaEnum
import java.io.Serializable

class SatsMinsteytelse : Serializable {
    var sats = 0.0
    var satsTypeEnum: MinsteytelseNivaEnum? = null
    var benyttetSivilstandEnum: BorMedTypeEnum? = null
    var benyttetUngUfor = false
    var oppfyltUngUfor = false

    /**
     * Angir om ung Uføregaranti ikke er benyttet pga eksportforbud.
     */
    var eksportForbudUngUfor = false

}