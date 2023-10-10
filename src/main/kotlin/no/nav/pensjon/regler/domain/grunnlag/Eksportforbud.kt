package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.kode.EksportUnntakCti
import java.io.Serializable

class Eksportforbud : Serializable {
    /**
     * Angir om personen har eksportforbud eller ikke.
     */
    var forbud = false

    /**
     * Angir type eksportunntak.
     */
    var unntakType: EksportUnntakCti? = null
}