package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.kode.BorMedTypeCti
import no.nav.pensjon.regler.domain.kode.MinsteytelseNivaCti
import java.io.Serializable

class SatsMinsteytelse : Serializable {
    var sats = 0.0
    var satsType: MinsteytelseNivaCti? = null
    var benyttetSivilstand: BorMedTypeCti? = null
    var isBenyttetUngUfor = false
    var isOppfyltUngUfor = false

    /**
     * Angir om ung Uføregaranti ikke er benyttet pga eksportforbud.
     */
    var isEksportForbudUngUfor = false

}