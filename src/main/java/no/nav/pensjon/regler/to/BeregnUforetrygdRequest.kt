package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.BeregnetUtbetalingsperiode
import no.nav.pensjon.regler.domain.beregning2011.Gjenlevendetillegg
import no.nav.pensjon.regler.domain.grunnlag.EtteroppgjorGrunnlag
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*

/**
 * @author Swiddy de Louw (Capgemini) PK-16620
 */
class BeregnUforetrygdRequest {
    var kravhode: Kravhode? = null
    var vedtaksliste = Vector<VilkarsVedtak>()
    var virkFom: Date? = null
    var virkTom: Date? = null
    var forrigeGjenlevendetillegg: Gjenlevendetillegg? = null

    /**
     * Liste over perioder med utbetalt uføretrygd
     */
    var beregnetUtbetalingsperiodeListe: List<BeregnetUtbetalingsperiode> = ArrayList()

    //Angir om inntektsavkortingen skal gjøres på bakgrunn av reglene for etteroppgjør
    var isEtteroppgjor = false

    //Inneholder informasjon knyttet til etteroppgjør
    var etteroppgjorGrunnlag: EtteroppgjorGrunnlag? = null
}