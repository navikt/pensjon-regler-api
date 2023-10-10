package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.grunnlag.Eksportrett

class RettTilEksportEtterTrygdeavtaler : AbstraktVilkar() {
    /**
     * Eksportrett etter EØS forordning
     */
    var eksportrettEtterEOSForordning: Eksportrett? = null

    /**
     * Eksportrett etter trygdeavtaler EØS
     */
    var eksportrettEtterTrygdeavtalerEOS: Eksportrett? = null

    /**
     * Eksportrett etter andre trygdeavtaler.
     */
    var eksportrettEtterAndreTrygdeavtaler: Eksportrett? = null

}