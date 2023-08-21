package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.PenPerson;
import no.nav.pensjon.regler.domain.TTPeriode;
import no.nav.pensjon.regler.domain.Trygdetid;
import no.nav.pensjon.regler.domain.beregning2011.OvergangsinfoUPtilUT;
import no.nav.pensjon.regler.domain.beregning2011.UtbetalingsgradUT;
import no.nav.pensjon.regler.domain.kode.BorMedTypeCti;
import no.nav.pensjon.regler.domain.kode.GrunnlagsrolleCti;
import no.nav.pensjon.regler.domain.kode.LandCti;
import no.nav.pensjon.regler.domain.kode.SivilstandTypeCti;
import no.nav.pensjon.regler.domain.util.ToStringUtil;
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Persongrunnlag inneholder nødvendige data knyttet til en bestemt person.
 * Persongrunnlag brukes som inndata til kall på en regeltjeneste og må
 * defineres før kallet.
 * 
 * @author Swiddy de Louw (Capgemini) - PK-7973 - PKPYTON-526
 * @author Steinar Hjellvik (Decisive) - PK-6458
 * @author Lars Hartvigsen (Decisive) - PK-12705, PK-20946
 */
public class Persongrunnlag implements Serializable {
    private static final long serialVersionUID = -5160628000677716654L;

    /**
     * Representerer personen.
     */
    private PenPerson penPerson;

    /**
     * Søkers fødselsdato,brukes kun ved simuleringer.Da benyttes ikke reelle
     * personer.
     */
    private Date fodselsdato;

    /**
     * Personens eventuelle dødsdato, brukes ved beregning av ytelser til
     * gjenlevende ektefelle og barn.
     */
    private Date dodsdato;

    /**
     * Personens statsborgerskap.
     */
    private LandCti statsborgerskap;

    /**
     * Angir om personen er flyktning.
     */
    private Boolean flyktning;

    /**
     * Liste av PersonDetalj-objekter som representerer periodisert
     * detaljinformasjon om personen. Dersom listen har mer enn ett element
     * betyr dette at personens detaljinformasjon har forandret seg over tid,
     * eksempelvis skifte av sivilstand. Det er kun tjenesten
     * KontrollerInformasjonsgrunnlag som vil motta en personDetaljListe med mer
     * enn ett element. Andre tjenester vil kun ha ett element i
     * personDetaljListe. Eks: ved skifte av sivilstand vil en tjeneste bli kalt
     * to ganger.
     */
    private List<PersonDetalj> personDetaljListe;

    /**
     * Dato for sist innmeldt i Folketrygden- for fremtidig trygdetid.
     */
    private Date sistMedlITrygden;
    /**
     * Siste gyldige år for opptjening som benyttes for alderspensjon2011/2016/2025 og AFP Privat.
     * For eksempel skal saksbehandling som utføres i 2010 ta utgangspunkt i opptjeninger til
     * og med 2008 (sisteGyldigeOpptjeningsAr vil her være 2008).
     */
    private int sisteGyldigeOpptjeningsAr = 0;
    /**
     * Angir om opptjeningsinformasjonen er hentet fra Opptjeningsregisteret og
     * registrert som grunnlag på kravet. Det vil være kun ett element i listen
     * ved beregnings/vilkårsprøvingstjenester. Ved tjenesten
     * KontrollerInformasjonsgrunnlag vil det være flere elementer.
     */
    private Boolean hentetPopp;

    /**
     * Angir om informasjonen om inntektsinformasjon er hentet fra
     * Inntektsregisteret og registrert som grunnlag på kravet.
     */
    private Boolean hentetInnt;

    /**
     * Angir om informasjonen om institusjonsopphold er hentet fra
     * Institusjonsoppholdsregisteret og registrert som grunnlag på kravet.
     */
    private Boolean hentetInst;

    /**
     * Angir om trygdetidsinformasjon er hentet inn og registrert som grunnlag
     * på kravet.
     */
    private Boolean hentetTT;

    /**
     * Angir om informasjon om arbeidsforhold er hentet fra
     * Arbeidsforholdregisteret og registrert som grunnlag på kravet.
     */
    private Boolean hentetArbeid;

    /**
     * Angir om personens ytelse skal beregnes med overkompensasjonsregler.
     * Gjelde utenlandstilfeller.
     */
    private Boolean overkompUtl;

    /**
     * Liste av opptjeningsgrunnlag for personen.
     */
    private List<Opptjeningsgrunnlag> opptjeningsgrunnlagListe;

    /**
     * Liste av inntektsgrunnlag for personen.
     */
    private List<Inntektsgrunnlag> inntektsgrunnlagListe;

    /**
     * Liste av trygdetidsperioder for personen.
     */
    private List<TTPeriode> trygdetidPerioder;

    /**
     * Liste av trygdetidsperioder for personen.
     * For beregning av trygdetid for AP2016 iht. kapittel 20 og AP2025.
     */
    private List<TTPeriode> trygdetidPerioderKapittel20;

    /**
     * Framtidig og faktisk trygdetid. Denne ligger også i VilkarsVedtak, men er
     * nødvendig når vi skal ytelsesberegninger der det ikke finnes et vedtak.
     * F.eks Barnepensjon gjenlevende.
     */
    private Trygdetid trygdetid;

    /**
     * Samme som over, men for ny opptjeningsmodell.
     */
    private Trygdetid trygdetidKapittel20;

    /**
     * Trygdetid for alternative Uføretidspunkt.
     */
    private Trygdetid trygdetidAlternativ;

    /**
     * Spesifikke grunnlagsdata for uførepensjon.
     */
    private Uforegrunnlag uforegrunnlag;

    /**
     * Historikk for uføreytelser.Inneholder en blanding av data fra
     * Uforegrunnlag og UforeEkstra.
     */

    private Uforehistorikk uforeHistorikk;

    /**
     * Spesifikke grunnlagsdata for yrkesskadepensjon. Dersom yrkesskadegrunnlag =
     * null betyr det at personen ikke har yrkesskade.
     */
    private Yrkesskadegrunnlag yrkesskadegrunnlag;

    /**
     * Angir om en avdød døde av yrkesskade. Hvis satt vil det finnes et yrkesskadegrunnlag og en dodsdato.
     * Det skal da ikke finnes et uføregrunnlag. Brukes ved BP/GJP/GJR.
     */
    private Boolean dodAvYrkesskade;

    /**
     * Generell historisk informasjon om en person. Ventetilleggsgrunnlag, fravik_19_3.
     */
    private GenerellHistorikk generellHistorikk;
    /**
     * Historikk for AFP ytelser. Inneholder informasjon relevant for
     * perioden(e) bruker hadde AFP.
     */
    private List<AfpHistorikk> afpHistorikkListe;

    /**
     * Beskriver hvor mange barn det er i kullet.
     */
    private Barnekull barnekull;

    /**
     * Hentet som eneste element fra PEN Persongrunnlag.barnetilleggVurderingsperiodeListe
     */
    private BarnetilleggVurderingsperiode barnetilleggVurderingsperiode;

    /**
     * Antall år personen har bodd/arbeidet i utlandet etter fylte 16 år.
     */
    private int antallArUtland;

    /**
     * Angir om personen har vært medlem i Folketrygden de siste 3 år. Brukes
     * ved simulering.
     */
    private Boolean medlemIFolketrygdenSiste3Ar;

    /**
     * Angir om personen er over 60 år eller ikke kan forsørge seg selv. Brukes
     * i simulering for å angi vilkår for ektefelletillegg.
     */
    private Boolean over60ArKanIkkeForsorgesSelv;

    /**
     * Liste av utenlandsopphold.
     */
    private List<Utenlandsopphold> utenlandsoppholdListe;

    /**
     * Trygdeavtale, representerer en saksbehandlers vurdering av hvilken
     * avtale/konvensjon som skal anvendes i en utenlandssak.
     */
    private Trygdeavtale trygdeavtale;

