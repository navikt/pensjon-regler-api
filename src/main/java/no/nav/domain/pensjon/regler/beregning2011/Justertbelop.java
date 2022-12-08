package no.nav.domain.pensjon.regler.beregning2011;

import java.io.Serializable;

/**
 * @author Aasmund Nordstoga (Accenture) PK-5549
 */
public class Justertbelop implements Serializable {

    

    private int g01052014;

    private int gjennomsnittligG2014;

    private double justertbelop;

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
