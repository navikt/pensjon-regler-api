package no.nav.domain.pensjon.regler.vedtak;

/**
 * @author Magnus Bakken (Accenture), PK-10597, PKPYTON-1063
 */
public class Yrkesskadegrad extends AbstraktBeregningsvilkar {

    private static final long serialVersionUID = 7217228228692411165L;

    private int grad;

    public Yrkesskadegrad() {
        super();
    }

    public Yrkesskadegrad(int grad) {
        super();
        this.grad = grad;
    }

    public Yrkesskadegrad(Yrkesskadegrad yrkesskadegrad) {
        super(yrkesskadegrad);
        this.grad = yrkesskadegrad.grad;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public AbstraktBeregningsvilkar dypKopi(AbstraktBeregningsvilkar abs) {
        Yrkesskadegrad ysk = null;
        if(abs.getClass() == Yrkesskadegrad.class) {
           ysk = new Yrkesskadegrad((Yrkesskadegrad) abs);
        }
        return ysk;
    }
}
