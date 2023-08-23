package no.nav.pensjon.regler.domain.beregning2011

class FremtidigBarnetilleggperiode : AbstraktBarnetilleggperiode() {
    /**
     * Hva perioden skal avkortes med. årlig beløp.
     */
    var fradragPerAr = 0.0

    /**
     * årlig netto uten hensyn til justeringsbeløp
     */
    var nettoPerArForJustering = 0

    /**
     * årlig netto hensyntatt justeringsbeløp
     */
    var nettoPerAr = 0.0

    /**
     * månedlig nettobeløp
     */
    var nettoPerMnd = 0

    /**
     * Hva gjenstår å utbetale i perioden
     */
    var restTilUtbetaling = 0

    /**
     * Hva ville ha gjenstøtt å utbetale i perioden gitt ingen justering
     */
    var restTilUtbetalingForJustering = 0.0

    /**
     * nødvendig justering av avkortingsbeløp for perioden
     */
    var justeringsbelopUbegrensetPerAr = 0.0

    /**
     * Hva må avkortingsbeløpet justeres med for å oppnå riktig fradrag for perioden
     */
    var justeringsbelopPerAr = 0.0

    /**
     * månedlig justeringsbeløp
     */
    var justeringsbelopPerMnd = 0

}