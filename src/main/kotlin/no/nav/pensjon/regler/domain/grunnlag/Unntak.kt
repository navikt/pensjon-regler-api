package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.EksportUnntakEnum
import no.nav.pensjon.regler.domain.enum.InngangUnntakEnum
import no.nav.pensjon.regler.domain.kode.EksportUnntakCti
import no.nav.pensjon.regler.domain.kode.InngangUnntakCti
import java.io.Serializable

class Unntak : Serializable {
    /**
     * Angir om personen har unntak eller ikke.
     */
    var unntak = false

    /**
     * Angir type unntak.
     */
    var unntakType: InngangUnntakCti? = null
    var unntakTypeEnum: InngangUnntakEnum? = null

    /**
     * Unntak fra eksportforbud.
     */
    var eksportUnntak: EksportUnntakCti? = null
    var eksportUnntakEnum: EksportUnntakEnum? = null

}