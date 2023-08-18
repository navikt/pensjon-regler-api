package no.nav.pensjon.regler.domain.beregning2011;

/**
 * PK-27754: Innførte nytt felt som skal være på alle uføretrygdytelser.
 */
public interface UforetrygdYtelseskomponent{
    public int getTidligereBelopAr();
    public void setTidligereBelopAr(int tidligereBelopAr);
}
