package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.enum.BorMedTypeEnum
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak

class BeslutningsstotteBeregnIFURequest(
    /** Vilkårsvedtaket for uføretrygd. Påkrevd. */
    var vilkarsvedtak: VilkarsVedtak
) : ServiceRequest() {
    /** Vurdert sivilstand. Valgfri — brukes for å fastsette regnesSomGift. */
    var benyttetSivilstandEnum: BorMedTypeEnum? = null
}
