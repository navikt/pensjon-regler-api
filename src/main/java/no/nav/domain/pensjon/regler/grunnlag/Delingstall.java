package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;

public class Delingstall implements Serializable {

    /**
     * �rskull delingstallet gjelder for. Eks. 1964.
     */
    private long arskull;
    /**
     * Alder for det gitte �rskullet
     */
    private long alder;
    /*
     * Angir m�ned i �ret. 0 = januar, 11 = desember
     */
    private long maned;
    /**
     * Det gitte delingstall for et �rskull, p� en gitt alder, i en gitt m�ned.
     */
    private double delingstall;

}
