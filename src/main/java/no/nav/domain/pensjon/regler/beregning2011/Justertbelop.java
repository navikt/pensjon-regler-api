package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.GuiPrompt;

import java.io.Serializable;

/**
 * @author Aasmund Nordstoga (Accenture) PK-5549
 */
public class Justertbelop implements Serializable {

    private static final long serialVersionUID = 8226436523267966505L;

    @GuiPrompt(prompt = "Grunnbeløp per 01.05.2014")
    private int g01052014;

    @GuiPrompt(prompt = "Gjennomsnittlig grunnbeløp 2014")
    private int gjennomsnittligG2014;

    @GuiPrompt(prompt = "Justert beløp")
    private double justertbelop;

    @GuiPrompt(prompt = "Overgangsbeløp")
    private Overgangsbelop overgangsbelop;

    public Justertbelop() {
        super();
    }

    public Justertbelop(Justertbelop justertbelop) {
        this.g01052014 = justertbelop.g01052014;
        this.gjennomsnittligG2014 = justertbelop.gjennomsnittligG2014;
        this.justertbelop = justertbelop.justertbelop;
        if(justertbelop.overgangsbelop != null){
            this.overgangsbelop = new Overgangsbelop(justertbelop.overgangsbelop);
        }
    }

    public int getG01052014() {
        return g01052014;
    }

    public void setG01052014(int g01052014) {
        this.g01052014 = g01052014;
    }

    public int getGjennomsnittligG2014() {
        return gjennomsnittligG2014;
    }

    public void setGjennomsnittligG2014(int gjennomsnittligG2014) {
        this.gjennomsnittligG2014 = gjennomsnittligG2014;
    }

    public double getJustertbelop() {
        return justertbelop;
    }

    public void setJustertbelop(double justertbelop) {
        this.justertbelop = justertbelop;
    }

    public Overgangsbelop getOvergangsbelop() {
        return overgangsbelop;
    }

    public void setOvergangsbelop(Overgangsbelop overgangsbelop) {
        this.overgangsbelop = overgangsbelop;
    }
}
