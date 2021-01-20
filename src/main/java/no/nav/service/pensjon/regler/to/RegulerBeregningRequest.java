package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Date;

import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.grunnlag.Persongrunnlag;
import no.nav.domain.pensjon.regler.grunnlag.Uttaksgrad;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

public class RegulerBeregningRequest extends ServiceRequest {
	private static final long serialVersionUID = 4216891788328945353L;
	
	private Beregning beregning1967;
	private Date virkFom;
	private ArrayList<Uttaksgrad> uttaksgradListe;
	private ArrayList<VilkarsVedtak> brukersVilkarsvedtakListe;
	private Persongrunnlag sokersPersongrunnlag;
	private Persongrunnlag epsPersongrunnlag;
	
	public RegulerBeregningRequest() {
		super();
		uttaksgradListe = new ArrayList<Uttaksgrad>();
		brukersVilkarsvedtakListe = new ArrayList<VilkarsVedtak>();
	}

	public Beregning getBeregning1967() {
		return beregning1967;
	}

	public void setBeregning1967(Beregning beregning1967) {
		this.beregning1967 = beregning1967;
	}

	public Date getVirkFom() {
		return virkFom;
	}

	public void setVirkFom(Date virkFom) {
		this.virkFom = virkFom;
	}

	public ArrayList<Uttaksgrad> getUttaksgradListe() {
		return uttaksgradListe;
	}
	/**
	 * Read only property for opptjeningsgrunnlagListe as array.
	 * @return array of Opptjeningsgrunnlag
	 */
	public Uttaksgrad[] getUttaksgradListeAsArray() {
		return (uttaksgradListe != null ? uttaksgradListe.toArray(new Uttaksgrad[uttaksgradListe.size()]) : new Uttaksgrad[0]);
	}

	public void setUttaksgradListe(ArrayList<Uttaksgrad> uttaksgradListe) {
		this.uttaksgradListe = uttaksgradListe;
	}

	public ArrayList<VilkarsVedtak> getBrukersVilkarsvedtakListe() {
		return brukersVilkarsvedtakListe;
	}

	public void setBrukersVilkarsvedtakListe(
			ArrayList<VilkarsVedtak> brukersVilkarsvedtakListe) {
		this.brukersVilkarsvedtakListe = brukersVilkarsvedtakListe;
	}
	/**
	 * Read only property for opptjeningsgrunnlagListe as array.
	 * @return array of Opptjeningsgrunnlag
	 */
	public VilkarsVedtak[] getBrukersVilkarsvedtakListeAsArray() {
		return (brukersVilkarsvedtakListe != null ? brukersVilkarsvedtakListe.toArray(new VilkarsVedtak[brukersVilkarsvedtakListe.size()]) : new VilkarsVedtak[0]);
	}

	public Persongrunnlag getSokersPersongrunnlag() {
		return sokersPersongrunnlag;
	}

	public void setSokersPersongrunnlag(Persongrunnlag sokersPersongrunnlag) {
		this.sokersPersongrunnlag = sokersPersongrunnlag;
	}

	public Persongrunnlag getEpsPersongrunnlag() {
		return epsPersongrunnlag;
	}

	public void setEpsPersongrunnlag(Persongrunnlag epsPersongrunnlag) {
		this.epsPersongrunnlag = epsPersongrunnlag;
	}
	
}
