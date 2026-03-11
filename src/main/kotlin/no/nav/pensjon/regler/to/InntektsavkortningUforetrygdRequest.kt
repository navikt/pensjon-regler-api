package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.BeregnetUtbetalingsperiode
import no.nav.pensjon.regler.domain.beregning2011.BeregningsresultatUforetrygd
import no.nav.pensjon.regler.domain.grunnlag.EtteroppgjorGrunnlag
import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*
import java.time.LocalDate

class InntektsavkortningUforetrygdRequest : ServiceRequest() {
    /**
     * Et beregningsresultat for uføretrygd basert på forventet inntekt som skal inntektsavkortes på nytt.
     */
    var beregningsresultatUforetrygd: BeregningsresultatUforetrygd? = null

    /**
     * Personen det gjennomføres ny inntektsavkortning for.
     */
    var persongrunnlag: Persongrunnlag? = null

    /**
     * Vilkarsvedtaket for uføretrygd. Inkludert relevante beregningsvilkarPerioder.
     */
    var vilkarsVedtak: VilkarsVedtak? = null

    /**
     * Virkningstidspunkt for beregning av ny inntektsavkortning.
     */
    @Deprecated("Use virkFomLd instead")
    var virkFom: Date? = null
    var virkFomLd: LocalDate? = null

    /**
     * Virkningstidspunkt for beregning av ny inntektsavkortning.
     */
    @Deprecated("Use virkTomLd instead")
    var virkTom: Date? = null
    var virkTomLd: LocalDate? = null

    /**
     * Angir om inntektsavkortingen skal gjøres på bakgrunn av reglene for etteroppgjør.
     */
    var etteroppgjor = false

    /**
     * Inneholder informasjon knyttet til etteroppgjør.
     */
    var etteroppgjorGrunnlag: EtteroppgjorGrunnlag? = null

    /**
     * Liste over perioder med utbetalt uføretrygd
     */
    var beregnetUtbetalingsperiodeListe: List<BeregnetUtbetalingsperiode> = ArrayList()

    fun setBeregnetUtbetalingPeriodeUTListe(beregnetUtbetalingsperiodeListe: List<BeregnetUtbetalingsperiode>) {
        this.beregnetUtbetalingsperiodeListe = beregnetUtbetalingsperiodeListe
    }
}