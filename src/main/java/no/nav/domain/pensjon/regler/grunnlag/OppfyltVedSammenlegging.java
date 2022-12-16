package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.AvtalelandCti;

import java.io.Serializable;

public class OppfyltVedSammenlegging implements Serializable {

    

    /**
     * Angir om kriteriet er oppfylt eller ikke.
     */
    boolean oppfylt;

    /**
     * Angir avtaleland.
     */
    AvtalelandCti avtaleland;

}
