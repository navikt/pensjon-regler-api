package no.nav.domain.pensjon.regler.trygdetid;

import java.io.Serializable;

/**
 * Brøk som brukes til
 * - (prorata) beregning av pensjon
 * - antall måneder barnetillegg
 */
public class Brok implements Serializable {



    /**
     * Brøkens teller.
     */
    private int teller;

    /**
     * Brøkens nevner.
     */
    private int nevner;


}
