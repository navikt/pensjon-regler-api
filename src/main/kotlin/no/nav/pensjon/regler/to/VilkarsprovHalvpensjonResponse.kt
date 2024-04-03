package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak

class VilkarsprovHalvpensjonResponse : ServiceResponse() {
    var vilkarsvedtak: VilkarsVedtak? = null
}