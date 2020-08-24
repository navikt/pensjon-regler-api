package no.nav.domain.pensjon.regler.beregning2011;

import java.util.Date;

public interface IJustering {

    public abstract double getJusteringsfaktor();

    public abstract void setJusteringsfaktor(double justeringsfaktor);

    public abstract Date getJusteringTomDato();

    public abstract void setJusteringTomDato(Date justeringTomDato);
}
