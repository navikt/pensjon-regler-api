package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.beregning2011.PensjonUnderUtbetaling
import java.io.Serializable

/**
 * @author Tatyana Lochehina PK-11673
 * @author Swiddy de Louw PK-16620
 */
class EtteroppgjorGrunnlag : Serializable {
    /**
     * Ytterligere informasjon om etteroppgjør
     */
    var uforetrygdEtteroppgjor: UforetrygdEtteroppgjor? = null
    /**
     * @return the pensjonUnderUtbetalingForRevurdering
     */
    /**
     * @param pensjonUnderUtbetalingForRevurdering the pensjonUnderUtbetalingForRevurdering to set
     */
    /**
     * Den PensjonUnderUtbetaling som blir revurdert.
     */
    var pensjonUnderUtbetalingForRevurdering: PensjonUnderUtbetaling? = null

}