    /**
     * Detaljer knyttet til trygdeavtale. Brukes i beregningen av
     * tilleggspensjon i utenlandssaker.
     */
    private Trygdeavtaledetaljer trygdeavtaledetaljer;

    /**
     * Grunnlag påkrevd for å kunne behandle inngang og eksport av pensjonssaker mellom Norge og utland.
     */
    private InngangOgEksportGrunnlag inngangOgEksportGrunnlag;

    /**
     * Grunnlag påkrevd for å kunne behandle inngang og eksport av pensjonssaker mellom Norge og utland.
     */
    private List<ForsteVirkningsdatoGrunnlag> forsteVirkningsdatoGrunnlagListe;

    /**
     * Årlig pensjonsgivende inntekt var minst 1G på dødstidspunktet.
     */
    private Boolean arligPGIMinst1G;

    /**
     * Angir omdet skal beregnes etter artikkel 10 - nordisk konvensjon.
     * Trygdetiden kan bli redusert.
     */
    private Boolean artikkel10;

    /**
     * Årstall for avtjent verneplikt. Maks 4 år godkjennes. Er null dersom det
     * ikke finnes vernepliktsår. Må være i stigende rekkefølge, eks:<br>
     * <code>[0] = 2001</code><br>
     * <code>[1] = 2002</code><br>
     * <code>[2] = 2004</code>
     */
    private int[] vernepliktAr;

    /**
     * Den skiltes del av avdødes tilleggspensjon. Angis i prosent. Default
     * verdi settes til -99 fordi 0 er en lovlig verdi.
     */
    private int skiltesDelAvAvdodesTP = -99;

    /**
     * Liste av institusjonsoppholdsreduksjonsperioder relatert til
     * persongrunnlaget
     */
    private List<InstOpphReduksjonsperiode> instOpphReduksjonsperiodeListe;

    /**
     * Liste av institusjonsoppholdsfasteutgifterperioder relatert til
     * persongrunnlaget
     */
    private List<InstOpphFasteUtgifterperiode> instOpphFasteUtgifterperiodeListe;

    /**
     * Landskode - det land personen er bosatt i på VIRK. Intern PREG attributt.
     * Default settes denne til NOR og erstattes med Trygdeavtale.bostedsland
     * dersom trygdeavtale ikke er null.
     */
    private LandCti bosattLand;

    private Pensjonsbeholdning pensjonsbeholdning;

    /**
     * Informasjon om førstegangstjenesteperioder.
     */
    private Forstegangstjeneste forstegangstjenestegrunnlag;

    private List<Dagpengegrunnlag> dagpengegrunnlagListe;

    private List<Omsorgsgrunnlag> omsorgsgrunnlagListe;

    /**
     * Informasjon om arbeidsforhold med perioder og stillingsprosent.
     */
    private List<Arbeidsforholdsgrunnlag> arbeidsforholdsgrunnlagListe;

    /**
     * Contains information about post injury arbeidsforhold perioder and stillingsprosent.
     */
    private List<ArbeidsforholdEtterUforgrunnlag> arbeidsforholdEtterUforgrunnlagListe;

    /**
     * Informasjon om konverterting fra UP til UT.
     */
    private OvergangsinfoUPtilUT overgangsInfoUPtilUT;

    /**
     * Inneholder utbetalingsgraden for uføretrygd etter inntektsavkorting.
     */
    private List<UtbetalingsgradUT> utbetalingsgradUTListe;

    /**
     * Intern PREG attributt. Relasjon til personen's tilhørende vedtak.
     */
    private VilkarsVedtak PREG_vilkarsVedtak;

    /**
     * Intern PREG attributt. Sivilstand som gjelder på beregningstidspunkt.
     */
    private SivilstandTypeCti PREG_sivilstandType;

    /**
     * Intern PREG attributt. Grunnlagsrolle som gjelder på beregningstidspunkt.
     */
    private GrunnlagsrolleCti PREG_grunnlagsrolle;

    /**
     * Intern PREG attributt. BarnDetalj som gjelder på beregningstidspunkt.
     */
    private BarnDetalj PREG_barnDetalj;

    /**
     * Intern PREG attributt. Angir om brukeren skal behandles som gift. Satt på
     * grunnlag av tilknyttet persons borMed relasjon til søker.
     */
    private boolean PREG_behandlesSomGift;

    /**
     * Intern PREG attributt. Angir om poengrekkeberegningen skal bruke
     * opptjening kun til og med 67 år.
     */
    private boolean PREG_P67;

    private BorMedTypeCti PREG_borMed;

    private InstOpphReduksjonsperiode PREG_instOpphReduksjonsperiode;

    private InstOpphFasteUtgifterperiode PREG_instOpphFasteUtgifterperiode;

    /**
     * Denne PREG variabel brukes ikke slik den er navngitt!
     * Er omdøpt til "mottarPensjon" i regelmotor og brukes til
     * å angi om personen selv mottar pensjon.
     */
    private boolean PREG_ektefellenMottarPensjon;

    private PersonDetalj PREG_personDetalj;

    private double PREG_poengtillegg;

    private boolean PREG_boddEllerArbeidetIUtlandet;

    /**
     * Midlertidig felt. Brukes til å sette første virk på grunnlaget til MOR/FAR
     * ved barnepensjon. Angir første virk på vedtaket (som ikke er med).
     * Ref CR 81364 og 85157 - fiktiv uføreperiode med type VIRK_IKKE_UFOR.
     * Kun getter/setter for feltet, ikke med i constructor'ene.
     */
    private Date PREG_forsteVirk;

	/**
	* Objekt som inneholder informasjon om TP-ordningers uførepensjonsgrunnlag. Dette er manuelt registrerte data og ikke hentet fra TP-registeret eller andre eksterne kilder.
	*/
	
	private no.nav.pensjon.regler.domain.grunnlag.AfpTpoUpGrunnlag AfpTpoUpGrunnlag;

    /**
     * Liste over hovedytelser som kan påvirke ytelsen. Kun fastsatt for EPS.
     */
	private List<VilkarsVedtak> PREG_vilkarsvedtakEPSListe;
	
	
    public Persongrunnlag() {
        super();
        // initialiser alle lister
        personDetaljListe = new ArrayList<PersonDetalj>();
        instOpphReduksjonsperiodeListe = new ArrayList<InstOpphReduksjonsperiode>();
        instOpphFasteUtgifterperiodeListe = new ArrayList<InstOpphFasteUtgifterperiode>();
        inntektsgrunnlagListe = new ArrayList<Inntektsgrunnlag>();
        opptjeningsgrunnlagListe = new ArrayList<Opptjeningsgrunnlag>();
        trygdetidPerioder = new ArrayList<TTPeriode>();
        trygdetidPerioderKapittel20 = new ArrayList<TTPeriode>();
        afpHistorikkListe = new ArrayList<AfpHistorikk>();
        utenlandsoppholdListe = new ArrayList<Utenlandsopphold>();
        dagpengegrunnlagListe = new ArrayList<Dagpengegrunnlag>();
        omsorgsgrunnlagListe = new ArrayList<Omsorgsgrunnlag>();
        arbeidsforholdsgrunnlagListe = new ArrayList<Arbeidsforholdsgrunnlag>();
        arbeidsforholdEtterUforgrunnlagListe = new ArrayList<ArbeidsforholdEtterUforgrunnlag>();
        utbetalingsgradUTListe = new ArrayList<UtbetalingsgradUT>();
        forsteVirkningsdatoGrunnlagListe = new ArrayList<ForsteVirkningsdatoGrunnlag>();
        PREG_vilkarsvedtakEPSListe = new ArrayList<VilkarsVedtak>();
    }

