package no.nav.pensjon.regler.domain.trygdetid;



import java.io.Serializable;

/**
 * Brøk som brukes til
 * - (prorata) beregning av pensjon
 * - antall måneder barnetillegg
 */
public class Brok implements Serializable {

    private static final long serialVersionUID = -3772670089952086803L;

    /**
     * Brøkens teller.
     */

    private int teller;

    /**
     * Brøkens nevner.
     */

    private int nevner;

    public Brok() {
        super();
    }

    public Brok(Brok brok) {
        super();
        teller = brok.teller;
        nevner = brok.nevner;
    }

    public Brok(int teller, int nevner) {
        super();
        this.teller = teller;
        this.nevner = nevner;
    }

    public int getTeller() {
        return teller;
    }

    public void setTeller(int teller) {
        this.teller = teller;
    }

    public int getNevner() {
        return nevner;
    }

    public void setNevner(int nevner) {
        this.nevner = nevner;
    }

}
