package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import no.stelvio.common.transferobject.ServiceRequest;

import no.nav.domain.pensjon.regler.beregning2011.BeregnetUtbetalingsperiode;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsresultatUforetrygd;
import no.nav.domain.pensjon.regler.grunnlag.EtteroppgjorGrunnlag;
import no.nav.domain.pensjon.regler.grunnlag.Persongrunnlag;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

/**
 * @author Tatyana Lochehina
 */
public class InntektsavkortningUforetrygdRequest extends ServiceRequest {

    private static final long serialVersionUID = 1496199225706828583L;

    /**
     * Et beregningsresultat for uføretrygd basert på forventet inntekt som skal inntektsavkortes på nytt.
     */
    private BeregningsresultatUforetrygd beregningsresultatUforetrygd;

    /**
     * Personen det gjennomføres ny inntektsavkortning for.
     */
    private Persongrunnlag persongrunnlag;

    /**
     * Vilkarsvedtaket for uføretrygd. Inkludert relevante beregningsvilkarPerioder.
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
     * Angir om inntektsavkortingen skal gjøres på bakgrunn av reglene for etteroppgjør.
     */
    private boolean etteroppgjor;

    /**
     * Inneholder informasjon knyttet til etteroppgjør.
     */
    private EtteroppgjorGrunnlag etteroppgjorGrunnlag;

    /**
     * Liste over perioder med utbetalt uføretrygd
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

    public BeregnetUtbetalingsperiode[] getBeregnetUtbetalingsperiodeListeAsArray() {
        return beregnetUtbetalingsperiodeListe != null ? beregnetUtbetalingsperiodeListe.toArray(
                new BeregnetUtbetalingsperiode[beregnetUtbetalingsperiodeListe.size()]) :
                new BeregnetUtbetalingsperiode[0];
    }

    public List<BeregnetUtbetalingsperiode> getBeregnetUtbetalingsperiodeListe() {
        return beregnetUtbetalingsperiodeListe;
    }

    public void setBeregnetUtbetalingPeriodeUTListe(List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeListe) {
        this.beregnetUtbetalingsperiodeListe = beregnetUtbetalingsperiodeListe;
    }
}
