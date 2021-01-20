package no.nav.service.pensjon.regler.to;

import java.util.Date;

import no.nav.domain.pensjon.regler.grunnlag.Opptjeningsgrunnlag;

public class BeregnPoengtallRequest extends ServiceRequest{

	private static final long serialVersionUID = 1549575076171580341L;

	private Opptjeningsgrunnlag opptjening;
	private Date fodselsdato;

	public BeregnPoengtallRequest() {
		super();
	}

	public BeregnPoengtallRequest(Opptjeningsgrunnlag opptjening, Date d) {
		super();
		this.opptjening = opptjening;
		this.fodselsdato = d;
	}

	public Opptjeningsgrunnlag getOpptjening() {
		return opptjening;
	}

	public void setOpptjening(Opptjeningsgrunnlag opptjening) {
		this.opptjening = opptjening;
	}

	public Date getFodselsdato() {
		return fodselsdato;
	}

	public void setFodselsdato(Date fodselsdato) {
		this.fodselsdato = fodselsdato;
	}

}
