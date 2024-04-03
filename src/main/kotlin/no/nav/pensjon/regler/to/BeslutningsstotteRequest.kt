package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.grunnlag.InntektKontrollGrunnlag
import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag
import no.nav.pensjon.regler.domain.kode.BeslutningsstotteTypeCti
import no.nav.pensjon.regler.domain.kode.BorMedTypeCti
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak

class BeslutningsstotteRequest : ServiceRequest() {
    var beslutningsstotteType: BeslutningsstotteTypeCti? = null
    var persongrunnlag: Persongrunnlag? = null

    /** vilkårsvedtaket for uføretrygd  */
    var vilkarsvedtak: VilkarsVedtak? = null

    /** Vurdert sivilstand på Kravhode.konverteringsgrunnlagUT.lopendeUFB.benyttetSivilstand  */
    var benyttetSivilstand: BorMedTypeCti? = null

    /** Inneholder nødvendig informasjon for å beregne ny forventet inntekt ifbm løpende inntektskontroll.  */
    var inntektKontrollGrunnlag: InntektKontrollGrunnlag? = null
}