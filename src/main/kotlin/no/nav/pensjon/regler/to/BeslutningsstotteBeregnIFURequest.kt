package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.enum.BorMedTypeEnum
import no.nav.pensjon.regler.domain.vedtak.InntektForUforhet
import no.nav.pensjon.regler.domain.vedtak.Uforetidspunkt
import no.nav.pensjon.regler.domain.vedtak.UngUfor
import java.util.*

class BeslutningsstotteBeregnIFURequest(
    /**
     * Fra siste beregningsvilkar periode:
     */
    var inntektForUforhet: InntektForUforhet,
    var ungUfor: UngUfor,
    var uforetidspunkt: Uforetidspunkt

) : ServiceRequest() {
    /** Vurdert sivilstand. Valgfri — brukes for å fastsette regnesSomGift. */
    var benyttetSivilstandEnum: BorMedTypeEnum? = null

    /** Virkningsdato fom, fra vilkarsvedtak */
    var virkFom: Date? = null
}
