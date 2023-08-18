package no.nav.pensjon.regler.domain.beregning2011;

public class FremtidigBarnetilleggperiode extends AbstraktBarnetilleggperiode {
    private static final long serialVersionUID = 6485459168505914786L;

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

    public FremtidigBarnetilleggperiode() {
    }

    public FremtidigBarnetilleggperiode(FremtidigBarnetilleggperiode fbtp) {
        super(fbtp);
        this.fradragPerAr = fbtp.fradragPerAr;
        this.nettoPerArForJustering = fbtp.nettoPerArForJustering;
        this.nettoPerAr = fbtp.nettoPerAr;
        this.nettoPerMnd = fbtp.nettoPerMnd;
        this.restTilUtbetaling = fbtp.restTilUtbetaling;
        this.restTilUtbetalingForJustering = fbtp.restTilUtbetalingForJustering;
        this.justeringsbelopUbegrensetPerAr = fbtp.justeringsbelopUbegrensetPerAr;
        this.justeringsbelopPerAr = fbtp.justeringsbelopPerAr;
        this.justeringsbelopPerMnd = fbtp.justeringsbelopPerMnd;
    }

    public double getFradragPerAr() {
        return fradragPerAr;
    }

    public void setFradragPerAr(double fradragPerAr) {
        this.fradragPerAr = fradragPerAr;
    }

    public int getNettoPerArForJustering() {
        return nettoPerArForJustering;
    }

    public void setNettoPerArForJustering(int nettoPerArForJustering) {
        this.nettoPerArForJustering = nettoPerArForJustering;
    }

    public double getNettoPerAr() {
        return nettoPerAr;
    }

    public void setNettoPerAr(double nettoPerAr) {
        this.nettoPerAr = nettoPerAr;
    }

    public int getNettoPerMnd() {
        return nettoPerMnd;
    }

    public void setNettoPerMnd(int nettoPerMnd) {
        this.nettoPerMnd = nettoPerMnd;
    }

    public int getRestTilUtbetaling() {
        return restTilUtbetaling;
    }

    public void setRestTilUtbetaling(int restTilUtbetaling) {
        this.restTilUtbetaling = restTilUtbetaling;
    }

    public double getRestTilUtbetalingForJustering() {
        return restTilUtbetalingForJustering;
    }

    public void setRestTilUtbetalingForJustering(double restTilUtbetalingForJustering) {
        this.restTilUtbetalingForJustering = restTilUtbetalingForJustering;
    }

    public double getJusteringsbelopUbegrensetPerAr() {
        return justeringsbelopUbegrensetPerAr;
    }

    public void setJusteringsbelopUbegrensetPerAr(double justeringsbelopUbegrensetPerAr) {
        this.justeringsbelopUbegrensetPerAr = justeringsbelopUbegrensetPerAr;
    }

    public double getJusteringsbelopPerAr() {
        return justeringsbelopPerAr;
    }

    public void setJusteringsbelopPerAr(double justeringsbelopPerAr) {
        this.justeringsbelopPerAr = justeringsbelopPerAr;
    }

    public int getJusteringsbelopPerMnd() {
        return justeringsbelopPerMnd;
    }

    public void setJusteringsbelopPerMnd(int justeringsbelopPerMnd) {
        this.justeringsbelopPerMnd = justeringsbelopPerMnd;
    }
}
