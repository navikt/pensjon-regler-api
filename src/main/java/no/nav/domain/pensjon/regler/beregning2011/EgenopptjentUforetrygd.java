package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.FormelKodeCti;
import no.nav.domain.pensjon.regler.trygdetid.AnvendtTrygdetid;

import java.io.Serializable;

/**
 * @author Steinar Hjellvik (Decisive) - PKPYTON-1746
 *
 */
public class EgenopptjentUforetrygd implements Serializable {

    

    private double faktor;

    private FormelKodeCti formelKode;

    private int arsbelop;

    private AbstraktBeregningsgrunnlag beregningsgrunnlagOrdiner;

    private AbstraktBeregningsgrunnlag beregningsgrunnlagYrkesskade;

    private boolean beregningsgrunnlagYrkesskadeBest;

    /**
     * Prosentsats brukt for påslag.
     */
    private int konverteringsPaslagForRedGP;

    /**
     * Påslag pga økt redusert grunnpensjon sats til egenopptjent uføretrygd som angår konvertert uføretidpunkt.
     */
    private int konverteringsPaslagForRedGPSats;


    /**
     * Trygdetid som er brukt ved beregning av egenopptjent uføretrygd.
     */
    private AnvendtTrygdetid anvendtTrygdetid;

}
