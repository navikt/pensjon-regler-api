package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.afpoppgjor.AFPEtteroppgjorgrunnlag
import java.util.*

class KategoriserAfpEtteroppgjorRequest {
    var afpEtteroppgjorgrunnlagListe = mutableListOf<AFPEtteroppgjorgrunnlag>()
}