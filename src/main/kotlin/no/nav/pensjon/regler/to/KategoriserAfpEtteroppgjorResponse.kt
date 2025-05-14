package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.afpoppgjor.AfpEtteroppgjorKategori

import java.util.*

class KategoriserAfpEtteroppgjorResponse : ServiceResponse() {
    @Deprecated(
        "Avvikles, erstattes av 'afpEtteroppgjorgrunnlag'",
        replaceWith = ReplaceWith("afpEtteroppgjorgrunnlag")
    )
    var afpEtteroppgjorKategoriListe = Vector<AfpEtteroppgjorKategori>()
    var afpEtteroppgjorKategori: AfpEtteroppgjorKategori? = null
}