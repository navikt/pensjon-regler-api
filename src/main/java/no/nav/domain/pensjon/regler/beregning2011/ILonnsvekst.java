package no.nav.domain.pensjon.regler.beregning2011;

public interface ILonnsvekst extends IJustering {

    public abstract double getLonnsvekst();

    public abstract void setLonnsvekst(double lonnsvekst);
}
