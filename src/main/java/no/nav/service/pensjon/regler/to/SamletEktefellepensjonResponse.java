package no.nav.service.pensjon.regler.to;


import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.beregning2011.AbstraktBeregningsResultat;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsResultatAfpPrivat;

public class SamletEktefellepensjonResponse extends ServiceResponse  {
	private static final long serialVersionUID = 8139164929316752781L;
	private AbstraktBeregningsResultat soker1Beregningsresultat;
	private AbstraktBeregningsResultat soker2Beregningsresultat;
	private Beregning soker1Beregning;
	private Beregning soker2Beregning;
	private BeregningsResultatAfpPrivat soker1BeregningsResultatAfpPrivat;
	private BeregningsResultatAfpPrivat soker2BeregningsResultatAfpPrivat;
	private Pakkseddel pakkseddel;

	public SamletEktefellepensjonResponse() {

	}

	public AbstraktBeregningsResultat getSoker1Beregningsresultat() {
		//return soker1Beregningsresultat;
		return soker1Beregningsresultat;
	}

	public void setSoker1Beregningsresultat(AbstraktBeregningsResultat soker1BeregningsResultat) {
		this.soker1Beregningsresultat = soker1BeregningsResultat;
	}

	public AbstraktBeregningsResultat getSoker2Beregningsresultat() {
		//return soker2Beregningsresultat;
		return soker2Beregningsresultat;
	}

	public void setSoker2Beregningsresultat(AbstraktBeregningsResultat soker2BeregningsResultat) {
		this.soker2Beregningsresultat = soker2BeregningsResultat;
	}
	public Beregning getSoker1Beregning() {
		return soker1Beregning;
	}
	
	public void setSoker1Beregning(Beregning soker1Beregning) {
		this.soker1Beregning = soker1Beregning;
	}
	public Beregning getSoker2Beregning() {
		return soker2Beregning;
	}
	
	public void setSoker2Beregning(Beregning soker2Beregning) {
		this.soker2Beregning = soker2Beregning;
	}
	public BeregningsResultatAfpPrivat getSoker1BeregningsresultatAfpPrivat() {
		return soker1BeregningsResultatAfpPrivat;
	}
	
	public void setSoker1BeregningsresultatAfpPrivat(BeregningsResultatAfpPrivat soker1BeregningsResultatAfpPrivat) {
		this.soker1BeregningsResultatAfpPrivat = soker1BeregningsResultatAfpPrivat;
	}
	
	public BeregningsResultatAfpPrivat getSoker2BeregningsresultatAfpPrivat() {
		return soker2BeregningsResultatAfpPrivat;
	}
	
	public void setSoker2BeregningsresultatAfpPrivat(BeregningsResultatAfpPrivat soker2BeregningsResultatAfpPrivat) {
		this.soker2BeregningsResultatAfpPrivat = soker2BeregningsResultatAfpPrivat;
	}

	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}

	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}

}
