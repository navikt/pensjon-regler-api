package no.nav.domain.pensjon.regler.beregning2011;

import java.io.Serializable;
import java.util.Date;

public class GReguleringDetaljer implements Serializable, IGRegulering {



    private Date justeringTomDato;
    private double justeringsfaktor;
    private int forrigeG;
    private int gjeldendeG;

    public GReguleringDetaljer() {
        super();
    }

    public GReguleringDetaljer(GReguleringDetaljer greg) {
        this();
        if (greg.justeringTomDato != null) {
            justeringTomDato = (Date) greg.justeringTomDato.clone();
        }
        justeringsfaktor = greg.justeringsfaktor;
        forrigeG = greg.forrigeG;
        gjeldendeG = greg.gjeldendeG;
    }

    @Override
    public Date getJusteringTomDato() {
        return justeringTomDato;
    }

    @Override
    public double getJusteringsfaktor() {
        return justeringsfaktor;
    }

    @Override
    public void setJusteringTomDato(Date justeringTomDato) {
        this.justeringTomDato = justeringTomDato;
    }

    @Override
    public void setJusteringsfaktor(double justeringsfaktor) {
        this.justeringsfaktor = justeringsfaktor;
    }

    @Override
    public int getForrigeG() {
        return forrigeG;
    }

    @Override
    public void setForrigeG(int forrigeG) {
        this.forrigeG = forrigeG;
    }

    @Override
    public int getGjeldendeG() {
        return gjeldendeG;
    }

    @Override
    public void setGjeldendeG(int gjeldendeG) {
        this.gjeldendeG = gjeldendeG;
    }

}
