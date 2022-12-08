package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.PenPerson;
import no.nav.domain.pensjon.regler.TTPeriode;
import no.nav.domain.pensjon.regler.Trygdetid;
import no.nav.domain.pensjon.regler.beregning2011.OvergangsinfoUPtilUT;
import no.nav.domain.pensjon.regler.beregning2011.UtbetalingsgradUT;
import no.nav.domain.pensjon.regler.kode.BorMedTypeCti;
import no.nav.domain.pensjon.regler.kode.GrunnlagsrolleCti;
import no.nav.domain.pensjon.regler.kode.LandCti;
import no.nav.domain.pensjon.regler.kode.SivilstandTypeCti;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Persongrunnlag inneholder n�dvendige data knyttet til en bestemt person.
 * Persongrunnlag brukes som inndata til kall p� en regeltjeneste og m�
 * defineres f�r kallet.
 * 
 * @author Swiddy de Louw (Capgemini) - PK-7973 - PKPYTON-526
 * @author Steinar Hjellvik (Decisive) - PK-6458
 * @author Lars Hartvigsen (Decisive) - PK-12705, PK-20946
 */
public class Persongrunnlag implements Serializable {


    /**
     * Representerer personen.
     */
    private PenPerson penPerson;

    /**
     * S�kers f�dselsdato,brukes kun ved simuleringer.Da benyttes ikke reelle
     * personer.
     */
    private Date fodselsdato;

    /**
     * Personens eventuelle d�dsdato, brukes ved beregning av ytelser til
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
     * Siste gyldige �r for opptjening som benyttes for alderspensjon2011/2016/2025 og AFP Privat.
     * For eksempel skal saksbehandling som utf�res i 2010 ta utgangspunkt i opptjeninger til
     * og med 2008 (sisteGyldigeOpptjeningsAr vil her v�re 2008).
     */
    private int sisteGyldigeOpptjeningsAr = 0;
    /**
     * Angir om opptjeningsinformasjonen er hentet fra Opptjeningsregisteret og
     * registrert som grunnlag p� kravet. Det vil v�re kun ett element i listen
     * ved beregnings/vilk�rspr�vingstjenester. Ved tjenesten
     * KontrollerInformasjonsgrunnlag vil det v�re flere elementer.
     */
    private Boolean hentetPopp;

    /**
     * Angir om informasjonen om inntektsinformasjon er hentet fra
     * Inntektsregisteret og registrert som grunnlag p� kravet.
     */
    private Boolean hentetInnt;

    /**
     * Angir om informasjonen om institusjonsopphold er hentet fra
     * Institusjonsoppholdsregisteret og registrert som grunnlag p� kravet.
     */
    private Boolean hentetInst;

    /**
     * Angir om trygdetidsinformasjon er hentet inn og registrert som grunnlag
     * p� kravet.
     */
    private Boolean hentetTT;

    /**
     * Angir om informasjon om arbeidsforhold er hentet fra
     * Arbeidsforholdregisteret og registrert som grunnlag p� kravet.
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
     * Framtidig og faktisk trygdetid. Denne ligger ogs� i VilkarsVedtak, men er
     * n�dvendig n�r vi skal ytelsesberegninger der det ikke finnes et vedtak.
     * F.eks Barnepensjon gjenlevende.
     */
    private Trygdetid trygdetid;

    /**
     * Samme som over, men for ny opptjeningsmodell.
     */
    private Trygdetid trygdetidKapittel20;

    /**
     * Trygdetid for alternative Uf�retidspunkt.
     */
    private Trygdetid trygdetidAlternativ;

    /**
     * Spesifikke grunnlagsdata for uf�repensjon.
     */
    private Uforegrunnlag uforegrunnlag;

    /**
     * Historikk for uf�reytelser.Inneholder en blanding av data fra
     * Uforegrunnlag og UforeEkstra.
     */

    private Uforehistorikk uforeHistorikk;

    /**
     * Spesifikke grunnlagsdata for yrkesskadepensjon. Dersom yrkesskadegrunnlag =
     * null betyr det at personen ikke har yrkesskade.
     */
    private Yrkesskadegrunnlag yrkesskadegrunnlag;

    /**
     * Angir om en avd�d d�de av yrkesskade. Hvis satt vil det finnes et yrkesskadegrunnlag og en dodsdato.
     * Det skal da ikke finnes et uf�regrunnlag. Brukes ved BP/GJP/GJR.
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
     * Antall �r personen har bodd/arbeidet i utlandet etter fylte 16 �r.
     */
    private int antallArUtland;

    /**
     * Angir om personen har v�rt medlem i Folketrygden de siste 3 �r. Brukes
     * ved simulering.
     */
    private Boolean medlemIFolketrygdenSiste3Ar;

    /**
     * Angir om personen er over 60 �r eller ikke kan fors�rge seg selv. Brukes
     * i simulering for � angi vilk�r for ektefelletillegg.
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
     * Grunnlag p�krevd for � kunne behandle inngang og eksport av pensjonssaker mellom Norge og utland.
     */
    private InngangOgEksportGrunnlag inngangOgEksportGrunnlag;

    /**
     * Grunnlag p�krevd for � kunne behandle inngang og eksport av pensjonssaker mellom Norge og utland.
     */
    private List<ForsteVirkningsdatoGrunnlag> forsteVirkningsdatoGrunnlagListe;

    /**
     * �rlig pensjonsgivende inntekt var minst 1G p� d�dstidspunktet.
     */
    private Boolean arligPGIMinst1G;

    /**
     * Angir omdet skal beregnes etter artikkel 10 - nordisk konvensjon.
     * Trygdetiden kan bli redusert.
     */
    private Boolean artikkel10;

    /**
     * �rstall for avtjent verneplikt. Maks 4 �r godkjennes. Er null dersom det
     * ikke finnes verneplikts�r. M� v�re i stigende rekkef�lge, eks:<br>
     * <code>[0] = 2001</code><br>
     * <code>[1] = 2002</code><br>
     * <code>[2] = 2004</code>
     */
    private int[] vernepliktAr;

    /**
     * Den skiltes del av avd�des tilleggspensjon. Angis i prosent. Default
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
     * Landskode - det land personen er bosatt i p� VIRK. Intern PREG attributt.
     * Default settes denne til NOR og erstattes med Trygdeavtale.bostedsland
     * dersom trygdeavtale ikke er null.
     */
    private LandCti bosattLand;

    private Pensjonsbeholdning pensjonsbeholdning;

    /**
     * Informasjon om f�rstegangstjenesteperioder.
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
     * Inneholder utbetalingsgraden for uf�retrygd etter inntektsavkorting.
     */
    private List<UtbetalingsgradUT> utbetalingsgradUTListe;

	/**
	* Objekt som inneholder informasjon om TP-ordningers uf�repensjonsgrunnlag. Dette er manuelt registrerte data og ikke hentet fra TP-registeret eller andre eksterne kilder.
	*/
	
	private AfpTpoUpGrunnlag AfpTpoUpGrunnlag;

}
