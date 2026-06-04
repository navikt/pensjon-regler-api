package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.AfpOffentligLivsvarigGrunnlag
import no.nav.pensjon.regler.domain.beregning2011.AfpPrivatLivsvarig
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.time.LocalDate
import java.util.*

class BeregnAlderspensjon2025ForsteUttakRequest : ServiceRequest() {
    var virkFomLd: LocalDate? = null
    var kravhode: Kravhode? = null
    var vilkarsvedtakListe: List<VilkarsVedtak> = Vector()
    var epsMottarPensjon = false
    var afpPrivatLivsvarig: AfpPrivatLivsvarig? = null
    var afpOffentligLivsvarigGrunnlag: AfpOffentligLivsvarigGrunnlag? = null
}