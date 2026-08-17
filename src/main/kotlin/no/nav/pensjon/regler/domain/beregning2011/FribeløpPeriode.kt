package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.VenteperiodeBegrunnelseEnum
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class FribeløpPeriode(
    val fom: LocalDate,
    var tom: LocalDate,
    val faktor: Double,
    val grunnbeløp: Int,
    val venteperiodeStartDato: LocalDate,
    val venteperiodeBegrunnelse: VenteperiodeBegrunnelseEnum
) {
    fun lengde(): Int = ChronoUnit.MONTHS.between(fom, tom.withDayOfMonth(1)).toInt() + 1
}