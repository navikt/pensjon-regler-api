package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import no.nav.pensjon.regler.domain.enum.JustertPeriodeEnum
import no.nav.pensjon.regler.domain.enum.YtelseVedDodEnum
import no.nav.pensjon.regler.domain.trygdetid.Brok
import java.util.*

class Uforetrygdberegning : Beregning2011() {
    var bruttoPerAr = 0
    var formelKodeEnum: FormelKodeEnum? = null
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

    /* Viser hvilken type institusjonsopphold det er beregnet for. Kodene hentes fra K_JUST_PERIODE */
    var instOppholdTypeEnum: JustertPeriodeEnum? = null

    /* Angir om ytelsen er endret, enten  økt eller redusert. */
    var instOpphAnvendt = false

    /**
     * Ekstra informasjon til beregnet uføretrygd.
     * Brukes for at pensjon-regler skal beregne en Uførehistorikk for uføretrygd.
     */
    var uforeEkstra: UforeEkstraUT? = null

    /**
     * Satt på de beregninger hvor avdødes ytelse har påvirket beregningen.
     */
    var ytelseVedDodEnum: YtelseVedDodEnum? = null

}