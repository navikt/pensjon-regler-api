package no.nav.pensjon.regler.domain.beregning;

import no.nav.pensjon.regler.domain.IBeregning;
import no.nav.pensjon.regler.domain.Merknad;
import no.nav.pensjon.regler.domain.PenPerson;
import no.nav.pensjon.regler.domain.Trygdetid;
import no.nav.pensjon.regler.domain.beregning.penobjekter.*;
import no.nav.pensjon.regler.domain.beregning2011.Beregning2011;
import no.nav.pensjon.regler.domain.beregning2011.LonnsvekstInformasjon;
import no.nav.pensjon.regler.domain.beregning2011.MinstenivatilleggIndividuelt;
import no.nav.pensjon.regler.domain.beregning2011.MinstenivatilleggPensjonistpar;
import no.nav.pensjon.regler.domain.grunnlag.EosEkstra;
import no.nav.pensjon.regler.domain.kode.*;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Beregning er resultatet fra en beregning i PREG.
 */
public class Beregning implements IBeregning, Serializable {
    private static final long serialVersionUID = 2755905023205082187L;

    /**
     * Felt som gj�res for � holde orden p� de forskjellige beregningene,
     * f.eks hjelpeberegninger.
     */
    private String PREG_beregningsnavn;

    /**
     * Referanse tilbake til beregningsrelasjon dersom denne beregning inng�r i en beregningsrelasjon.
     */
    private BeregningRelasjon PREG_beregningsrelasjon;

    /**
     * Representerer personen beregning gjelder for.
     */
    private PenPerson penPerson;

    /**
     * Virkningstidspunktet ytelsen kan utbetales fra.
     */
    private Date virkFom;

    /**
     * Virkningstidspunktet ytelsen kan utbetales til.
     */
    private Date virkTom;

    /**
     * Bel�p f�r avkorting.
     */
    private int brutto;

    /**
     * Bel�p etter avkorting.
     */
    private int netto;

    /**
     * Grunnpensjonen, regulert med l�nnsvekst - 0.0075. Fra og med Horisonten.
     */
    private Grunnpensjon gp;
    /**
     * Grunnpensjonen regulert med l�nnsvekst.Fra og med Horisonten.
     */
    private Grunnpensjon gpKapittel3;

    /**
     * Uavkortet grunnpensjon regulert med l�nnsvekst - 0.0075.
     * Trengs kun for Afp hvor gp er avkortet kan v�re avkortet til 70%.
     */
    private Grunnpensjon gpAfpPensjonsregulert;

    /**
     * Tilleggspensjonen.
     */
    private Tilleggspensjon tp;

    private Tilleggspensjon tpKapittel3;

    /**
     * S�rtillegget.
     */
    private Sertillegg st;

    private Sertillegg stKapittel3;

    /**
     * SamletektefelleGarantiTillegg
     */
    private MinstenivatilleggPensjonistpar minstenivatilleggPensjonistpar;
    /**
     * MinstenivatilleggIndividuelt
     */
    private MinstenivatilleggIndividuelt minstenivatilleggIndividuelt;
    /**
     * AFP tillegget.
     */
    private AfpTillegg afpTillegg;
    /**
     * Ventetillegget
     */
    private Ventetillegg vt;

    private Ventetillegg vtKapittel3;

    /**
     * �8.5.1 tillegget.
     */
    private Paragraf_8_5_1_tillegg p851_tillegg;

    /**
     * Ektefelletillegget.
     */
    private Ektefelletillegg et;

    /**
     * Barnetillegget fellesbarn.
     */
    private BarnetilleggFellesbarn tfb;

    /**
     * Barnetillegget s�rkullsbarn.
     */
    private BarnetilleggSerkullsbarn tsb;

    /**
     * Familietillegg - aktuelt ved institusjonsopphold.
     */
    private Familietillegg familietillegg;

    /**
     * Tillegg for faste utgifter - aktuelt ved institusjonsopphold.
     */
    private FasteUtgifterTillegg tilleggFasteUtgifter;

    /**
     * Brukes bare ved g-omregningstjenesten BEF270.
     */
    private Garantitillegg_Art_27 garantitillegg_Art_27;

    /**
     * Brukes bare ved g-omregningstjenesten BEF270.
     */
    private Garantitillegg_Art_50 garantitillegg_Art_50;

    /**
     * Brukes bare ved g-omregningstjenesten BEF270.
     */
    private Hjelpeloshetsbidrag hjelpeloshetsbidrag;

    /**
     * Brukes bare ved g-omregningstjenesten BEF270.
     */
    private KrigOgGammelYrkesskade krigOgGammelYrkesskade;

    /**
     * Ved konvertering av uf�repensjon til uf�retrygd, og gradert yrkesskade
     * brukes denne for � angi andel tilleggspensjon som stammer fra restgrad
     * og som stammer fra yrkesskadegrad.
     */
    private KonverteringsdataUT konverteringsdataUT;

    /**
     * Brukes bare ved g-omregningstjenesten BEF270.
     */
    private Mendel mendel;

    /**
     * Brukes bare ved g-omregningstjenesten BEF270.
     */
    private TilleggTilHjelpIHuset tilleggTilHjelpIHuset;

    /**
     * Grunnbel�pet.
     */
    private int g;

    /**
     * Anvendt tt i beregningen, i hele �r. Blir satt lik antall poeng�r dersom antall
     * poeng�r (fra poengrekke-beregningen) er st�rre enn Trygdetid.tt.
     */
    private int tt_anv;

    /**
     * Angir hvilken metode som ble benyttet ved beregningen.E�S/nordisk/et annet land
     */
    private BeregningMetodeTypeCti beregningsMetode;

    /**
     * Framtidig trygdetid.
     */
    private Trygdetid trygdetid;

    /**
     * Liste av beregninger.Kan inneholde alternative beregninger gjort ved l�nnsomhetsberegninger.Vinneren ligger da i hovedobjektet mens taperen(e) ligger i denne listen.
     */
    private List<BeregningRelasjon> delberegningsListe;

    /**
     * Angir type beregning: BER, HJELPEBER, SAM_BER, VUR_BER.
     */
    private BeregningTypeCti beregningType;

