package no.nav.pensjon.regler.domain.vedtak;

import no.nav.pensjon.regler.domain.Trygdetid;

/**
 * Beregningsvilkår trygdetid.
 *
 * @author Magnus Bakken (Accenture), PK-10597, PKPYTON-1063
 */
public class TrygdetidBeregningsvilkar extends AbstraktBeregningsvilkar {

    private static final long serialVersionUID = 6960158100594909935L;

    /**
     * Trygdetiden.
     */
    private Trygdetid trygdetid;

    public TrygdetidBeregningsvilkar() {
        super();
    }

    public TrygdetidBeregningsvilkar(Trygdetid trygdetid) {
        super();
        this.trygdetid = trygdetid;
    }

    /**
     * Kopikonstruktør.
     * @param trygdetidBeregningsvilkar TrygdetidBeregningsvilkar som skal kopieres.
     */
    public TrygdetidBeregningsvilkar(TrygdetidBeregningsvilkar trygdetidBeregningsvilkar) {
        super(trygdetidBeregningsvilkar);
        this.trygdetid = new Trygdetid(trygdetidBeregningsvilkar.trygdetid);
    }

    /**
     * @return trygdetiden.
     */
    public Trygdetid getTrygdetid() {
        return trygdetid;
    }

    /**
     * @param trygdetid Ny trygdetid.
     */
    public void setTrygdetid(Trygdetid trygdetid) {
        this.trygdetid = trygdetid;
    }

    public AbstraktBeregningsvilkar dypKopi(AbstraktBeregningsvilkar abs) {
        TrygdetidBeregningsvilkar tb = null;
        if(abs.getClass() == TrygdetidBeregningsvilkar.class) {
            tb = new TrygdetidBeregningsvilkar((TrygdetidBeregningsvilkar) abs);
        }
        return tb;
    }
}
