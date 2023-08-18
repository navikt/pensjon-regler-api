package no.nav.pensjon.regler.domain.beregning2011;

import java.io.Serializable;
import java.util.Date;

public class FremskrivingsDetaljer implements Serializable, IFremskriving {

    private static final long serialVersionUID = 1574525081526453384L;

    private Date justeringTomDato;
    private double justeringsfaktor;
    private double teller;
    private double nevner;
    private int arskull;

    public FremskrivingsDetaljer() {
        super();
    }

    public FremskrivingsDetaljer(FremskrivingsDetaljer frem) {
        this();
        if (frem.justeringTomDato != null) {
            justeringTomDato = (Date) frem.justeringTomDato.clone();
        }
        justeringsfaktor = frem.justeringsfaktor;
        teller = frem.teller;
        nevner = frem.nevner;
        arskull = frem.arskull;
    }

    @Override
    public double getJusteringsfaktor() {
        return justeringsfaktor;
    }

    @Override
    public void setJusteringsfaktor(double justeringsfaktor) {
        this.justeringsfaktor = justeringsfaktor;
    }

    @Override
    public Date getJusteringTomDato() {
        return justeringTomDato;
    }

    @Override
    public void setJusteringTomDato(Date justeringTomDato) {
        this.justeringTomDato = justeringTomDato;
    }

    @Override
    public double getNevner() {
        return nevner;
    }

    @Override
    public void setNevner(double nevner) {
        this.nevner = nevner;
    }

    @Override
    public double getTeller() {
        return teller;
    }

    @Override
    public void setTeller(double teller) {
        this.teller = teller;
    }

    public int getArskull() {
        return arskull;
    }

    public void setArskull(int arskull) {
        this.arskull = arskull;
    }
}
