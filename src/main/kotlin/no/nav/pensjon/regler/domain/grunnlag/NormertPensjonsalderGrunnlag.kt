package no.nav.pensjon.regler.domain.grunnlag

data class NormertPensjonsalderGrunnlag(
    val ovreAr: Int,
    val ovreMnd: Int,
    val normertAr: Int,
    val normertMnd: Int,
    val nedreAr: Int,
    val nedreMnd: Int,
    val erPrognose: Boolean
)