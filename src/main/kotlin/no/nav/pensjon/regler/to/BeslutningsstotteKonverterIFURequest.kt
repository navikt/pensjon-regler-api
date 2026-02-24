package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.enum.BorMedTypeEnum
import no.nav.pensjon.regler.domain.grunnlag.Uforehistorikk

class BeslutningsstotteKonverterIFURequest(
    /** Uførehistorikk med uføreperioder, fra persongrunnlag */
    var uforeHistorikk: Uforehistorikk,
    /** Angitt inntekt før uførhet, fra persongrunnlag.uforegrunnlag */
    var angittIfu: Int,
) : ServiceRequest() {
    /** Vurdert sivilstand. Valgfri — brukes for konverteringsberegning. */
    var benyttetSivilstandEnum: BorMedTypeEnum? = null
}
