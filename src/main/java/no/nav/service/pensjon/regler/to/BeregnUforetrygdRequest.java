package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;


import no.nav.domain.pensjon.regler.beregning2011.BeregnetUtbetalingsperiode;
import no.nav.domain.pensjon.regler.grunnlag.EtteroppgjorGrunnlag;
import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

/**
 * @author Swiddy de Louw (Capgemini) PK-16620
 */

public class BeregnUforetrygdRequest extends ServiceRequest {

    private static final long serialVersionUID = -1490015136921364487L;

    private Kravhode kravhode;

    private Vector<VilkarsVedtak> vilkarsvedtaksliste = new Vector<VilkarsVedtak>();

    private Date virkFom;

    private Date virkTom;

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
            EtteroppgjorGrunnlag etteroppgjorGrunnlag) {
        this.kravhode = kravhode;
        vilkarsvedtaksliste = vedtaksliste;
        this.virkFom = virkFom;
        this.virkTom = virkTom;
        this.beregnetUtbetalingsperiodeListe = beregnetUtbetalingsperiodeListe;
        this.etteroppgjor = etteroppgjor;
        this.etteroppgjorGrunnlag = etteroppgjorGrunnlag;
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

    /**
     * Read only property for vilkarsvedtaksliste
     * 
     * @return array of VilkarsVedtak
     */
    public VilkarsVedtak[] getVilkarsVedtakListeAsArray() {
        return vilkarsvedtaksliste != null ? vilkarsvedtaksliste.toArray(new VilkarsVedtak[vilkarsvedtaksliste.size()]) : new VilkarsVedtak[0];
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

    public List<BeregnetUtbetalingsperiode> getBeregnetUtbetalingsperiodeListe() {
        return beregnetUtbetalingsperiodeListe;
    }

    public void setBeregnetUtbetalingsperiodeListe(List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeListe) {
        this.beregnetUtbetalingsperiodeListe = beregnetUtbetalingsperiodeListe;
    }

    /**
     * Read only property av BeregnetUtbetalingsperiodeListe as Array
     * 
     * @return array of BeregnetUtbetalingsperiode
     */
    public BeregnetUtbetalingsperiode[] getBeregnetUtbetalingsperiodeListeAsArray() {
        return beregnetUtbetalingsperiodeListe != null ? beregnetUtbetalingsperiodeListe.toArray(new BeregnetUtbetalingsperiode[beregnetUtbetalingsperiodeListe.size()])
                : new BeregnetUtbetalingsperiode[0];
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