    /**
     * Copy Constructor
     * 
     * @param persongrunnlag a <code>Persongrunnlag</code> object
     */
    public Persongrunnlag(Persongrunnlag persongrunnlag) {
        this();
        if (persongrunnlag.penPerson != null) {
            penPerson = new PenPerson(persongrunnlag.penPerson);
        }
        if (persongrunnlag.fodselsdato != null) {
            fodselsdato = (Date) persongrunnlag.fodselsdato.clone();
        }
        if (persongrunnlag.dodsdato != null) {
            dodsdato = (Date) persongrunnlag.dodsdato.clone();
        }
        if (persongrunnlag.statsborgerskap != null) {
            statsborgerskap = new LandCti(persongrunnlag.statsborgerskap);
        }
        if (persongrunnlag.flyktning != null) {
            flyktning = new Boolean(persongrunnlag.flyktning);
        }
        //this.personDetaljListe = new ArrayList<PersonDetalj>();
        if (persongrunnlag.personDetaljListe != null) {
            for (PersonDetalj personDetalj : persongrunnlag.personDetaljListe) {
                personDetaljListe.add(new PersonDetalj(personDetalj));
            }
        }
        if (persongrunnlag.sistMedlITrygden != null) {
            sistMedlITrygden = (Date) persongrunnlag.sistMedlITrygden.clone();
        }
        if (persongrunnlag.hentetPopp != null) {
            hentetPopp = new Boolean(persongrunnlag.hentetPopp);
        }
        if (persongrunnlag.hentetInnt != null) {
            hentetInnt = new Boolean(persongrunnlag.hentetInnt);
        }
        if (persongrunnlag.hentetInst != null) {
            hentetInst = new Boolean(persongrunnlag.hentetInst);
        }
        if (persongrunnlag.hentetTT != null) {
            hentetTT = new Boolean(persongrunnlag.hentetTT);
        }
        if (persongrunnlag.hentetArbeid != null) {
            hentetArbeid = new Boolean(persongrunnlag.hentetArbeid);
        }
        if (persongrunnlag.overkompUtl != null) {
            overkompUtl = new Boolean(persongrunnlag.overkompUtl);
        }
        // this.opptjeningsgrunnlagListe = new ArrayList<Opptjeningsgrunnlag>();
        if (persongrunnlag.opptjeningsgrunnlagListe != null) {
            for (Opptjeningsgrunnlag opptjeningsgrunnlag : persongrunnlag.opptjeningsgrunnlagListe) {
                opptjeningsgrunnlagListe.add(new Opptjeningsgrunnlag(opptjeningsgrunnlag));
            }
        }
        //  this.inntektsgrunnlagListe = new ArrayList<Inntektsgrunnlag>();
        if (persongrunnlag.inntektsgrunnlagListe != null) {
            for (Inntektsgrunnlag inntektsgrunnlag : persongrunnlag.inntektsgrunnlagListe) {
                inntektsgrunnlagListe.add(new Inntektsgrunnlag(inntektsgrunnlag));
            }
        }
        // this.trygdetidPerioder = new ArrayList<TTPeriode>();
        if (persongrunnlag.trygdetidPerioder != null) {
            for (TTPeriode ttPeriode : persongrunnlag.trygdetidPerioder) {
                trygdetidPerioder.add(new TTPeriode(ttPeriode));
            }
        }
        if (persongrunnlag.trygdetidPerioderKapittel20 != null) {
            for (TTPeriode ttPeriode : persongrunnlag.trygdetidPerioderKapittel20) {
                trygdetidPerioderKapittel20.add(new TTPeriode(ttPeriode));
            }
        }
        if (persongrunnlag.trygdetid != null) {
            trygdetid = new Trygdetid(persongrunnlag.trygdetid);
        }
        if (persongrunnlag.uforegrunnlag != null) {
            uforegrunnlag = new Uforegrunnlag(persongrunnlag.uforegrunnlag);
        }
        if (persongrunnlag.uforeHistorikk != null) {
            uforeHistorikk = new Uforehistorikk(persongrunnlag.uforeHistorikk);
        }
        if (persongrunnlag.yrkesskadegrunnlag != null) {
            yrkesskadegrunnlag = new Yrkesskadegrunnlag(persongrunnlag.yrkesskadegrunnlag);
        }
        if (persongrunnlag.dodAvYrkesskade != null) {
            dodAvYrkesskade = new Boolean(persongrunnlag.dodAvYrkesskade);
        }
        if (persongrunnlag.generellHistorikk != null) {
            generellHistorikk = new GenerellHistorikk(persongrunnlag.generellHistorikk);
        }
        //  this.afpHistorikkListe = new ArrayList<AfpHistorikk>();
        if (persongrunnlag.afpHistorikkListe != null) {
            for (AfpHistorikk afpHistorikk : persongrunnlag.afpHistorikkListe) {
                afpHistorikkListe.add(new AfpHistorikk(afpHistorikk));
            }
        }
        if (persongrunnlag.barnekull != null) {
            barnekull = new Barnekull(persongrunnlag.barnekull);
        }
        antallArUtland = persongrunnlag.antallArUtland;
        if (persongrunnlag.medlemIFolketrygdenSiste3Ar != null) {
            medlemIFolketrygdenSiste3Ar = new Boolean(persongrunnlag.medlemIFolketrygdenSiste3Ar);
        }
        if (persongrunnlag.over60ArKanIkkeForsorgesSelv != null) {
            over60ArKanIkkeForsorgesSelv = new Boolean(persongrunnlag.over60ArKanIkkeForsorgesSelv);
        }
        // this.utenlandsoppholdListe = new ArrayList<Utenlandsopphold>();
        if (persongrunnlag.utenlandsoppholdListe != null) {
            for (Utenlandsopphold utenlandsopphold : persongrunnlag.utenlandsoppholdListe) {
                utenlandsoppholdListe.add(new Utenlandsopphold(utenlandsopphold));
            }
        }
        if (persongrunnlag.trygdeavtale != null) {
            trygdeavtale = new Trygdeavtale(persongrunnlag.trygdeavtale);
        }
        if (persongrunnlag.trygdeavtaledetaljer != null) {
            trygdeavtaledetaljer = new Trygdeavtaledetaljer(persongrunnlag.trygdeavtaledetaljer);
        }
        if (persongrunnlag.inngangOgEksportGrunnlag != null) {
            inngangOgEksportGrunnlag = new InngangOgEksportGrunnlag(persongrunnlag.inngangOgEksportGrunnlag);
        }
        if (persongrunnlag.arligPGIMinst1G != null) {
            arligPGIMinst1G = new Boolean(persongrunnlag.arligPGIMinst1G);
        }
        if (persongrunnlag.artikkel10 != null) {
            artikkel10 = new Boolean(persongrunnlag.artikkel10);
        }
        if (persongrunnlag.vernepliktAr != null) {
            vernepliktAr = persongrunnlag.vernepliktAr.clone();
        }
        skiltesDelAvAvdodesTP = persongrunnlag.skiltesDelAvAvdodesTP;
        // this.instOpphReduksjonsperiodeListe = new ArrayList<InstOpphReduksjonsperiode>();
        if (persongrunnlag.instOpphReduksjonsperiodeListe != null) {
            for (InstOpphReduksjonsperiode instOpphReduksjonsperiode : persongrunnlag.instOpphReduksjonsperiodeListe) {
                instOpphReduksjonsperiodeListe.add(new InstOpphReduksjonsperiode(instOpphReduksjonsperiode));
            }
        }
        //  this.instOpphFasteUtgifterperiodeListe = new ArrayList<InstOpphFasteUtgifterperiode>();
        if (persongrunnlag.instOpphFasteUtgifterperiodeListe != null) {
            for (InstOpphFasteUtgifterperiode instOpphFasteUtgifterperiode : persongrunnlag.instOpphFasteUtgifterperiodeListe) {
                instOpphFasteUtgifterperiodeListe.add(new InstOpphFasteUtgifterperiode(instOpphFasteUtgifterperiode));
            }
        }
        if (persongrunnlag.bosattLand != null) {
            bosattLand = new LandCti(persongrunnlag.bosattLand);
        }

        //Horisonten
        if (persongrunnlag.trygdetidKapittel20 != null) {
            trygdetidKapittel20 = new Trygdetid(persongrunnlag.trygdetidKapittel20);
        }
        if (persongrunnlag.pensjonsbeholdning != null) {
            pensjonsbeholdning = new Pensjonsbeholdning(persongrunnlag.pensjonsbeholdning);
        }
        if (persongrunnlag.dagpengegrunnlagListe != null) {
            for (Dagpengegrunnlag dagpengegrunnlag : persongrunnlag.dagpengegrunnlagListe) {
                dagpengegrunnlagListe.add(new Dagpengegrunnlag(dagpengegrunnlag));
            }
        }
        if (persongrunnlag.forstegangstjenestegrunnlag != null) {
            forstegangstjenestegrunnlag = new Forstegangstjeneste(persongrunnlag.forstegangstjenestegrunnlag);
        }
        if (persongrunnlag.omsorgsgrunnlagListe != null) {
            for (Omsorgsgrunnlag omsorgsgrunnlag : persongrunnlag.omsorgsgrunnlagListe) {
                omsorgsgrunnlagListe.add(new Omsorgsgrunnlag(omsorgsgrunnlag));
            }
        }
        if (persongrunnlag.arbeidsforholdsgrunnlagListe != null) {
            for (Arbeidsforholdsgrunnlag afg : persongrunnlag.arbeidsforholdsgrunnlagListe) {
                arbeidsforholdsgrunnlagListe.add(new Arbeidsforholdsgrunnlag(afg));
            }
        }
        if (persongrunnlag.arbeidsforholdEtterUforgrunnlagListe != null) {
            for (ArbeidsforholdEtterUforgrunnlag arbeidsforholdEtterUforgrunnlag : persongrunnlag.arbeidsforholdEtterUforgrunnlagListe) {
                arbeidsforholdEtterUforgrunnlagListe.add(new ArbeidsforholdEtterUforgrunnlag(arbeidsforholdEtterUforgrunnlag));
            }
        }
        if (persongrunnlag.overgangsInfoUPtilUT != null) {
            overgangsInfoUPtilUT = new OvergangsinfoUPtilUT(persongrunnlag.overgangsInfoUPtilUT);
        }
        if (persongrunnlag.utbetalingsgradUTListe != null) {
            for (UtbetalingsgradUT utbetalingsgradUT : persongrunnlag.utbetalingsgradUTListe) {
                utbetalingsgradUTListe.add(new UtbetalingsgradUT(utbetalingsgradUT));
            }
        }
        if (persongrunnlag.trygdetidAlternativ != null) {
            trygdetidAlternativ = new Trygdetid(persongrunnlag.trygdetidAlternativ);
        }
        if (persongrunnlag.forsteVirkningsdatoGrunnlagListe != null) {
            for (ForsteVirkningsdatoGrunnlag forsteVirkningsdatoGrunnlag : persongrunnlag.forsteVirkningsdatoGrunnlagListe) {
                forsteVirkningsdatoGrunnlagListe.add(new ForsteVirkningsdatoGrunnlag(forsteVirkningsdatoGrunnlag));
            }
        }
        //PREG_
        if (persongrunnlag.PREG_vilkarsVedtak != null) {
            PREG_vilkarsVedtak = new VilkarsVedtak(persongrunnlag.PREG_vilkarsVedtak);
        }
        if (persongrunnlag.PREG_sivilstandType != null) {
            PREG_sivilstandType = new SivilstandTypeCti(persongrunnlag.PREG_sivilstandType);
        }
        if (persongrunnlag.PREG_grunnlagsrolle != null) {
            PREG_grunnlagsrolle = new GrunnlagsrolleCti(persongrunnlag.PREG_grunnlagsrolle);
        }
        if (persongrunnlag.PREG_barnDetalj != null) {
            PREG_barnDetalj = new BarnDetalj(persongrunnlag.PREG_barnDetalj);
        }
        PREG_behandlesSomGift = persongrunnlag.PREG_behandlesSomGift;
        PREG_P67 = persongrunnlag.PREG_P67;
        if (persongrunnlag.PREG_borMed != null) {
            PREG_borMed = new BorMedTypeCti(persongrunnlag.PREG_borMed);
        }
        if (persongrunnlag.PREG_instOpphReduksjonsperiode != null) {
            PREG_instOpphReduksjonsperiode = new InstOpphReduksjonsperiode(persongrunnlag.PREG_instOpphReduksjonsperiode);
        }
        if (persongrunnlag.PREG_instOpphFasteUtgifterperiode != null) {
            PREG_instOpphFasteUtgifterperiode = new InstOpphFasteUtgifterperiode(persongrunnlag.PREG_instOpphFasteUtgifterperiode);
        }
        PREG_ektefellenMottarPensjon = persongrunnlag.PREG_ektefellenMottarPensjon;
        if (persongrunnlag.PREG_personDetalj != null) {
            PREG_personDetalj = new PersonDetalj(persongrunnlag.PREG_personDetalj);
        }
        PREG_poengtillegg = persongrunnlag.PREG_poengtillegg;
        PREG_boddEllerArbeidetIUtlandet = persongrunnlag.PREG_boddEllerArbeidetIUtlandet;
        sisteGyldigeOpptjeningsAr = persongrunnlag.sisteGyldigeOpptjeningsAr;
        barnetilleggVurderingsperiode = persongrunnlag.barnetilleggVurderingsperiode;
		
		if (persongrunnlag.AfpTpoUpGrunnlag != null) {
		
			AfpTpoUpGrunnlag = new AfpTpoUpGrunnlag(persongrunnlag.AfpTpoUpGrunnlag);
		}
        if (persongrunnlag.PREG_vilkarsvedtakEPSListe != null) {
            for (VilkarsVedtak vilkarsVedtak : persongrunnlag.PREG_vilkarsvedtakEPSListe) {
                PREG_vilkarsvedtakEPSListe.add(new VilkarsVedtak(vilkarsVedtak));
            }
        }
    }
    /**
     * Returnerer utbetalingsgradUT om det finnes et innslag for et gitt år i utbetalingsgradUTListe, null hvis innslag ikke finnes
     * 
     * @param aar
     * @return UtbetalingsgradUT
     */
    public UtbetalingsgradUT finnUtbetalingsgradUTForAar(int aar) {
        if (utbetalingsgradUTListe != null) {
            for (UtbetalingsgradUT ug : utbetalingsgradUTListe) {
                if (ug.getAr() == aar) {
                    return ug;
                }
            }
        }
        return null;
    }

