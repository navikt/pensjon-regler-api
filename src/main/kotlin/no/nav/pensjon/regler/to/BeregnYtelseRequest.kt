package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.grunnlag.InfoPavirkendeYtelse
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*

class BeregnYtelseRequest {
    var kravhode: Kravhode? = null
    var vilkarsvedtaksliste = Vector<VilkarsVedtak>()
    var fom: Date? = null
    var tom: Date? = null
    var ektefelleMottarPensjon = false
    var beregnForsorgingstillegg = false
    var beregnInstitusjonsopphold = false
    var infoPavirkendeYtelse: InfoPavirkendeYtelse? = null
    var vedtakVirkFom: Date? = null
}