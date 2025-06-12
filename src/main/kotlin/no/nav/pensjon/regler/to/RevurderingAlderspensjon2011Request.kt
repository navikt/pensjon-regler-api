package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.AfpPrivatLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2011
import no.nav.pensjon.regler.domain.grunnlag.InfoPavirkendeYtelse
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*

class RevurderingAlderspensjon2011Request : ServiceRequest() {
    var kravhode: Kravhode? = null
    var vilkarsvedtakListe: Vector<VilkarsVedtak> = Vector()
    var infoPavirkendeYtelse: InfoPavirkendeYtelse? = null
    var epsMottarPensjon = false
    var virkFom: Date? = null
    var virkTom: Date? = null
    var forrigeAldersBeregning: SisteAldersberegning2011? = null
    var afpPrivatLivsvarig: AfpPrivatLivsvarig? = null
}