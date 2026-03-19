package no.nav.pensjon.regler.to

import com.fasterxml.jackson.annotation.JsonAlias
import no.nav.pensjon.regler.domain.grunnlag.InfoPavirkendeYtelse
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*
import java.time.LocalDate

class BeregnYtelseRequest : ServiceRequest() {
    var kravhode: Kravhode? = null
    var vilkarsvedtaksliste = Vector<VilkarsVedtak>()
    @Deprecated("Use virkLd instead")
    @JsonAlias("fom")
    var virk: Date? = null
    @JsonAlias("fomLd")
    var virkLd: LocalDate? = null
    @Deprecated("Use tomLd instead")
    @JsonAlias("tom")
    var tom: Date? = null
    var tomLd: LocalDate? = null
    var ektefelleMottarPensjon = false
    var beregnForsorgingstillegg = false
    var beregnInstitusjonsopphold = false
    var infoPavirkendeYtelse: InfoPavirkendeYtelse? = null
    @Deprecated("Use vedtakVirkFomLd instead")
    var vedtakVirkFom: Date? = null
    var vedtakVirkFomLd: LocalDate? = null
}