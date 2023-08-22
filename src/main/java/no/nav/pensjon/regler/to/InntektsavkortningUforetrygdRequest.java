package no.nav.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import no.nav.pensjon.regler.domain.beregning2011.BeregnetUtbetalingsperiode;
import no.nav.pensjon.regler.domain.beregning2011.BeregningsresultatUforetrygd;
import no.nav.pensjon.regler.domain.grunnlag.EtteroppgjorGrunnlag;
import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag;
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak;

/**
 * @author Tatyana Lochehina
 */
public class InntektsavkortningUforetrygdRequest extends ServiceRequest {

    private static final long serialVersionUID = 1496199225706828583L;

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
    private List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeListe;

    public InntektsavkortningUforetrygdRequest() {
        super();
        beregnetUtbetalingsperiodeListe = new ArrayList<BeregnetUtbetalingsperiode>();
    }

    public InntektsavkortningUforetrygdRequest(BeregningsresultatUforetrygd res, Persongrunnlag person, VilkarsVedtak vedtak, Date fom, Date tom, boolean etteroppgjor,
            EtteroppgjorGrunnlag grunnlag) {
        this();
        beregningsresultatUforetrygd = res;
        persongrunnlag = person;
        vilkarsVedtak = vedtak;
        virkFom = fom;
        virkTom = tom;
        this.etteroppgjor = etteroppgjor;
        etteroppgjorGrunnlag = grunnlag;
        beregnetUtbetalingsperiodeListe = new ArrayList<BeregnetUtbetalingsperiode>();
    }

    public BeregningsresultatUforetrygd getBeregningsresultatUforetrygd() {
        return beregningsresultatUforetrygd;
    }

    public void setBeregningsresultatUforetrygd(BeregningsresultatUforetrygd beregningsresultatUforetrygd) {
        this.beregningsresultatUforetrygd = beregningsresultatUforetrygd;
    }

    public Persongrunnlag getPersongrunnlag() {
        return persongrunnlag;
    }

    public void setPersongrunnlag(Persongrunnlag persongrunnlag) {
        this.persongrunnlag = persongrunnlag;
    }

    public VilkarsVedtak getVilkarsVedtak() {
        return vilkarsVedtak;
    }

    public void setVilkarsVedtak(VilkarsVedtak vilkarsVedtak) {
        this.vilkarsVedtak = vilkarsVedtak;
    }

    public Date getVirkFom() {
        return virkFom;
    }

    public void setVirkFom(Date virkFom) {
        this.virkFom = virkFom;
    }

    public Date getVirkTom() {
        return virkTom;
    }

    public void setVirkTom(Date virkTom) {
        this.virkTom = virkTom;
    }

    public boolean isEtteroppgjor() {
        return etteroppgjor;
    }

    public void setEtteroppgjor(boolean etteroppgjor) {
        this.etteroppgjor = etteroppgjor;
    }

    public EtteroppgjorGrunnlag getEtteroppgjorGrunnlag() {
        return etteroppgjorGrunnlag;
    }

    public void setEtteroppgjorGrunnlag(EtteroppgjorGrunnlag etteroppgjorGrunnlag) {
        this.etteroppgjorGrunnlag = etteroppgjorGrunnlag;
    }

    public List<BeregnetUtbetalingsperiode> getBeregnetUtbetalingsperiodeListe() {
        return beregnetUtbetalingsperiodeListe;
    }

    public void setBeregnetUtbetalingPeriodeUTListe(List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeListe) {
        this.beregnetUtbetalingsperiodeListe = beregnetUtbetalingsperiodeListe;
    }
}
