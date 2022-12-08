package no.nav.domain.pensjon.regler.vedtak;

import java.util.Date;

/**
 * @author Magnus Bakken (Accenture), PK-9491
 */
public class Uforetidspunkt extends AbstraktBeregningsvilkar {


    /**
     * Angir det tidligste året som kan påvirke opptjeningen for dette uføretidspunktet.
     */
    private int tidligstVurderteAr;

    private Date uforetidspunkt;

    /**
     * Dato for når man var sist innmeldt i folketrygden. Benyttes for fremtidig trygdetid.
     */
    private Date sistMedlTrygden;


}