    /**
     * Returnerer førsteKravFremsattDato utledet fra forsteVirkningsdatoGrunnlagListe. Hvis listen har innhold er førsteKravFremsattDato den tidligste dato blant disse.
     * @return Date
     */
    public Date finnForsteKravFremsattDato() {
        if (forsteVirkningsdatoGrunnlagListe != null && forsteVirkningsdatoGrunnlagListe.size() >= 1) {
            forsteVirkningsdatoGrunnlagListe.sort(ForsteVirkningsdatoGrunnlag::compareTo);
            return forsteVirkningsdatoGrunnlagListe.get(0).getKravFremsattDato();
        }
        return null;
    }

    public List<AfpHistorikk> getAfpHistorikkListe() {
        return afpHistorikkListe;
    }

    /**
     * Read only property for afpHistorikkListe as array
     * 
     * @return array of AfpHistorikk
     */
    public AfpHistorikk[] getAfpHistorikkListeAsArray() {
        return afpHistorikkListe != null ? afpHistorikkListe.toArray(new AfpHistorikk[afpHistorikkListe.size()]) : new AfpHistorikk[0];
    }

    public int getAntallArUtland() {
        return antallArUtland;
    }

    /**
     * @return the arbeidsforholdEtterUforgrunnlagListe
     */
    public List<ArbeidsforholdEtterUforgrunnlag> getArbeidsforholdEtterUforgrunnlagListe() {
        return arbeidsforholdEtterUforgrunnlagListe;
    }

    /**
     * @return array of ArbeidsforholdEtterUforgrunnlag
     */
    public ArbeidsforholdEtterUforgrunnlag[] getArbeidsforholdEtterUforgrunnlagListeAsArray() {
        return arbeidsforholdEtterUforgrunnlagListe != null ?
                arbeidsforholdEtterUforgrunnlagListe.toArray(new ArbeidsforholdEtterUforgrunnlag[arbeidsforholdEtterUforgrunnlagListe.size()]) :
                new ArbeidsforholdEtterUforgrunnlag[0];
    }

