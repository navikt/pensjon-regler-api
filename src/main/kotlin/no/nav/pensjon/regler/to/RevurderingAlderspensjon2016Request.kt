package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.AfpLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2016
import no.nav.pensjon.regler.domain.grunnlag.DelingstallUtvalg
import no.nav.pensjon.regler.domain.grunnlag.ForholdstallUtvalg
import no.nav.pensjon.regler.domain.grunnlag.GarantitilleggsbeholdningGrunnlag
import no.nav.pensjon.regler.domain.grunnlag.InfoPavirkendeYtelse
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*

class RevurderingAlderspensjon2016Request {
    var kravhode: Kravhode? = null
    var vilkarsvedtakListe: MutableList<VilkarsVedtak> = mutableListOf()
    var infoPavirkendeYtelse: InfoPavirkendeYtelse? = null
    var epsMottarPensjon = false
    var forholdstallUtvalg: ForholdstallUtvalg? = null
    var delingstallUtvalg: DelingstallUtvalg? = null
    var virkFom: Date? = null
    var forrigeAldersBeregning: SisteAldersberegning2016? = null
    var afpLivsvarig: AfpLivsvarig? = null

    /**
     * Grunnlag for beregning av garantitilleggsbeholdning.
     * (Ref. BER3156)
     */
    var garantitilleggsbeholdningGrunnlag: GarantitilleggsbeholdningGrunnlag? = null
}