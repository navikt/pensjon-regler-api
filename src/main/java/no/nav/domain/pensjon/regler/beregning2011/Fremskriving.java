package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.FremskrevetMPNTypeCti;

public interface Fremskriving {

    public void setTeller(int teller);

    public int getTeller();

    public void setNevner(int nevner);

    public int getNevner();

    public void setBrok(double brok);

    public double getBrok();

    public void setType(FremskrevetMPNTypeCti type);

    public FremskrevetMPNTypeCti getType();
}
