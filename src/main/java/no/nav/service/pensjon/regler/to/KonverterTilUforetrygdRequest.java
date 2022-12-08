package no.nav.service.pensjon.regler.to;

import java.util.Date;
import java.util.Vector;


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

}
