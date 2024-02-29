package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.beregning2011.ReguleringsInformasjon
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.SakTypeCti
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import no.nav.pensjon.regler.domain.util.formula.IFormelProvider
import java.io.Serializable

/**
 * Superklasse for alle ytelser, Grunnpensjon, Sertillegg, AfpTillegg osv. For
 * alle ytelser gjelder at brutto - netto = fradrag.
 */
abstract class Ytelseskomponent(
    /**
     * Brutto beløp.
     */
    var brutto: Int = 0,

    /**
     * Netto beløp.
     */
    var netto: Int = 0,

    /**
     * Fradraget: brutto - netto
     */
    var fradrag: Int = 0,

    /**
     * Ikke avrundet beløp, gjelder for hele året.
     */
    var bruttoPerAr: Double = 0.0,

    /**
     * årlig netto utbetalt sum.
     */
    var nettoPerAr: Double = 0.0,

    /**
     * Ytelsens fradrag per år.
     */
    var fradragPerAr: Double = 0.0,

    /**
     * Type ytelse, verdi fra kodeverk.
     */
    var ytelsekomponentType: YtelsekomponentTypeCti? = null,

    /**
     * Liste av merknader.
     */
    var merknadListe: MutableList<Merknad> = mutableListOf(),

    /**
     * Indikerer hvilken beregningsformel som ble brukt.
     */
    var formelKode: FormelKodeCti? = null,

    /**
     * Informasjon om regulering av ytelsen.
     */
    var reguleringsInformasjon: ReguleringsInformasjon? = null,

    /**
     * Angir om ytelseskomponenten går til utbetaling eller tilbakekreving.
     * Settes ikke i PREG, men mappes slik at vi ikke mister den ved kall til regeltjenester som returnerer kopier av innsendt ytelseskomponent (f.eks. faktoromregning).
     */
    var fradragsTransaksjon: Boolean = false,

    /**
     * Angir om ytelseskomponenten er opphørt.
     * Settes ikke i PREG, men mappes slik at vi ikke mister den ved kall til regeltjenester som returnerer kopier av innsendt ytelseskomponent (f.eks. faktoromregning).
     */
    var opphort: Boolean = false,

    /**
     * Angir sakentypen ytelseskomponenten er knyttet til.
     * Settes ikke i PREG, men mappes slik at vi ikke mister den ved kall til regeltjenester som returnerer kopier av innsendt ytelseskomponent (f.eks. faktoromregning).
     */
    var sakType: SakTypeCti? = null,

    ) : Serializable {


    val isIFormelProvider: Boolean
        get() = this is IFormelProvider
    constructor(ytelseskomponent: Ytelseskomponent) : this() {
        brutto = ytelseskomponent.brutto
        netto = ytelseskomponent.netto
        fradrag = ytelseskomponent.fradrag
        bruttoPerAr = ytelseskomponent.bruttoPerAr
        nettoPerAr = ytelseskomponent.nettoPerAr
        fradragPerAr = ytelseskomponent.fradragPerAr
        if (ytelseskomponent.ytelsekomponentType != null) {
            ytelsekomponentType = YtelsekomponentTypeCti(ytelseskomponent.ytelsekomponentType!!)
        }
        if (ytelseskomponent.formelKode != null) {
            formelKode = FormelKodeCti(ytelseskomponent.formelKode!!)
        }
        for (merknad in ytelseskomponent.merknadListe) {
            merknadListe.add(Merknad(merknad))
        }
        if (ytelseskomponent.reguleringsInformasjon != null) {
            reguleringsInformasjon = ReguleringsInformasjon(ytelseskomponent.reguleringsInformasjon!!)
        }
        fradragsTransaksjon = ytelseskomponent.fradragsTransaksjon
        opphort = ytelseskomponent.opphort
        if (ytelseskomponent.sakType != null) {
            sakType = SakTypeCti(ytelseskomponent.sakType!!)
        }
    }
}