package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.afpoppgjor.AFPetteroppgjor
import java.io.Serializable
import java.util.*

class BeregnAfpEtteroppgjorResponse : Serializable {
    var afpEtteroppgjorListe = Vector<AFPetteroppgjor>()
}