    /**
     * @return the arbeidsforholdsgrunnlagListe
     */
    public List<Arbeidsforholdsgrunnlag> getArbeidsforholdsgrunnlagListe() {
        return arbeidsforholdsgrunnlagListe;
    }

    public Arbeidsforholdsgrunnlag[] getArbeidsforholdsgrunnlagListeAsArray() {
        return arbeidsforholdsgrunnlagListe != null ? arbeidsforholdsgrunnlagListe.toArray(new Arbeidsforholdsgrunnlag[arbeidsforholdsgrunnlagListe.size()])
                : new Arbeidsforholdsgrunnlag[0];
    }

    public Boolean getArligPGIMinst1G() {
        return arligPGIMinst1G;
    }

    public Boolean getArtikkel10() {
        return artikkel10;
    }

    public Barnekull getBarnekull() {
        return barnekull;
    }

    public BarnetilleggVurderingsperiode getBarnetilleggVurderingsperiode() {
        return barnetilleggVurderingsperiode;
    }

    public LandCti getBosattLand() {
        return bosattLand;
    }

    public List<Dagpengegrunnlag> getDagpengegrunnlagListe() {
        return dagpengegrunnlagListe;
    }

    /**
     * Read only property for dagpengegrunnlagListe as array.
     * 
     * @return array of Dagpengegrunnlag
     */
    public Dagpengegrunnlag[] getDagpengegrunnlagListeAsArray() {
        return dagpengegrunnlagListe != null ? dagpengegrunnlagListe.toArray(new Dagpengegrunnlag[dagpengegrunnlagListe.size()]) : new Dagpengegrunnlag[0];
    }

    public Boolean getDodAvYrkesskade() {
        return dodAvYrkesskade;
    }

    public Date getDodsdato() {
        return dodsdato;
    }

    public Boolean getFlyktning() {
        return flyktning;
    }

    public Date getFodselsdato() {
        return fodselsdato;
    }

    public Forstegangstjeneste getForstegangstjenestegrunnlag() {
        return forstegangstjenestegrunnlag;
    }

    public GenerellHistorikk getGenerellHistorikk() {
        return generellHistorikk;
    }

    public Boolean getHentetArbeid() {
        return hentetArbeid;
    }

    public Boolean getHentetInnt() {
        return hentetInnt;
    }

    public Boolean getHentetInst() {
        return hentetInst;
    }

    public Boolean getHentetPopp() {
        return hentetPopp;
    }

    public Boolean getHentetTT() {
        return hentetTT;
    }

    public InngangOgEksportGrunnlag getInngangOgEksportGrunnlag() {
        return inngangOgEksportGrunnlag;
    }

    public List<Inntektsgrunnlag> getInntektsgrunnlagListe() {
        return inntektsgrunnlagListe;
    }

    /**
     * Read only property for inntektsgrunnlagListe as array.
     * 
     * @return array of Inntektsgrunnlag
     */
    public Inntektsgrunnlag[] getInntektsgrunnlagListeAsArray() {
        return inntektsgrunnlagListe != null ? inntektsgrunnlagListe.toArray(new Inntektsgrunnlag[inntektsgrunnlagListe.size()]) : new Inntektsgrunnlag[0];
    }

    public List<InstOpphFasteUtgifterperiode> getInstOpphFasteUtgifterperiodeListe() {
        return instOpphFasteUtgifterperiodeListe;
    }

    /**
     * Read only property for instOpphFasteUtgifterperiodeListe as array
     * 
     * @return array of InstOpphFasteUtgifterperiode
     */
    public InstOpphFasteUtgifterperiode[] getInstOpphFasteUtgifterperiodeListeAsArray() {
        return instOpphFasteUtgifterperiodeListe != null ? instOpphFasteUtgifterperiodeListe.toArray(new InstOpphFasteUtgifterperiode[instOpphFasteUtgifterperiodeListe.size()])
                : new InstOpphFasteUtgifterperiode[0];
    }

    public List<InstOpphReduksjonsperiode> getInstOpphReduksjonsperiodeListe() {
        return instOpphReduksjonsperiodeListe;
    }

    /**
     * Read only property for instOpphReduksjonsperiodeListe as array.
     * 
     * @return array of InstOpphReduksjonsperiode
     */
    public InstOpphReduksjonsperiode[] getInstOpphReduksjonsperiodeListeAsArray() {
        return instOpphReduksjonsperiodeListe != null ? instOpphReduksjonsperiodeListe.toArray(new InstOpphReduksjonsperiode[instOpphReduksjonsperiodeListe.size()])
                : new InstOpphReduksjonsperiode[0];
    }

    public Boolean getMedlemIFolketrygdenSiste3Ar() {
        return medlemIFolketrygdenSiste3Ar;
    }

    public List<Omsorgsgrunnlag> getOmsorgsgrunnlagListe() {
        return omsorgsgrunnlagListe;
    }

    /**
     * Read only property for omsorgsgrunnlagListe as array.
     * 
     * @return array of Omsorgsgrunnlag
     */
    public Omsorgsgrunnlag[] getOmsorgsgrunnlagListeAsArray() {
        return omsorgsgrunnlagListe != null ? omsorgsgrunnlagListe.toArray(new Omsorgsgrunnlag[omsorgsgrunnlagListe.size()]) : new Omsorgsgrunnlag[0];
    }

    public List<Opptjeningsgrunnlag> getOpptjeningsgrunnlagListe() {
        return opptjeningsgrunnlagListe;
    }

    /**
     * Read only property for opptjeningsgrunnlagListe as array.
     * 
     * @return array of Opptjeningsgrunnlag
     */
    public Opptjeningsgrunnlag[] getOpptjeningsgrunnlagListeAsArray() {
        return opptjeningsgrunnlagListe != null ? opptjeningsgrunnlagListe.toArray(new Opptjeningsgrunnlag[opptjeningsgrunnlagListe.size()]) : new Opptjeningsgrunnlag[0];
    }

    public Boolean getOver60ArKanIkkeForsorgesSelv() {
        return over60ArKanIkkeForsorgesSelv;
    }

    /**
     * @return the overgangsinfoUPtilUT
     */
    public OvergangsinfoUPtilUT getOvergangsinfoUPtilUT() {
        return overgangsInfoUPtilUT;
    }

    public Boolean getOverkompUtl() {
        return overkompUtl;
    }

    public PenPerson getPenPerson() {
        return penPerson;
    }

    public Pensjonsbeholdning getPensjonsbeholdning() {
        return pensjonsbeholdning;
    }

    public List<PersonDetalj> getPersonDetaljListe() {
        return personDetaljListe;
    }

    /**
     * Read only property for personDetaljListe as array.
     * 
     * @return array of PersonDetalj
     */
    public PersonDetalj[] getPersonDetaljListeAsArray() {
        return personDetaljListe != null ? personDetaljListe.toArray(new PersonDetalj[personDetaljListe.size()]) : new PersonDetalj[0];
    }

    public BarnDetalj getPREG_barnDetalj() {
        return PREG_barnDetalj;
    }

    public BorMedTypeCti getPREG_borMed() {
        return PREG_borMed;
    }

    public Date getPREG_forsteVirk() {
        return PREG_forsteVirk;
    }

    public GrunnlagsrolleCti getPREG_grunnlagsrolle() {
        return PREG_grunnlagsrolle;
    }

    public InstOpphFasteUtgifterperiode getPREG_instOpphFasteUtgifterperiode() {
        return PREG_instOpphFasteUtgifterperiode;
    }

    public InstOpphReduksjonsperiode getPREG_instOpphReduksjonsperiode() {
        return PREG_instOpphReduksjonsperiode;
    }

    public PersonDetalj getPREG_personDetalj() {
        return PREG_personDetalj;
    }

