package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.EksportUnntakEnum
import no.nav.pensjon.regler.domain.enum.InngangUnntakEnum
import java.io.Serializable

class Unntak : Serializable {
    /**
     * Angir om personen har unntak eller ikke.
     */
    var unntak = false

    /**
     * Angir type unntak.
     */
    var unntakTypeEnum: InngangUnntakEnum? = null

    /**
     * Unntak fra eksportforbud.
     */
    var eksportUnntakEnum: EksportUnntakEnum? = null

}