package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.PenPerson
import no.nav.pensjon.regler.domain.TTPeriode
import no.nav.pensjon.regler.domain.Trygdetid
import no.nav.pensjon.regler.domain.beregning2011.OvergangsinfoUPtilUT
import no.nav.pensjon.regler.domain.beregning2011.UtbetalingsgradUT
import no.nav.pensjon.regler.domain.kode.BorMedTypeCti
import no.nav.pensjon.regler.domain.kode.GrunnlagsrolleCti
import no.nav.pensjon.regler.domain.kode.LandCti
import no.nav.pensjon.regler.domain.kode.SivilstandTypeCti
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import org.apache.commons.lang3.mutable.Mutable
import java.io.Serializable
import java.util.*

/**
 * Persongrunnlag inneholder nødvendige data knyttet til en bestemt person.
 * Persongrunnlag brukes som inndata til kall på en regeltjeneste og må
 * defineres før kallet.
 */
open class Persongrunnlag : Serializable {
    /**
     * Representerer personen.
     */
    var penPerson: PenPerson? = null

    /**
     * søkers Fødselsdato,brukes kun ved simuleringer.Da benyttes ikke reelle
     * personer.
     */
    var fodselsdato: Date? = null

    /**
     * Personens eventuelle dødsdato, brukes ved beregning av ytelser til
     * gjenlevende ektefelle og barn.
     */
    var dodsdato: Date? = null

    /**
     * Personens statsborgerskap.
     */
    var statsborgerskap: LandCti? = null

    /**
     * Angir om personen er flyktning.
     */
    var flyktning: Boolean? = null

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
    var personDetaljListe: MutableList<PersonDetalj> = mutableListOf()

    /**
     * Dato for sist innmeldt i Folketrygden- for fremtidig trygdetid.
     */
    var sistMedlITrygden: Date? = null

    /**
     * Siste gyldige år for opptjening som benyttes for alderspensjon2011/2016/2025 og AFP Privat.
     * For eksempel skal saksbehandling som utfåres i 2010 ta utgangspunkt i opptjeninger til
     * og med 2008 (sisteGyldigeOpptjeningsAr vil her være 2008).
     */
    var sisteGyldigeOpptjeningsAr = 0

    /**
     * Angir om opptjeningsinformasjonen er hentet fra Opptjeningsregisteret og
     * registrert som grunnlag på kravet. Det vil være kun ett element i listen
     * ved beregnings/vilkårsprøvingstjenester. Ved tjenesten
     * KontrollerInformasjonsgrunnlag vil det være flere elementer.
     */
    var hentetPopp: Boolean? = null

    /**
     * Angir om informasjonen om inntektsinformasjon er hentet fra
     * Inntektsregisteret og registrert som grunnlag på kravet.
     */
    var hentetInnt: Boolean? = null

    /**
     * Angir om informasjonen om institusjonsopphold er hentet fra
     * Institusjonsoppholdsregisteret og registrert som grunnlag på kravet.
     */
    var hentetInst: Boolean? = null

    /**
     * Angir om trygdetidsinformasjon er hentet inn og registrert som grunnlag
     * på kravet.
     */
    var hentetTT: Boolean? = null

    /**
     * Angir om informasjon om arbeidsforhold er hentet fra
     * Arbeidsforholdregisteret og registrert som grunnlag på kravet.
     */
    var hentetArbeid: Boolean? = null

    /**
     * Angir om personens ytelse skal beregnes med overkompensasjonsregler.
     * Gjelde utenlandstilfeller.
     */
    var overkompUtl: Boolean? = null

    /**
     * Liste av opptjeningsgrunnlag for personen.
     */
    var opptjeningsgrunnlagListe: MutableList<Opptjeningsgrunnlag> = mutableListOf()

    /**
     * Liste av inntektsgrunnlag for personen.
     */
    var inntektsgrunnlagListe: MutableList<Inntektsgrunnlag> = mutableListOf()

