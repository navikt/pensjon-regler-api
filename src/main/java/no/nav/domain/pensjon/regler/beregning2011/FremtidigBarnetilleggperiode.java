package no.nav.domain.pensjon.regler.beregning2011;

public class FremtidigBarnetilleggperiode extends AbstraktBarnetilleggperiode {
    private static final long serialVersionUID = 6485459168505914786L;

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
