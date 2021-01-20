package no.nav.service.pensjon.regler.to;

import java.util.List;
import java.util.Vector;

import no.nav.domain.pensjon.regler.grunnlag.InstOpphPeriodegrunnlag;

public class InstitusjonsOppholdRequest extends ServiceRequest{

	private static final long serialVersionUID = -7311203540843921062L;

	private List<InstOpphPeriodegrunnlag> instOpphPeriodegrunnlagListe = new Vector<InstOpphPeriodegrunnlag>();

	public InstitusjonsOppholdRequest() {
		super();
	}

	public InstitusjonsOppholdRequest(List<InstOpphPeriodegrunnlag> instOpphPeriodegrunnlagListe) {
		super();
		this.instOpphPeriodegrunnlagListe = instOpphPeriodegrunnlagListe;
	}


	public List<InstOpphPeriodegrunnlag> getInstOpphPeriodegrunnlagListe() {
		return instOpphPeriodegrunnlagListe;
	}

	/**
	 * Read only property for instOpphPeriodegrunnlagListe
	 * @return array of InstOpphPeriodegrunnlag
	 */
	public InstOpphPeriodegrunnlag[] getInstOpphPeriodegrunnlagListeAsArray() {
		return (instOpphPeriodegrunnlagListe != null ? this.instOpphPeriodegrunnlagListe.toArray(new InstOpphPeriodegrunnlag[this.instOpphPeriodegrunnlagListe.size()]) : new InstOpphPeriodegrunnlag[0]);
	}

	public void setInstOpphPeriodegrunnlagListe(
			Vector<InstOpphPeriodegrunnlag> instOpphPeriodegrunnlagListe) {
		this.instOpphPeriodegrunnlagListe = instOpphPeriodegrunnlagListe;
	}
}
