package no.nav.pensjon.regler.domain.vedtak

import java.util.*
import java.time.LocalDate

class Uforetidspunkt : AbstraktBeregningsvilkar() {
    /**
     * Angir det tidligste året som kan påvirke opptjeningen for dette uføretidspunktet.
     */
    var tidligstVurderteAr = 0
    @Deprecated("Use uforetidspunktLd instead")
    var uforetidspunkt: Date? = null
    var uforetidspunktLd: LocalDate? = null

    /**
     * Dato for når man var sist innmeldt i folketrygden. Benyttes for fremtidig trygdetid.
     */
    @Deprecated("Use sistMedlTrygdenLd instead")
    var sistMedlTrygden: Date? = null
    var sistMedlTrygdenLd: LocalDate? = null

}