    public double getPREG_poengtillegg() {
        return PREG_poengtillegg;
    }

    public SivilstandTypeCti getPREG_sivilstandType() {
        return PREG_sivilstandType;
    }

    public VilkarsVedtak getPREG_vilkarsVedtak() {
        return PREG_vilkarsVedtak;
    }

    public int getSisteGyldigeOpptjeningsAr() {
        return sisteGyldigeOpptjeningsAr;
    }

    public Date getSistMedlITrygden() {
        return sistMedlITrygden;
    }

    public int getSkiltesDelAvAvdodesTP() {
        return skiltesDelAvAvdodesTP;
    }

    /**
     * Read only property for arbeidsforholdEtterUforgrunnlagListe as sorted array.
     * 
     * @return array of ArbeidsforholdEtterUforgrunnlag
     */
    public ArbeidsforholdEtterUforgrunnlag[] getSortedArbeidsforholdEtterUforgrunnlagListeAsArray() {
        if (arbeidsforholdEtterUforgrunnlagListe != null) {
            ArrayList<ArbeidsforholdEtterUforgrunnlag> sortedList = new ArrayList<ArbeidsforholdEtterUforgrunnlag>(arbeidsforholdEtterUforgrunnlagListe);
            Collections.sort(sortedList);
            return sortedList.toArray(new ArbeidsforholdEtterUforgrunnlag[arbeidsforholdEtterUforgrunnlagListe.size()]);
        } else {
            return new ArbeidsforholdEtterUforgrunnlag[0];
        }
    }

    /**
     * Read only property for arbeidsforholdsgrunnlagListe as sorted array.
     * 
     * @return array of Arbeidsforholdsgrunnlag
     */
    public Arbeidsforholdsgrunnlag[] getSortedArbeidsforholdsgrunnlagListeAsArray() {
        if (arbeidsforholdsgrunnlagListe != null) {
            ArrayList<Arbeidsforholdsgrunnlag> sortedList = new ArrayList<Arbeidsforholdsgrunnlag>(arbeidsforholdsgrunnlagListe);
            Collections.sort(sortedList);
            return sortedList.toArray(new Arbeidsforholdsgrunnlag[arbeidsforholdsgrunnlagListe.size()]);
        } else {
            return new Arbeidsforholdsgrunnlag[0];
        }
    }

    /**
     * Read only property for opptjeningsgrunnlagListe as sorted array
     * Sorterer i reversert rekkefølge
     * 
     * @return array of Opptjeningsgrunnlag, sorted by year.
     */
    public Opptjeningsgrunnlag[] getSortedOpptjeningsgrunnlagListeAsArray() {
        return getSortedOpptjeningsgrunnlagListeAsArray(true);
    }

    /**
     * Read only property for opptjeningsgrunnlagListe as sorted array
     * 
     * @return array of Opptjeningsgrunnlag, sorted by year.
     */
    public Opptjeningsgrunnlag[] getSortedOpptjeningsgrunnlagListeAsArray(boolean reverse) {
        if (opptjeningsgrunnlagListe != null) {
            ArrayList<Opptjeningsgrunnlag> sortedOg = new ArrayList<Opptjeningsgrunnlag>(opptjeningsgrunnlagListe);
            if (reverse) {
                Collections.sort(sortedOg, Collections.reverseOrder());
            } else {
                Collections.sort(sortedOg);
            }
            return sortedOg.toArray(new Opptjeningsgrunnlag[sortedOg.size()]);
        } else {
            return new Opptjeningsgrunnlag[0];
        }
    }

    /**
     * Read only property for trygdetidPerioder as sorted array.
     * 
     * @return sorted array of TTPeriode
     */
    public TTPeriode[] getSortedTrygdetidPerioderAsArray() {
        if (trygdetidPerioder != null) {
            ArrayList<TTPeriode> sortedList = new ArrayList<TTPeriode>(trygdetidPerioder);
            Collections.sort(sortedList);
            return sortedList.toArray(new TTPeriode[trygdetidPerioder.size()]);
        } else {
            return new TTPeriode[0];
        }
    }

    /**
     * Read only property for trygdetidPerioderKapittel20 as sorted array.
     * 
     * @return array of TTPeriode
     */
    public TTPeriode[] getSortedTrygdetidPerioderKapittel20AsArray() {
        if (trygdetidPerioderKapittel20 != null) {
            ArrayList<TTPeriode> sortedList = new ArrayList<TTPeriode>(trygdetidPerioderKapittel20);
            Collections.sort(sortedList);
            return sortedList.toArray(new TTPeriode[trygdetidPerioderKapittel20.size()]);
        } else {
            return new TTPeriode[0];
        }
    }

    public LandCti getStatsborgerskap() {
        return statsborgerskap;
    }

    public Trygdeavtale getTrygdeavtale() {
        return trygdeavtale;
    }

    public Trygdeavtaledetaljer getTrygdeavtaledetaljer() {
        return trygdeavtaledetaljer;
    }

    public Trygdetid getTrygdetid() {
        return trygdetid;
    }

    public Trygdetid getTrygdetidAlternativ() {
        return trygdetidAlternativ;
    }

    public Trygdetid getTrygdetidKapittel20() {
        return trygdetidKapittel20;
    }

    public List<TTPeriode> getTrygdetidPerioder() {
        return trygdetidPerioder;
    }

    /**
     * Read only property for trygdetidPerioder as array.
     * 
     * @return array of TTPeriode
     */
    public TTPeriode[] getTrygdetidPerioderAsArray() {
        return trygdetidPerioder != null ? trygdetidPerioder.toArray(new TTPeriode[trygdetidPerioder.size()]) : new TTPeriode[0];
    }

    public List<TTPeriode> getTrygdetidPerioderKapittel20() {
        return trygdetidPerioderKapittel20;
    }

    /**
     * Read only property for trygdetidPerioderKapittel20 as array.
     * 
     * @return array of TTPeriode
     */
    public TTPeriode[] getTrygdetidPerioderKapittel20AsArray() {
        return trygdetidPerioderKapittel20 != null ? trygdetidPerioderKapittel20.toArray(new TTPeriode[trygdetidPerioderKapittel20.size()]) : new TTPeriode[0];
    }

    public Uforegrunnlag getUforegrunnlag() {
        return uforegrunnlag;
    }

    public Uforehistorikk getUforeHistorikk() {
        return uforeHistorikk;
    }

    public List<UtbetalingsgradUT> getUtbetalingsgradUTListe() {
        return utbetalingsgradUTListe;
    }

    public UtbetalingsgradUT[] getUtbetalingsgradUTListeAsArray() {
        return utbetalingsgradUTListe != null ? utbetalingsgradUTListe.toArray(new UtbetalingsgradUT[utbetalingsgradUTListe.size()]) : new UtbetalingsgradUT[0];
    }

    public List<Utenlandsopphold> getUtenlandsoppholdListe() {
        return utenlandsoppholdListe;
    }

    /**
     * Read only property for utenlandsoppholdListe as array.
     * 
     * @return array of Utenlandsopphold
     */
    public Utenlandsopphold[] getUtenlandsoppholdListeAsArray() {
        return utenlandsoppholdListe != null ? utenlandsoppholdListe.toArray(new Utenlandsopphold[0]) : new Utenlandsopphold[0];
    }

    public int[] getVernepliktAr() {
        return vernepliktAr;
    }

    public Yrkesskadegrunnlag getYrkesskadegrunnlag() {
        return yrkesskadegrunnlag;
    }

    public boolean isPREG_behandlesSomGift() {
        return PREG_behandlesSomGift;
    }

    public boolean isPREG_boddEllerArbeidetIUtlandet() {
        return PREG_boddEllerArbeidetIUtlandet;
    }

    public boolean isPREG_ektefellenMottarPensjon() {
        return PREG_ektefellenMottarPensjon;
    }

    public boolean isPREG_P67() {
        return PREG_P67;
    }

