package no.nav.pensjon.regler.domain.enum

enum class SatsTypeEnum {
    LONNSVEKST,
    GRUNNBELOP,
    LONNSVEKSTSATS,
    MPNSATS,
    REGULERINGSFAKTORSATS,
    SARTILLEGGSATS,
    SKJERMINGSTILLEGGSATS,
    VEIETGRUNNBELOPSATS,
    GPNSATS,
    GRUNNPENSJONSATS,
    MINSTEYTELSEUTSATS,
    RETTSGEBYR,
    TOL_GR_EO_ETTERBET,
    TOL_GR_EO_TILBAKEKR,
    TERSKEL_FEILUTBET,

    /**
     * Fra PEN
     */
    REGULERINGSFAKTOR,
    SKJERMINGSGRAD;
}