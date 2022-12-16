package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;

import no.nav.domain.pensjon.regler.vedtak.FortsattMedlemskap;
import no.nav.domain.pensjon.regler.vedtak.ForutgaendeMedlemskap;
import no.nav.domain.pensjon.regler.vedtak.MedlemskapForUTEtterTrygdeavtaler;
import no.nav.domain.pensjon.regler.vedtak.RettTilEksportEtterTrygdeavtaler;

/**
 * @author Magnus Bakken (Accenture), PK-9695, PKPYTON-923
 * @author Aasmund Nordstoga (Accenture) PK-19079, PKPYTON-1962
 */
public class InngangOgEksportGrunnlag implements Serializable {


    /**
     * Minst tre års trygdetid i Norge
     */
    private Boolean treArTrygdetidNorge;
    /**
     * Minst fem års trygdetid i Norge
     */
    private Boolean femArTrygdetidNorge;
    /**
     * Unntak fra forutgående trygdetid
     */
    private Unntak unntakFraForutgaendeTT;
    /**
     * Fortsatt medlem i folketrygden
     */
    private Boolean fortsattMedlemFT;
    /**
     * Brukeren har minst 20 års botid i Norge
     */
    private Boolean minstTyveArBotidNorge;
    /**
     * Opptjent rett til tilleggspensjon etter folketrygdloven
     */
    private Boolean opptjentRettTilTPEtterFT;
    /**
     * Eksportforbud
     */
    private Eksportforbud eksportforbud;
    /**
     * Fri eksport fordi uførhet skyldes yrkesskade
     */
    private Boolean friEksportPgaYrkesskade;
    /**
     * Eksportrett etter EØS forordning eller trygdeavtaler med EØS-land i kraft etter 01.01.1994
     */
    private Eksportrett eksportrettEtterEOSForordning;
    /**
     * Eksportrett etter trygdeavtaler med EØS-land i kraft før 01.01.1994
     */
    private Eksportrett eksportrettEtterTrygdeavtalerEOS;
    /**
     * Eksportrett etter andre trygdeavtaler
     */
    private Eksportrett eksportrettEtterAndreTrygdeavtaler;
    /**
     * IKKE I BRUK (se PENPORT-279)
     * Innvilget garantert tilleggspensjon til ung ufør/død skal eksporteres
     */
    private Boolean innvilgetGarantertTP;
    /**
     * Eksportrett for garantert tilleggspensjon ung ufør.
     */
    private Unntak eksportrettGarantertTP;
    /**
     * Minst tre års forutgående medlemskap i Norge med uføretidspunkt FOM 01.01.1994
     */
    private Boolean minstTreArsFMNorge;
    /**
     * Minst fem års forutgående medlemskap i Norge med uføretidspunkt FOM 01.01.1994 og førsteKravFremsattdato FOM 01.01.2021
     */
    private Boolean minstFemArsFMNorge;
    /**
     * Minst tre års forutgående medlemskap i Norge med uføretidspunkt før 01.01.1994 og virkningstidspunkt FOM 01.01.1990
     */
    private Boolean minstTreArsFMNorgeVirkdato;
    /**
     * Unntak fra forutgående medlemskap
     */
    private Unntak unntakFraForutgaendeMedlemskap;
    /**
     * Oppfylt etter gamle regler og virkningsdato før 01.01.1990
     */
    private Boolean oppfyltEtterGamleRegler;
    /**
     * Oppfylt ved sammenlegging tre år
     */
    private OppfyltVedSammenlegging oppfyltVedSammenlegging;
    /**
     * Oppfylt ved sammenlegging fem år
     */
    private OppfyltVedSammenlegging oppfyltVedSammenleggingFemAr;
    /**
     * Oppfylt ved gjenlevendes forutgående medlemskap
     */
    private Boolean oppfyltVedGjenlevendesMedlemskap;
    /**
     * Gjenlevende fortsatt medlem av folketrygden
     */
    private Boolean gjenlevendeMedlemFT;
    /**
     * Avdøde har minst ett års forutgående medlemskap i Norge med dødsdato før 01.01.1994 og virkningsdato FOM 01.01.1990
     */
    private Boolean minstEttArFMNorge;
    /**
     * En av foreldrene har minst 20 års botid i Norge.
     */
    private Boolean foreldreMinstTyveArBotidNorge;
    /**
     * Fri eksport fordi dødsfall skyldes yrkesskade
     */
    private Boolean friEksportDodsfall;
    /**
     * Brukeren har minst 20 års botid i Norge
     */
    private Boolean minstTyveArTrygdetidNorgeKap20;
    /**
     * Minst tre års trygdetid i Norge
     */
    private Boolean treArTrygdetidNorgeKap20;
    /**
     * Minst fem års trygdetid i Norge
     */
    private Boolean femArTrygdetidNorgeKap20;
    /**
     * Oppfylt ved sammenlegging
     */
    private OppfyltVedSammenlegging oppfyltVedSammenleggingKap20;
    /**
     * Oppfylt ved sammenlegging fem år
     */
    private OppfyltVedSammenlegging oppfyltVedSammenleggingFemArKap20;

}