    /**
     * @deprecated
     * @return Returns the afpHistorikkListe as array.
     */
    @Deprecated
    public AfpHistorikk[] retrieveAfpHistorikkListeAsArray() {
        return afpHistorikkListe.toArray(new AfpHistorikk[0]);
    }

    /**
     * @deprecated
     * @return Returns the inntektsgrunnlagListe as array.
     */
    @Deprecated
    public Inntektsgrunnlag[] retrieveInntektsgrunnlagListeAsArray() {
        return inntektsgrunnlagListe.toArray(new Inntektsgrunnlag[0]);
    }

    /**
     * @deprecated
     * @return Returns the afpHistorikkListe as array.
     */
    @Deprecated
    public InstOpphFasteUtgifterperiode[] retrieveInstOpphFasteUtgifterperiodeListeAsArray() {
        return instOpphFasteUtgifterperiodeListe.toArray(new InstOpphFasteUtgifterperiode[0]);
    }

    /**
     * @deprecated
     * @return Returns the afpHistorikkListe as array.
     */
    @Deprecated
    public InstOpphReduksjonsperiode[] retrieveInstOpphReduksjonsperiodeListeAsArray() {
        return instOpphReduksjonsperiodeListe.toArray(new InstOpphReduksjonsperiode[0]);
    }

    /**
     * @deprecated
     * @return Returns the opptjeningsgrunnlagListe as array.
     */
    @Deprecated
    public Opptjeningsgrunnlag[] retrieveOpptjeningsgrunnlagListeAsArray() {
        return opptjeningsgrunnlagListe.toArray(new Opptjeningsgrunnlag[0]);
    }

    /**
     * @deprecated
     * @return Returns the personDetaljListe as array.
     */
    @Deprecated
    public PersonDetalj[] retrievePersonDetaljListeAsArray() {
        return personDetaljListe.toArray(new PersonDetalj[0]);
    }

    /**
     * @deprecated
     * @return Returns the opptjeningsgrunnlagListe as array, sorted by year.
     */
    @Deprecated
    public Opptjeningsgrunnlag[] retrieveSortedOpptjeningsgrunnlagListeAsArray() {
        ArrayList<Opptjeningsgrunnlag> sortedOg = new ArrayList<Opptjeningsgrunnlag>(opptjeningsgrunnlagListe);
        Collections.sort(sortedOg, Collections.reverseOrder());
        return sortedOg.toArray(new Opptjeningsgrunnlag[0]);
    }

    /**
     * @deprecated
     * @return Returns the trygdetidPerioder as array.
     */
    @Deprecated
    public TTPeriode[] retrieveTrygdetidPerioderAsArray() {
        return trygdetidPerioder.toArray(new TTPeriode[0]);
    }

    /**
     * @deprecated
     * @return Returns the utenlandsoppholdListe as array.
     */
    @Deprecated
    public Utenlandsopphold[] retrieveUtenlandsoppholdListeAsArray() {
        return utenlandsoppholdListe.toArray(new Utenlandsopphold[0]);
    }

    public void setAfpHistorikkListe(List<AfpHistorikk> afpHistorikkListe) {
        this.afpHistorikkListe = afpHistorikkListe;
    }

    public void setAntallArUtland(int antallArUtland) {
        this.antallArUtland = antallArUtland;
    }

    /**
     * @param arbeidsforholdEtterUforgrunnlagListe the arbeidsforholdEtterUforgrunnlagListe to set
     */
    public void setArbeidsforholdEtterUforgrunnlagListe(List<ArbeidsforholdEtterUforgrunnlag> arbeidsforholdEtterUforgrunnlagListe) {
        this.arbeidsforholdEtterUforgrunnlagListe = arbeidsforholdEtterUforgrunnlagListe;
    }

    /**
     * @param arbeidsforholdsgrunnlagListe the arbeidsforholdsgrunnlagListe to set
     */
    public void setArbeidsforholdsgrunnlagListe(List<Arbeidsforholdsgrunnlag> arbeidsforholdsgrunnlagListe) {
        this.arbeidsforholdsgrunnlagListe = arbeidsforholdsgrunnlagListe;
    }

    public void setArligPGIMinst1G(Boolean arligPGIMinst1G) {
        this.arligPGIMinst1G = arligPGIMinst1G;
    }

    public void setArtikkel10(Boolean artikkel10) {
        this.artikkel10 = artikkel10;
    }

    public void setBarnekull(Barnekull barnekull) {
        this.barnekull = barnekull;
    }

    public void setBarnetilleggVurderingsperiode(BarnetilleggVurderingsperiode barnetilleggVurderingsperiode) {
        this.barnetilleggVurderingsperiode = barnetilleggVurderingsperiode;
    }

    public void setBosattLand(LandCti bosattLand) {
        this.bosattLand = bosattLand;
    }

    public void setDagpengegrunnlagListe(List<Dagpengegrunnlag> dagpengegrunnlagListe) {
        this.dagpengegrunnlagListe = dagpengegrunnlagListe;
    }

    public void setDodAvYrkesskade(Boolean dodAvYrkesskade) {
        this.dodAvYrkesskade = dodAvYrkesskade;
    }

    public void setDodsdato(Date dodsdato) {
        this.dodsdato = dodsdato;
    }

    public void setFlyktning(Boolean flyktning) {
        this.flyktning = flyktning;
    }

    public void setFodselsdato(Date fodselsdato) {
        this.fodselsdato = fodselsdato;
    }

    public void setForstegangstjenestegrunnlag(Forstegangstjeneste forstegangstjenestegrunnlag) {
        this.forstegangstjenestegrunnlag = forstegangstjenestegrunnlag;
    }

    public void setGenerellHistorikk(GenerellHistorikk generellHistorikk) {
        this.generellHistorikk = generellHistorikk;
    }

    public void setHentetArbeid(Boolean hentetArbeid) {
        this.hentetArbeid = hentetArbeid;
    }

    public void setHentetInnt(Boolean hentetInnt) {
        this.hentetInnt = hentetInnt;
    }

    public void setHentetInst(Boolean hentetInst) {
        this.hentetInst = hentetInst;
    }

    public void setHentetPopp(Boolean hentetPopp) {
        this.hentetPopp = hentetPopp;
    }

    public void setHentetTT(Boolean hentetTT) {
        this.hentetTT = hentetTT;
    }

    public void setInngangOgEksportGrunnlag(InngangOgEksportGrunnlag inngangOgEksportGrunnlag) {
        this.inngangOgEksportGrunnlag = inngangOgEksportGrunnlag;
    }

    public void setInntektsgrunnlagListe(List<Inntektsgrunnlag> inntektsgrunnlagListe) {
        this.inntektsgrunnlagListe = inntektsgrunnlagListe;
    }

    public void setInstOpphFasteUtgifterperiodeListe(List<InstOpphFasteUtgifterperiode> instOpphFasteUtgifterperiodeListe) {
        this.instOpphFasteUtgifterperiodeListe = instOpphFasteUtgifterperiodeListe;
    }

    public void setInstOpphReduksjonsperiodeListe(List<InstOpphReduksjonsperiode> instOpphReduksjonsperiodeListe) {
        this.instOpphReduksjonsperiodeListe = instOpphReduksjonsperiodeListe;
    }

    public void setMedlemIFolketrygdenSiste3Ar(Boolean medlemIFolketrygdenSiste3Ar) {
        this.medlemIFolketrygdenSiste3Ar = medlemIFolketrygdenSiste3Ar;
    }

    public void setOmsorgsgrunnlagListe(List<Omsorgsgrunnlag> omsorgsgrunnlagListe) {
        this.omsorgsgrunnlagListe = omsorgsgrunnlagListe;
    }

    public void setOpptjeningsgrunnlagListe(List<Opptjeningsgrunnlag> opptjeningsgrunnlagListe) {
        this.opptjeningsgrunnlagListe = opptjeningsgrunnlagListe;
    }

    public void setOver60ArKanIkkeForsorgesSelv(Boolean over60ArKanIkkeForsorgesSelv) {
        this.over60ArKanIkkeForsorgesSelv = over60ArKanIkkeForsorgesSelv;
    }

