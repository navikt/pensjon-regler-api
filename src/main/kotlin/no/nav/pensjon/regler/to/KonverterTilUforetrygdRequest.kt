package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.SisteUforepensjonBeregning
import no.nav.pensjon.regler.domain.grunnlag.EtteroppgjorGrunnlag
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*

class KonverterTilUforetrygdRequest : ServiceRequest() {
    var kravhode: Kravhode? = null
    var sisteUforepensjonBeregning: SisteUforepensjonBeregning? = null
    var sisteUforepensjonBeregningTilRevurdering: SisteUforepensjonBeregning? = null
    var vilkarsvedtaksliste = Vector<VilkarsVedtak>()
    var virkFom: Date? = null

    // Brukes til å si om en beregning skal faktorkonverteres eller ikke
    var faktorkonvertering = false

    //Angir om inntektsavkortingen skal gjøres på bakgrunn av reglene for etteroppgjør
    var etteroppgjor = false

    //Inneholder informasjon knyttet til etteroppgjør
    var etteroppgjorGrunnlag: EtteroppgjorGrunnlag? = null
}