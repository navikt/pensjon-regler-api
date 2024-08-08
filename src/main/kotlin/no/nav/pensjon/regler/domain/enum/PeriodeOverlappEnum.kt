package no.nav.pensjon.regler.domain.enum

enum class PeriodeOverlappEnum {
    perioder_overlapper_delvis,
    periode_b_innenfor_periode_a,
    periode_a_innenfor_periode_b,
    perioder_like,
    perioder_ulike,
    default
}