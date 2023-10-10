package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.afpoppgjor.AfpEtteroppgjorKategori
import java.io.Serializable
import java.util.*

class KategoriserAfpEtteroppgjorResponse : Serializable {
    var afpEtteroppgjorKategoriListe = Vector<AfpEtteroppgjorKategori>()

}