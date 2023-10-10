package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable

class EOSGrunnlag : Serializable {
    /**
     * Garantibeløp for alderspensjons
     */
    var apgBelop = 0

    /**
     * faktisk trygdetid i Norge, i måneder
     */
    var faktiskTT_Norge = 0

    /**
     * faktisk trygdetid i Norden, utenom Norge, i måneder
     */
    var faktiskTT_Norden = 0

    /**
     * faktisk trygdetid i EØS land, i måneder
     */
    var faktiskTT_EOS = 0

    /**
     * faktisk trygdetid i øvrige land med bilateral avtale, i måneder
     */
    var faktiskTT_Ovrige = 0

    /**
     * Antall faktiske trygdetidsår - brukes ved bilaterale avtale med Canada
     */
    var faktiskTT_Ar = 0

}