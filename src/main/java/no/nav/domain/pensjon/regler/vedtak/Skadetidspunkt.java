package no.nav.domain.pensjon.regler.vedtak;

import java.util.Date;

/**
 * @author Magnus Bakken (Accenture), PK-10597, PKPYTON-1063
 */
public class Skadetidspunkt extends AbstraktBeregningsvilkar {

    private static final long serialVersionUID = -4972396557422340167L;

    private Date dato;

    public Skadetidspunkt() {
        super();
    }

    public Skadetidspunkt(Date d) {
        super();
        this.dato = d;
    }

    public Skadetidspunkt(Skadetidspunkt skadetidspunkt) {
        super(skadetidspunkt);
        if (skadetidspunkt.dato != null){
            this.dato = (Date)skadetidspunkt.dato.clone();
        }
    }

    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    public AbstraktBeregningsvilkar dypKopi(AbstraktBeregningsvilkar abs) {
        Skadetidspunkt st = null;
        if(abs.getClass() == Skadetidspunkt.class) {
            st = new Skadetidspunkt((Skadetidspunkt) abs);
        }
        return st;
    }
}
