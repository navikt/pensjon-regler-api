package no.nav.pensjon.regler.domain.vedtak

class Uforegrad : AbstraktBeregningsvilkar() {
    /**
     * Angir Uføregraden UFG.
     */
    var uforegrad = 0

    /**
     * Angir hvilende rett til garantigrad.
     */
    var isErGarantigrad = false

}