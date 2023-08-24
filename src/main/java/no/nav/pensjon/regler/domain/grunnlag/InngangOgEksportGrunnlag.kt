package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable

class InngangOgEksportGrunnlag : Serializable {
    /**
     * Minst tre års trygdetid i Norge
     */
    var treArTrygdetidNorge: Boolean? = null

    /**
     * Minst fem års trygdetid i Norge
     */
    var femArTrygdetidNorge: Boolean? = null

    /**
     * Unntak fra forutgående trygdetid
     */
    var unntakFraForutgaendeTT: Unntak? = null

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
     * Eksportrett etter EØS forordning eller trygdeavtaler med EØS-land i kraft etter 01.01.1994
     */
    var eksportrettEtterEOSForordning: Eksportrett? = null

    /**
     * Eksportrett etter trygdeavtaler med EØS-land i kraft før 01.01.1994
     */
    var eksportrettEtterTrygdeavtalerEOS: Eksportrett? = null

    /**
     * Eksportrett etter andre trygdeavtaler
     */
    var eksportrettEtterAndreTrygdeavtaler: Eksportrett? = null

    /**
     * IKKE I BRUK (se PENPORT-279)
     * Innvilget garantert tilleggspensjon til ung ufør/død skal eksporteres
     */
    private val innvilgetGarantertTP: Boolean? = null

    /**
     * Eksportrett for garantert tilleggspensjon ung ufør.
     */
    var eksportrettGarantertTP: Unntak? = null

    /**
     * Minst tre års forutgående medlemskap i Norge med uføretidspunkt FOM 01.01.1994
     */
    var minstTreArsFMNorge: Boolean? = null

    /**
     * Minst fem års forutgående medlemskap i Norge med uføretidspunkt FOM 01.01.1994 og FørsteKravFremsattdato FOM 01.01.2021
     */
    var minstFemArsFMNorge: Boolean? = null

    /**
     * Minst tre års forutgående medlemskap i Norge med uføretidspunkt før 01.01.1994 og virkningstidspunkt FOM 01.01.1990
     */
    var minstTreArsFMNorgeVirkdato: Boolean? = null

    /**
     * Unntak fra forutgående medlemskap
     */
    var unntakFraForutgaendeMedlemskap: Unntak? = null

    /**
     * Oppfylt etter gamle regler og virkningsdato før 01.01.1990
     */
    var oppfyltEtterGamleRegler: Boolean? = null

    /**
     * Oppfylt ved sammenlegging tre år
     */
    var oppfyltVedSammenlegging: OppfyltVedSammenlegging? = null

    /**
     * Oppfylt ved sammenlegging fem år
     */
    var oppfyltVedSammenleggingFemAr: OppfyltVedSammenlegging? = null

    /**
     * Oppfylt ved gjenlevendes forutgående medlemskap
     */
    var oppfyltVedGjenlevendesMedlemskap: Boolean? = null

    /**
     * Gjenlevende fortsatt medlem av folketrygden
     */
    var gjenlevendeMedlemFT: Boolean? = null

    /**
     * Avdøde har minst ett års forutgående medlemskap i Norge med dødsdato før 01.01.1994 og virkningsdato FOM 01.01.1990
     */
    var minstEttArFMNorge: Boolean? = null

    /**
     * En av foreldrene har minst 20 års botid i Norge.
     */
    var foreldreMinstTyveArBotidNorge: Boolean? = null

    /**
     * Fri eksport fordi dødsfall skyldes yrkesskade
     */
    var friEksportDodsfall: Boolean? = null

    /**
     * Brukeren har minst 20 års botid i Norge
     */
    var minstTyveArTrygdetidNorgeKap20: Boolean? = null

    /**
     * Minst tre års trygdetid i Norge
     */
    var treArTrygdetidNorgeKap20: Boolean? = null

    /**
     * Minst fem års trygdetid i Norge
     */
    var femArTrygdetidNorgeKap20: Boolean? = null

    /**
     * Oppfylt ved sammenlegging
     */
    var oppfyltVedSammenleggingKap20: OppfyltVedSammenlegging? = null

    /**
     * Oppfylt ved sammenlegging fem år
     */
    var oppfyltVedSammenleggingFemArKap20: OppfyltVedSammenlegging? = null

}