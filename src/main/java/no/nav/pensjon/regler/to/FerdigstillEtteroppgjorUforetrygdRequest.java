package no.nav.pensjon.regler.to;

import static no.nav.pensjon.regler.domain.util.ListUtil.deepCopyList;

import java.util.ArrayList;
import java.util.List;

import no.nav.pensjon.regler.domain.PenPerson;

import no.nav.pensjon.regler.domain.beregning2011.BeregnetUtbetalingsperiode;

public class FerdigstillEtteroppgjorUforetrygdRequest extends ServiceRequest {

    private static final long serialVersionUID = 6922410751915204854L;

    private List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeListe = new ArrayList<BeregnetUtbetalingsperiode>();

    private int etteroppgjorsar;

    /**
     * Unik id for personen det gjelder.
     * Lagt til av hensyn til arbeid med logger og feilanalyse.
     */
    private PenPerson penPerson;

    public FerdigstillEtteroppgjorUforetrygdRequest() {
        super();
    }

    public FerdigstillEtteroppgjorUforetrygdRequest(FerdigstillEtteroppgjorUforetrygdRequest ferdigstillEtteroppgjorUforetrygdRequest) {
        super();
        etteroppgjorsar = ferdigstillEtteroppgjorUforetrygdRequest.etteroppgjorsar;
        deepCopyList(ferdigstillEtteroppgjorUforetrygdRequest.beregnetUtbetalingsperiodeListe);
    }

    public List<BeregnetUtbetalingsperiode> getBeregnetUtbetalingsperiodeListe() {
        return beregnetUtbetalingsperiodeListe;
    }

    public BeregnetUtbetalingsperiode[] getBeregnetUtbetalingsperiodeListeAsArray() {
        return beregnetUtbetalingsperiodeListe != null ?
                beregnetUtbetalingsperiodeListe.toArray(new BeregnetUtbetalingsperiode[beregnetUtbetalingsperiodeListe.size()])
                : new BeregnetUtbetalingsperiode[0];
    }

    public int getEtteroppgjorsar() {
        return etteroppgjorsar;
    }

    public void setBeregnetUtbetalingsperiodeListe(List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeListe) {
        this.beregnetUtbetalingsperiodeListe = beregnetUtbetalingsperiodeListe;
    }

    public void setEtteroppgjorsar(int etteroppgjorsar) {
        this.etteroppgjorsar = etteroppgjorsar;
    }

    public PenPerson getPenPerson() {
        return penPerson;
    }

    public void setPenPerson(PenPerson penPerson) {
        this.penPerson = penPerson;
    }
}
