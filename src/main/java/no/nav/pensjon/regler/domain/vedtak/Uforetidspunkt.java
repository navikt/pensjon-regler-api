package no.nav.pensjon.regler.domain.vedtak;

import java.util.Date;

/**
 * @author Magnus Bakken (Accenture), PK-9491
 */
public class Uforetidspunkt extends AbstraktBeregningsvilkar {

    private static final long serialVersionUID = -1282519701570926916L;

    /**
     * Angir det tidligste �ret som kan p�virke opptjeningen for dette uf�retidspunktet.
     */
    private int tidligstVurderteAr;

    private Date uforetidspunkt;

    /**
     * Dato for n�r man var sist innmeldt i folketrygden. Benyttes for fremtidig trygdetid.
     */
    private Date sistMedlTrygden;

    public Uforetidspunkt() {
        super();
    }

    public Uforetidspunkt(int tidligstVurderteAr, Date uforetidspunkt) {
        super();
        this.tidligstVurderteAr = tidligstVurderteAr;
        this.uforetidspunkt = uforetidspunkt;
    }

    public Uforetidspunkt(Uforetidspunkt uforetidspunkt) {
        super(uforetidspunkt);
        this.tidligstVurderteAr = uforetidspunkt.tidligstVurderteAr;
        this.uforetidspunkt = uforetidspunkt.uforetidspunkt;
        this.sistMedlTrygden = uforetidspunkt.sistMedlTrygden;
    }

    /**
     * @return Det tidligste �ret som kan p�virke opptjeningen for dette uf�retidspunktet.
     */
    public int getTidligstVurderteAr() {
        return tidligstVurderteAr;
    }

    /**
     * @param tidligstVurderteAr Det tidligste �ret som kan p�virke opptjeningen for dette uf�retidspunktet.
     */
    public void setTidligstVurderteAr(int tidligstVurderteAr) {
        this.tidligstVurderteAr = tidligstVurderteAr;
    }

    public Date getUforetidspunkt() {
        return uforetidspunkt;
    }

    public void setUforetidspunkt(Date uforetidspunkt) {
        this.uforetidspunkt = uforetidspunkt;
    }

    public Date getSistMedlTrygden() { return sistMedlTrygden; }

    public void setSistMedlTrygden(Date sistMedlTrygden) { this.sistMedlTrygden = sistMedlTrygden; }

    public AbstraktBeregningsvilkar dypKopi(AbstraktBeregningsvilkar abs) {
        Uforetidspunkt ut = null;
        if(abs.getClass() == Uforetidspunkt.class) {
            ut = new Uforetidspunkt((Uforetidspunkt) abs);
        }
        return ut;
    }
}
