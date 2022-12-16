package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;

public class Delingstall implements Serializable {

    /**
     * Årskull delingstallet gjelder for. Eks. 1964.
     */
    private long arskull;
    /**
     * Alder for det gitte årskullet
     */
    private long alder;
    /*
     * Angir måned i året. 0 = januar, 11 = desember
     */
    private long maned;
    /**
     * Det gitte delingstall for et årskull, på en gitt alder, i en gitt måned.
     */
    private double delingstall;

}
