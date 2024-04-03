package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.afpoppgjor.AFPetteroppgjor

import java.util.*

class BeregnAfpEtteroppgjorResponse : ServiceResponse() {
    var afpEtteroppgjorListe = Vector<AFPetteroppgjor>()
}