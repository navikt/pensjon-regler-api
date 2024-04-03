package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak


class VilkarsprovForsorgingstilleggResponse : ServiceResponse() {
    var vedtaksliste: List<VilkarsVedtak> = ArrayList()
}