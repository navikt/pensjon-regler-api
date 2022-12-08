package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import no.nav.domain.pensjon.regler.beregning2011.BeregnetUtbetalingsperiode;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsresultatUforetrygd;
import no.nav.domain.pensjon.regler.grunnlag.EtteroppgjorGrunnlag;
import no.nav.domain.pensjon.regler.grunnlag.Persongrunnlag;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

/**
 * @author Tatyana Lochehina
 */
public class InntektsavkortningUforetrygdRequest extends ServiceRequest {


    /**
     * Et beregningsresultat for uf�retrygd basert p� forventet inntekt som skal inntektsavkortes p� nytt.
     */
    private BeregningsresultatUforetrygd beregningsresultatUforetrygd;

    /**
     * Personen det gjennomf�res ny inntektsavkortning for.
     */
    private Persongrunnlag persongrunnlag;

    /**
     * Vilkarsvedtaket for uf�retrygd. Inkludert relevante beregningsvilkarPerioder.
     */
    private VilkarsVedtak vilkarsVedtak;

    /**
     * Virkningstidspunkt for beregning av ny inntektsavkortning.
     */
    private Date virkFom;

    /**
     * Virkningstidspunkt for beregning av ny inntektsavkortning.
     */
    private Date virkTom;

    /**
     * Angir om inntektsavkortingen skal gj�res p� bakgrunn av reglene for etteroppgj�r.
     */
    private boolean etteroppgjor;

    /**
     * Inneholder informasjon knyttet til etteroppgj�r.
     */
    private EtteroppgjorGrunnlag etteroppgjorGrunnlag;

    /**
     * Liste over perioder med utbetalt uf�retrygd
     */
    private List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeListe =new ArrayList<BeregnetUtbetalingsperiode>();


}
