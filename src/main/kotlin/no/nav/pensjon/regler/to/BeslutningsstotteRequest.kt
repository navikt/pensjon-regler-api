package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.enum.BeslutningsstotteTypeEnum
import no.nav.pensjon.regler.domain.enum.BorMedTypeEnum
import no.nav.pensjon.regler.domain.grunnlag.InntektKontrollGrunnlag
import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak

class BeslutningsstotteRequest : ServiceRequest() {
    var beslutningsstotteTypeEnum: BeslutningsstotteTypeEnum? = null
    var persongrunnlag: Persongrunnlag? = null

    /** vilkårsvedtaket for uføretrygd  */
    var vilkarsvedtak: VilkarsVedtak? = null

    /** Vurdert sivilstand på Kravhode.konverteringsgrunnlagUT.lopendeUFB.benyttetSivilstand  */
    var benyttetSivilstandEnum: BorMedTypeEnum? = null

    /** Inneholder nødvendig informasjon for å beregne ny forventet inntekt ifbm løpende inntektskontroll.  */
    var inntektKontrollGrunnlag: InntektKontrollGrunnlag? = null
}