package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.kode.VilkarOppfyltUTCti
import java.io.Serializable

abstract class AbstraktVilkar : Serializable {

    var resultat: VilkarOppfyltUTCti? = null

}