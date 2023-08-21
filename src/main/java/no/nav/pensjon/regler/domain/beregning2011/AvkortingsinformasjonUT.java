package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.GuiPrompt;

import java.io.Serializable;

/**
 * Angir detaljer rund avkortingen av uføretrygd.
 */
public class AvkortingsinformasjonUT extends AbstraktAvkortingsinformasjon implements Serializable {

    private static final long serialVersionUID = -4831919123994190973L;

    /**
     * Beløpsgrense.
     */
    @GuiPrompt(prompt = "Beløpsgrense")
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
     * Inntektsgrense nest år settes når neste års inntektsgrense beregnes
     */
    @GuiPrompt(prompt = "Inntektsgrense neste år")
    private int inntektsgrenseNesteAr;

    /**
     * Inntektstaket for påfølgende år fastsatt på bakgrunn av siste gjeldende OIFU i året. Feltet er kun angitt dersom inntektstak neste år avviker fra gjeldende inntektstak.
     */
    @GuiPrompt(prompt = "Inntektstak neste år")
    private int inntektstakNesteAr;
    /**
     * Angir dekningsgrad av tapt arbeidsevne.
     */
    @GuiPrompt(prompt = "Dekningsgrad av tapt arbeidsevne")
    private double kompensasjonsgrad;

    /**
     * Oppjustert inntekt etter uførhet.
     */
    @GuiPrompt(prompt = "Oppjustert inntekt etter uførhet")
    private int oieu;

    /**
     * Oppjustert inntekt før uførhet.
     */
    @GuiPrompt(prompt = "Oppjustert inntekt før uførhet")
    private int oifu;

    /**
     * Den OIFU som er angitt i beregningsperioden. Denne er ikke nødvendigvis den høyeste i året og skal benyttes for beregning av brutto barnetillegg.
     */
    @GuiPrompt(prompt = "Oppjustert inntekt før uførhet for barnetillegg")
    private int oifuForBarnetillegg;

    /**
     * Beregnet årlig bruttobeløp etter full uføregrad.
     */
    @GuiPrompt(prompt = "Brutto per år, ugradert")
    private int ugradertBruttoPerAr;

    /**
     * Utbetalingsgrad etter inntektsavkorting.
     */
    @GuiPrompt(prompt = "Utbetalingsgrad etter inntektsavkorting")
    private int utbetalingsgrad;

    /**
     * Beløpet som skal legges til avkortningsbeløpet for å få fradraget som er nødvendig for å kompensere for tidligere for lite eller mye avkortet.
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
