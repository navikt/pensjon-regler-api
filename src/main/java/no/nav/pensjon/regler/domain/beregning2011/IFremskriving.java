package no.nav.pensjon.regler.domain.beregning2011;

public interface IFremskriving extends IJustering {

    public abstract double getTeller();

    public abstract void setTeller(double teller);

    public abstract double getNevner();

    public abstract void setNevner(double nevner);
}
