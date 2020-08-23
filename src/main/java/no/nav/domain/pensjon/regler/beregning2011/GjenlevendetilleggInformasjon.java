package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.GuiPrompt;
import no.nav.domain.pensjon.regler.kode.YtelseVedDodCti;
import no.nav.domain.pensjon.regler.trygdetid.AnvendtTrygdetid;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Steinar Hjellvik (Decisive) - PK-11391
 */
public class GjenlevendetilleggInformasjon implements Serializable {

    private static final long serialVersionUID = 2365345949559700922L;

    /**
     * Avdødes beregningsgrunnlag.
     */
    @GuiPrompt(prompt = "Avdødes beregningsgrunnlag")
    private AbstraktBeregningsgrunnlag beregningsgrunnlagAvdodOrdiner;

    /**
     * Avdødes anvendte trygdetid.
     */
    @GuiPrompt(prompt = "Avdødes anvendte trygdetid")
    private AnvendtTrygdetid anvendtTrygdetid;

    /**
     * Dødsdato.
     */
    @GuiPrompt(prompt = "Dødsdato")
    private Date dodstidspunkt;

    /**
     * Hvis ufør ved død er dette gjeldende uføretidspunkt.
     */
    @GuiPrompt(prompt = "Uføretidspunkt hvis ufør ved død")
    private Date uforetidspunkt;

    /**
     * Hvilken ytelse avdød mottok ved sin død.
     */
    @GuiPrompt(prompt = "Ytelse ved død")
    private YtelseVedDodCti ytelseVedDod;

    /**
     * Angir om avdøde ga opphav til gjenlevendepensjon.
     */
    @GuiPrompt(prompt = "Avdød ga opphav til gjenlevendepensjon")
    private boolean gjenlevendepensjon;

    /**
     * Angir om ung ufør ble anvendt for avdøde.
     */
    @GuiPrompt(prompt = "Ung ufør anvendt for avdøde")
    private boolean minsteYtelseBenyttetUngUfor;

    /**
     * Minsteytelsen med avdødes egen trygdetid.
     */
    @GuiPrompt(prompt = "Minsteytelse med avdødes trygdetid")
    private int minsteYtelseArsbelop;

    /**
     * Avdødes minsteytelsesats basert på gjenlevendes sivilstand.
     */
    @GuiPrompt(prompt = "Minsteytelse sats")
    private double minsteYtelseSats;

    /**
     * Yrkesskade beregnet for avdød.
     */
    @GuiPrompt(prompt = "Yrkesskade beregnet for avdød")
    private boolean yrkesskade;

    /**
     * Avdødes beregningsgrunnlag for yrkesskade.
     */
    @GuiPrompt(prompt = "Avdødes yrkesskade beregningsgrunnlag")
    private AbstraktBeregningsgrunnlag beregningsgrunnlagAvdodYrkesskade;

    /**
     * Skadetidspunkt ved yrkesskade.
     */
    @GuiPrompt(prompt = "Skadetidspunkt ved yrkesskade")
    private Date skadetidspunkt;

    /**
     * Avdødes yrkesskadegrad.
     */
    @GuiPrompt(prompt = "Avdødes yrkesskadegrad")
    private int yrkesskadegrad;

    public GjenlevendetilleggInformasjon() {
    }

    public GjenlevendetilleggInformasjon(GjenlevendetilleggInformasjon gjenlevendetilleggInformasjon) {
        if (gjenlevendetilleggInformasjon.anvendtTrygdetid != null){
            this.anvendtTrygdetid = new AnvendtTrygdetid(gjenlevendetilleggInformasjon.anvendtTrygdetid);
        }
        if (gjenlevendetilleggInformasjon.dodstidspunkt != null){
            this.dodstidspunkt = (Date)gjenlevendetilleggInformasjon.dodstidspunkt.clone();
        }
        if (gjenlevendetilleggInformasjon.uforetidspunkt != null){
            this.uforetidspunkt = (Date)gjenlevendetilleggInformasjon.uforetidspunkt.clone();
        }
        if (gjenlevendetilleggInformasjon.ytelseVedDod !=  null){
            this.ytelseVedDod = new YtelseVedDodCti(gjenlevendetilleggInformasjon.ytelseVedDod);
        }
        this.gjenlevendepensjon = gjenlevendetilleggInformasjon.gjenlevendepensjon;
        this.minsteYtelseBenyttetUngUfor = gjenlevendetilleggInformasjon.minsteYtelseBenyttetUngUfor;
        this.minsteYtelseArsbelop = gjenlevendetilleggInformasjon.minsteYtelseArsbelop;
        this.minsteYtelseSats = gjenlevendetilleggInformasjon.minsteYtelseSats;
        this.yrkesskade = gjenlevendetilleggInformasjon.yrkesskade;
        if (gjenlevendetilleggInformasjon.skadetidspunkt != null){
            this.skadetidspunkt = (Date)gjenlevendetilleggInformasjon.skadetidspunkt.clone();
        }
        this.yrkesskadegrad = gjenlevendetilleggInformasjon.yrkesskadegrad;
        if (gjenlevendetilleggInformasjon.beregningsgrunnlagAvdodOrdiner != null){
            if (gjenlevendetilleggInformasjon.beregningsgrunnlagAvdodOrdiner instanceof BeregningsgrunnlagOrdiner) {
                this.beregningsgrunnlagAvdodOrdiner = new BeregningsgrunnlagOrdiner((BeregningsgrunnlagOrdiner) gjenlevendetilleggInformasjon.beregningsgrunnlagAvdodOrdiner);
            } else if (gjenlevendetilleggInformasjon.beregningsgrunnlagAvdodOrdiner instanceof BeregningsgrunnlagKonvertert) {
                this.beregningsgrunnlagAvdodOrdiner = new BeregningsgrunnlagKonvertert((BeregningsgrunnlagKonvertert) gjenlevendetilleggInformasjon.beregningsgrunnlagAvdodOrdiner);
            }
        }
        if (gjenlevendetilleggInformasjon.beregningsgrunnlagAvdodYrkesskade != null) {
            if (gjenlevendetilleggInformasjon.beregningsgrunnlagAvdodYrkesskade instanceof BeregningsgrunnlagYrkesskade) {
                this.beregningsgrunnlagAvdodYrkesskade = new BeregningsgrunnlagYrkesskade((BeregningsgrunnlagYrkesskade) gjenlevendetilleggInformasjon.beregningsgrunnlagAvdodYrkesskade);
            } else if (gjenlevendetilleggInformasjon.beregningsgrunnlagAvdodYrkesskade instanceof BeregningsgrunnlagKonvertert) {
                this.beregningsgrunnlagAvdodYrkesskade = new BeregningsgrunnlagKonvertert((BeregningsgrunnlagKonvertert) gjenlevendetilleggInformasjon.beregningsgrunnlagAvdodYrkesskade);
            }
        }

    }

