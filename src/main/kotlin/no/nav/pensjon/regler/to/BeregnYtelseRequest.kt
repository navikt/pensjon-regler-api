package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.grunnlag.InfoPavirkendeYtelse
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*
import java.time.LocalDate

class BeregnYtelseRequest : ServiceRequest() {
    var kravhode: Kravhode? = null
    var vilkarsvedtaksliste = Vector<VilkarsVedtak>()
    var fomLd: LocalDate? = null
    var tomLd: LocalDate? = null
    var ektefelleMottarPensjon = false
    var beregnForsorgingstillegg = false
    var beregnInstitusjonsopphold = false
    var infoPavirkendeYtelse: InfoPavirkendeYtelse? = null
    var vedtakVirkFomLd: LocalDate? = null
}