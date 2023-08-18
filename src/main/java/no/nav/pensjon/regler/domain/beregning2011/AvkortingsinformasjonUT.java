package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.GuiPrompt;

import java.io.Serializable;

/**
 * Angir detaljer rund avkortingen av uf�retrygd.
 */
public class AvkortingsinformasjonUT extends AbstraktAvkortingsinformasjon implements Serializable {

    private static final long serialVersionUID = -4831919123994190973L;

    /**
     * Bel�psgrense.
     */
    @GuiPrompt(prompt = "Bel�psgrense")
    private int belopsgrense;

    /**
     * Sum av inntektskomponentene som ble lagt til grunn.
     */
    @GuiPrompt(prompt = "Forventet inntekt")
    private int forventetInntekt;

    /**
     * Inntekt under denne grensen gir ikke utslag i avkorting.
     */
    @GuiPrompt(prompt = "Inntektsgrense")
    private int inntektsgrense;

    /**
     * Inntektsgrense nest �r settes n�r neste �rs inntektsgrense beregnes
     */
    @GuiPrompt(prompt = "Inntektsgrense neste �r")
    private int inntektsgrenseNesteAr;

    /**
     * Inntektstaket for p�f�lgende �r fastsatt p� bakgrunn av siste gjeldende OIFU i �ret. Feltet er kun angitt dersom inntektstak neste �r avviker fra gjeldende inntektstak.
     */
    @GuiPrompt(prompt = "Inntektstak neste �r")
    private int inntektstakNesteAr;
    /**
     * Angir dekningsgrad av tapt arbeidsevne.
     */
    @GuiPrompt(prompt = "Dekningsgrad av tapt arbeidsevne")
    private double kompensasjonsgrad;

    /**
     * Oppjustert inntekt etter uf�rhet.
     */
    @GuiPrompt(prompt = "Oppjustert inntekt etter uf�rhet")
    private int oieu;

    /**
     * Oppjustert inntekt f�r uf�rhet.
     */
    @GuiPrompt(prompt = "Oppjustert inntekt f�r uf�rhet")
    private int oifu;

    /**
     * Den OIFU som er angitt i beregningsperioden. Denne er ikke n�dvendigvis den h�yeste i �ret og skal benyttes for beregning av brutto barnetillegg.
     */
    @GuiPrompt(prompt = "Oppjustert inntekt f�r uf�rhet for barnetillegg")
    private int oifuForBarnetillegg;

    /**
     * Beregnet �rlig bruttobel�p etter full uf�regrad.
     */
    @GuiPrompt(prompt = "Brutto per �r, ugradert")
    private int ugradertBruttoPerAr;

    /**
     * Utbetalingsgrad etter inntektsavkorting.
     */
    @GuiPrompt(prompt = "Utbetalingsgrad etter inntektsavkorting")
    private int utbetalingsgrad;

    /**
     * Bel�pet som skal legges til avkortningsbel�pet for � f� fradraget som er n�dvendig for � kompensere for tidligere for lite eller mye avkortet.
     */
    private int differansebelop;

    public AvkortingsinformasjonUT() {
        super();
    }

    public AvkortingsinformasjonUT(AvkortingsinformasjonUT avkortingsinformasjonUT) {

        super(avkortingsinformasjonUT);
        oifu = avkortingsinformasjonUT.oifu;
        oieu = avkortingsinformasjonUT.oieu;
        belopsgrense = avkortingsinformasjonUT.belopsgrense;
        inntektsgrense = avkortingsinformasjonUT.inntektsgrense;
        ugradertBruttoPerAr = avkortingsinformasjonUT.ugradertBruttoPerAr;
        kompensasjonsgrad = avkortingsinformasjonUT.kompensasjonsgrad;
        utbetalingsgrad = avkortingsinformasjonUT.utbetalingsgrad;
        forventetInntekt = avkortingsinformasjonUT.forventetInntekt;
        inntektsgrenseNesteAr = avkortingsinformasjonUT.inntektsgrenseNesteAr;
        inntektstakNesteAr = avkortingsinformasjonUT.inntektstakNesteAr;
        differansebelop = avkortingsinformasjonUT.differansebelop;
        oifuForBarnetillegg = avkortingsinformasjonUT.oifuForBarnetillegg;

    }

    public int getBelopsgrense() {
        return belopsgrense;
    }

    public int getForventetInntekt() {
        return forventetInntekt;
    }

    public int getInntektsgrense() {
        return inntektsgrense;
    }

    /**
     * @return the inntektsgrenseNesteAr
     */
    public int getInntektsgrenseNesteAr() {
        return inntektsgrenseNesteAr;
    }

    public double getKompensasjonsgrad() {
        return kompensasjonsgrad;
    }

    public int getOieu() {
        return oieu;
    }

    public int getOifu() {
        return oifu;
    }

    public int getUgradertBruttoPerAr() {
        return ugradertBruttoPerAr;
    }

    public int getUtbetalingsgrad() {
        return utbetalingsgrad;
    }

    public void setBelopsgrense(int belopsgrense) {
        this.belopsgrense = belopsgrense;
    }

    public void setForventetInntekt(int forventetInntekt) {
        this.forventetInntekt = forventetInntekt;
    }

    public void setInntektsgrense(int inntektsgrense) {
        this.inntektsgrense = inntektsgrense;
    }

    public int getDifferansebelop() {
        return differansebelop;
    }

    public void setDifferansebelop(int differansebelop) {
        this.differansebelop = differansebelop;
    }

    /**
     * @param inntektsgrenseNesteAr the inntektsgrenseNesteAr to set
     */
    public void setInntektsgrenseNesteAr(int inntektsgrenseNesteAr) {
        this.inntektsgrenseNesteAr = inntektsgrenseNesteAr;
    }

    public int getInntektstakNesteAr() {
        return inntektstakNesteAr;
    }

    public void setInntektstakNesteAr(int inntektstakNesteAr) {
        this.inntektstakNesteAr = inntektstakNesteAr;
    }

    public int getOifuForBarnetillegg() {
        return oifuForBarnetillegg;
    }

    public void setOifuForBarnetillegg(int oifuForBarnetillegg) {
        this.oifuForBarnetillegg = oifuForBarnetillegg;
    }

    public void setKompensasjonsgrad(double kompensasjonsgrad) {
        this.kompensasjonsgrad = kompensasjonsgrad;
    }

    public void setOieu(int oieu) {
        this.oieu = oieu;
    }

    public void setOifu(int oifu) {
        this.oifu = oifu;
    }

    public void setUgradertBruttoPerAr(int ugradertBruttoPerAr) {
        this.ugradertBruttoPerAr = ugradertBruttoPerAr;
    }

    public void setUtbetalingsgrad(int utbetalingsgrad) {
        this.utbetalingsgrad = utbetalingsgrad;
    }

}