    /**
     * Hvilken resultattype en beregning er : AP,AP_GJP osv.
     */
    private ResultatTypeCti resultatType;

    /**
     * Flegg som brukes p� beregninger med beregningType HJELPEBER.
     * Anvendes i l�nnsomhetsberegninger (VUR_BER). Settes p� den av delberegningene som ikke er HJELPEBER
     * dersom TP'en fra HJELPEBER er brukt. Da er ogs� flagget bruk i beregningsrelasjonen som hjelpeberegningen
     * inng�r i satt.
     */
    private boolean ikkeTraverser = false;

    /**
     * Er ektefelles totalinntekt, inkludert alle relevante inntekter > 2G.
     */
    private boolean ektefelleInntektOver2g;

    /**
     * Hvorvidt det er en P67 beregning.Gjelder alderspensjon .
     */
    private boolean p67beregning;

    /**
     * �rsak til periodisering av beregningen, G-justering, regelendring osv.
     * Settes dersom beregningen blir periodiserer av PREG (i.e. det returneres en liste av beregninger ).
     * Skal brukes i saksbehandling for � vise �rsaken til periodiseringen av beregningen.
     * Hvis det er flere �rsaker til at det er en periode i beregningen p� samme periode (i.e. endring i sats og regel p� samme dag s� m� det v�re en prioritering av endringene.
     * Da skal den �rsak som mest sjelden skjer settes.
     */
    private BeregningArsakCti beregningArsak;

    /**
     * Angir type av minstepensjon.
     * ER_MINST_PEN eller IKKE_MINST_PEN
     */
    private MinstepensjonTypeCti minstepensjontype;

    /**
     * Samler opp �rsakene til at en brukers minstepensjonstatus er satt og tilh�rende verdier
     * dersom disse er relevante til beslutningen.
     */
    private String minstepensjonArsak;

    /**
     * Angir om denne beregningen er top-noden av beregningene.
     */
    private boolean totalVinner;

    /**
     * Pensjonsgraden ved AFP,heltall mellom 0-100.
     */
    private int afpPensjonsgrad;

    /**
     * Fribel�pet en pensjonist kan ha f�r vilk�rene for � f� ytelsen blir avkortet (AP = 2G, GJP = 0,5G etc).
     */
    private int fribelop;

    /**
     * Friinntekt = (IEU) Inntekt den uf�re (UP) kan ha etter uf�retidspunktet.
     * Beregnet etter inntekt f�r uf�re (IFU).
     * IEU er grensen for hva inntekten kan v�re f�r en m� revurdere uf�regraden
     */
    private int friinntekt;

    /**
     * Beregnet fremtidig inntekt.Det er en G-omregnet oppgitt fremtidig inntekt som skal brukes av inntektskontrollen i Myggen.
     * beregnetFremtidigInntekt er G-omregnet oppgitt fremtidig inntekt som skal brukes av inntektskontrollen i Myggen.
     * PREG bruker Inntekt av type (FPI eller HYPF eller HYPF2G) og opptjusterer denne ihht til G:
     * beregnetFremtidigInntekt = (FPI eller HYPF eller HYPF2G) * nyG/gammelG
     * Dette attributtet er ytelsesuavhengig.
     * 30-jan-2008: Denne m� antagelig suppleres med en tilsvarende beregnetFremtidigInntekt p� Ektefelletillegget.
     * Verdien skal oppfattes som en grenseverdi,dvs den verdien som ble lagt til grunn ved eventuell avkorting.
     * For UP vil denne verdien settes lik uforeEkstra.tak.
     */
    private int beregnetFremtidigInntekt;

    /**
     * Angir om ektefellen mottar ytelser fra Folketrygden, dvs har inntekt av type PENF.
     */
    private boolean ektefelleMottarPensjon;

    /**
     * Andre beregningsdata ved beregning av uf�repensjon.
     */
    private UforeEkstra uforeEkstra;

    /**
     * Benyttet sivilstand (tilknyttetPerson.borMedType
     */
    private BorMedTypeCti benyttetSivilstand;

    /**
     * Brukerens sivilstand (som definert i TPS).
     */
    private SivilstandTypeCti brukersSivilstand;

    /**
     * Angir om beregningen er gjort med mindre enn full grad for ufg,afpPensjonsgrad eller tt_anv..
     * Er satt dersom ufg < 100%, tt_anv < 40 eller afpPensjongrad < 100%.
     */
    private boolean gradert;

    /**
     * Inntekten som har ligget til grunn ved inntektsavkorting - Det er denne inntekten vi i Myggen vil kj�re inntektskontroll mot.
     */
    private int inntektBruktIAvkorting;

    /**
     * Angir om ytelsene er redusert p� grunn av institusjonsopphold.
     */
    private boolean redusertPgaInstOpphold;

    /**
     * Angir hvilken type institusjon beregningen ang�r.
     */
    private JustertPeriodeCti instOppholdType;

    /**
     * Angir den siste uf�regraden fra uf�regrunnlaget som ble lagt til grunn for beregningen.
     * Kun relevant for uf�repensjon.
     */
    private int ufg;

    /**
     * Angir den siste yrkesskadegraden fra yrkesskadegrunnlaget som ble lagt til grunn for beregningen.
     * Kun relevant for ytelser som involverer yrkesskade.
     */
    private int yug;

    /**
     * Angir om opptjeningen fra det 65 �ret er brukt som opptjening i de 66 �ret fram til brukeren
     * fyller 70 �r.
     */
    private boolean brukOpptjeningFra65I66Aret;

    /**
     * Informasjon ang E�S beregning. Objektet sparer p� data for bruk ved konvertering til AP.
     * EosEkstra finnes da i grunnlaget p� GenerellHistorikk.
     */
    private EosEkstra eosEkstra;

    /**
     * Innf�rt i Horisonten
     */
    private LonnsvekstInformasjon lonnsvekstInformasjon;

    /**
     * 0.0075
     */
    private double pubReguleringFratrekk;
    /**
     * Beregnet trygdetid som kun gjelder for grunnlagsrollen (eks. s�ker). Det vil si at det ikke ligger
     * noen gjenlevendedel i denne trygdetiden. Det er heller n�dvendigvis ikke denne trygdetiden som er
     * benyttet i beregningen.
     */
    private int ttBeregnetForGrunnlagsrolle;

