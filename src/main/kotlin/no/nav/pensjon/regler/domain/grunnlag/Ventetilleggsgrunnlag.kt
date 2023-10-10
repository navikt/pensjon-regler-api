package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable

class Ventetilleggsgrunnlag : Serializable {
    /**
     * Ventetilleggprosenten.
     */
    var ventetilleggprosent: Double? = null

    /**
     * Sluttpoengtallet til søker ved 67 år.
     */
    var vt_spt: Double? = null

    /**
     * Sluttpoengtallet til søker ved 67 år relatert til overkompensasjon.
     */
    var vt_opt: Double? = null

    /**
     * Antall poengår til søker ved 67 år.
     */
    var vt_pa: Int? = null

    /**
     * Anvendt trygdetid til søker ved 67 år.
     */
    var tt_vent: Int? = null
}