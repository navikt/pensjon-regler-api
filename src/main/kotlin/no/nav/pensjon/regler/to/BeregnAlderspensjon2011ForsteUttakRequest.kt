package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.AfpLivsvarig
import no.nav.pensjon.regler.domain.grunnlag.ForholdstallUtvalg
import no.nav.pensjon.regler.domain.grunnlag.InfoPavirkendeYtelse
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*

class BeregnAlderspensjon2011ForsteUttakRequest {
    var kravhode: Kravhode? = null
    var vilkarsvedtakListe: MutableList<VilkarsVedtak> = mutableListOf()
    var infoPavirkendeYtelse: InfoPavirkendeYtelse? = null
    var virkFom: Date? = null
    var virkTom: Date? = null
    var forholdstallUtvalg: ForholdstallUtvalg? = null
    var ektefellenMottarPensjon = false
    var afpLivsvarig: AfpLivsvarig? = null
}