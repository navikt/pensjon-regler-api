package no.nav.pensjon.regler.to;

import java.util.List;
import java.util.Vector;

import no.nav.pensjon.regler.domain.grunnlag.InstOpphPeriodegrunnlag;

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

	public void setInstOpphPeriodegrunnlagListe(
			Vector<InstOpphPeriodegrunnlag> instOpphPeriodegrunnlagListe) {
		this.instOpphPeriodegrunnlagListe = instOpphPeriodegrunnlagListe;
	}
}
