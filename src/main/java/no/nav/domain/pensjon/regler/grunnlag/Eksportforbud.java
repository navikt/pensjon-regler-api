package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.EksportUnntakCti;

import java.io.Serializable;

public class Eksportforbud implements Serializable {



    /**
     * Angir om personen har eksportforbud eller ikke.
     */
    boolean forbud;

    /**
     * Angir type eksportunntak.
     */
    EksportUnntakCti unntakType;


}
