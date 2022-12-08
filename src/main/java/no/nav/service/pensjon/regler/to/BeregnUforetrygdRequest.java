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


}
