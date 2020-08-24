package no.nav.domain.pensjon.regler.vedtak;

import java.util.Date;

/**
 * Angir inntekt etter uførhet (IEU).
 *
 * @author Magnus Bakken (Accenture), PK-9491, PK-10597 PKPYTON-1063
 * @author Steinar Hjellvik (Decisive), PK-6172
 */
public class InntektEtterUforhet extends AbstraktBeregningsvilkar {

    private static final long serialVersionUID = 1397895334311189056L;

    /**
     * Inntekten.
     */
    private int inntekt;

    /**
     * Virkningstidspunktet for inntekt etter uførhet.
     */
    private Date ieuDato;

    public InntektEtterUforhet(){
        super();
    }

    public InntektEtterUforhet(InntektEtterUforhet inntektEtterUforhet){
        super(inntektEtterUforhet);
        this.inntekt = inntektEtterUforhet.inntekt;
        this.ieuDato = inntektEtterUforhet.ieuDato;
    }

    public int getInntekt() {
        return inntekt;
    }

    public void setInntekt(int inntekt) {
        this.inntekt = inntekt;
    }

    public Date getIeuDato() {
        return ieuDato;
    }

    public void setIeuDato(Date ieuDato) {
        this.ieuDato = ieuDato;
    }

    public AbstraktBeregningsvilkar dypKopi(AbstraktBeregningsvilkar abs) {
        InntektEtterUforhet ieu = null;
        if(abs.getClass() == InntektEtterUforhet.class) {
            ieu = new InntektEtterUforhet((InntektEtterUforhet) abs);
        }
        return ieu;
    }
}
