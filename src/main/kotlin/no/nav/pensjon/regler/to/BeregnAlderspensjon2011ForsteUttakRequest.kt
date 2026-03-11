package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.AfpPrivatLivsvarig
import no.nav.pensjon.regler.domain.grunnlag.InfoPavirkendeYtelse
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*
import java.time.LocalDate

class BeregnAlderspensjon2011ForsteUttakRequest : ServiceRequest() {
    var kravhode: Kravhode? = null
    var vilkarsvedtakListe: List<VilkarsVedtak> = Vector()
    var infoPavirkendeYtelse: InfoPavirkendeYtelse? = null
    @Deprecated("Use virkFomLd instead")
    var virkFom: Date? = null
    var virkFomLd: LocalDate? = null
    @Deprecated("Use virkTomLd instead")
    var virkTom: Date? = null
    var virkTomLd: LocalDate? = null
    var ektefellenMottarPensjon = false
    var afpPrivatLivsvarig: AfpPrivatLivsvarig? = null
}