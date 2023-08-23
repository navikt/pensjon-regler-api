package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.Trygdetid
import no.nav.pensjon.regler.domain.beregning.Ektefelletillegg
import no.nav.pensjon.regler.domain.beregning.UforeEkstra
import no.nav.pensjon.regler.domain.kode.MinstepensjonTypeCti
import no.nav.pensjon.regler.domain.kode.ResultatKildeCti
import no.nav.pensjon.regler.domain.trygdetid.AnvendtTrygdetid

/**
 * @auhtor Magnus Bakken (Accenture) PK-9158
 * @author Aasmund Nordstoga (Accenture) PK-5549
 * @author Swiddy de Louw (Capgemini) PK-7113
 */
class SisteUforepensjonBeregning : SisteBeregning() {
    var et: Ektefelletillegg? = null
    var tt: Trygdetid? = null
    var uforeEkstra: UforeEkstra? = null
    /**
     * Konverteringsgrunnlaget for brukers rettigheter
     */
    var konverteringsgrunnlagOrdinert: Konverteringsgrunnlag? = null
    /**
     * Betinget, Konverteringsgrunnlag hvis gjenlevenderetten vant
     */
    var konverteringsgrunnlagGJT: Konverteringsgrunnlag? = null

    /**
     * Betinget: Hvis Uføregraden > 0, yrkesskadegrad < Uføregrad.
     */
    var konverteringsgrunnlagUforedel: Konverteringsgrunnlag? = null

    /**
     * Betinget: Hvis Uføregraden > 0, yrkesskadegrad < Uføregrad.
     */
    var konverteringsgrunnlagYrkesskade: Konverteringsgrunnlag? = null

    /**
     * Betinget: Hvis det fantes en folketrygdberegning(ikke nødvendigvis vinnende) i UP
     */
    var anvendtTrygdetidFolketrygd: AnvendtTrygdetid? = null

    /**
     * Hvorvidt utbetalt uførepensjonen per 31.12.2014 ble definert som minstepensjon.
     */
    var minstepensjonType: MinstepensjonTypeCti? = null

    /**
     * Hvorvidt utbetalt uførepensjonen per 31.12.2014 ble manuelt overstyrt eller ikke.
     */
    var resultatKilde: ResultatKildeCti? = null

    /**
     * Netto særtillegg i utbetalt uførepensjonen per 31.12.2014.
     */
    var sertilleggNetto = 0
}