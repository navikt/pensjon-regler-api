package no.nav.pensjon.regler.domain.vedtak

import java.util.*

class Uforetidspunkt : AbstraktBeregningsvilkar() {
    /**
     * Angir det tidligste året som kan påvirke opptjeningen for dette uføretidspunktet.
     */
    var tidligstVurderteAr = 0
    var uforetidspunkt: Date? = null

    /**
     * Dato for når man var sist innmeldt i folketrygden. Benyttes for fremtidig trygdetid.
     */
    var sistMedlTrygden: Date? = null

}