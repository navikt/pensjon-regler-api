package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.GuiPrompt;
import no.nav.pensjon.regler.domain.beregning2011.PensjonUnderUtbetaling;
import no.nav.pensjon.regler.domain.util.ToStringUtil;

import java.io.Serializable;

/**
 * @author Tatyana Lochehina PK-11673
 * @author Swiddy de Louw PK-16620
 */
public class EtteroppgjorGrunnlag implements Serializable {

    private static final long serialVersionUID = 1282769210375222640L;

    /**
     * Ytterligere informasjon om etteroppgj�r
     */
    @GuiPrompt(prompt = "Informasjon om etteroppgj�r")
    private UforetrygdEtteroppgjor uforetrygdEtteroppgjor;

    /**
     * Den PensjonUnderUtbetaling som blir revurdert.
     */
    @GuiPrompt(prompt = "Pensjon under utbetaling som blir revurdert")
    private PensjonUnderUtbetaling pensjonUnderUtbetalingForRevurdering;

    public EtteroppgjorGrunnlag() {
        super();
    }

    public EtteroppgjorGrunnlag(EtteroppgjorGrunnlag etteroppgjorGrunnlag) {
        this();

        if (etteroppgjorGrunnlag.uforetrygdEtteroppgjor != null) {
            uforetrygdEtteroppgjor = new UforetrygdEtteroppgjor(etteroppgjorGrunnlag.uforetrygdEtteroppgjor);
        }

        if (etteroppgjorGrunnlag.pensjonUnderUtbetalingForRevurdering != null) {
            pensjonUnderUtbetalingForRevurdering = new PensjonUnderUtbetaling(etteroppgjorGrunnlag.pensjonUnderUtbetalingForRevurdering);
        }

    }

    public UforetrygdEtteroppgjor getUforetrygdEtteroppgjor() {
        return uforetrygdEtteroppgjor;
    }

    public void setUforetrygdEtteroppgjor(UforetrygdEtteroppgjor uforetrygdEtteroppgjor) {
        this.uforetrygdEtteroppgjor = uforetrygdEtteroppgjor;
    }

    /**
     * @return the pensjonUnderUtbetalingForRevurdering
     */
    public PensjonUnderUtbetaling getPensjonUnderUtbetalingForRevurdering() {
        return pensjonUnderUtbetalingForRevurdering;
    }

    /**
     * @param pensjonUnderUtbetalingForRevurdering the pensjonUnderUtbetalingForRevurdering to set
     */
    public void setPensjonUnderUtbetalingForRevurdering(PensjonUnderUtbetaling pensjonUnderUtbetalingForRevurdering) {
        this.pensjonUnderUtbetalingForRevurdering = pensjonUnderUtbetalingForRevurdering;
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }
}