    /**
     * Liste av trygdetidsperioder for personen.
     */
    var trygdetidPerioder: MutableList<TTPeriode> = mutableListOf()

    /**
     * Liste av trygdetidsperioder for personen.
     * For beregning av trygdetid for AP2016 iht. kapittel 20 og AP2025.
     */
    var trygdetidPerioderKapittel20: MutableList<TTPeriode> = mutableListOf()

    /**
     * Framtidig og faktisk trygdetid. Denne ligger også i VilkarsVedtak, men er
     * nødvendig når vi skal ytelsesberegninger der det ikke finnes et vedtak.
     * F.eks Barnepensjon gjenlevende.
     */
    var trygdetid: Trygdetid? = null

    /**
     * Samme som over, men for ny opptjeningsmodell.
     */
    var trygdetidKapittel20: Trygdetid? = null

    /**
     * Trygdetid for alternative uføretidspunkt.
     */
    var trygdetidAlternativ: Trygdetid? = null

    /**
     * Spesifikke grunnlagsdata for uførepensjon.
     */
    var uforegrunnlag: Uforegrunnlag? = null

    /**
     * Historikk for Uføreytelser.Inneholder en blanding av data fra
     * Uforegrunnlag og UforeEkstra.
     */
    var uforeHistorikk: Uforehistorikk? = null

    /**
     * Spesifikke grunnlagsdata for yrkesskadepensjon. Dersom yrkesskadegrunnlag =
     * null betyr det at personen ikke har yrkesskade.
     */
    var yrkesskadegrunnlag: Yrkesskadegrunnlag? = null

    /**
     * Angir om en avdød døde av yrkesskade. Hvis satt vil det finnes et yrkesskadegrunnlag og en dodsdato.
     * Det skal da ikke finnes et Uføregrunnlag. Brukes ved BP/GJP/GJR.
     */
    var dodAvYrkesskade: Boolean? = null

    /**
     * Generell historisk informasjon om en person. Ventetilleggsgrunnlag, fravik_19_3.
     */
    var generellHistorikk: GenerellHistorikk? = null

    /**
     * Historikk for AFP ytelser. Inneholder informasjon relevant for
     * perioden(e) bruker hadde AFP.
     */
    var afpHistorikkListe: List<AfpHistorikk> = mutableListOf()

    /**
     * Beskriver hvor mange barn det er i kullet.
     */
    var barnekull: Barnekull? = null

    /**
     * Hentet som eneste element fra PEN Persongrunnlag.barnetilleggVurderingsperiodeListe
     */
    var barnetilleggVurderingsperiode: BarnetilleggVurderingsperiode? = null

    /**
     * Antall år personen har bodd/arbeidet i utlandet etter fylte 16 år.
     */
    var antallArUtland = 0

    /**
     * Angir om personen har vært medlem i Folketrygden de siste 3 år. Brukes
     * ved simulering.
     */
    var medlemIFolketrygdenSiste3Ar: Boolean? = null

    /**
     * Angir om personen er over 60 år eller ikke kan forsørge seg selv. Brukes
     * i simulering for å angi vilkår for ektefelletillegg.
     */
    var over60ArKanIkkeForsorgesSelv: Boolean? = null

    /**
     * Liste av utenlandsopphold.
     */
    var utenlandsoppholdListe: MutableList<Utenlandsopphold> = mutableListOf()

    /**
     * Trygdeavtale, representerer en saksbehandlers vurdering av hvilken
     * avtale/konvensjon som skal anvendes i en utenlandssak.
     */
    var trygdeavtale: Trygdeavtale? = null

    /**
     * Detaljer knyttet til trygdeavtale. Brukes i beregningen av
     * tilleggspensjon i utenlandssaker.
     */
    var trygdeavtaledetaljer: Trygdeavtaledetaljer? = null

