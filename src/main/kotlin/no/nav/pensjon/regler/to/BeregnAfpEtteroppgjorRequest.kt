package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.afpoppgjor.AFPEtteroppgjorgrunnlag
import java.util.*

class BeregnAfpEtteroppgjorRequest(
    @Deprecated(
        "Avvikles, erstattes av 'afpEtteroppgjorgrunnlag'",
        replaceWith = ReplaceWith("afpEtteroppgjorgrunnlag")
    )
    var afpEtteroppgjorgrunnlagListe: Vector<AFPEtteroppgjorgrunnlag> = Vector<AFPEtteroppgjorgrunnlag>(),
    var afpEtteroppgjorgrunnlag: AFPEtteroppgjorgrunnlag? = null
) : ServiceRequest()