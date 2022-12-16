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
     * Minst tre �rs trygdetid i Norge
     */
    private Boolean treArTrygdetidNorge;
    /**
     * Minst fem �rs trygdetid i Norge
     */
    private Boolean femArTrygdetidNorge;
    /**
     * Unntak fra forutg�ende trygdetid
     */
    private Unntak unntakFraForutgaendeTT;
    /**
     * Fortsatt medlem i folketrygden
     */
    private Boolean fortsattMedlemFT;
    /**
     * Brukeren har minst 20 �rs botid i Norge
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
     * Fri eksport fordi uf�rhet skyldes yrkesskade
     */
    private Boolean friEksportPgaYrkesskade;
    /**
     * Eksportrett etter E�S forordning eller trygdeavtaler med E�S-land i kraft etter 01.01.1994
     */
    private Eksportrett eksportrettEtterEOSForordning;
    /**
     * Eksportrett etter trygdeavtaler med E�S-land i kraft f�r 01.01.1994
     */
    private Eksportrett eksportrettEtterTrygdeavtalerEOS;
    /**
     * Eksportrett etter andre trygdeavtaler
     */
    private Eksportrett eksportrettEtterAndreTrygdeavtaler;
    /**
     * IKKE I BRUK (se PENPORT-279)
     * Innvilget garantert tilleggspensjon til ung uf�r/d�d skal eksporteres
     */
    private Boolean innvilgetGarantertTP;
    /**
     * Eksportrett for garantert tilleggspensjon ung uf�r.
     */
    private Unntak eksportrettGarantertTP;
    /**
     * Minst tre �rs forutg�ende medlemskap i Norge med uf�retidspunkt FOM 01.01.1994
     */
    private Boolean minstTreArsFMNorge;
    /**
     * Minst fem �rs forutg�ende medlemskap i Norge med uf�retidspunkt FOM 01.01.1994 og f�rsteKravFremsattdato FOM 01.01.2021
     */
    private Boolean minstFemArsFMNorge;
    /**
     * Minst tre �rs forutg�ende medlemskap i Norge med uf�retidspunkt f�r 01.01.1994 og virkningstidspunkt FOM 01.01.1990
     */
    private Boolean minstTreArsFMNorgeVirkdato;
    /**
     * Unntak fra forutg�ende medlemskap
     */
    private Unntak unntakFraForutgaendeMedlemskap;
    /**
     * Oppfylt etter gamle regler og virkningsdato f�r 01.01.1990
     */
    private Boolean oppfyltEtterGamleRegler;
    /**
     * Oppfylt ved sammenlegging tre �r
     */
    private OppfyltVedSammenlegging oppfyltVedSammenlegging;
    /**
     * Oppfylt ved sammenlegging fem �r
     */
    private OppfyltVedSammenlegging oppfyltVedSammenleggingFemAr;
    /**
     * Oppfylt ved gjenlevendes forutg�ende medlemskap
     */
    private Boolean oppfyltVedGjenlevendesMedlemskap;
    /**
     * Gjenlevende fortsatt medlem av folketrygden
     */
    private Boolean gjenlevendeMedlemFT;
    /**
     * Avd�de har minst ett �rs forutg�ende medlemskap i Norge med d�dsdato f�r 01.01.1994 og virkningsdato FOM 01.01.1990
     */
    private Boolean minstEttArFMNorge;
    /**
     * En av foreldrene har minst 20 �rs botid i Norge.
     */
    private Boolean foreldreMinstTyveArBotidNorge;
    /**
     * Fri eksport fordi d�dsfall skyldes yrkesskade
     */
    private Boolean friEksportDodsfall;
    /**
     * Brukeren har minst 20 �rs botid i Norge
     */
    private Boolean minstTyveArTrygdetidNorgeKap20;
    /**
     * Minst tre �rs trygdetid i Norge
     */
    private Boolean treArTrygdetidNorgeKap20;
    /**
     * Minst fem �rs trygdetid i Norge
     */
    private Boolean femArTrygdetidNorgeKap20;
    /**
     * Oppfylt ved sammenlegging
     */
    private OppfyltVedSammenlegging oppfyltVedSammenleggingKap20;
    /**
     * Oppfylt ved sammenlegging fem �r
     */
    private OppfyltVedSammenlegging oppfyltVedSammenleggingFemArKap20;

}
