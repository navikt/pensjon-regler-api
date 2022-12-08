package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.List;

import no.nav.domain.pensjon.regler.PenPerson;

import no.nav.domain.pensjon.regler.beregning2011.BeregnetUtbetalingsperiode;

public class FerdigstillEtteroppgjorUforetrygdRequest extends ServiceRequest {

    private List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeListe = new ArrayList<BeregnetUtbetalingsperiode>();

    private int etteroppgjorsar;

    /**
     * Unik id for personen det gjelder.
     * Lagt til av hensyn til arbeid med logger og feilanalyse.
     */
    private PenPerson penPerson;

}
