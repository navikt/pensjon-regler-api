package no.nav.pensjon.regler.domain.vedtak

class Uforegrad : AbstraktBeregningsvilkar() {
    /**
     * Angir Uføregraden UFG.
     */
    var uforegrad = 0

    /**
     * Angir hvilende rett til garantigrad.
     */
    var erGarantigrad = false

    /**
     * Angir om uføregrad har økt uten at restarbeidsevne er vurdert
     */
    var øktUføregradUtenVurderingAvRestarbeidsevne = false

}