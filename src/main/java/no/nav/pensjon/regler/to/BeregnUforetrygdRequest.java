package no.nav.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;


import no.nav.pensjon.regler.domain.beregning2011.BeregnetUtbetalingsperiode;
import no.nav.pensjon.regler.domain.beregning2011.Gjenlevendetillegg;
import no.nav.pensjon.regler.domain.grunnlag.EtteroppgjorGrunnlag;
import no.nav.pensjon.regler.domain.krav.Kravhode;
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak;

/**
 * @author Swiddy de Louw (Capgemini) PK-16620
 */

public class BeregnUforetrygdRequest extends ServiceRequest {

    private static final long serialVersionUID = -1490015136921364487L;

    private Kravhode kravhode;

    private Vector<VilkarsVedtak> vilkarsvedtaksliste = new Vector<VilkarsVedtak>();

    private Date virkFom;

    private Date virkTom;

    private Gjenlevendetillegg forrigeGjenlevendetillegg;

    /**
     * Liste over perioder med utbetalt uføretrygd
     */
    private List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeListe;

    //Angir om inntektsavkortingen skal gjøres på bakgrunn av reglene for etteroppgjør
    private boolean etteroppgjor;

    //Inneholder informasjon knyttet til etteroppgjør
    private EtteroppgjorGrunnlag etteroppgjorGrunnlag;

    public BeregnUforetrygdRequest() {
        super();
        beregnetUtbetalingsperiodeListe = new ArrayList<BeregnetUtbetalingsperiode>();

    }

    public BeregnUforetrygdRequest(Kravhode kravhode, Vector<VilkarsVedtak> vedtaksliste, Date virkFom, Date virkTom,
            List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeListe, boolean etteroppgjor,
            EtteroppgjorGrunnlag etteroppgjorGrunnlag, Gjenlevendetillegg forrigeGjenlevendetillegg) {
        this.kravhode = kravhode;
        vilkarsvedtaksliste = vedtaksliste;
        this.virkFom = virkFom;
        this.virkTom = virkTom;
        this.beregnetUtbetalingsperiodeListe = beregnetUtbetalingsperiodeListe;
        this.etteroppgjor = etteroppgjor;
        this.etteroppgjorGrunnlag = etteroppgjorGrunnlag;
        this.forrigeGjenlevendetillegg = forrigeGjenlevendetillegg;
    }

    public Kravhode getKravhode() {
        return kravhode;
    }

    public void setKravhode(Kravhode kravhode) {
        this.kravhode = kravhode;
    }

    public Vector<VilkarsVedtak> getVedtaksliste() {
        return vilkarsvedtaksliste;
    }

    public void setVedtaksliste(Vector<VilkarsVedtak> vedtaksliste) {
        vilkarsvedtaksliste = vedtaksliste;
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

    public Gjenlevendetillegg getForrigeGjenlevendetillegg() {
        return forrigeGjenlevendetillegg;
    }

    public void setForrigeGjenlevendetillegg(Gjenlevendetillegg forrigeGjenlevendetillegg) {
        this.forrigeGjenlevendetillegg = forrigeGjenlevendetillegg;
    }

    public List<BeregnetUtbetalingsperiode> getBeregnetUtbetalingsperiodeListe() {
        return beregnetUtbetalingsperiodeListe;
    }

    public void setBeregnetUtbetalingsperiodeListe(List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeListe) {
        this.beregnetUtbetalingsperiodeListe = beregnetUtbetalingsperiodeListe;
    }


    /**
     * @return the etteroppgjor
     */
    public boolean isEtteroppgjor() {
        return etteroppgjor;
    }

    /**
     * @param etteroppgjor the etteroppgjor to set
     */
    public void setEtteroppgjor(boolean etteroppgjor) {
        this.etteroppgjor = etteroppgjor;
    }

    /**
     * @return the etteroppgjorGrunnlag
     */
    public EtteroppgjorGrunnlag getEtteroppgjorGrunnlag() {
        return etteroppgjorGrunnlag;
    }

    /**
     * @param etteroppgjorGrunnlag the etteroppgjorGrunnlag to set
     */
    public void setEtteroppgjorGrunnlag(EtteroppgjorGrunnlag etteroppgjorGrunnlag) {
        this.etteroppgjorGrunnlag = etteroppgjorGrunnlag;
    }

}
