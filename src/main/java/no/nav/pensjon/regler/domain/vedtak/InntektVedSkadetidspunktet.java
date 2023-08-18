package no.nav.pensjon.regler.domain.vedtak;

/**
 * @author Magnus Bakken (Accenture), PK-10597
 */
public class InntektVedSkadetidspunktet extends AbstraktBeregningsvilkar {

    private static final long serialVersionUID = -6132448674812437369L;

    private int inntekt;

    public InntektVedSkadetidspunktet() {
        super();
    }

    public InntektVedSkadetidspunktet(int inntekt) {
        super();
        this.inntekt = inntekt;
    }

    public InntektVedSkadetidspunktet(InntektVedSkadetidspunktet inntektVedSkadetidspunktet) {
        super(inntektVedSkadetidspunktet);
        this.inntekt = inntektVedSkadetidspunktet.inntekt;
    }

    public int getInntekt() {
        return inntekt;
    }

    public void setInntekt(int inntekt) {
        this.inntekt = inntekt;
    }

    public AbstraktBeregningsvilkar dypKopi(AbstraktBeregningsvilkar abs) {
        InntektVedSkadetidspunktet ivs = null;
        if(abs.getClass() == InntektVedSkadetidspunktet.class) {
            ivs = new InntektVedSkadetidspunktet((InntektVedSkadetidspunktet) abs);
        }
        return ivs;
    }
}
