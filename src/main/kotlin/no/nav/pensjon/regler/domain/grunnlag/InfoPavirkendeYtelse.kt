package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.YtelseTpOrdTypeEnum
import no.nav.pensjon.regler.domain.kode.YtelseTypeCti
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.io.Serializable

class InfoPavirkendeYtelse : Serializable {
    /**
     * Liste av alle vilkårsvedtak for hovedytelse som EPS har løpende.
     */
    var vilkarsvedtakEPSListe: MutableList<VilkarsVedtak> = mutableListOf()

    /**
     * EPS uforegrad dersom EPS har uførepensjon.
     */
    var uforegradEPS = 0

    /**
     * Hvis vilkarsvedtakEPSListen er tom og det finnes en tjenestepensjon for ektefellen som
     * ikke blir beregnet av PESYS skal denne fylles ut.
     */
    var tjenestepensjonsordningEps: YtelseTypeCti? = null
    var tjenestepensjonsordningEpsEnum: YtelseTpOrdTypeEnum? = null

    /**
     * Satt til true dersom EPS mottar omstillingsstonad (utbetalt beløp > 0).
     */
    var mottarOmstillingsstonadEps: Boolean = false

}