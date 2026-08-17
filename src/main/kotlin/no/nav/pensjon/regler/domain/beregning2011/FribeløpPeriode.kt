package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.VenteperiodeBegrunnelseEnum
import java.time.LocalDate

class FribeløpPeriode(
    /**
     * Fra hvilken måned i virkåret perioden gjelder fra og med.
     */
    val fom: LocalDate,

    /**
     * Fra hvilken måned i virkåret perioden gjelder til og med.
     */
    var tom: LocalDate,

    /**
     * Hvilken faktor perioden bidrar med ved beregning av fribeløp.
     */
    val faktor: Double,

    /**
     * Grunnbeløpet som legges til grunn for perioden.
     */
    val grunnbeløp: Int,

    /**
     * Fra hvilken dato venteperioden har startet å telle fra.
     */
    val venteperiodeStartDato: LocalDate,

    /**
     * Årsaken til hvorfor venteperioden har startet.
     */
    val venteperiodeBegrunnelseEnum: VenteperiodeBegrunnelseEnum
)