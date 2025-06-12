package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.AfpPrivatLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2016
import no.nav.pensjon.regler.domain.grunnlag.InfoPavirkendeYtelse
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*

class RevurderingAlderspensjon2016Request : ServiceRequest() {
    var kravhode: Kravhode? = null
    var vilkarsvedtakListe: List<VilkarsVedtak> = Vector()
    var infoPavirkendeYtelse: InfoPavirkendeYtelse? = null
    var epsMottarPensjon = false
    var virkFom: Date? = null
    var forrigeAldersBeregning: SisteAldersberegning2016? = null
    var afpPrivatLivsvarig: AfpPrivatLivsvarig? = null
}