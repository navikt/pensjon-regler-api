package no.nav.pensjon.regler.domain.enum

enum class KravVelgtypeEnum  {
    AVDOD_MOR,
    AVDOD_FAR,
    FORELDRELOS,
    FORELOPIG,
    VARIG,
    BP,
    EP,

    /**
     * Tatt fra PEN. Kan de fjernes, eller vil vi ta i mot disse?
     */
    MIL_BARNEP,
    MIL_GJENLEV,
    MIL_INV,
    NSB,
    SIVIL_BARNEP,
    SIVIL_GJENLEV,
    SIVIL_INV,
    UP;
}