package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag
import no.nav.pensjon.regler.domain.grunnlag.Uttaksgrad
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*

class RegulerBeregningRequest {
    var beregning1967: Beregning? = null
    var virkFom: Date? = null
    var uttaksgradListe: MutableList<Uttaksgrad> = mutableListOf()
    var brukersVilkarsvedtakListe: MutableList<VilkarsVedtak> = mutableListOf()
    var sokersPersongrunnlag: Persongrunnlag? = null
    var epsPersongrunnlag: Persongrunnlag? = null
}