package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.kode.YtelseVedDodCti

class Alderspensjon2011VedDod : AbstraktBeregningsvilkar() {
    /**
     * Angir hvilken ytelse avdøde hadde før død.
     */
    var ytelseVedDod: YtelseVedDodCti? = null

}