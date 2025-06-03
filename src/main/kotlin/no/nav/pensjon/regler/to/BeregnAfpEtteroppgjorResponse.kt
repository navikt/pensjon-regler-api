package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.afpoppgjor.AFPetteroppgjor

import java.util.*

class BeregnAfpEtteroppgjorResponse : ServiceResponse() {
    @Deprecated(
        "Avvikles, erstattes av 'afpEtteroppgjor'",
        replaceWith = ReplaceWith("afpEtteroppgjor")
    )
    var afpEtteroppgjorListe: Vector<AFPetteroppgjor>? = Vector<AFPetteroppgjor>()
    var afpEtteroppgjor: AFPetteroppgjor? = null
}