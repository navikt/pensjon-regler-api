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

    private static final long serialVersionUID = -7987108737661054863L;
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
    /**
     * PREG variabel for å vite om det finnes trygdeavtale når man er i BestemUngUførRS i Folketrygd flyter.
     * Trygdeavtale objetet nulles før kall til Folketrygd-flyter
     */
    private Trygdeavtale PREG_trygdeavtale;

    /**
     * Copy Constructor
     *
     * @param inngangOgEksportGrunnlag a <code>InngangOgEksportGrunnlag</code> object
     */
    public InngangOgEksportGrunnlag(InngangOgEksportGrunnlag inngangOgEksportGrunnlag) {
        if (inngangOgEksportGrunnlag.treArTrygdetidNorge != null) {
            treArTrygdetidNorge = new Boolean(inngangOgEksportGrunnlag.treArTrygdetidNorge);
        }
        if (inngangOgEksportGrunnlag.femArTrygdetidNorge != null) {
            femArTrygdetidNorge = new Boolean(inngangOgEksportGrunnlag.femArTrygdetidNorge);
        }
        if (inngangOgEksportGrunnlag.femArTrygdetidNorgeKap20 != null) {
            femArTrygdetidNorgeKap20 = new Boolean(inngangOgEksportGrunnlag.femArTrygdetidNorgeKap20);
        }
        if (inngangOgEksportGrunnlag.oppfyltVedSammenleggingFemAr != null) {
            oppfyltVedSammenleggingFemAr = new OppfyltVedSammenlegging(inngangOgEksportGrunnlag.oppfyltVedSammenleggingFemAr);
        }
        if (inngangOgEksportGrunnlag.oppfyltVedSammenleggingFemArKap20 != null) {
            oppfyltVedSammenleggingFemArKap20 = new OppfyltVedSammenlegging(inngangOgEksportGrunnlag.oppfyltVedSammenleggingFemArKap20);
        }
        if (inngangOgEksportGrunnlag.minstFemArsFMNorge != null) {
            minstFemArsFMNorge = new Boolean(inngangOgEksportGrunnlag.minstFemArsFMNorge);
        }
        if (inngangOgEksportGrunnlag.unntakFraForutgaendeTT != null) {
            unntakFraForutgaendeTT = new Unntak(inngangOgEksportGrunnlag.unntakFraForutgaendeTT);
        }
        if (inngangOgEksportGrunnlag.fortsattMedlemFT != null) {
            fortsattMedlemFT = new Boolean(inngangOgEksportGrunnlag.fortsattMedlemFT);
        }
        if (inngangOgEksportGrunnlag.minstTyveArBotidNorge != null) {
            minstTyveArBotidNorge = new Boolean(inngangOgEksportGrunnlag.minstTyveArBotidNorge);
        }
        if (inngangOgEksportGrunnlag.opptjentRettTilTPEtterFT != null) {
            opptjentRettTilTPEtterFT = new Boolean(inngangOgEksportGrunnlag.opptjentRettTilTPEtterFT);
        }
        if (inngangOgEksportGrunnlag.eksportforbud != null) {
            eksportforbud = new Eksportforbud(inngangOgEksportGrunnlag.eksportforbud);
        }
        if (inngangOgEksportGrunnlag.friEksportPgaYrkesskade != null) {
            friEksportPgaYrkesskade = new Boolean(inngangOgEksportGrunnlag.friEksportPgaYrkesskade);
        }
        if (inngangOgEksportGrunnlag.eksportrettEtterEOSForordning != null) {
            eksportrettEtterEOSForordning = new Eksportrett(inngangOgEksportGrunnlag.eksportrettEtterEOSForordning);
        }
        if (inngangOgEksportGrunnlag.eksportrettEtterTrygdeavtalerEOS != null) {
            eksportrettEtterTrygdeavtalerEOS = new Eksportrett(inngangOgEksportGrunnlag.eksportrettEtterTrygdeavtalerEOS);
        }
        if (inngangOgEksportGrunnlag.eksportrettEtterAndreTrygdeavtaler != null) {
            eksportrettEtterAndreTrygdeavtaler = new Eksportrett(inngangOgEksportGrunnlag.eksportrettEtterAndreTrygdeavtaler);
        }
        if (inngangOgEksportGrunnlag.eksportrettGarantertTP != null) {
            eksportrettGarantertTP = new Unntak(inngangOgEksportGrunnlag.eksportrettGarantertTP);
        }
        if (inngangOgEksportGrunnlag.minstTreArsFMNorge != null) {
            minstTreArsFMNorge = new Boolean(inngangOgEksportGrunnlag.minstTreArsFMNorge);
        }
        if (inngangOgEksportGrunnlag.minstTreArsFMNorgeVirkdato != null) {
            minstTreArsFMNorgeVirkdato = new Boolean(inngangOgEksportGrunnlag.minstTreArsFMNorgeVirkdato);
        }
        if (inngangOgEksportGrunnlag.unntakFraForutgaendeMedlemskap != null) {
            unntakFraForutgaendeMedlemskap = new Unntak(inngangOgEksportGrunnlag.unntakFraForutgaendeMedlemskap);
        }
        if (inngangOgEksportGrunnlag.oppfyltEtterGamleRegler != null) {
            oppfyltEtterGamleRegler = new Boolean(inngangOgEksportGrunnlag.oppfyltEtterGamleRegler);
        }
        if (inngangOgEksportGrunnlag.oppfyltVedSammenlegging != null) {
            oppfyltVedSammenlegging = new OppfyltVedSammenlegging(inngangOgEksportGrunnlag.oppfyltVedSammenlegging);
        }
        if (inngangOgEksportGrunnlag.oppfyltVedGjenlevendesMedlemskap != null) {
            oppfyltVedGjenlevendesMedlemskap = new Boolean(inngangOgEksportGrunnlag.oppfyltVedGjenlevendesMedlemskap);
        }
        if (inngangOgEksportGrunnlag.gjenlevendeMedlemFT != null) {
            gjenlevendeMedlemFT = new Boolean(inngangOgEksportGrunnlag.gjenlevendeMedlemFT);
        }
        if (inngangOgEksportGrunnlag.minstEttArFMNorge != null) {
            minstEttArFMNorge = new Boolean(inngangOgEksportGrunnlag.minstEttArFMNorge);
        }
        if (inngangOgEksportGrunnlag.foreldreMinstTyveArBotidNorge != null) {
            foreldreMinstTyveArBotidNorge = new Boolean(inngangOgEksportGrunnlag.foreldreMinstTyveArBotidNorge);
        }
        if (inngangOgEksportGrunnlag.friEksportDodsfall != null) {
            friEksportDodsfall = new Boolean(inngangOgEksportGrunnlag.friEksportDodsfall);
        }
        if (inngangOgEksportGrunnlag.treArTrygdetidNorgeKap20 != null) {
            treArTrygdetidNorgeKap20 = new Boolean(inngangOgEksportGrunnlag.treArTrygdetidNorgeKap20);
        }
        if (inngangOgEksportGrunnlag.minstTyveArTrygdetidNorgeKap20 != null) {
            minstTyveArTrygdetidNorgeKap20 = new Boolean(inngangOgEksportGrunnlag.minstTyveArTrygdetidNorgeKap20);
        }
        if (inngangOgEksportGrunnlag.oppfyltVedSammenleggingKap20 != null) {
            oppfyltVedSammenleggingKap20 = new OppfyltVedSammenlegging(inngangOgEksportGrunnlag.oppfyltVedSammenleggingKap20);
        }
        if (inngangOgEksportGrunnlag.PREG_trygdeavtale != null) {
            PREG_trygdeavtale = new Trygdeavtale(inngangOgEksportGrunnlag.PREG_trygdeavtale);
        }
    }

    /**
     * Default constructor
     */
    public InngangOgEksportGrunnlag() {
        super();
    }

    public InngangOgEksportGrunnlag(Boolean treArTrygdetidNorge, Unntak unntakFraForutgaendeTT, Boolean fortsattMedlemFT, Boolean minstTyveArBotidNorge,
                                    Boolean opptjentRettTilTPEtterFT, Eksportforbud eksportforbud, Boolean friEksportPgaYrkesskade, Eksportrett eksportrettEtterEOSForordning,
                                    Eksportrett eksportrettEtterTrygdeavtalerEOS, Eksportrett eksportrettEtterAndreTrygdeavtaler, Boolean innvilgetGarantertTP,
                                    Boolean minstTreArsFMNorge, Boolean minstTreArsFMNorgeVirkdato, Unntak unntakFraForutgaendeMedlemskap, Boolean oppfyltEtterGamleRegler,
                                    OppfyltVedSammenlegging oppfyltVedSammenlegging, Boolean oppfyltVedGjenlevendesMedlemskap, Boolean gjenlevendeMedlemFT,
                                    Boolean minstEttArFMNorge, Boolean foreldreMinstTyveArBotidNorge, Boolean friEksportDodsfall) {
        super();
        this.treArTrygdetidNorge = treArTrygdetidNorge;
        this.unntakFraForutgaendeTT = unntakFraForutgaendeTT;
        this.fortsattMedlemFT = fortsattMedlemFT;
        this.minstTyveArBotidNorge = minstTyveArBotidNorge;
        this.opptjentRettTilTPEtterFT = opptjentRettTilTPEtterFT;
        this.eksportforbud = eksportforbud;
        this.friEksportPgaYrkesskade = friEksportPgaYrkesskade;
        this.eksportrettEtterEOSForordning = eksportrettEtterEOSForordning;
        this.eksportrettEtterTrygdeavtalerEOS = eksportrettEtterTrygdeavtalerEOS;
        this.eksportrettEtterAndreTrygdeavtaler = eksportrettEtterAndreTrygdeavtaler;
        //this.innvilgetGarantertTP = innvilgetGarantertTP;
        this.minstTreArsFMNorge = minstTreArsFMNorge;
        this.minstTreArsFMNorgeVirkdato = minstTreArsFMNorgeVirkdato;
        this.unntakFraForutgaendeMedlemskap = unntakFraForutgaendeMedlemskap;
        this.oppfyltEtterGamleRegler = oppfyltEtterGamleRegler;
        this.oppfyltVedSammenlegging = oppfyltVedSammenlegging;
        this.oppfyltVedGjenlevendesMedlemskap = oppfyltVedGjenlevendesMedlemskap;
        this.gjenlevendeMedlemFT = gjenlevendeMedlemFT;
        this.minstEttArFMNorge = minstEttArFMNorge;
        this.foreldreMinstTyveArBotidNorge = foreldreMinstTyveArBotidNorge;
        this.friEksportDodsfall = friEksportDodsfall;
    }

    /**
     * For uføretrygd er innholdet i InngangOgEksportGrunnlag fordelt på to klasser, FortsattMedlemkap og ForutgaendeMedlemskap.
     * Denne constructor kan brukes for bakoverkompatibilitet med gammel regelkode som forventer et InngangOgEksportGrunnlag.
     */
    public InngangOgEksportGrunnlag(FortsattMedlemskap fortsattMedlemskap, ForutgaendeMedlemskap forutgaendeMedlemskap) {
        if (fortsattMedlemskap != null) {
            if (fortsattMedlemskap.getFortsattMedlemFT() != null) {
                this.fortsattMedlemFT = new Boolean(fortsattMedlemskap.getFortsattMedlemFT());
            }
            if (fortsattMedlemskap.getMinstTyveArBotidNorge() != null) {
                this.minstTyveArBotidNorge = new Boolean(fortsattMedlemskap.getMinstTyveArBotidNorge());
            }
            if (fortsattMedlemskap.getOpptjentRettTilTPEtterFT() != null) {
                this.opptjentRettTilTPEtterFT = new Boolean(fortsattMedlemskap.getOpptjentRettTilTPEtterFT());
            }
            if (fortsattMedlemskap.getEksportforbud() != null) {
                this.eksportforbud = new Eksportforbud(fortsattMedlemskap.getEksportforbud());
            }
            if (fortsattMedlemskap.getFriEksportPgaYrkesskade() != null) {
                this.friEksportPgaYrkesskade = new Boolean(fortsattMedlemskap.getFriEksportPgaYrkesskade());
            }
            if (fortsattMedlemskap.getEksportrettGarantertTP() != null) {
                this.eksportrettGarantertTP = new Unntak(fortsattMedlemskap.getEksportrettGarantertTP());
            }
        }

        if (forutgaendeMedlemskap != null) {
            if (forutgaendeMedlemskap.getMinstTreArsFMNorge() != null) {
                this.minstTreArsFMNorge = new Boolean(forutgaendeMedlemskap.getMinstTreArsFMNorge());
                this.minstTreArsFMNorgeVirkdato = new Boolean(forutgaendeMedlemskap.getMinstTreArsFMNorge());
                this.treArTrygdetidNorge = new Boolean(forutgaendeMedlemskap.getMinstTreArsFMNorge());
            } else {
                this.minstTreArsFMNorge = false;
                this.minstTreArsFMNorgeVirkdato = false;
                this.treArTrygdetidNorge = false;
            }
            if (forutgaendeMedlemskap.getMinstFemArsFMNorge() != null) {
                this.minstFemArsFMNorge = new Boolean(forutgaendeMedlemskap.getMinstFemArsFMNorge());
                this.femArTrygdetidNorge = new Boolean(forutgaendeMedlemskap.getMinstFemArsFMNorge());
            } else {
                this.minstFemArsFMNorge = false;
                this.femArTrygdetidNorge = false;
            }
            if (forutgaendeMedlemskap.getMinstEttArFMNorge() != null) {
                this.minstEttArFMNorge = new Boolean(forutgaendeMedlemskap.getMinstEttArFMNorge());
            } else {
                this.minstEttArFMNorge = false;
            }
            if (forutgaendeMedlemskap.getUnntakFraForutgaendeMedlemskap() != null) {
                this.unntakFraForutgaendeMedlemskap = new Unntak(forutgaendeMedlemskap.getUnntakFraForutgaendeMedlemskap());
            } else {
                this.unntakFraForutgaendeMedlemskap = new Unntak(false, null);
            }
            if (forutgaendeMedlemskap.getUnntakFraForutgaendeTT() != null) {
                this.unntakFraForutgaendeTT = new Unntak(forutgaendeMedlemskap.getUnntakFraForutgaendeTT());
            }
            else{
                this.unntakFraForutgaendeTT = new Unntak(false, null);
            }
            if (forutgaendeMedlemskap.getOppfyltEtterGamleRegler() != null) {
                this.oppfyltEtterGamleRegler = new Boolean(forutgaendeMedlemskap.getOppfyltEtterGamleRegler());
            }
            else{
                this.oppfyltEtterGamleRegler = false;
            }
        }
    }

    /**
     * Mapping fra ulike Vilkar til InngangOgEksportGrunnlag (PK-9695, PKPYTON-923).
     * Gjort pr. løsningsbeskrivelse PK-6071 (PK-6951), foruten  innvilgetGarantertTP som ikke skal brukes.
     * Brukes for å opprette grunnlaget ved beregning av uføretrygd med trygdeavtaler.
     *
     * @param fortsattMedlemskap
     * @param forutgaendeMedlemskap
     * @param rettTilEksportEtterTrygdeavtaler
     * @param medlemskapForUTEtterTrygdeavtaler
     */
    public InngangOgEksportGrunnlag(FortsattMedlemskap fortsattMedlemskap, ForutgaendeMedlemskap forutgaendeMedlemskap,
                                    RettTilEksportEtterTrygdeavtaler rettTilEksportEtterTrygdeavtaler, MedlemskapForUTEtterTrygdeavtaler medlemskapForUTEtterTrygdeavtaler) {
        this(fortsattMedlemskap, forutgaendeMedlemskap);
        if(rettTilEksportEtterTrygdeavtaler != null) {
            if (rettTilEksportEtterTrygdeavtaler.getEksportrettEtterEOSForordning() != null) {
                this.eksportrettEtterEOSForordning = new Eksportrett(rettTilEksportEtterTrygdeavtaler.getEksportrettEtterEOSForordning());
            }
            if (rettTilEksportEtterTrygdeavtaler.getEksportrettEtterTrygdeavtalerEOS() != null) {
                this.eksportrettEtterTrygdeavtalerEOS = new Eksportrett(rettTilEksportEtterTrygdeavtaler.getEksportrettEtterTrygdeavtalerEOS());
            }
            if (rettTilEksportEtterTrygdeavtaler.getEksportrettEtterAndreTrygdeavtaler() != null){
                this.eksportrettEtterAndreTrygdeavtaler = new Eksportrett(rettTilEksportEtterTrygdeavtaler.getEksportrettEtterAndreTrygdeavtaler());
            }
        }

        if(medlemskapForUTEtterTrygdeavtaler != null &&medlemskapForUTEtterTrygdeavtaler.getOppfyltVedSammenlegging() != null) {
            this.oppfyltVedSammenlegging = new OppfyltVedSammenlegging(medlemskapForUTEtterTrygdeavtaler.getOppfyltVedSammenlegging());
        }

        if (medlemskapForUTEtterTrygdeavtaler != null && medlemskapForUTEtterTrygdeavtaler.getOppfyltVedSammenleggingFemAr() != null) {
            this.oppfyltVedSammenleggingFemAr = new OppfyltVedSammenlegging(medlemskapForUTEtterTrygdeavtaler.getOppfyltVedSammenleggingFemAr());
        }
    }

    public Eksportforbud getEksportforbud() {
        return eksportforbud;
    }

    public void setEksportforbud(Eksportforbud eksportforbud) {
        this.eksportforbud = eksportforbud;
    }

    public Eksportrett getEksportrettEtterAndreTrygdeavtaler() {
        return eksportrettEtterAndreTrygdeavtaler;
    }

    public void setEksportrettEtterAndreTrygdeavtaler(Eksportrett eksportrettEtterAndreTrygdeavtaler) {
        this.eksportrettEtterAndreTrygdeavtaler = eksportrettEtterAndreTrygdeavtaler;
    }

    public Eksportrett getEksportrettEtterEOSForordning() {
        return eksportrettEtterEOSForordning;
    }

    public void setEksportrettEtterEOSForordning(Eksportrett eksportrettEtterEOSForordning) {
        this.eksportrettEtterEOSForordning = eksportrettEtterEOSForordning;
    }

    public Eksportrett getEksportrettEtterTrygdeavtalerEOS() {
        return eksportrettEtterTrygdeavtalerEOS;
    }

    public void setEksportrettEtterTrygdeavtalerEOS(Eksportrett eksportrettEtterTrygdeavtalerEOS) {
        this.eksportrettEtterTrygdeavtalerEOS = eksportrettEtterTrygdeavtalerEOS;
    }

    public Boolean getForeldreMinstTyveArBotidNorge() {
        return foreldreMinstTyveArBotidNorge;
    }

    public void setForeldreMinstTyveArBotidNorge(Boolean foreldreMinstTyveArBotidNorge) {
        this.foreldreMinstTyveArBotidNorge = foreldreMinstTyveArBotidNorge;
    }

    public Boolean getFortsattMedlemFT() {
        return fortsattMedlemFT;
    }

    public void setFortsattMedlemFT(Boolean fortsattMedlemFT) {
        this.fortsattMedlemFT = fortsattMedlemFT;
    }

    public Boolean getFriEksportDodsfall() {
        return friEksportDodsfall;
    }

    public void setFriEksportDodsfall(Boolean friEksportDodsfall) {
        this.friEksportDodsfall = friEksportDodsfall;
    }

    public Boolean getFriEksportPgaYrkesskade() {
        return friEksportPgaYrkesskade;
    }

    public void setFriEksportPgaYrkesskade(Boolean friEksportPgaYrkesskade) {
        this.friEksportPgaYrkesskade = friEksportPgaYrkesskade;
    }

    public Boolean getGjenlevendeMedlemFT() {
        return gjenlevendeMedlemFT;
    }

    public void setGjenlevendeMedlemFT(Boolean gjenlevendeMedlemFT) {
        this.gjenlevendeMedlemFT = gjenlevendeMedlemFT;
    }

    public Unntak getEksportrettGarantertTP() {
        return eksportrettGarantertTP;
    }

    public void setEksportrettGarantertTP(Unntak eksportrettGarantertTP) {
        this.eksportrettGarantertTP = eksportrettGarantertTP;
    }

    public Boolean getMinstEttArFMNorge() {
        return minstEttArFMNorge;
    }

    public void setMinstEttArFMNorge(Boolean minstEttArFMNorge) {
        this.minstEttArFMNorge = minstEttArFMNorge;
    }

    public Boolean getMinstTreArsFMNorge() {
        return minstTreArsFMNorge;
    }

    public void setMinstTreArsFMNorge(Boolean minstTreArsFMNorge) {
        this.minstTreArsFMNorge = minstTreArsFMNorge;
    }

    public Boolean getMinstTreArsFMNorgeVirkdato() {
        return minstTreArsFMNorgeVirkdato;
    }

    public void setMinstTreArsFMNorgeVirkdato(Boolean minstTreArsFMNorgeVirkdato) {
        this.minstTreArsFMNorgeVirkdato = minstTreArsFMNorgeVirkdato;
    }

    public Boolean getMinstTyveArBotidNorge() {
        return minstTyveArBotidNorge;
    }

    public void setMinstTyveArBotidNorge(Boolean minstTyveArBotidNorge) {
        this.minstTyveArBotidNorge = minstTyveArBotidNorge;
    }

    public Boolean getOppfyltEtterGamleRegler() {
        return oppfyltEtterGamleRegler;
    }

    public void setOppfyltEtterGamleRegler(Boolean oppfyltEtterGamleRegler) {
        this.oppfyltEtterGamleRegler = oppfyltEtterGamleRegler;
    }

    public Boolean getOppfyltVedGjenlevendesMedlemskap() {
        return oppfyltVedGjenlevendesMedlemskap;
    }

    public void setOppfyltVedGjenlevendesMedlemskap(Boolean oppfyltVedGjenlevendesMedlemskap) {
        this.oppfyltVedGjenlevendesMedlemskap = oppfyltVedGjenlevendesMedlemskap;
    }

    public OppfyltVedSammenlegging getOppfyltVedSammenlegging() {
        return oppfyltVedSammenlegging;
    }

    public void setOppfyltVedSammenlegging(OppfyltVedSammenlegging oppfyltVedSammenlegging) {
        this.oppfyltVedSammenlegging = oppfyltVedSammenlegging;
    }

    public Boolean getOpptjentRettTilTPEtterFT() {
        return opptjentRettTilTPEtterFT;
    }

    public void setOpptjentRettTilTPEtterFT(Boolean opptjentRettTilTPEtterFT) {
        this.opptjentRettTilTPEtterFT = opptjentRettTilTPEtterFT;
    }

    public Boolean getTreArTrygdetidNorge() {
        return treArTrygdetidNorge;
    }

    public void setTreArTrygdetidNorge(Boolean treArTrygdetidNorge) {
        this.treArTrygdetidNorge = treArTrygdetidNorge;
    }

    public Unntak getUnntakFraForutgaendeMedlemskap() {
        return unntakFraForutgaendeMedlemskap;
    }

    public void setUnntakFraForutgaendeMedlemskap(Unntak unntakFraForutgaendeMedlemskap) {
        this.unntakFraForutgaendeMedlemskap = unntakFraForutgaendeMedlemskap;
    }

    public Unntak getUnntakFraForutgaendeTT() {
        return unntakFraForutgaendeTT;
    }

    public void setUnntakFraForutgaendeTT(Unntak unntakFraForutgaendeTT) {
        this.unntakFraForutgaendeTT = unntakFraForutgaendeTT;
    }

    public Boolean getMinstTyveArTrygdetidNorgeKap20() {
        return minstTyveArTrygdetidNorgeKap20;
    }

    public void setMinstTyveArTrygdetidNorgeKap20(Boolean minstTyveArTrygdetidNorgeKap20) {
        this.minstTyveArTrygdetidNorgeKap20 = minstTyveArTrygdetidNorgeKap20;
    }

    public Boolean getTreArTrygdetidNorgeKap20() {
        return treArTrygdetidNorgeKap20;
    }

    public void setTreArTrygdetidNorgeKap20(Boolean treArTrygdetidNorgeKap20) {
        this.treArTrygdetidNorgeKap20 = treArTrygdetidNorgeKap20;
    }

    public OppfyltVedSammenlegging getOppfyltVedSammenleggingKap20() {
        return oppfyltVedSammenleggingKap20;
    }

    public void setOppfyltVedSammenleggingKap20(OppfyltVedSammenlegging oppfyltVedSammenleggingKap20) {
        this.oppfyltVedSammenleggingKap20 = oppfyltVedSammenleggingKap20;
    }

    public Trygdeavtale getPREG_trygdeavtale() {
        return PREG_trygdeavtale;
    }

    public void setPREG_trygdeavtale(Trygdeavtale preg_trygdeavtale) {
        PREG_trygdeavtale = preg_trygdeavtale;
    }

    public Boolean getFemArTrygdetidNorge() {
        return femArTrygdetidNorge;
    }

    public void setFemArTrygdetidNorge(Boolean femArTrygdetidNorge) {
        this.femArTrygdetidNorge = femArTrygdetidNorge;
    }

    public Boolean getMinstFemArsFMNorge() {
        return minstFemArsFMNorge;
    }

    public void setMinstFemArsFMNorge(Boolean minstFemArsFMNorge) {
        this.minstFemArsFMNorge = minstFemArsFMNorge;
    }

    public OppfyltVedSammenlegging getOppfyltVedSammenleggingFemAr() {
        return oppfyltVedSammenleggingFemAr;
    }

    public void setOppfyltVedSammenleggingFemAr(OppfyltVedSammenlegging oppfyltVedSammenleggingFemAr) {
        this.oppfyltVedSammenleggingFemAr = oppfyltVedSammenleggingFemAr;
    }

    public Boolean getFemArTrygdetidNorgeKap20() {
        return femArTrygdetidNorgeKap20;
    }

    public void setFemArTrygdetidNorgeKap20(Boolean femArTrygdetidNorgeKap20) {
        this.femArTrygdetidNorgeKap20 = femArTrygdetidNorgeKap20;
    }

    public OppfyltVedSammenlegging getOppfyltVedSammenleggingFemArKap20() {
        return oppfyltVedSammenleggingFemArKap20;
    }

    public void setOppfyltVedSammenleggingFemArKap20(OppfyltVedSammenlegging oppfyltVedSammenleggingFemArKap20) {
        this.oppfyltVedSammenleggingFemArKap20 = oppfyltVedSammenleggingFemArKap20;
    }

    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     *
     * @return a <code>String</code> representation
     * of this object.
     */
    @Override
    public String toString() {
        final String TAB = "    ";

        StringBuilder retValue = new StringBuilder();

        retValue.append("InngangOgEksportGrunnlag ( ").append(super.toString()).append(TAB).append("treArTrygdetidNorge = ").append(treArTrygdetidNorge).append(TAB)
                .append("unntakFraForutgaendeTT = ").append(unntakFraForutgaendeTT).append(TAB).append("fortsattMedlemFT = ").append(fortsattMedlemFT).append(TAB)
                .append("minstTyveArBotidNorge = ").append(minstTyveArBotidNorge).append(TAB).append("opptjentRettTilTPEtterFT = ").append(opptjentRettTilTPEtterFT).append(TAB)
                .append("eksportforbud = ").append(eksportforbud).append(TAB).append("friEksportPgaYrkesskade = ").append(friEksportPgaYrkesskade).append(TAB)
                .append("eksportrettEtterEOSForordning = ").append(eksportrettEtterEOSForordning).append(TAB).append("eksportrettEtterTrygdeavtalerEOS = ")
                .append(eksportrettEtterTrygdeavtalerEOS).append(TAB).append("eksportrettEtterAndreTrygdeavtaler = ").append(eksportrettEtterAndreTrygdeavtaler).append(TAB)
                .append("eksportrettGarantertTP = ").append(eksportrettGarantertTP).append(TAB).append("minstTreArsFMNorge = ").append(minstTreArsFMNorge).append(TAB)
                .append("minstTreArsFMNorgeVirkdato = ").append(minstTreArsFMNorgeVirkdato).append(TAB).append("unntakFraForutgaendeMedlemskap = ")
                .append(unntakFraForutgaendeMedlemskap).append(TAB).append("oppfyltEtterGamleRegler = ").append(oppfyltEtterGamleRegler).append(TAB)
                .append("oppfyltVedSammenlegging = ").append(oppfyltVedSammenlegging).append(TAB).append("oppfyltVedGjenlevendesMedlemskap = ")
                .append(oppfyltVedGjenlevendesMedlemskap).append(TAB).append("gjenlevendeMedlemFT = ").append(gjenlevendeMedlemFT).append(TAB).append("minstEttArFMNorge = ")
                .append(minstEttArFMNorge).append(TAB).append("foreldreMinstTyveArBotidNorge = ").append(foreldreMinstTyveArBotidNorge).append(TAB).append("friEksportDodsfall = ")
                .append(friEksportDodsfall).append(TAB).append(" )");

        return retValue.toString();
    }
}
