package no.nav.pensjon.regler.domain.vedtak

class TidligereGjenlevendePensjon : AbstraktBeregningsvilkar() {
    /**
     * Angir om bruker mottok GJP som fålge av avdødes dødsfall.
     */
    var sokerMottokGJPForAvdod = false

    /**
     * Angir om avdøde hadde inntekt på minst 1G før dødsfall
     */
    var arligPGIMinst1G = false

}