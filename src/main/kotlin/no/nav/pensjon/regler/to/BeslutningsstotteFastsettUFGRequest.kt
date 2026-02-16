package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak

class BeslutningsstotteFastsettUFGRequest(
    /** Vilkårsvedtaket for uføretrygd. Påkrevd. */
    var vilkarsvedtak: VilkarsVedtak
) : ServiceRequest()
