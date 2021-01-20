package no.nav.service.pensjon.regler.to;

import java.util.Date;

import no.nav.domain.pensjon.regler.grunnlag.Opptjeningsgrunnlag;

public class BeregnPoengtallResponse extends ServiceResponse{

	private static final long serialVersionUID = -175084041181743103L;
	private Opptjeningsgrunnlag opptjening;
	private Date fodselsdato;

	public BeregnPoengtallResponse(Opptjeningsgrunnlag opptjening, Date fodselsdato) {
		super();
		this.opptjening = opptjening;
		this.fodselsdato = fodselsdato;
	}

	public BeregnPoengtallResponse() {
		super();
	}

	public BeregnPoengtallResponse(Opptjeningsgrunnlag opptjening) {
		super();
		this.opptjening = opptjening;
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
