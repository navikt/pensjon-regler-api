package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.afpoppgjor.AFPEtteroppgjorgrunnlag

class BeregnAfpEtteroppgjorRequest(
    var afpEtteroppgjorgrunnlag: AFPEtteroppgjorgrunnlag? = null
) : ServiceRequest()