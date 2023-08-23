package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.BeregnetUtbetalingsperiode
import no.nav.pensjon.regler.domain.beregning2011.BeregningsresultatUforetrygd
import no.nav.pensjon.regler.domain.grunnlag.EtteroppgjorGrunnlag
import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*

class InntektsavkortningUforetrygdRequest {
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
    var virkFom: Date? = null

    /**
     * Virkningstidspunkt for beregning av ny inntektsavkortning.
     */
    var virkTom: Date? = null

    /**
     * Angir om inntektsavkortingen skal gjøres på bakgrunn av reglene for etteroppgjør.
     */
    var isEtteroppgjor = false

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