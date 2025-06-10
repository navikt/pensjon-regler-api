package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.afpoppgjor.AFPEtteroppgjorgrunnlag

class KategoriserAfpEtteroppgjorRequest(
    var afpEtteroppgjorgrunnlag: AFPEtteroppgjorgrunnlag? = null
) : ServiceRequest()