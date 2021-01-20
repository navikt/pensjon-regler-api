package no.nav.service.pensjon.regler.to;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.beregning2011.AbstraktBeregningsResultat;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsresultatUforetrygd;

/**
 * @author Nabil Safadi (Decisive) - PK-8518
 */
public class BeregnInstitusjonsoppholdResponse extends ServiceResponse {
	private static final long serialVersionUID = -2421181758743665426L;

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
	
	
	public BeregnInstitusjonsoppholdResponse() {
		super();
	}


	public BeregnInstitusjonsoppholdResponse(Pakkseddel pakkseddel, Beregning bruker1Beregning, AbstraktBeregningsResultat bruker1BeregningsResultat, Beregning bruker1BeregningTilRevurdering, AbstraktBeregningsResultat bruker1BeregningsResultatTilRevurdering, Beregning bruker2Beregning, AbstraktBeregningsResultat bruker2BeregningsResultat, Beregning bruker2BeregningTilRevurdering, AbstraktBeregningsResultat bruker2BeregningsResultatTilRevurdering) {
		super();
		this.pakkseddel = pakkseddel;
		this.bruker1Beregning = bruker1Beregning;
		this.bruker1BeregningsResultat = bruker1BeregningsResultat;
		this.bruker1BeregningTilRevurdering = bruker1BeregningTilRevurdering;
		this.bruker1BeregningsResultatTilRevurdering = bruker1BeregningsResultatTilRevurdering;
		this.bruker2Beregning = bruker2Beregning;
		this.bruker2BeregningsResultat = bruker2BeregningsResultat;
		this.bruker2BeregningTilRevurdering = bruker2BeregningTilRevurdering;
		this.bruker2BeregningsResultatTilRevurdering = bruker2BeregningsResultatTilRevurdering;
	}


	public Beregning getBruker1Beregning() {
		return bruker1Beregning;
	}

	public void setBruker1Beregning(Beregning bruker1Beregning) {
		this.bruker1Beregning = bruker1Beregning;
	}


    public BeregningsresultatUforetrygd getBruker1BeregningsresultatUforetrygd() {
        return bruker1BeregningsresultatUforetrygd;
    }

    public void setBruker1BeregningsresultatUforetrygd(BeregningsresultatUforetrygd bruker1BeregningsresultatUforetrygd) {
        this.bruker1BeregningsresultatUforetrygd = bruker1BeregningsresultatUforetrygd;
    }


    public BeregningsresultatUforetrygd getBruker1BeregningsresultatUforetrygdTilRevurdering() {
        return bruker1BeregningsresultatUforetrygdTilRevurdering;
    }

    public void setBruker1BeregningsresultatUforetrygdTilRevurdering(BeregningsresultatUforetrygd bruker1BeregningsresultatUforetrygdTilRevurdering) {
        this.bruker1BeregningsresultatUforetrygdTilRevurdering = bruker1BeregningsresultatUforetrygdTilRevurdering;
    }


	public Beregning getBruker2Beregning() {
		return bruker2Beregning;
	}

	public void setBruker2Beregning(Beregning bruker2Beregning) {
		this.bruker2Beregning = bruker2Beregning;
	}


	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}

	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}


	public AbstraktBeregningsResultat getBruker1BeregningsResultat() {
		return bruker1BeregningsResultat;
	}


	public void setBruker1BeregningsResultat(
			AbstraktBeregningsResultat bruker1BeregningsResultat) {
		this.bruker1BeregningsResultat = bruker1BeregningsResultat;
	}


	public AbstraktBeregningsResultat getBruker2BeregningsResultat() {
		return bruker2BeregningsResultat;
	}


	public void setBruker2BeregningsResultat(
			AbstraktBeregningsResultat bruker2BeregningsResultat) {
		this.bruker2BeregningsResultat = bruker2BeregningsResultat;
	}


	public Beregning getBruker1BeregningTilRevurdering() {
		return bruker1BeregningTilRevurdering;
	}


	public void setBruker1BeregningTilRevurdering(
			Beregning bruker1BeregningTilRevurdering) {
		this.bruker1BeregningTilRevurdering = bruker1BeregningTilRevurdering;
	}


	public AbstraktBeregningsResultat getBruker1BeregningsResultatTilRevurdering() {
		return bruker1BeregningsResultatTilRevurdering;
	}


	public void setBruker1BeregningsResultatTilRevurdering(
			AbstraktBeregningsResultat bruker1BeregningsResultatTilRevurdering) {
		this.bruker1BeregningsResultatTilRevurdering = bruker1BeregningsResultatTilRevurdering;
	}


	public Beregning getBruker2BeregningTilRevurdering() {
		return bruker2BeregningTilRevurdering;
	}


	public void setBruker2BeregningTilRevurdering(
			Beregning bruker2BeregningTilRevurdering) {
		this.bruker2BeregningTilRevurdering = bruker2BeregningTilRevurdering;
	}


	public AbstraktBeregningsResultat getBruker2BeregningsResultatTilRevurdering() {
		return bruker2BeregningsResultatTilRevurdering;
	}


	public void setBruker2BeregningsResultatTilRevurdering(
			AbstraktBeregningsResultat bruker2BeregningsResultatTilRevurdering) {
		this.bruker2BeregningsResultatTilRevurdering = bruker2BeregningsResultatTilRevurdering;
	}
	
	
	
}
