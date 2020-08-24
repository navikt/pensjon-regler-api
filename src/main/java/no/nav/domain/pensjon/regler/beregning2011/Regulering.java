package no.nav.domain.pensjon.regler.beregning2011;

public interface Regulering {

    public void setGap(int gap);

    public int getGap();

    public void setReguleringsfaktor(double reguleringsfaktor);

    public double getReguleringsfaktor();
}
