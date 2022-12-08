package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.Merknad;
import no.nav.domain.pensjon.regler.PenPerson;
import no.nav.domain.pensjon.regler.Trygdetid;
import no.nav.domain.pensjon.regler.beregning.penobjekter.Garantitillegg_Art_27;
import no.nav.domain.pensjon.regler.beregning.penobjekter.Garantitillegg_Art_50;
import no.nav.domain.pensjon.regler.beregning.penobjekter.Hjelpeloshetsbidrag;
import no.nav.domain.pensjon.regler.beregning.penobjekter.KrigOgGammelYrkesskade;
import no.nav.domain.pensjon.regler.beregning.penobjekter.Mendel;
import no.nav.domain.pensjon.regler.beregning.penobjekter.TilleggTilHjelpIHuset;
import no.nav.domain.pensjon.regler.beregning2011.LonnsvekstInformasjon;
import no.nav.domain.pensjon.regler.beregning2011.MinstenivatilleggIndividuelt;
import no.nav.domain.pensjon.regler.beregning2011.MinstenivatilleggPensjonistpar;
import no.nav.domain.pensjon.regler.grunnlag.EosEkstra;
import no.nav.domain.pensjon.regler.kode.BeregningArsakCti;
import no.nav.domain.pensjon.regler.kode.BeregningMetodeTypeCti;
import no.nav.domain.pensjon.regler.kode.BeregningTypeCti;
import no.nav.domain.pensjon.regler.kode.BorMedTypeCti;
import no.nav.domain.pensjon.regler.kode.JustertPeriodeCti;
import no.nav.domain.pensjon.regler.kode.MinstepensjonTypeCti;
import no.nav.domain.pensjon.regler.kode.ResultatTypeCti;
import no.nav.domain.pensjon.regler.kode.SivilstandTypeCti;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Beregning er resultatet fra en beregning i PREG.
 */
public class Beregning implements Serializable {

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
     * Liste av merknader - forklaringer,unntak og avvisningsgrunner fra regelmotoren.
     */
    private List<Merknad> merknadListe;


}
