package no.nav.domain.pensjon.regler.trygdetid;

import java.io.Serializable;

/**
 * Br�k som brukes til
 * - (prorata) beregning av pensjon
 * - antall m�neder barnetillegg
 */
public class Brok implements Serializable {



    /**
     * Br�kens teller.
     */
    private int teller;

    /**
     * Br�kens nevner.
     */
    private int nevner;


}
