package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.EksportUnntakEnum
import java.io.Serializable

class Eksportforbud : Serializable {
    /**
     * Angir om personen har eksportforbud eller ikke.
     */
    var forbud = false

    /**
     * Angir type eksportunntak.
     */
    var unntakTypeEnum: EksportUnntakEnum? = null
}