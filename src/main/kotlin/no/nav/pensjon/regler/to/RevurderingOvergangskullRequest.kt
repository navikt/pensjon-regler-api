package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.AfpLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2011
import no.nav.pensjon.regler.domain.grunnlag.DelingstallUtvalg
import no.nav.pensjon.regler.domain.grunnlag.ForholdstallUtvalg
import no.nav.pensjon.regler.domain.grunnlag.InfoPavirkendeYtelse
import no.nav.pensjon.regler.domain.kode.ResultatTypeCti
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*

class RevurderingOvergangskullRequest : ServiceRequest() {
    var kravhode: Kravhode? = null
    var vilkarsvedtakListe: Vector<VilkarsVedtak> = Vector()
    var infoPavirkendeYtelse: InfoPavirkendeYtelse? = null
    var delingstallUtvalg: DelingstallUtvalg? = null
    var forholdstallUtvalg: ForholdstallUtvalg? = null
    var virkFom: Date? = null
    var sisteAldersBeregning: SisteAldersberegning2011? = null
    var nettoUPellerGJP = 0.0
    var nettoUPellerGJPresultatType: ResultatTypeCti? = null
    var afpLivsvarig: AfpLivsvarig? = null

}