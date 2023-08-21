package no.nav.pensjon.regler.domain.beregning2011;

public interface IGRegulering extends IJustering {

    public int getForrigeG();

    public void setForrigeG(int forrigeG);

    public int getGjeldendeG();

    public void setGjeldendeG(int gjeldendeG);
}