    /*
     * Flagg som angir om ung uf�r garanti er tatt bort ved eksport.
     */
    private boolean ungUforGarantiFrafalt;
    /**
     * Intern PREG variabel.
     * Anvendt uf�retidspunkt. Hentes normalt fra uf�regrunnlag men kan v�re hentet fra uf�rehistorikk ved
     * l�nnsomhetsberegning.
     */
    private Date uft;

    /**
     * Intern PREG variabel.
     * Anvendt yrkesskadetidspunkt. Hentes normalt fra yrkesskadegrunnlag men kan v�re hentet fra yrkesskadehistorikk
     * ved l�nnsomhetsberegning.
     */
    private Date yst;

    /**
     * Intern PREG variabel.
     * Benyttes for � avgj�re hvilken beregningsmetode som skal kj�res for fors�rgertillegg.
     */
    private String PREG_ftType;

    /**
     * PREG versjonsnummer.
     */
    private String PREG_versjon;

    /**
     * Liste av merknader - forklaringer,unntak og avvisningsgrunner fra regelmotoren.
     */
    private List<Merknad> merknadListe;

    /**
     * Indikerer om beregningen er gjort p� grunnlag av en GammelUngUf�r-garanti.
     */
    private boolean PREG_gammelUngUfor;

    /**
     * Angir om den avd�des tt_anv ble valgt. Settes i regelsettet GJPbestemTrygdetidRS.
     */
    private boolean PREG_tt_anv_avdodBrukt;

    /**
     * Holder p� brukers originale tt_anv dersom den har blitt overskrevet.
     */
    private int PREG_tt_anv_andre;

    /**
     * Sparer unna uforeEkstra i denne f�r det blir slettet i FjernUforeEkstraGJPRS;
     */
    private UforeEkstra PREG_uforeEkstraAvdod;
    private String PREG_avtaleBeregningsmetode;

    /**
     * Prorata faktor anvendt for grunnpensjon.
     */
    private double PREG_prorata_anv_gp;

    /**
     * Copy Constructors
     * 
     * @param beregning a <code>Beregning</code> object
     */
    public Beregning(Beregning beregning, boolean inkluderDelberegninger) {
        this(beregning);
        if (beregning == null) {
            return;
        }
        if (inkluderDelberegninger) {
            kopierberegningstre(beregning, this);
        }
    }

    /**
     * Kopierer et beregningstre rekursivt
     * 
     * @param b - originalt beregningstre
     * @param t - en beregning som potensielt skal utfylles med delberegninger
     * @return t - kopi av beregningstreet
     * Forutsetning: alle beregninger i b er unike.
     * Advarsel : hvis to beregninger peker p� hverandre => stack overflow
     */
    private void kopierberegningstre(Beregning b, Beregning t) {
        // Sjekker om delberegninger har delberegninger
        for (BeregningRelasjon relasjon : b.getDelberegningsListe()) {
            Beregning kopi = new Beregning(relasjon.getBeregning());
            t.getDelberegningsListe().add(new BeregningRelasjon(kopi, relasjon.isBruk()));
            if (relasjon.getBeregning().getDelberegningsListe().size() > 0) {
                kopierberegningstre(relasjon.getBeregning(), kopi);
            }
        }
    }

