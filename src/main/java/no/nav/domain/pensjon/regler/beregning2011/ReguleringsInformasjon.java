package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.GuiPrompt;

import java.io.Serializable;

public class ReguleringsInformasjon implements Serializable {
    private static final long serialVersionUID = -8046515500454507355L;

    @GuiPrompt(prompt = "L�nnsvekst")
    private double lonnsvekst;

    @GuiPrompt(prompt = "Fratrekksfaktor")
    private double fratrekksfaktor;

    @GuiPrompt(prompt = "Gammelt grunnbel�p")
    private int gammelG;

    @GuiPrompt(prompt = "Nytt grunnbel�p")
    private int nyG;

    @GuiPrompt(prompt = "Reguleringsfaktor")
    private double reguleringsfaktor;

    @GuiPrompt(prompt = "Gjennomsnittlig uttaksgrad siste �r")
    private double gjennomsnittligUttaksgradSisteAr;

    @GuiPrompt(prompt = "Reguleringsbel�p")
    private double reguleringsbelop;

    @GuiPrompt(prompt = "Faktor som vil v�re gjennomsnittet av pris og l�nnvekst")
    private double prisOgLonnsvekst;

    public ReguleringsInformasjon() {
        super();
    }

    public ReguleringsInformasjon(ReguleringsInformasjon r) {
        this();
        lonnsvekst = r.lonnsvekst;
        fratrekksfaktor = r.fratrekksfaktor;
        gammelG = r.gammelG;
        nyG = r.nyG;
        reguleringsfaktor = r.reguleringsfaktor;
        gjennomsnittligUttaksgradSisteAr = r.gjennomsnittligUttaksgradSisteAr;
        reguleringsbelop = r.reguleringsbelop;
        prisOgLonnsvekst = r.prisOgLonnsvekst;
    }

    /**
     * @return the lonnsvekst
     */
    public double getLonnsvekst() {
        return lonnsvekst;
    }

    /**
     * @param lonnsvekst the lonnsvekst to set
     */
    public void setLonnsvekst(double lonnsvekst) {
        this.lonnsvekst = lonnsvekst;
    }

    /**
     * @return the fratrekksfaktor
     */
    public double getFratrekksfaktor() {
        return fratrekksfaktor;
    }

    /**
     * @param fratrekksfaktor the fratrekksfaktor to set
     */
    public void setFratrekksfaktor(double fratrekksfaktor) {
        this.fratrekksfaktor = fratrekksfaktor;
    }

    /**
     * @return the gammelG
     */
    public int getGammelG() {
        return gammelG;
    }

    /**
     * @param gammelG the gammelG to set
     */
    public void setGammelG(int gammelG) {
        this.gammelG = gammelG;
    }

    /**
     * @return the nyG
     */
    public int getNyG() {
        return nyG;
    }

    /**
     * @param nyG the nyG to set
     */
    public void setNyG(int nyG) {
        this.nyG = nyG;
    }

    /**
     * @return the reguleringsfaktor
     */
    public double getReguleringsfaktor() {
        return reguleringsfaktor;
    }

    /**
     * @param reguleringsfaktor the reguleringsfaktor to set
     */
    public void setReguleringsfaktor(double reguleringsfaktor) {
        this.reguleringsfaktor = reguleringsfaktor;
    }

    /**
     * @return the gjennomsnittligUttaksgradSisteAr
     */
    public double getGjennomsnittligUttaksgradSisteAr() {
        return gjennomsnittligUttaksgradSisteAr;
    }

    /**
     * @param gjennomsnittligUttaksgradSisteAr the gjennomsnittligUttaksgradSisteAr to set
     */
    public void setGjennomsnittligUttaksgradSisteAr(double gjennomsnittligUttaksgradSisteAr) {
        this.gjennomsnittligUttaksgradSisteAr = gjennomsnittligUttaksgradSisteAr;
    }

    public void setReguleringsbelop(double reguleringsbelop) {
        this.reguleringsbelop = reguleringsbelop;
    }

    public double getReguleringsbelop() {
        return reguleringsbelop;
    }

    public double getPrisOgLonnsvekst() {
        return prisOgLonnsvekst;
    }

    public void setPrisOgLonnsvekst(double prisOgLonnsvekst) {
        this.prisOgLonnsvekst = prisOgLonnsvekst;
    }

}
