package no.nav.pensjon.regler.domain.beregning

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.beregning.penobjekter.*
import no.nav.pensjon.regler.domain.beregning2011.*
import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import no.nav.pensjon.regler.domain.enum.SakTypeEnum
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import java.io.Serializable

/**
 * Superklasse for alle ytelser, Grunnpensjon, Sertillegg, AfpTillegg osv. For
 * alle ytelser gjelder at brutto - netto = fradrag.
 */
@JsonSubTypes(
    JsonSubTypes.Type(value = AfpKompensasjonstillegg::class),
    JsonSubTypes.Type(value = AfpKronetillegg::class),
    JsonSubTypes.Type(value = AfpTillegg::class),
    JsonSubTypes.Type(value = BeregningYtelseskomponent::class),
    JsonSubTypes.Type(value = Ektefelletillegg::class),
    JsonSubTypes.Type(value = EktefelletilleggUT::class),
    JsonSubTypes.Type(value = Familietillegg::class),
    JsonSubTypes.Type(value = FasteUtgifterTillegg::class),
    JsonSubTypes.Type(value = FasteUtgifterTilleggUT::class),
    JsonSubTypes.Type(value = Garantipensjon::class),
    JsonSubTypes.Type(value = Garantitillegg::class),
    JsonSubTypes.Type(value = Garantitillegg_Art_27::class),
    JsonSubTypes.Type(value = Garantitillegg_Art_27_UT::class),
    JsonSubTypes.Type(value = Garantitillegg_Art_50::class),
    JsonSubTypes.Type(value = Gjenlevendetillegg::class),
    JsonSubTypes.Type(value = GjenlevendetilleggAP::class),
    JsonSubTypes.Type(value = GjenlevendetilleggAPKap19::class),
    JsonSubTypes.Type(value = Grunnpensjon::class),
    JsonSubTypes.Type(value = Hjelpeloshetsbidrag::class),
    JsonSubTypes.Type(value = Inntektspensjon::class),
    JsonSubTypes.Type(value = KrigOgGammelYrkesskade::class),
    JsonSubTypes.Type(value = Mendel::class),
    JsonSubTypes.Type(value = MinstenivatilleggIndividuelt::class),
    JsonSubTypes.Type(value = MinstenivatilleggPensjonistpar::class),
    JsonSubTypes.Type(value = Paragraf_8_5_1_tillegg::class),
    JsonSubTypes.Type(value = Pensjonstillegg::class),
    JsonSubTypes.Type(value = Sertillegg::class),
    JsonSubTypes.Type(value = Skjermingstillegg::class),
    JsonSubTypes.Type(value = TemporarYtelseskomponent::class),
    JsonSubTypes.Type(value = Tilleggspensjon::class),
    JsonSubTypes.Type(value = TilleggTilHjelpIHuset::class),
    JsonSubTypes.Type(value = UforetilleggTilAlderspensjon::class),
    JsonSubTypes.Type(value = UforetrygdOrdiner::class),
    JsonSubTypes.Type(value = Ventetillegg::class),
    JsonSubTypes.Type(value = AbstraktAfpLivsvarig::class),
    JsonSubTypes.Type(value = AbstraktBarnetillegg::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
abstract class Ytelseskomponent : Serializable {
    /**
     * Brutto beløp.
     */
    open var brutto = 0

    /**
     * Netto beløp.
     */
    open var netto = 0

    /**
     * Fradraget: brutto - netto
     */
    var fradrag = 0

    /**
     * Ikke avrundet beløp, gjelder for hele året.
     */
    var bruttoPerAr = 0.0

    /**
     * årlig netto utbetalt sum.
     */
    var nettoPerAr = 0.0

    /**
     * Ytelsens fradrag per år.
     */
    var fradragPerAr = 0.0

    /**
     * Type ytelse, verdi fra kodeverk.
     */
    abstract var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum

    /**
     * Liste av merknader.
     */
    var merknadListe: MutableList<Merknad> = mutableListOf()

    /**
     * Indikerer hvilken beregningsformel som ble brukt.
     */
    var formelKodeEnum: FormelKodeEnum? = null

    /**
     * Informasjon om regulering av ytelsen.
     */
    var reguleringsInformasjon: ReguleringsInformasjon? = null

    /**
     * Angir om ytelseskomponenten går til utbetaling eller tilbakekreving.
     * Settes ikke i pensjon-regler, men mappes slik at vi ikke mister den ved kall til regeltjenester som returnerer kopier av innsendt ytelseskomponent (f.eks. faktoromregning).
     */
    var fradragsTransaksjon = false

    /**
     * Angir om ytelseskomponenten er opphørt.
     * Settes ikke i pensjon-regler, men mappes slik at vi ikke mister den ved kall til regeltjenester som returnerer kopier av innsendt ytelseskomponent (f.eks. faktoromregning).
     */
    var opphort = false

    /**
     * Angir sakentypen ytelseskomponenten er knyttet til.
     * Settes ikke i pensjon-regler, men mappes slik at vi ikke mister den ved kall til regeltjenester som returnerer kopier av innsendt ytelseskomponent (f.eks. faktoromregning).
     */
    var sakTypeEnum: SakTypeEnum? = null

    constructor()
    constructor(ytelseskomponent: Ytelseskomponent) {
        brutto = ytelseskomponent.brutto
        netto = ytelseskomponent.netto
        fradrag = ytelseskomponent.fradrag
        bruttoPerAr = ytelseskomponent.bruttoPerAr
        nettoPerAr = ytelseskomponent.nettoPerAr
        fradragPerAr = ytelseskomponent.fradragPerAr
        ytelsekomponentTypeEnum = ytelseskomponent.ytelsekomponentTypeEnum

        if (ytelseskomponent.formelKodeEnum != null) {
            formelKodeEnum = ytelseskomponent.formelKodeEnum
        }
        for (merknad in ytelseskomponent.merknadListe) {
            merknadListe.add(Merknad(merknad))
        }
        if (ytelseskomponent.reguleringsInformasjon != null) {
            reguleringsInformasjon = ReguleringsInformasjon(ytelseskomponent.reguleringsInformasjon!!)
        }
        fradragsTransaksjon = ytelseskomponent.fradragsTransaksjon
        opphort = ytelseskomponent.opphort
        if (ytelseskomponent.sakTypeEnum != null) {
            sakTypeEnum = ytelseskomponent.sakTypeEnum
        }
    }
}