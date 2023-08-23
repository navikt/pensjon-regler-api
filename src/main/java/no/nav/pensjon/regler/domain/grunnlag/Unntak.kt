package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.kode.EksportUnntakCti
import no.nav.pensjon.regler.domain.kode.InngangUnntakCti
import java.io.Serializable

class Unntak : Serializable {
    /**
     * Angir om personen har unntak eller ikke.
     */
    var isUnntak = false

    /**
     * Angir type unntak.
     */
    var unntakType: InngangUnntakCti? = null

    /**
     * Unntak fra eksportforbud.
     */
    var eksportUnntak: EksportUnntakCti? = null

}