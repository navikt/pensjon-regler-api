package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.grunnlag.Eksportforbud
import no.nav.pensjon.regler.domain.grunnlag.Unntak

class FortsattMedlemskap : AbstraktVilkar() {
    /**
     * Fortsatt medlem i folketrygden
     */
    var fortsattMedlemFT: Boolean? = null

    /**
     * Brukeren har minst 20 års botid i Norge
     */
    var minstTyveArBotidNorge: Boolean? = null

    /**
     * Opptjent rett til tilleggspensjon etter folketrygdloven
     */
    var opptjentRettTilTPEtterFT: Boolean? = null

    /**
     * Eksportforbud
     */
    var eksportforbud: Eksportforbud? = null

    /**
     * Fri eksport fordi uførhet skyldes yrkesskade
     */
    var friEksportPgaYrkesskade: Boolean? = null

    /**
     * Innvilget garantert tilleggspensjon til ung ufør/død skal eksporteres
     */
    var innvilgetGarantertTP: Boolean? = null

    /**
     * Eksportrett garantert TP
     */
    var eksportrettGarantertTP: Unntak? = null

}