package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.afpoppgjor.AFPetteroppgjor

class BeregnAfpEtteroppgjorResponse : ServiceResponse() {
    var afpEtteroppgjor: AFPetteroppgjor? = null
}