    /**
     * Grunnlag påkrevd for å kunne behandle inngang og eksport av pensjonssaker mellom Norge og utland.
     */
    var inngangOgEksportGrunnlag: InngangOgEksportGrunnlag? = null

    /**
     * Grunnlag påkrevd for å kunne behandle inngang og eksport av pensjonssaker mellom Norge og utland.
     */
    var forsteVirkningsdatoGrunnlagListe: MutableList<ForsteVirkningsdatoGrunnlag> = mutableListOf()

    /**
     * årlig pensjonsgivende inntekt var minst 1G på dødstidspunktet.
     */
    var arligPGIMinst1G: Boolean? = null

    /**
     * Angir omdet skal beregnes etter artikkel 10 - nordisk konvensjon.
     * Trygdetiden kan bli redusert.
     */
    var artikkel10: Boolean? = null

    /**
     * Årstall for avtjent verneplikt. Maks 4 år godkjennes. Er null dersom det
     * ikke finnes vernepliktsær. må være i stigende rekkefålge, eks:<br></br>
     * `[0] = 2001`<br></br>
     * `[1] = 2002`<br></br>
     * `[2] = 2004`
     */
    var vernepliktAr: IntArray? = null

    /**
     * Den skiltes del av avdødes tilleggspensjon. Angis i prosent. Default
     * verdi settes til -99 fordi 0 er en lovlig verdi.
     */
    var skiltesDelAvAvdodesTP = -99

    /**
     * Liste av institusjonsoppholdsreduksjonsperioder relatert til
     * persongrunnlaget
     */
    var instOpphReduksjonsperiodeListe: List<InstOpphReduksjonsperiode> = mutableListOf()

    /**
     * Liste av institusjonsoppholdsfasteutgifterperioder relatert til
     * persongrunnlaget
     */
    var instOpphFasteUtgifterperiodeListe: MutableList<InstOpphFasteUtgifterperiode> = mutableListOf()

    /**
     * Landskode - det land personen er bosatt i på VIRK. Intern PREG attributt.
     * Default settes denne til NOR og erstattes med Trygdeavtale.bostedsland
     * dersom trygdeavtale ikke er null.
     */
    var bosattLand: LandCti? = null
    var pensjonsbeholdning: Pensjonsbeholdning? = null

    /**
     * Informasjon om Førstegangstjenesteperioder.
     */
    var forstegangstjenestegrunnlag: Forstegangstjeneste? = null
    var dagpengegrunnlagListe: MutableList<Dagpengegrunnlag> = mutableListOf()
    var omsorgsgrunnlagListe: MutableList<Omsorgsgrunnlag> = mutableListOf()

    /**
     * Informasjon om arbeidsforhold med perioder og stillingsprosent.
     */
    var arbeidsforholdsgrunnlagListe: MutableList<Arbeidsforholdsgrunnlag> = mutableListOf()

    /**
     * Contains information about post injury arbeidsforhold perioder and stillingsprosent.
     */
    var arbeidsforholdEtterUforgrunnlagListe: List<ArbeidsforholdEtterUforgrunnlag> = mutableListOf()
    /**
     * @return the overgangsinfoUPtilUT
     */
    /**
     * @param overgangsinfoUPtilUT the overgangsinfoUPtilUT to set
     */
    /**
     * Informasjon om konverterting fra UP til UT.
     */
    var overgangsinfoUPtilUT: OvergangsinfoUPtilUT? = null

    /**
     * Inneholder utbetalingsgraden for uføretrygd etter inntektsavkorting.
     */
    var utbetalingsgradUTListe: List<UtbetalingsgradUT> = mutableListOf()

    /**
     * Objekt som inneholder informasjon om TP-ordningers uførepensjonsgrunnlag. Dette er manuelt registrerte data og ikke hentet fra TP-registeret eller andre eksterne kilder.
     */
    var afpTpoUpGrunnlag: AfpTpoUpGrunnlag? = null


}