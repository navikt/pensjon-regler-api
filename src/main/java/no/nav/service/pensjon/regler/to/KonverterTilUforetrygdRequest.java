package no.nav.service.pensjon.regler.to;

import java.util.Date;
import java.util.Vector;

import no.stelvio.common.transferobject.ServiceRequest;

import no.nav.domain.pensjon.regler.beregning2011.SisteUforepensjonBeregning;
import no.nav.domain.pensjon.regler.grunnlag.EtteroppgjorGrunnlag;
import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

/**
 * @author Magnus Bakken (Accenture) PK-7799 - Utvidet request med sisteUforepensjonBeregningTilRevurdering
 * @author Aasmund Nordstoga (Accenture) PK-5549
 * @author Swiddy de Louw (Capgemini) PK-16620
 */
public class KonverterTilUforetrygdRequest extends ServiceRequest {

    private static final long serialVersionUID = -710823114647735031L;

    private Kravhode kravhode;

    private SisteUforepensjonBeregning sisteUforepensjonBeregning;

    private SisteUforepensjonBeregning sisteUforepensjonBeregningTilRevurdering;

    private Vector<VilkarsVedtak> vilkarsvedtaksliste = new Vector<VilkarsVedtak>();

    private Date virkFom;

    // Brukes til å si om en beregning skal faktorkonverteres eller ikke
    private boolean faktorkonvertering;

    //Angir om inntektsavkortingen skal gjøres på bakgrunn av reglene for etteroppgjør
    private boolean etteroppgjor;

    //Inneholder informasjon knyttet til etteroppgjør
    private EtteroppgjorGrunnlag etteroppgjorGrunnlag;

    public KonverterTilUforetrygdRequest() {
        super();
    }

    public KonverterTilUforetrygdRequest(Kravhode kravhode, Vector<VilkarsVedtak> vedtaksliste, Date virkFom, SisteUforepensjonBeregning sisteUforepensjonBeregning,
                                         SisteUforepensjonBeregning sisteUforepensjonBeregningTilRevurdering, boolean faktorkonvertering, boolean etteroppgjor,
                                         EtteroppgjorGrunnlag etteroppgjorGrunnlag) {
        this.kravhode = kravhode;
        vilkarsvedtaksliste = vedtaksliste;
        this.virkFom = virkFom;
        this.sisteUforepensjonBeregning = sisteUforepensjonBeregning;
        this.sisteUforepensjonBeregningTilRevurdering = sisteUforepensjonBeregningTilRevurdering;
        this.faktorkonvertering = faktorkonvertering;
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

    public SisteUforepensjonBeregning getSisteUforepensjonBeregning() {
        return sisteUforepensjonBeregning;
    }

    public void setSisteUforepensjonBeregning(SisteUforepensjonBeregning sisteUforepensjonBeregning) {
        this.sisteUforepensjonBeregning = sisteUforepensjonBeregning;
    }

    public SisteUforepensjonBeregning getSisteUforepensjonBeregningTilRevurdering() {
        return sisteUforepensjonBeregningTilRevurdering;
    }

    public void setSisteUforepensjonBeregningTilRevurdering(SisteUforepensjonBeregning sisteUforepensjonBeregningTilRevurdering) {
        this.sisteUforepensjonBeregningTilRevurdering = sisteUforepensjonBeregningTilRevurdering;
    }

    public boolean isFaktorkonvertering() {
        return faktorkonvertering;
    }

    public void setFaktorkonvertering(boolean faktorkonvertering) {
        this.faktorkonvertering = faktorkonvertering;
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
