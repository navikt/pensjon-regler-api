package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*

class VilkarsprovResponse : ServiceResponse() {
    var vedtaksliste: MutableList<VilkarsVedtak> = Vector()
}