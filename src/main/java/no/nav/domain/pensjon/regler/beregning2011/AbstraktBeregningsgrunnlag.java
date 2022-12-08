package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.FormelKodeCti;

import java.io.Serializable;

/**
 * @author Steinar Hjellvik (Decisive) - PK-6458
 * @author Magnus Bakken (Accenture) - PK-20759
 */
public abstract class AbstraktBeregningsgrunnlag implements Serializable {

    private FormelKodeCti formelKode;

    private int arsbelop;

    /**
     *  Antatt årlig inntekt før uføretidspunktet (brukes i fastsettelse av opptjening til alderspensjon etter kapittel 19).
     */
    private double antattInntektFaktorKap19;

    /**
     *  Antatt årlig inntekt før uføretidspunktet (brukes i fastsettelse av opptjening til alderspensjon etter kapittel 20).
     */
    private double antattInntektFaktorKap20;

}