    /**
     * Copy constructor for Beregning
     * NB! Kopierer ikke delberegninger
     * 
     * @param beregning
     */
    public Beregning(Beregning beregning) {
        if (beregning == null) {
            return;
        }
        if (beregning.penPerson != null) {
            penPerson = new PenPerson(beregning.penPerson);
        }
        if (beregning.virkFom != null) {
            virkFom = (Date) beregning.virkFom.clone();
        }
        if (beregning.virkTom != null) {
            virkTom = (Date) beregning.virkTom.clone();
        }
        brutto = beregning.brutto;
        netto = beregning.netto;
        if (beregning.gp != null) {
            gp = new Grunnpensjon(beregning.gp);
        }
        if (beregning.gpAfpPensjonsregulert != null) {
            gpAfpPensjonsregulert = new Grunnpensjon(beregning.gpAfpPensjonsregulert);
        }
        if (beregning.tp != null) {
            tp = new Tilleggspensjon(beregning.tp);
        }
        if (beregning.st != null) {
            st = new Sertillegg(beregning.st);
        }
        if (beregning.minstenivatilleggPensjonistpar != null) {
            minstenivatilleggPensjonistpar = new MinstenivatilleggPensjonistpar(beregning.minstenivatilleggPensjonistpar);
        }
        if (beregning.afpTillegg != null) {
            afpTillegg = new AfpTillegg(beregning.afpTillegg);
        }
        if (beregning.vt != null) {
            vt = new Ventetillegg(beregning.vt);
        }
        if (beregning.p851_tillegg != null) {
            p851_tillegg = new Paragraf_8_5_1_tillegg(beregning.p851_tillegg);
        }
        if (beregning.et != null) {
            et = new Ektefelletillegg(beregning.et);
        }
        if (beregning.tfb != null) {
            tfb = new BarnetilleggFellesbarn(beregning.tfb);
        }
        if (beregning.tsb != null) {
            tsb = new BarnetilleggSerkullsbarn(beregning.tsb);
        }
        if (beregning.familietillegg != null) {
            familietillegg = new Familietillegg(beregning.familietillegg);
        }
        if (beregning.tilleggFasteUtgifter != null) {
            tilleggFasteUtgifter = new FasteUtgifterTillegg(beregning.tilleggFasteUtgifter);
        }
        g = beregning.g;
        tt_anv = beregning.tt_anv;
        if (beregning.beregningsMetode != null) {
            beregningsMetode = new BeregningMetodeTypeCti(beregning.beregningsMetode);
        }
        if (beregning.trygdetid != null) {
            trygdetid = new Trygdetid(beregning.trygdetid);
        }

        delberegningsListe = new ArrayList<BeregningRelasjon>();

        if (beregning.beregningType != null) {
            beregningType = new BeregningTypeCti(beregning.beregningType);
        }
        if (beregning.resultatType != null) {
            resultatType = new ResultatTypeCti(beregning.resultatType);
        }
        ikkeTraverser = beregning.ikkeTraverser;
        ektefelleInntektOver2g = beregning.ektefelleInntektOver2g;
        p67beregning = beregning.p67beregning;
        if (beregning.beregningArsak != null) {
            beregningArsak = new BeregningArsakCti(beregning.beregningArsak);
        }
        if (beregning.minstepensjontype != null) {
            minstepensjontype = new MinstepensjonTypeCti(beregning.minstepensjontype);
        }
        totalVinner = beregning.totalVinner;
        afpPensjonsgrad = beregning.afpPensjonsgrad;
        fribelop = beregning.fribelop;
        friinntekt = beregning.friinntekt;
        beregnetFremtidigInntekt = beregning.beregnetFremtidigInntekt;
        ektefelleMottarPensjon = beregning.ektefelleMottarPensjon;
        if (beregning.uforeEkstra != null) {
            uforeEkstra = new UforeEkstra(beregning.uforeEkstra);
        }
        if (beregning.benyttetSivilstand != null) {
            benyttetSivilstand = new BorMedTypeCti(beregning.benyttetSivilstand);
        }
        if (beregning.brukersSivilstand != null) {
            brukersSivilstand = new SivilstandTypeCti(beregning.brukersSivilstand);
        }
        gradert = beregning.gradert;
        inntektBruktIAvkorting = beregning.inntektBruktIAvkorting;
        redusertPgaInstOpphold = beregning.redusertPgaInstOpphold;
        if (beregning.instOppholdType != null) {
            instOppholdType = new JustertPeriodeCti(beregning.instOppholdType);
        }
        redusertPgaInstOpphold = beregning.redusertPgaInstOpphold;
        ufg = beregning.ufg;
        yug = beregning.yug;
        brukOpptjeningFra65I66Aret = beregning.brukOpptjeningFra65I66Aret;
        if (beregning.eosEkstra != null) {
            eosEkstra = new EosEkstra(beregning.eosEkstra);
        }
        merknadListe = new ArrayList<Merknad>();
        if (beregning.merknadListe != null) {
            for (Merknad merknad : beregning.merknadListe) {
                merknadListe.add(new Merknad(merknad));
            }
        }
        if (beregning.lonnsvekstInformasjon != null) {
            lonnsvekstInformasjon = new LonnsvekstInformasjon(beregning.lonnsvekstInformasjon);
        }
        if (beregning.gpKapittel3 != null) {
            gpKapittel3 = new Grunnpensjon(beregning.gpKapittel3);
        }
        if (beregning.tpKapittel3 != null) {
            tpKapittel3 = new Tilleggspensjon(beregning.tpKapittel3);
        }
        if (beregning.stKapittel3 != null) {
            stKapittel3 = new Sertillegg(beregning.stKapittel3);
        }
        if (beregning.vtKapittel3 != null) {
            vtKapittel3 = new Ventetillegg(beregning.vtKapittel3);
        }

        if (beregning.minstenivatilleggIndividuelt != null) {
            minstenivatilleggIndividuelt = new MinstenivatilleggIndividuelt(beregning.minstenivatilleggIndividuelt);
        }

        ttBeregnetForGrunnlagsrolle = beregning.ttBeregnetForGrunnlagsrolle;
        if (beregning.konverteringsdataUT != null) {
            konverteringsdataUT = new KonverteringsdataUT(beregning.konverteringsdataUT);
        }
        //PREG_
        if (beregning.uft != null) {
            uft = (Date) beregning.uft.clone();
        }
        if (beregning.yst != null) {
            yst = (Date) beregning.yst.clone();
        }
        PREG_ftType = beregning.PREG_ftType;
        PREG_avtaleBeregningsmetode = beregning.PREG_avtaleBeregningsmetode;
        PREG_versjon = beregning.PREG_versjon;
        PREG_tt_anv_andre = beregning.PREG_tt_anv_andre;
        PREG_tt_anv_avdodBrukt = beregning.PREG_tt_anv_avdodBrukt;
        if (beregning.PREG_uforeEkstraAvdod != null) {
            PREG_uforeEkstraAvdod = new UforeEkstra(beregning.PREG_uforeEkstraAvdod);
        }
        PREG_beregningsnavn = beregning.PREG_beregningsnavn;
        pubReguleringFratrekk = beregning.pubReguleringFratrekk;
        PREG_avtaleBeregningsmetode = beregning.PREG_avtaleBeregningsmetode;
        PREG_prorata_anv_gp = beregning.PREG_prorata_anv_gp;

        //PEN-objekter
        if (beregning.garantitillegg_Art_27 != null) {
            garantitillegg_Art_27 = new Garantitillegg_Art_27(beregning.garantitillegg_Art_27);
        }
        if (beregning.garantitillegg_Art_50 != null) {
            garantitillegg_Art_50 = new Garantitillegg_Art_50(beregning.garantitillegg_Art_50);
        }
        if (beregning.hjelpeloshetsbidrag != null) {
            hjelpeloshetsbidrag = new Hjelpeloshetsbidrag(beregning.hjelpeloshetsbidrag);
        }
        if (beregning.krigOgGammelYrkesskade != null) {
            krigOgGammelYrkesskade = new KrigOgGammelYrkesskade(beregning.krigOgGammelYrkesskade);
        }
        if (beregning.mendel != null) {
            mendel = new Mendel(beregning.mendel);
        }
        if (beregning.tilleggTilHjelpIHuset != null) {
            tilleggTilHjelpIHuset = new TilleggTilHjelpIHuset(beregning.tilleggTilHjelpIHuset);
        }
        PREG_beregningsnavn = beregning.PREG_beregningsnavn;
        ungUforGarantiFrafalt = beregning.ungUforGarantiFrafalt;
    }

