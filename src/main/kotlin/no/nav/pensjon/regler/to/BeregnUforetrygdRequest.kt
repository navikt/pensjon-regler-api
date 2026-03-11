package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.BeregnetUtbetalingsperiode
import no.nav.pensjon.regler.domain.beregning2011.Gjenlevendetillegg
import no.nav.pensjon.regler.domain.grunnlag.EtteroppgjorGrunnlag
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*
import java.time.LocalDate

class BeregnUforetrygdRequest : ServiceRequest() {
    var kravhode: Kravhode? = null
    var vilkarsvedtaksliste = Vector<VilkarsVedtak>()
    @Deprecated("Use virkFomLd instead")
    var virkFom: Date? = null
    var virkFomLd: LocalDate? = null
    @Deprecated("Use virkTomLd instead")
    var virkTom: Date? = null
    var virkTomLd: LocalDate? = null
    var forrigeGjenlevendetillegg: Gjenlevendetillegg? = null

    /**
     * Liste over perioder med utbetalt uføretrygd
     */
    var beregnetUtbetalingsperiodeListe: List<BeregnetUtbetalingsperiode> = ArrayList()

    //Angir om inntektsavkortingen skal gjøres på bakgrunn av reglene for etteroppgjør
    var etteroppgjor = false

    //Inneholder informasjon knyttet til etteroppgjør
    var etteroppgjorGrunnlag: EtteroppgjorGrunnlag? = null
}