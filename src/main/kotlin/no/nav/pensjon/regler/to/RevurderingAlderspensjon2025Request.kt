package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.AfpOffentligLivsvarigGrunnlag
import no.nav.pensjon.regler.domain.beregning2011.AfpPrivatLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2011
import no.nav.pensjon.regler.domain.grunnlag.InfoPavirkendeYtelse
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*
import java.time.LocalDate

class RevurderingAlderspensjon2025Request : ServiceRequest() {
    var kravhode: Kravhode? = null
    var vilkarsvedtakListe: ArrayList<VilkarsVedtak> = ArrayList()
    var infoPavirkendeYtelse: InfoPavirkendeYtelse? = null
    var epsMottarPensjon = false
    @Deprecated("Use virkFomLd instead")
    var virkFom: Date? = null
    var virkFomLd: LocalDate? = null
    var sisteAldersBeregning2011: SisteAldersberegning2011? = null
    var afpPrivatLivsvarig: AfpPrivatLivsvarig? = null
    var afpOffentligLivsvarigGrunnlag: AfpOffentligLivsvarigGrunnlag? = null
}