    public AbstraktBeregningsgrunnlag getBeregningsgrunnlagAvdodOrdiner() {
        return beregningsgrunnlagAvdodOrdiner;
    }

    public void setBeregningsgrunnlagAvdodOrdiner(AbstraktBeregningsgrunnlag beregningsgrunnlagAvdodOrdiner) {
        this.beregningsgrunnlagAvdodOrdiner = beregningsgrunnlagAvdodOrdiner;
    }

    public AnvendtTrygdetid getAnvendtTrygdetid() {
        return anvendtTrygdetid;
    }

    public void setAnvendtTrygdetid(AnvendtTrygdetid anvendtTrygdetid) {
        this.anvendtTrygdetid = anvendtTrygdetid;
    }

    public Date getDodstidspunkt() {
        return dodstidspunkt;
    }

    public void setDodstidspunkt(Date dodstidspunkt) {
        this.dodstidspunkt = dodstidspunkt;
    }

    public Date getUforetidspunkt() {
        return uforetidspunkt;
    }

    public void setUforetidspunkt(Date uforetidspunkt) {
        this.uforetidspunkt = uforetidspunkt;
    }

    public YtelseVedDodCti getYtelseVedDod() {
        return ytelseVedDod;
    }

    public void setYtelseVedDod(YtelseVedDodCti ytelseVedDod) {
        this.ytelseVedDod = ytelseVedDod;
    }

    public boolean isGjenlevendepensjon() {
        return gjenlevendepensjon;
    }

    public void setGjenlevendepensjon(boolean gjenlevendepensjon) {
        this.gjenlevendepensjon = gjenlevendepensjon;
    }

    public boolean isMinsteYtelseBenyttetUngUfor() {
        return minsteYtelseBenyttetUngUfor;
    }

    public void setMinsteYtelseBenyttetUngUfor(boolean minsteYtelseBenyttetUngUfor) {
        this.minsteYtelseBenyttetUngUfor = minsteYtelseBenyttetUngUfor;
    }

    public int getMinsteYtelseArsbelop() {
        return minsteYtelseArsbelop;
    }

    public void setMinsteYtelseArsbelop(int minsteYtelseArsbelop) {
        this.minsteYtelseArsbelop = minsteYtelseArsbelop;
    }

    public double getMinsteYtelseSats() {
        return minsteYtelseSats;
    }

    public void setMinsteYtelseSats(double minsteYtelseSats) {
        this.minsteYtelseSats = minsteYtelseSats;
    }

    public boolean isYrkesskade() {
        return yrkesskade;
    }

    public void setYrkesskade(boolean yrkesskade) {
        this.yrkesskade = yrkesskade;
    }

    public AbstraktBeregningsgrunnlag getBeregningsgrunnlagAvdodYrkesskade() {
        return beregningsgrunnlagAvdodYrkesskade;
    }

    public void setBeregningsgrunnlagAvdodYrkesskade(AbstraktBeregningsgrunnlag beregningsgrunnlagAvdodYrkesskade) {
        this.beregningsgrunnlagAvdodYrkesskade = beregningsgrunnlagAvdodYrkesskade;
    }

    public Date getSkadetidspunkt() {
        return skadetidspunkt;
    }

    public void setSkadetidspunkt(Date skadetidspunkt) {
        this.skadetidspunkt = skadetidspunkt;
    }

    public int getYrkesskadegrad() {
        return yrkesskadegrad;
    }

    public void setYrkesskadegrad(int yrkesskadegrad) {
        this.yrkesskadegrad = yrkesskadegrad;
    }

}