    public Beregning(PenPerson penPerson,
            Date virkFom,
            Date virkTom,
            int brutto,
            int netto,
            Grunnpensjon gp,
            Grunnpensjon gpKapittel3,
            Tilleggspensjon tp,
            Sertillegg st,
            AfpTillegg afpTillegg,
            Ventetillegg vt,
            Paragraf_8_5_1_tillegg p851_tillegg,
            Ektefelletillegg et,
            BarnetilleggFellesbarn tfb,
            BarnetilleggSerkullsbarn tsb,
            Familietillegg familietillegg,
            FasteUtgifterTillegg tilleggFasteUtgifter,
            int g,
            int tt_anv,
            BeregningMetodeTypeCti beregningsMetode,
            Trygdetid trygdetid,
            List<BeregningRelasjon> delberegningsListe,
            Sluttpoengtall spt,
            Sluttpoengtall ypt,
            Sluttpoengtall opt,
            BeregningTypeCti beregningType,
            ResultatTypeCti resultatType,
            boolean ikkeTraverser,
            boolean ektefelleInntektOver2g,
            boolean p67beregning,
            BeregningArsakCti beregningArsak,
            MinstepensjonTypeCti minstepensjontype,
            boolean totalVinner,
            int afpPensjonsgrad,
            int fribelop,
            int friinntekt,
            int beregnetFremtidigInntekt,
            boolean ektefelleMottarPensjon,
            UforeEkstra uforeEkstra,
            BorMedTypeCti benyttetSivilstand,
            SivilstandTypeCti brukersSivilstand,
            boolean gradert,
            int inntektBruktIAvkorting,
            boolean redusertPgaInstOpphold,
            JustertPeriodeCti instOppholdType,
            int ufg,
            int yug,
            boolean brukOpptjeningFra65I66Aret,
            KrigOgGammelYrkesskade krigOgGammelYrkesskade,
            KonverteringsdataUT konverteringsdata,
            List<Merknad> merknadListe,
            EosEkstra eosEkstra,
            MinstenivatilleggPensjonistpar mintpp) {
        super();
        this.penPerson = penPerson;
        this.virkFom = virkFom;
        this.virkTom = virkTom;
        this.brutto = brutto;
        this.netto = netto;
        this.gp = gp;
        this.gpKapittel3 = gpKapittel3;
        this.tp = tp;
        this.st = st;
        minstenivatilleggPensjonistpar = mintpp;
        this.afpTillegg = afpTillegg;
        this.vt = vt;
        this.p851_tillegg = p851_tillegg;
        this.et = et;
        this.tfb = tfb;
        this.tsb = tsb;
        this.familietillegg = familietillegg;
        this.tilleggFasteUtgifter = tilleggFasteUtgifter;
        this.g = g;
        this.tt_anv = tt_anv;
        this.beregningsMetode = beregningsMetode;
        this.trygdetid = trygdetid;
        this.delberegningsListe = delberegningsListe;
        this.beregningType = beregningType;
        this.resultatType = resultatType;
        this.ikkeTraverser = ikkeTraverser;
        this.ektefelleInntektOver2g = ektefelleInntektOver2g;
        this.p67beregning = p67beregning;
        this.beregningArsak = beregningArsak;
        this.minstepensjontype = minstepensjontype;
        this.totalVinner = totalVinner;
        this.afpPensjonsgrad = afpPensjonsgrad;
        this.fribelop = fribelop;
        this.friinntekt = friinntekt;
        this.beregnetFremtidigInntekt = beregnetFremtidigInntekt;
        this.ektefelleMottarPensjon = ektefelleMottarPensjon;
        this.uforeEkstra = uforeEkstra;
        this.benyttetSivilstand = benyttetSivilstand;
        this.brukersSivilstand = brukersSivilstand;
        this.gradert = gradert;
        this.inntektBruktIAvkorting = inntektBruktIAvkorting;
        this.redusertPgaInstOpphold = redusertPgaInstOpphold;
        this.instOppholdType = instOppholdType;
        this.ufg = ufg;
        this.yug = yug;
        this.brukOpptjeningFra65I66Aret = brukOpptjeningFra65I66Aret;
        this.krigOgGammelYrkesskade = krigOgGammelYrkesskade;
        konverteringsdataUT = konverteringsdata;
        this.merknadListe = merknadListe;
        this.eosEkstra = eosEkstra;
    }

    public Beregning() {
        merknadListe = new ArrayList<Merknad>();
        delberegningsListe = new ArrayList<BeregningRelasjon>();
    }

    public BeregningMetodeTypeCti getBeregningsMetode() {
        return beregningsMetode;
    }

    public void setBeregningsMetode(BeregningMetodeTypeCti beregningsMetode) {
        this.beregningsMetode = beregningsMetode;
    }

    /**
     * @return Returns the afp_tillegg.
     */
    public AfpTillegg getAfpTillegg() {
        return afpTillegg;
    }

    /**
     * @param afpTillegg The afp_tillegg to set.
     */
    public void setAfpTillegg(AfpTillegg afpTillegg) {
        this.afpTillegg = afpTillegg;
    }

    /**
     * @return Returns the brutto.
     */
    public int getBrutto() {
        return brutto;
    }

    /**
     * @param brutto The brutto to set.
     */
    public void setBrutto(int brutto) {
        this.brutto = brutto;
    }

    /**
     * @return Returns the gp.
     */
    public Grunnpensjon getGp() {
        return gp;
    }

    /**
     * @param gp The gp to set.
     */
    public void setGp(Grunnpensjon gp) {
        this.gp = gp;
    }

    public Grunnpensjon getGpAfpPensjonsregulert() {
        return gpAfpPensjonsregulert;
    }

    public void setGpAfpPensjonsregulert(Grunnpensjon gpAfpPensjonsregulert) {
        this.gpAfpPensjonsregulert = gpAfpPensjonsregulert;
    }

    /**
     * @return Returns the netto.
     */
    public int getNetto() {
        return netto;
    }

    /**
     * @param netto The netto to set.
     */
    public void setNetto(int netto) {
        this.netto = netto;
    }

    /**
     * @return Returns the st.
     */
    public Sertillegg getSt() {
        return st;
    }

    /**
     * @param st The st to set.
     */
    public void setSt(Sertillegg st) {
        this.st = st;
    }

    /**
     * @return Returns the minstenivatilleggPensjonistpar.
     */
    public MinstenivatilleggPensjonistpar getMinstenivatilleggPensjonistpar() {
        return minstenivatilleggPensjonistpar;
    }

    /**
     * @param minstenivatilleggPensjonistpar The minstenivatilleggPensjonistpar to set.
     */
    public void setMinstenivatilleggPensjonistpar(MinstenivatilleggPensjonistpar minstenivatilleggPensjonistpar) {
        this.minstenivatilleggPensjonistpar = minstenivatilleggPensjonistpar;
    }

