package no.nav.pensjon.regler.domain.beregning2011

import java.io.Serializable
import java.util.*

class LonnsvekstInformasjon : Serializable {
    /**
     * @param lonnsvekst the lonnsvekst to set
     */
    var lonnsvekst = 0.0

    /**
     * @param reguleringsDato the reguleringsDato to set
     */
    var reguleringsDato: Date? = null

    /**
     * @param uttaksgradVedRegulering the uttaksgradVedRegulering to set
     */
    var uttaksgradVedRegulering = 0
}