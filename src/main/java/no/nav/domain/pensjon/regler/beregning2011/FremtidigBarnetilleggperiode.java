package no.nav.domain.pensjon.regler.beregning2011;

public class FremtidigBarnetilleggperiode extends AbstraktBarnetilleggperiode {

    /**
     * Hva perioden skal avkortes med. Årlig beløp.
     */
    private double fradragPerAr;
    /**
     * Årlig netto uten hensyn til justeringsbeløp
     */
    private int nettoPerArForJustering;
    /**
     * Årlig netto hensyntatt justeringsbeløp
     */
    private double nettoPerAr;
    /**
     * Månedlig nettobeløp
     */
    private int nettoPerMnd;
    /**
     * Hva gjenstår å utbetale i perioden
     */
    private int restTilUtbetaling;
    /**
     * Hva ville ha gjenstått å utbetale i perioden gitt ingen justering
     */
    private double restTilUtbetalingForJustering;
    /**
     * Nødvendig justering av avkortingsbeløp for perioden
     */
    private double justeringsbelopUbegrensetPerAr;
    /**
     * Hva må avkortingsbeløpet justeres med for å oppnå riktig fradrag for perioden
     */
    private double justeringsbelopPerAr;
    /**
     * Månedlig justeringsbeløp
     */
    private int justeringsbelopPerMnd;
}
