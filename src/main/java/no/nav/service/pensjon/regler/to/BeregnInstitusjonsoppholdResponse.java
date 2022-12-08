package no.nav.service.pensjon.regler.to;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.beregning2011.AbstraktBeregningsResultat;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsresultatUforetrygd;

/**
 * @author Nabil Safadi (Decisive) - PK-8518
 */
public class BeregnInstitusjonsoppholdResponse extends ServiceResponse {

	/**
	 * Pakkseddel for beregningene.
	 */
	private Pakkseddel pakkseddel = new Pakkseddel(true, true);
	
	// bruker1
	Beregning bruker1Beregning;
	AbstraktBeregningsResultat bruker1BeregningsResultat;
	Beregning bruker1BeregningTilRevurdering;
	AbstraktBeregningsResultat bruker1BeregningsResultatTilRevurdering;
    /* Bruker 1s beregningsresultatUforetrygd som skal utbetales ved institusjonsopphold */
    private BeregningsresultatUforetrygd bruker1BeregningsresultatUforetrygd;
    /* Bruker1s beregningsresultatUføretrgd som skal benyttes ved revurdering */
    private BeregningsresultatUforetrygd bruker1BeregningsresultatUforetrygdTilRevurdering;
	
	// bruker2
	Beregning bruker2Beregning;
	AbstraktBeregningsResultat bruker2BeregningsResultat;
	Beregning bruker2BeregningTilRevurdering;
	AbstraktBeregningsResultat bruker2BeregningsResultatTilRevurdering;
}
