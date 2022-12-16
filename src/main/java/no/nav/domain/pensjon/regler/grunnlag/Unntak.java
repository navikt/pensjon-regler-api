package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.EksportUnntakCti;
import no.nav.domain.pensjon.regler.kode.InngangUnntakCti;

import java.io.Serializable;

public class Unntak implements Serializable {

    /**
     * Angir om personen har unntak eller ikke.
     */
    boolean unntak;

    /**
     * Angir type unntak.
     */
    InngangUnntakCti unntakType;

    /**
     * Unntak fra eksportforbud.
     */
    EksportUnntakCti eksportUnntak;


}
