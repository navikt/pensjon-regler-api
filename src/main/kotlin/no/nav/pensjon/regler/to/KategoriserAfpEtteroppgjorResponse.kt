package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.afpoppgjor.AfpEtteroppgjorKategori

class KategoriserAfpEtteroppgjorResponse : ServiceResponse() {
    var afpEtteroppgjorKategori: AfpEtteroppgjorKategori? = null
}