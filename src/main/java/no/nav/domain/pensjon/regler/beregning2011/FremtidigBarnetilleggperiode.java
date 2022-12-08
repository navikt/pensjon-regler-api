package no.nav.domain.pensjon.regler.beregning2011;

public class FremtidigBarnetilleggperiode extends AbstraktBarnetilleggperiode {

    /**
     * Hva perioden skal avkortes med. �rlig bel�p.
     */
    private double fradragPerAr;
    /**
     * �rlig netto uten hensyn til justeringsbel�p
     */
    private int nettoPerArForJustering;
    /**
     * �rlig netto hensyntatt justeringsbel�p
     */
    private double nettoPerAr;
    /**
     * M�nedlig nettobel�p
     */
    private int nettoPerMnd;
    /**
     * Hva gjenst�r � utbetale i perioden
     */
    private int restTilUtbetaling;
    /**
     * Hva ville ha gjenst�tt � utbetale i perioden gitt ingen justering
     */
    private double restTilUtbetalingForJustering;
    /**
     * N�dvendig justering av avkortingsbel�p for perioden
     */
    private double justeringsbelopUbegrensetPerAr;
    /**
     * Hva m� avkortingsbel�pet justeres med for � oppn� riktig fradrag for perioden
     */
    private double justeringsbelopPerAr;
    /**
     * M�nedlig justeringsbel�p
     */
    private int justeringsbelopPerMnd;
}
