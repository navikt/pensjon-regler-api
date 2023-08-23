package no.nav.pensjon.regler.domain.beregning2011

import java.io.Serializable

class BeregningsInformasjonMinstenivatilleggPensjonistpar : Serializable {
    /*
     * Beregnet pensjon pensjon
     */
    var samletPensjon = 0.0

    /*
       * Minstepensjonsniva sats
       */
    var mpnSatsOrdinaer = 0.0

    /*
       * Garantipensjonpensjonsniva sats
       */
    var garPNSatsOrdinaer = 0.0

    /*
       * saertillegg sats
       */
    var stSatsOrdinaer = 0.0

    /*
       * tt anvendt brukt i alderspensjon etter kapittel 19
       */
    var tt_anv_AP = 0

    /*
       * tt anvendt brukt i alderspensjon etter kapittel 20
       */
    var tt_anv_AP_Kapittel20 = 0

    /*
       * tt anvendt brukt i uforepensjon
       */
    var tt_anv_UP = 0

    /*
       * trygdetid i prorata beregning
       */
    var prorataUP = 0.0

    /*
       * teller for proratabrok
       */
    var prorataUPTeller = 0

    /*
       * nevner for proratabrok
       */
    var prorataUPNevner = 0

    /*
       * personens gjeldende uttaksgrad
       */
    var uttaksgrad = 0

    /*
       * personens gjeldende uforegrad
       */
    var uforegrad = 0

}