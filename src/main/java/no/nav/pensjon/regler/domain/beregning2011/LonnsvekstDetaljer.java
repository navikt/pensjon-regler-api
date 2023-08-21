package no.nav.pensjon.regler.domain.beregning2011;

import java.io.Serializable;
import java.util.Date;

public class LonnsvekstDetaljer implements Serializable, ILonnsvekst {

    private static final long serialVersionUID = 3154627167523454725L;

    private Date justeringTomDato;
    private double justeringsfaktor;
    private double lonnsvekst;

    public LonnsvekstDetaljer() {
        super();
    }

    public LonnsvekstDetaljer(LonnsvekstDetaljer lvd) {
        this();
        if (lvd.justeringTomDato != null) {
            justeringTomDato = (Date) lvd.justeringTomDato.clone();
        }
        justeringsfaktor = lvd.justeringsfaktor;
        lonnsvekst = lvd.lonnsvekst;

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
    public double getLonnsvekst() {
        return lonnsvekst;
    }

    @Override
    public void setLonnsvekst(double lonnsvekst) {
        this.lonnsvekst = lonnsvekst;
    }
}
