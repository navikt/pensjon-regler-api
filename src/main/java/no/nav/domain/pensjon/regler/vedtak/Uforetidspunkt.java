package no.nav.domain.pensjon.regler.vedtak;

import java.util.Date;

/**
 * @author Magnus Bakken (Accenture), PK-9491
 */
public class Uforetidspunkt extends AbstraktBeregningsvilkar {


    /**
     * Angir det tidligste �ret som kan p�virke opptjeningen for dette uf�retidspunktet.
     */
    private int tidligstVurderteAr;

    private Date uforetidspunkt;

    /**
     * Dato for n�r man var sist innmeldt i folketrygden. Benyttes for fremtidig trygdetid.
     */
    private Date sistMedlTrygden;


}
