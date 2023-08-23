package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.JustertPeriodeCti
import no.nav.pensjon.regler.domain.kode.YtelseVedDodCti
import no.nav.pensjon.regler.domain.trygdetid.Brok
import java.util.*

class Uforetrygdberegning : Beregning2011() {
    var bruttoPerAr = 0
    var formelKode: FormelKodeCti? = null
    override var grunnbelop = 0
    var minsteytelse: Minsteytelse? = null
    var prorataBrok: Brok? = null
    var uforegrad = 0
    var uforetidspunkt: Date? = null
    var egenopptjentUforetrygd: EgenopptjentUforetrygd? = null
    var egenopptjentUforetrygdBest = false
    var yrkesskadegrad = 0
    var yrkesskadetidspunkt: Date? = null
    var mottarMinsteytelse = false

    /* Bygger opp årsakskoder som viser hvorfor personen mottar minsteytelse */
    var minsteytelseArsak: String? = null
    var pREG_avtaleBeregningsmetode: String? = null

    /* Viser hvilken type institusjonsopphold det er beregnet for. Kodene hentes fra K_JUST_PERIODE */
    var instOppholdType: JustertPeriodeCti? = null

    /* Angir om ytelsen er endret, enten  økt eller redusert. */
    var instOpphAnvendt = false

    /**
     * Ekstra informasjon til beregnet uføretrygd.
     * Brukes for at PREG skal beregne en Uførehistorikk for uføretrygd.
     */
    var uforeEkstra: UforeEkstraUT? = null

    /**
     * Satt på de beregninger hvor avdødes ytelse har påvirket beregningen.
     */
    var ytelseVedDod: YtelseVedDodCti? = null

}