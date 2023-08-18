package no.nav.pensjon.regler.to;

import java.util.Date;

import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAfpPrivat;

public class RegulerAfpPrivatBeregningRequest extends ServiceRequest {
	private static final long serialVersionUID = -3094634556146897922L;
	
	private Date virkFom;
	private Date virkFomAfpFrivatUttak;
	private BeregningsResultatAfpPrivat beregningsResultat;	
	
	public RegulerAfpPrivatBeregningRequest() {
		super();
	}

	public RegulerAfpPrivatBeregningRequest(Date virkFom,
			Date virkFomAfpFrivatUttak,
			BeregningsResultatAfpPrivat beregningsResultat) {
		this();
		this.virkFom = virkFom;
		this.virkFomAfpFrivatUttak = virkFomAfpFrivatUttak;
		this.beregningsResultat = beregningsResultat;
	}

	public Date getVirkFom() {
		return virkFom;
	}

	public void setVirkFom(Date virkFom) {
		this.virkFom = virkFom;
	}

	public Date getVirkFomAfpFrivatUttak() {
		return virkFomAfpFrivatUttak;
	}

	public void setVirkFomAfpFrivatUttak(Date virkFomAfpFrivatUttak) {
		this.virkFomAfpFrivatUttak = virkFomAfpFrivatUttak;
	}

	public BeregningsResultatAfpPrivat getBeregningsResultat() {
		return beregningsResultat;
	}

	public void setBeregningsResultat(BeregningsResultatAfpPrivat beregningsResultat) {
		this.beregningsResultat = beregningsResultat;
	}
	
}
