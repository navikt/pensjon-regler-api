package no.nav.pensjon.regler.domain.beregning2011;


import no.nav.pensjon.regler.domain.kode.FormelKodeCti;

import java.io.Serializable;

/**
 * @author Aasmund Nordstoga (Accenture) PK-5549
 */
public class Overgangsbelop implements Serializable {

    private static final long serialVersionUID = 2894452390016921661L;


    private FormelKodeCti formelKode;


    private int gpBrutto;


    private double gpSats;


    private double overgangsbelop;


    private int stBrutto;


    private int tpBrutto;

    public Overgangsbelop() {
        super();
    }

    public Overgangsbelop(Overgangsbelop overgangsbelop) {
        if (overgangsbelop.formelKode != null) {
            this.formelKode = new FormelKodeCti(overgangsbelop.formelKode);
        }
        this.gpBrutto = overgangsbelop.gpBrutto;
        this.gpSats = overgangsbelop.gpSats;
        this.overgangsbelop = overgangsbelop.overgangsbelop;
        this.stBrutto = overgangsbelop.stBrutto;
        this.tpBrutto = overgangsbelop.tpBrutto;
    }

    public FormelKodeCti getFormelKode() {
        return formelKode;
    }

    public void setFormelKode(FormelKodeCti formelKode) {
        this.formelKode = formelKode;
    }

    public int getGpBrutto() {
        return gpBrutto;
    }

    public void setGpBrutto(int gpBrutto) {
        this.gpBrutto = gpBrutto;
    }

    public double getGpSats() {
        return gpSats;
    }

    public void setGpSats(double gpSats) {
        this.gpSats = gpSats;
    }

    public double getOvergangsbelop() {
        return overgangsbelop;
    }

    public void setOvergangsbelop(double overgangsbelop) {
        this.overgangsbelop = overgangsbelop;
    }

    public int getStBrutto() {
        return stBrutto;
    }

    public void setStBrutto(int stBrutto) {
        this.stBrutto = stBrutto;
    }

    public int getTpBrutto() {
        return tpBrutto;
    }

    public void setTpBrutto(int tpBrutto) {
        this.tpBrutto = tpBrutto;
    }
}
