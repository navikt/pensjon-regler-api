package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.enum.YtelseVedDodEnum

class Alderspensjon2011VedDod : AbstraktBeregningsvilkar() {
    /**
     * Angir hvilken ytelse avdøde hadde før død.
     */
    var ytelseVedDodEnum: YtelseVedDodEnum? = null

}