    /**
     * @return Returns the tp.
     */
    public Tilleggspensjon getTp() {
        return tp;
    }

    /**
     * @param tp The tp to set.
     */
    public void setTp(Tilleggspensjon tp) {
        this.tp = tp;
    }

    /**
     * @return Returns the g.
     */
    public int getG() {
        return g;
    }

    /**
     * @param g The g to set.
     */
    public void setG(int g) {
        this.g = g;
    }

    /**
     * @param merknad The merknad to set.
     */
    public void setMerknadListe(List<Merknad> merknad) {
        merknadListe = merknad;
    }

    /**
     * @return Returns the merknad.
     */
    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    @Override
    public List<BeregningRelasjon> getDelberegningsListe() {
        return delberegningsListe;
    }

    public void setDelberegningsListe(List<BeregningRelasjon> delberegningsListe) {
        this.delberegningsListe = delberegningsListe;
    }

    public void putBeregningListe(BeregningRelasjon[] beregningListe) {
        delberegningsListe = Arrays.asList(beregningListe);
    }

    public Trygdetid getTrygdetid() {
        return trygdetid;
    }

    public void setTrygdetid(Trygdetid trygdetid) {
        this.trygdetid = trygdetid;
    }

    public Ektefelletillegg getEt() {
        return et;
    }

    public void setEt(Ektefelletillegg et) {
        this.et = et;
    }

    public Paragraf_8_5_1_tillegg getP851_tillegg() {
        return p851_tillegg;
    }

    public void setP851_tillegg(Paragraf_8_5_1_tillegg p851_tillegg) {
        this.p851_tillegg = p851_tillegg;
    }

    public BarnetilleggFellesbarn getTfb() {
        return tfb;
    }

    public void setTfb(BarnetilleggFellesbarn tfb) {
        this.tfb = tfb;
    }

    public BarnetilleggSerkullsbarn getTsb() {
        return tsb;
    }

    public void setTsb(BarnetilleggSerkullsbarn tsb) {
        this.tsb = tsb;
    }

    public no.nav.pensjon.regler.domain.beregning.Familietillegg getFamilietillegg() {
        return familietillegg;
    }

    public void setFamilietillegg(no.nav.pensjon.regler.domain.beregning.Familietillegg familietillegg) {
        this.familietillegg = familietillegg;
    }

    public no.nav.pensjon.regler.domain.beregning.FasteUtgifterTillegg getTilleggFasteUtgifter() {
        return tilleggFasteUtgifter;
    }

    public void setTilleggFasteUtgifter(no.nav.pensjon.regler.domain.beregning.FasteUtgifterTillegg tilleggFasteUtgifter) {
        this.tilleggFasteUtgifter = tilleggFasteUtgifter;
    }

    public KrigOgGammelYrkesskade getKrigOgGammelYrkesskade() {
        return krigOgGammelYrkesskade;
    }

    public void setKrigOgGammelYrkesskade(KrigOgGammelYrkesskade krigOgGammelYrkesskade) {
        this.krigOgGammelYrkesskade = krigOgGammelYrkesskade;
    }

    public Garantitillegg_Art_27 getGarantitillegg_Art_27() {
        return garantitillegg_Art_27;
    }

    public void setGarantitillegg_Art_27(Garantitillegg_Art_27 garantitillegg_Art_27) {
        this.garantitillegg_Art_27 = garantitillegg_Art_27;
    }

    public Garantitillegg_Art_50 getGarantitillegg_Art_50() {
        return garantitillegg_Art_50;
    }

    public void setGarantitillegg_Art_50(Garantitillegg_Art_50 garantitillegg_Art_50) {
        this.garantitillegg_Art_50 = garantitillegg_Art_50;
    }

    public Hjelpeloshetsbidrag getHjelpeloshetsbidrag() {
        return hjelpeloshetsbidrag;
    }

    public void setHjelpeloshetsbidrag(Hjelpeloshetsbidrag hjelpeloshetsbidrag) {
        this.hjelpeloshetsbidrag = hjelpeloshetsbidrag;
    }

    public Mendel getMendel() {
        return mendel;
    }

    public void setMendel(Mendel mendel) {
        this.mendel = mendel;
    }

    public TilleggTilHjelpIHuset getTilleggTilHjelpIHuset() {
        return tilleggTilHjelpIHuset;
    }

    public void setTilleggTilHjelpIHuset(TilleggTilHjelpIHuset tilleggTilHjelpIHuset) {
        this.tilleggTilHjelpIHuset = tilleggTilHjelpIHuset;
    }

    public Date getVirkFom() {
        return virkFom;
    }

    public void setVirkFom(Date virkFom) {
        this.virkFom = virkFom;
    }

    public String getPREG_ftType() {
        return PREG_ftType;
    }

    public void setPREG_ftType(String type) {
        PREG_ftType = type;
    }

    public int getAfpPensjonsgrad() {
        return afpPensjonsgrad;
    }

    public void setAfpPensjonsgrad(int afpPensjonsgrad) {
        this.afpPensjonsgrad = afpPensjonsgrad;
    }

    public int getBeregnetFremtidigInntekt() {
        return beregnetFremtidigInntekt;
    }

    public void setBeregnetFremtidigInntekt(int beregnetFremtidigInntekt) {
        this.beregnetFremtidigInntekt = beregnetFremtidigInntekt;
    }

    public int getFribelop() {
        return fribelop;
    }

    public void setFribelop(int fribelop) {
        this.fribelop = fribelop;
    }

    public int getFriinntekt() {
        return friinntekt;
    }

    public void setFriinntekt(int friinntekt) {
        this.friinntekt = friinntekt;
    }

    public UforeEkstra getUforeEkstra() {
        return uforeEkstra;
    }

    public void setUforeEkstra(UforeEkstra uforeEkstra) {
        this.uforeEkstra = uforeEkstra;
    }

    public BeregningArsakCti getBeregningArsak() {
        return beregningArsak;
    }

    public void setBeregningArsak(BeregningArsakCti beregningArsak) {
        this.beregningArsak = beregningArsak;
    }

    public BeregningTypeCti getBeregningType() {
        return beregningType;
    }