    /**
     * @param overgangsinfoUPtilUT the overgangsinfoUPtilUT to set
     */
    public void setOvergangsinfoUPtilUT(OvergangsinfoUPtilUT overgangsinfoUPtilUT) {
        overgangsInfoUPtilUT = overgangsinfoUPtilUT;
    }

    public void setOverkompUtl(Boolean overkompUtl) {
        this.overkompUtl = overkompUtl;
    }

    public void setPenPerson(PenPerson penPerson) {
        this.penPerson = penPerson;
    }

    public void setPensjonsbeholdning(Pensjonsbeholdning pensjonsbeholdning) {
        this.pensjonsbeholdning = pensjonsbeholdning;
    }

    public void setPersonDetaljListe(List<PersonDetalj> personDetaljListe) {
        this.personDetaljListe = personDetaljListe;
    }

    public void setPREG_barnDetalj(BarnDetalj detalj) {
        PREG_barnDetalj = detalj;
    }

    public void setPREG_behandlesSomGift(boolean somGift) {
        PREG_behandlesSomGift = somGift;
    }

    public void setPREG_boddEllerArbeidetIUtlandet(boolean ellerArbeidetIUtlandet) {
        PREG_boddEllerArbeidetIUtlandet = ellerArbeidetIUtlandet;
    }

    public void setPREG_borMed(BorMedTypeCti med) {
        PREG_borMed = med;
    }

    public void setPREG_ektefellenMottarPensjon(boolean mottarPensjon) {
        PREG_ektefellenMottarPensjon = mottarPensjon;
    }

    public void setPREG_forsteVirk(Date virk) {
        PREG_forsteVirk = virk;
    }

    public void setPREG_grunnlagsrolle(GrunnlagsrolleCti preg_grunnlagsrolle) {
        PREG_grunnlagsrolle = preg_grunnlagsrolle;
    }

    public void setPREG_instOpphFasteUtgifterperiode(InstOpphFasteUtgifterperiode opphFasteUtgifterperiode) {
        PREG_instOpphFasteUtgifterperiode = opphFasteUtgifterperiode;
    }

    public void setPREG_instOpphReduksjonsperiode(InstOpphReduksjonsperiode opphReduksjonsperiode) {
        PREG_instOpphReduksjonsperiode = opphReduksjonsperiode;
    }

    public void setPREG_P67(boolean preg_p67) {
        PREG_P67 = preg_p67;
    }

    public void setPREG_personDetalj(PersonDetalj detalj) {
        PREG_personDetalj = detalj;
    }

    public void setPREG_poengtillegg(double preg_poengtillegg) {
        PREG_poengtillegg = preg_poengtillegg;
    }

    public void setPREG_sivilstandType(SivilstandTypeCti type) {
        PREG_sivilstandType = type;
    }

    public void setPREG_vilkarsVedtak(VilkarsVedtak vedtak) {
        PREG_vilkarsVedtak = vedtak;
    }

    public void setSisteGyldigeOpptjeningsAr(int sisteGyldigeOpptjeningsAr) {
        this.sisteGyldigeOpptjeningsAr = sisteGyldigeOpptjeningsAr;
    }

    public void setSistMedlITrygden(Date sistMedlITrygden) {
        this.sistMedlITrygden = sistMedlITrygden;
    }

    public void setSkiltesDelAvAvdodesTP(int skiltesDelAvAvdodesTP) {
        this.skiltesDelAvAvdodesTP = skiltesDelAvAvdodesTP;
    }

    public void setStatsborgerskap(LandCti statsborgerskap) {
        this.statsborgerskap = statsborgerskap;
    }

    public void setTrygdeavtale(Trygdeavtale trygdeavtale) {
        this.trygdeavtale = trygdeavtale;
    }

    public void setTrygdeavtaledetaljer(Trygdeavtaledetaljer trygdeavtaledetaljer) {
        this.trygdeavtaledetaljer = trygdeavtaledetaljer;
    }

    public void setTrygdetid(Trygdetid trygdetid) {
        this.trygdetid = trygdetid;
    }

    public void setTrygdetidAlternativ(Trygdetid trygdetidAlternativ) {
        this.trygdetidAlternativ = trygdetidAlternativ;
    }

    public void setTrygdetidKapittel20(Trygdetid trygdetidKapittel20) {
        this.trygdetidKapittel20 = trygdetidKapittel20;
    }

    public void setTrygdetidPerioder(List<TTPeriode> trygdetidPerioder) {
        this.trygdetidPerioder = trygdetidPerioder;
    }

    public void setTrygdetidPerioderKapittel20(List<TTPeriode> trygdetidPerioderKapittel20) {
        this.trygdetidPerioderKapittel20 = trygdetidPerioderKapittel20;
    }

    public void setUforegrunnlag(Uforegrunnlag uforegrunnlag) {
        this.uforegrunnlag = uforegrunnlag;
    }

    public void setUforeHistorikk(Uforehistorikk uforeHistorikk) {
        this.uforeHistorikk = uforeHistorikk;
    }

    public void setUtbetalingsgradUTListe(List<UtbetalingsgradUT> utbetalingsgradUTListe) {
        this.utbetalingsgradUTListe = utbetalingsgradUTListe;
    }

    public void setUtenlandsoppholdListe(List<Utenlandsopphold> utenlandsoppholdListe) {
        this.utenlandsoppholdListe = utenlandsoppholdListe;
    }

    public void setVernepliktAr(int[] vernepliktAr) {
        this.vernepliktAr = vernepliktAr;
    }

    public void setYrkesskadegrunnlag(Yrkesskadegrunnlag yrkesskadegrunnlag) {
        this.yrkesskadegrunnlag = yrkesskadegrunnlag;
    }

	public no.nav.pensjon.regler.domain.grunnlag.AfpTpoUpGrunnlag getAfpTpoUpGrunnlag() {
	
		return AfpTpoUpGrunnlag;
	}
	
	public void setAfpTpoUpGrunnlag(no.nav.pensjon.regler.domain.grunnlag.AfpTpoUpGrunnlag AfpTpoUpGrunnlag) {
	
		this.AfpTpoUpGrunnlag = AfpTpoUpGrunnlag;
	}

    public List<ForsteVirkningsdatoGrunnlag> getForsteVirkningsdatoGrunnlagListe() {
        return forsteVirkningsdatoGrunnlagListe;
    }

    public ForsteVirkningsdatoGrunnlag[] getForsteVirkningsdatoGrunnlagListeAsArray() {
        return forsteVirkningsdatoGrunnlagListe != null ? forsteVirkningsdatoGrunnlagListe.toArray(new ForsteVirkningsdatoGrunnlag[forsteVirkningsdatoGrunnlagListe.size()]) : new ForsteVirkningsdatoGrunnlag[0];
    }

    public void setForsteVirkningsdatoGrunnlagListe(List<ForsteVirkningsdatoGrunnlag> forsteVirkningsdatoGrunnlagListe) {
        this.forsteVirkningsdatoGrunnlagListe = forsteVirkningsdatoGrunnlagListe;
    }

	public List<VilkarsVedtak> getPREG_vilkarsvedtakEPSListe() {
        return PREG_vilkarsvedtakEPSListe;
    }

    public VilkarsVedtak[] getPREG_vilkarsvedtakEPSListeAsArray() {
        return PREG_vilkarsvedtakEPSListe != null ? PREG_vilkarsvedtakEPSListe.toArray(new VilkarsVedtak[PREG_vilkarsvedtakEPSListe.size()]) : new VilkarsVedtak[0];
    }

    public void setPREG_vilkarsvedtakEPSListe(List<VilkarsVedtak> preg_vilkarsvedtakEPSListe) {
        this.PREG_vilkarsvedtakEPSListe = preg_vilkarsvedtakEPSListe;
    }
    @Deprecated
    public VilkarsVedtak[] retrievePREG_vilkarsvedtakEPSListeAsArray() {
        return PREG_vilkarsvedtakEPSListe.toArray(new VilkarsVedtak[0]);
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }
}
