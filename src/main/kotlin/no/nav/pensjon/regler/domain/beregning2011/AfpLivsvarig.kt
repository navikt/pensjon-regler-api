package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.SakTypeCti
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

abstract class AfpLivsvarig(
    /** super Ytelseskomponent*/
    brutto: Int = 0,
    netto: Int = 0,
    fradrag: Int = 0,
    bruttoPerAr: Double = 0.0,
    nettoPerAr: Double = 0.0,
    fradragPerAr: Double = 0.0,
    ytelsekomponentType: YtelsekomponentTypeCti,
    merknadListe: MutableList<Merknad> = mutableListOf(),
    fradragsTransaksjon: Boolean = false,
    opphort: Boolean = false,
    sakType: SakTypeCti? = null,
    formelKode: FormelKodeCti? = FormelKodeCti("AFPx"),
    reguleringsInformasjon: ReguleringsInformasjon? = null
) : Ytelseskomponent(
    brutto = brutto,
    netto = netto,
    fradrag = fradrag,
    bruttoPerAr = bruttoPerAr,
    nettoPerAr = nettoPerAr,
    fradragPerAr = fradragPerAr,
    ytelsekomponentType = ytelsekomponentType,
    merknadListe = merknadListe,
    fradragsTransaksjon = fradragsTransaksjon,
    opphort = opphort,
    sakType = sakType,
    formelKode = formelKode,
    reguleringsInformasjon = reguleringsInformasjon
) {
    constructor(afpLivsvarig: AfpLivsvarig) : this(
        brutto = afpLivsvarig.brutto,
        netto = afpLivsvarig.netto,
        fradrag = afpLivsvarig.fradrag,
        bruttoPerAr = afpLivsvarig.bruttoPerAr,
        nettoPerAr = afpLivsvarig.nettoPerAr,
        fradragPerAr = afpLivsvarig.fradragPerAr,
        ytelsekomponentType = afpLivsvarig.ytelsekomponentType!!,
        merknadListe = afpLivsvarig.merknadListe.toMutableList(),
        fradragsTransaksjon = afpLivsvarig.fradragsTransaksjon,
        opphort = afpLivsvarig.opphort,
        sakType = afpLivsvarig.sakType,
        formelKode = afpLivsvarig.formelKode,
        reguleringsInformasjon = afpLivsvarig.reguleringsInformasjon
    )
}