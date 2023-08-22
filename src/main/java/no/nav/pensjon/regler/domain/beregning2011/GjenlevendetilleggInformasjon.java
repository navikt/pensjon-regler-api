package no.nav.pensjon.regler.domain.beregning2011;


import no.nav.pensjon.regler.domain.kode.YtelseVedDodCti;
import no.nav.pensjon.regler.domain.trygdetid.AnvendtTrygdetid;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Steinar Hjellvik (Decisive) - PK-11391
 */
public class GjenlevendetilleggInformasjon implements Serializable {

    private static final long serialVersionUID = 2365345949559700922L;

    /**
     * Avd�des beregningsgrunnlag.
     */

    private AbstraktBeregningsgrunnlag beregningsgrunnlagAvdodOrdiner;

    /**
     * Avd�des anvendte trygdetid.
     */

    private AnvendtTrygdetid anvendtTrygdetid;

    /**
     * D�dsdato.
     */

    private Date dodstidspunkt;

    /**
     * Hvis uf�r ved d�d er dette gjeldende uf�retidspunkt.
     */

    private Date uforetidspunkt;

    /**
     * Hvilken ytelse avd�d mottok ved sin d�d.
     */

    private YtelseVedDodCti ytelseVedDod;

    /**
     * Angir om avd�de ga opphav til gjenlevendepensjon.
     */

    private boolean gjenlevendepensjon;

    /**
     * Angir om ung uf�r ble anvendt for avd�de.
     */

    private boolean minsteYtelseBenyttetUngUfor;

    /**
     * Minsteytelsen med avd�des egen trygdetid.
     */

    private int minsteYtelseArsbelop;

    /**
     * Avd�des minsteytelsesats basert p� gjenlevendes sivilstand.
     */

    private double minsteYtelseSats;

    /**
     * Yrkesskade beregnet for avd�d.
     */

    private boolean yrkesskade;

    /**
     * Avd�des beregningsgrunnlag for yrkesskade.
     */

    private AbstraktBeregningsgrunnlag beregningsgrunnlagAvdodYrkesskade;

    /**
     * Skadetidspunkt ved yrkesskade.
     */

    private Date skadetidspunkt;

    /**
     * Avd�des yrkesskadegrad.
     */

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