    public void setBeregningType(BeregningTypeCti beregningType) {
        this.beregningType = beregningType;
    }

    public boolean isP67beregning() {
        return p67beregning;
    }

    public void setP67beregning(boolean p67beregning) {
        this.p67beregning = p67beregning;
    }

    public ResultatTypeCti getResultatType() {
        return resultatType;
    }

    public void setResultatType(ResultatTypeCti resultatType) {
        this.resultatType = resultatType;
    }

    public boolean isTotalVinner() {
        return totalVinner;
    }

    public void setTotalVinner(boolean totalVinner) {
        this.totalVinner = totalVinner;
    }

    public boolean isEktefelleInntektOver2g() {
        return ektefelleInntektOver2g;
    }

    public void setEktefelleInntektOver2g(boolean ektefelleInntektOver2g) {
        this.ektefelleInntektOver2g = ektefelleInntektOver2g;
    }

    public boolean isEktefelleMottarPensjon() {
        return ektefelleMottarPensjon;
    }

    public void setEktefelleMottarPensjon(boolean ektefelleMottarPensjon) {
        this.ektefelleMottarPensjon = ektefelleMottarPensjon;
    }

    public BorMedTypeCti getBenyttetSivilstand() {
        return benyttetSivilstand;
    }

    public void setBenyttetSivilstand(BorMedTypeCti benyttetSivilstand) {
        this.benyttetSivilstand = benyttetSivilstand;
    }

    public boolean isGradert() {
        return gradert;
    }

    public void setGradert(boolean gradert) {
        this.gradert = gradert;
    }

    public MinstepensjonTypeCti getMinstepensjontype() {
        return minstepensjontype;
    }

    public void setMinstepensjontype(MinstepensjonTypeCti minstepensjontype) {
        this.minstepensjontype = minstepensjontype;
    }

    public String getMinstepensjonArsak() { return minstepensjonArsak; }

    public void setMinstepensjonArsak(String minstepensjonArsak) {
        this.minstepensjonArsak = minstepensjonArsak;
    }

    public Date getVirkTom() {
        return virkTom;
    }

    public void setVirkTom(Date virkTom) {
        this.virkTom = virkTom;
    }

    public int getInntektBruktIAvkorting() {
        return inntektBruktIAvkorting;
    }

    public void setInntektBruktIAvkorting(int inntektBruktIAvkorting) {
        this.inntektBruktIAvkorting = inntektBruktIAvkorting;
    }

    public boolean isRedusertPgaInstOpphold() {
        return redusertPgaInstOpphold;
    }

    public void setRedusertPgaInstOpphold(boolean redusertPgaInstOpphold) {
        this.redusertPgaInstOpphold = redusertPgaInstOpphold;
    }

    public JustertPeriodeCti getInstOppholdType() {
        return instOppholdType;
    }

    public void setInstOppholdType(JustertPeriodeCti instOppholdType) {
        this.instOppholdType = instOppholdType;
    }

    public Ventetillegg getVt() {
        return vt;
    }

    public void setVt(Ventetillegg vt) {
        this.vt = vt;
    }

    public int getTt_anv() {
        return tt_anv;
    }

    public void setTt_anv(int tt_anv) {
        this.tt_anv = tt_anv;
    }

    public boolean isBrukOpptjeningFra65I66Aret() {
        return brukOpptjeningFra65I66Aret;
    }

    public void setBrukOpptjeningFra65I66Aret(boolean brukOpptjeningFra65I66Aret) {
        this.brukOpptjeningFra65I66Aret = brukOpptjeningFra65I66Aret;
    }

    public int getUfg() {
        return ufg;
    }

    public void setUfg(int ufg) {
        this.ufg = ufg;
    }

    public int getYug() {
        return yug;
    }

    public void setYug(int yug) {
        this.yug = yug;
    }

    public PenPerson getPenPerson() {
        return penPerson;
    }

    public void setPenPerson(PenPerson penPerson) {
        this.penPerson = penPerson;
    }

    public SivilstandTypeCti getBrukersSivilstand() {
        return brukersSivilstand;
    }

    public void setBrukersSivilstand(SivilstandTypeCti brukersSivilstand) {
        this.brukersSivilstand = brukersSivilstand;
    }

    public EosEkstra getEosEkstra() {
        return eosEkstra;
    }

    public void setEosEkstra(EosEkstra eosEkstra) {
        this.eosEkstra = eosEkstra;
    }

    public Grunnpensjon getGpKapittel3() {
        return gpKapittel3;
    }

    public void setGpKapittel3(Grunnpensjon gpKapittel3) {
        this.gpKapittel3 = gpKapittel3;
    }

    public Tilleggspensjon getTpKapittel3() {
        return tpKapittel3;
    }

    public void setTpKapittel3(Tilleggspensjon tpKapittel3) {
        this.tpKapittel3 = tpKapittel3;
    }

    public Sertillegg getStKapittel3() {
        return stKapittel3;
    }

    public void setStKapittel3(Sertillegg stKapittel3) {
        this.stKapittel3 = stKapittel3;
    }

    public Ventetillegg getVtKapittel3() {
        return vtKapittel3;
    }

    public void setVtKapittel3(Ventetillegg vtKapittel3) {
        this.vtKapittel3 = vtKapittel3;
    }

    public MinstenivatilleggIndividuelt getMinstenivatilleggIndividuelt() {
        return minstenivatilleggIndividuelt;
    }

    public void setMinstenivatilleggIndividuelt(MinstenivatilleggIndividuelt minstenivatilleggIndividuelt) {
        this.minstenivatilleggIndividuelt = minstenivatilleggIndividuelt;
    }

    public LonnsvekstInformasjon getLonnsvekstInformasjon() {
        return lonnsvekstInformasjon;
    }

    public void setLonnsvekstInformasjon(LonnsvekstInformasjon lonnsvekstInformasjon) {
        this.lonnsvekstInformasjon = lonnsvekstInformasjon;
    }

    public Date getUft() {
        return uft;
    }

    public void setUft(Date uft) {
        this.uft = uft;
    }

    public Date getYst() {
        return yst;
    }

    public void setYst(Date yst) {
        this.yst = yst;
    }

    public String getPREG_versjon() {
        return PREG_versjon;
    }

