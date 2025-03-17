package no.nav.pensjon.regler.domain.beregning2011

import java.time.LocalDate

data class AfpOffentligLivsvarigGrunnlag(val sistRegulertG: Int, val bruttoPerAr: Double, val uttaksdato: LocalDate)