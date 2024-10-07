package no.nav.pensjon.regler.domain.enum

enum class SimuleringTypeEnum {
    /**
     * AFP
     */
    AFP,
    /**
     * AFP i offentlig sektor etterfulgt av alderspensjon
     */
    AFP_ETTERF_ALDER,
    /**
     * AFP - vedtak om fremtidig pensjonspoeng
     */
    AFP_FPP,
    /**
     * Alderspensjon
     */
    ALDER,
    /**
     * Alderspensjon
     */
    ALDER_KAP_20,
    /**
     * Alderspensjon med AFP i privat sektor
     */
    ALDER_M_AFP_PRIVAT,
    /**
     * Alderspensjon med gjenlevenderettigheter
     */
    ALDER_M_GJEN,
    /**
     * Barnepensjon
     */
    BARN,
    /**
     * Endring av alderspensjon
     */
    ENDR_ALDER,
    /**
     * Endring av alderspensjon med gjenlevenderettigheter
     */
    ENDR_ALDER_M_GJEN,
    /**
     * Endring av alderspensjon med AFP i privat sektor
     */
    ENDR_AP_M_AFP_PRIVAT,
    /**
     * Gjenlevendepensjon
     */
    GJENLEVENDE;
}