    public void setPREG_versjon(String preg_versjon) {
        PREG_versjon = preg_versjon;
    }

    public boolean isIkkeTraverser() {
        return ikkeTraverser;
    }

    public void setIkkeTraverser(boolean ikkeTraverser) {
        this.ikkeTraverser = ikkeTraverser;
    }

    public double getPubReguleringFratrekk() {
        return pubReguleringFratrekk;
    }

    public void setPubReguleringFratrekk(double pubReguleringFratrekk) {
        this.pubReguleringFratrekk = pubReguleringFratrekk;
    }

    public boolean isPREG_gammelUngUfor() {
        return PREG_gammelUngUfor;
    }

    public void setPREG_gammelUngUfor(boolean ungUfor) {
        PREG_gammelUngUfor = ungUfor;
    }

    public int getPREG_tt_anv_andre() {
        return PREG_tt_anv_andre;
    }

    public void setPREG_tt_anv_andre(int preg_tt_anv_andre) {
        PREG_tt_anv_andre = preg_tt_anv_andre;
    }

    public boolean isPREG_tt_anv_avdodBrukt() {
        return PREG_tt_anv_avdodBrukt;
    }

    public void setPREG_tt_anv_avdodBrukt(boolean brukt) {
        PREG_tt_anv_avdodBrukt = brukt;
    }

    public UforeEkstra getPREG_uforeEkstraAvdod() {
        return PREG_uforeEkstraAvdod;
    }

    public void setPREG_uforeEkstraAvdod(UforeEkstra ekstraAvdod) {
        PREG_uforeEkstraAvdod = ekstraAvdod;
    }

    public boolean erLovNode() {
        return false;
    }

    public boolean erToppnode() {
        return false;
    }

    public String getPREG_beregningsnavn() {
        return PREG_beregningsnavn;
    }

    public void setPREG_beregningsnavn(String preg_beregningsnavn) {
        PREG_beregningsnavn = preg_beregningsnavn;
    }

    /**
     * Legger til beregningRelasjon til lista. BeregningsId blir satt p� den respektive beregningen.
     * 
     * @param beregningRelasjon
     * @param beregningsnavn
     */
    public void addBeregningRelasjon(BeregningRelasjon beregningRelasjon, String beregningsnavn) {
        if (beregningsnavn != null && beregningRelasjon != null) {
            BeregningRelasjon eksisterende = getBeregningRelasjon(beregningsnavn);
            if (eksisterende != null) {
                // Fjern eksisterende
                delberegningsListe.remove(eksisterende);
            }
            if (beregningRelasjon.getBeregning() != null) {
                beregningRelasjon.getBeregning().setPREG_beregningsnavn(beregningsnavn);
            }
            if (beregningRelasjon.getBeregning2011() != null) {
                beregningRelasjon.getBeregning2011().setPREG_beregningsnavn(beregningsnavn);
            }
            beregningRelasjon.setPREG_parentBeregning(this);
            delberegningsListe.add(beregningRelasjon);
        }
    }

    public void addBeregning(Beregning2011 beregning2011, boolean brukt, String beregningsnavn) {
        beregning2011.setPREG_beregningsnavn(beregningsnavn);
        BeregningRelasjon br = new BeregningRelasjon();
        br.setBeregning2011(beregning2011);
        addBeregningRelasjon(br, beregningsnavn);
    }

    public void addBeregning(Beregning beregning, boolean brukt, String beregningsnavn) {
        beregning.setPREG_beregningsnavn(beregningsnavn);
        BeregningRelasjon br = new BeregningRelasjon();
        br.setBeregning(beregning);
        addBeregningRelasjon(br, beregningsnavn);
    }

    public BeregningRelasjon getBeregningRelasjon(String beregningId) {
        for (BeregningRelasjon br : delberegningsListe) {
            if (br.getBeregning() != null && beregningId.equals(br.getBeregning().getPREG_beregningsnavn())) {
                return br;
            }
            if (br.getBeregning2011() != null && beregningId.equals(br.getBeregning2011().getPREG_beregningsnavn())) {
                return br;
            }
        }
        return null;
    }

    public String getPREG_avtaleBeregningsmetode() {
        return PREG_avtaleBeregningsmetode;
    }

    public void setPREG_avtaleBeregningsmetode(String beregningsmetode) {
        PREG_avtaleBeregningsmetode = beregningsmetode;
    }

    public BeregningRelasjon getPREG_beregningsrelasjon() {
        return PREG_beregningsrelasjon;
    }

    public void setPREG_beregningsrelasjon(BeregningRelasjon preg_beregningsrelasjon) {
        PREG_beregningsrelasjon = preg_beregningsrelasjon;
    }

    public double getPREG_prorata_anv_gp() {
        return PREG_prorata_anv_gp;
    }

    public void setPREG_prorata_anv_gp(double preg_prorata_anv_gp) {
        PREG_prorata_anv_gp = preg_prorata_anv_gp;
    }

    public void setTtBeregnetForGrunnlagsrolle(int ttBeregnetForGrunnlagsrolle) {
        this.ttBeregnetForGrunnlagsrolle = ttBeregnetForGrunnlagsrolle;
    }

    public int getTtBeregnetForGrunnlagsrolle() {
        return ttBeregnetForGrunnlagsrolle;
    }

    public boolean isUngUforGarantiFrafalt() {
        return ungUforGarantiFrafalt;
    }

    public void setUngUforGarantiFrafalt(boolean ungUforGarantiFrafalt) {
        this.ungUforGarantiFrafalt = ungUforGarantiFrafalt;
    }

    public KonverteringsdataUT getKonverteringsdataUT() {
        return konverteringsdataUT;
    }

    public void setKonverteringsdataUT(KonverteringsdataUT konverteringsdataUT) {
        this.konverteringsdataUT = konverteringsdataUT;
    }

    public List<Ytelseskomponent> getYtelseskomponenter() {
        List<Ytelseskomponent> retval = new ArrayList<>();
        for (Field f : getClass().getDeclaredFields()) {
            try {
                Object o = f.get(this);
                if (Ytelseskomponent.class.isInstance(o)) {
                    retval.add((Ytelseskomponent) o);
                }
            } catch (IllegalAccessException ex) {
                // skip
            }
        }
        return retval;
    }
}
