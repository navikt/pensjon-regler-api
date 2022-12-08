package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.beregning2011.PensjonUnderUtbetaling;

import java.io.Serializable;

/**
 * @author Tatyana Lochehina PK-11673
 * @author Swiddy de Louw PK-16620
 */
public class EtteroppgjorGrunnlag implements Serializable {

    

    /**
     * Ytterligere informasjon om etteroppgjør
     */
    private UforetrygdEtteroppgjor uforetrygdEtteroppgjor;

    /**
     * Den PensjonUnderUtbetaling som blir revurdert.
     */
    private PensjonUnderUtbetaling pensjonUnderUtbetalingForRevurdering;


}
