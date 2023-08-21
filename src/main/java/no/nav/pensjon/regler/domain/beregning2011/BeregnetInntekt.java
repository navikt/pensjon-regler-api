package no.nav.pensjon.regler.domain.beregning2011;

import java.io.Serializable;

public class BeregnetInntekt implements Serializable {

    private static final long serialVersionUID = -1518936335627730994L;

    /** Sum av ytelse og andre inntekter for relevant bruker. */
    private int forventetInntekt;

    /** Faktisk utbetalt ytelse og fremskrevet ytelse fra folketrygden ved virk
     * som inngår i avkortning av barnetillegg. */
    private double ytelseFolketrygd;

    /** Faktisk utbetalt ytelse og fremskrevet ytelse som ikke er en del av folketrygden
     * ved virk som inngår i avkortning av barnetillegg. Feks. AFP privat  */
    private double ytelseIkkeFolketrygd;

    /** Sum av relevante inntekter fra inntektskomponenten. */
    private double inntektIK;

    /** Høyeste av akkumulert arbeidsinntekt hittil i år og forventet arbeidsinntekt. */
    private double inntektArbeid;

    /** Høyeste av akkumulert andre ytelser hittil i år og forventet andre ytelser. */
    private double andreYtelser;

    public BeregnetInntekt() {
    }

    public BeregnetInntekt(BeregnetInntekt beregnetInntekt) {
        forventetInntekt = beregnetInntekt.forventetInntekt;
        ytelseFolketrygd = beregnetInntekt.ytelseFolketrygd;
        ytelseIkkeFolketrygd = beregnetInntekt.ytelseIkkeFolketrygd;
        inntektIK = beregnetInntekt.inntektIK;
        inntektArbeid = beregnetInntekt.inntektArbeid;
        andreYtelser = beregnetInntekt.andreYtelser;
    }

    public int getForventetInntekt() {
        return forventetInntekt;
    }

    public void setForventetInntekt(int forventetInntekt) {
        this.forventetInntekt = forventetInntekt;
    }

    public double getYtelseFolketrygd() {
        return ytelseFolketrygd;
    }

    public void setYtelseFolketrygd(double ytelseFokletrygd) {
        this.ytelseFolketrygd = ytelseFokletrygd;
    }

    public double getYtelseIkkeFolketrygd() {
        return ytelseIkkeFolketrygd;
    }

    public void setYtelseIkkeFolketrygd(double ytelseIkkeFolketrygd) {
        this.ytelseIkkeFolketrygd = ytelseIkkeFolketrygd;
    }

    public double getInntektIK() {
        return inntektIK;
    }

    public void setInntektIK(double inntektIK) {
        this.inntektIK = inntektIK;
    }

    public double getInntektArbeid() {
        return inntektArbeid;
    }

    public void setInntektArbeid(double inntektArbeid) {
        this.inntektArbeid = inntektArbeid;
    }

    public double getAndreYtelser() {
        return andreYtelser;
    }

    public void setAndreYtelser(double andreFaktisk) {
        this.andreYtelser = andreFaktisk;
    }

}
