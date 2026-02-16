package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.enum.BorMedTypeEnum
import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag

class BeslutningsstotteKonverterIFURequest(
    /** Persongrunnlag med uførehistorikk og uføregrunnlag. Påkrevd. */
    var persongrunnlag: Persongrunnlag
) : ServiceRequest() {
    /** Vurdert sivilstand. Valgfri — brukes for konverteringsberegning. */
    var benyttetSivilstandEnum: BorMedTypeEnum? = null
}
