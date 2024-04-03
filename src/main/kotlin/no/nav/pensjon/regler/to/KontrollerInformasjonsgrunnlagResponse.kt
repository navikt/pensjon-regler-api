package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.Merknad
import java.util.*

class KontrollerInformasjonsgrunnlagResponse : ServiceResponse() {
    var merknadListe: List<Merknad> = Vector()
}