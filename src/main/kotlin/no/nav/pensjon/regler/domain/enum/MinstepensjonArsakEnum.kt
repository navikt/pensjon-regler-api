package no.nav.pensjon.regler.domain.enum

enum class MinstepensjonArsakEnum {
    NEG_YTELSE_OVER_MIN,
    POS_YTELSE_UNDER_MIN,
    POS_BRUTTO_ST_OVER_NULL,
    NEG_ST_FINNES_IKKE,
    POS_MNT_PENSJONISTPAR,
    POS_MNT_INDIVIDUELL,
    POS_MOTTAR_MINSTENIVA,
    NEG_MOTTAR_IKKE_MINSTENIVA,
    POS_MINSTEYTELSE_BEDRE_EN_EGENOPPTJENT,
    POS_UFORE_IKKE_OVERSTYRT,
    POS_UFORE_OVERSTYRT,
    NEG_UFORE,
    OVER_MPN_HAR_GARP,
    UNDER_MPN
}