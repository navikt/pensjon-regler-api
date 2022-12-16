package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;

public class Barnekull implements Serializable {


    /**
     * Antall barn i kullet.
     */
    int antallBarn;
    /**
     * Angir om persondetaljen brukes som grunnlag på kravet.
     */
    private boolean bruk;

}
