package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.afpoppgjor.AfpEtteroppgjorKategori

import java.util.*

class KategoriserAfpEtteroppgjorResponse : ServiceResponse() {
    var afpEtteroppgjorKategoriListe = Vector<AfpEtteroppgjorKategori>()

}