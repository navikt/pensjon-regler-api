package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.SisteBeregning1967
import no.nav.pensjon.regler.domain.grunnlag.InfoPavirkendeYtelse
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*

class RevurderingYtelse1967Request {
    var virkFom: Date? = null
    var kravhode: Kravhode? = null
    var vilkarsvedtakListe: Vector<VilkarsVedtak> = Vector()
    var sisteBeregning1967: SisteBeregning1967? = null
    var infoPavirkendeYtelse: InfoPavirkendeYtelse? = null
    var epsMottarPensjon = false
    var beregnForsorgingstillegg = false
    var beregnInstitusjonsopphold = false
}