package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Date;

import no.nav.domain.pensjon.regler.beregning2011.AbstraktBeregningsResultat;
import no.nav.domain.pensjon.regler.beregning2011.AfpLivsvarig;
import no.nav.domain.pensjon.regler.grunnlag.DelingstallUtvalg;
import no.nav.domain.pensjon.regler.grunnlag.ForholdstallUtvalg;
import no.nav.domain.pensjon.regler.grunnlag.Uttaksgrad;

public class RegulerBeregning2011Request extends ServiceRequest {
	private static final long serialVersionUID = -5436561080264077829L;
	
	private Date virkFom;
	private AbstraktBeregningsResultat beregningsResultat;
	private AfpLivsvarig afpLivsvarig;
	private ArrayList<Uttaksgrad> uttaksgradListe;
	private Date fodselsdato;
	private ForholdstallUtvalg forholdstallUtvalg;
	private DelingstallUtvalg delingstallUtvalg;
	
	public RegulerBeregning2011Request() {
		super();
		uttaksgradListe = new ArrayList<Uttaksgrad>();
	}

	public Date getVirkFom() {
		return virkFom;
	}

	public void setVirkFom(Date virkFom) {
		this.virkFom = virkFom;
	}

	public AbstraktBeregningsResultat getBeregningsResultat() {
		return beregningsResultat;
	}

	public void setBeregningsResultat(AbstraktBeregningsResultat beregningsResultat) {
		this.beregningsResultat = beregningsResultat;
	}

	public ArrayList<Uttaksgrad> getUttaksgradListe() {
		return uttaksgradListe;
	}

	public void setUttaksgradListe(ArrayList<Uttaksgrad> uttaksgradListe) {
		this.uttaksgradListe = uttaksgradListe;
	}

	public AfpLivsvarig getAfpLivsvarig() {
		return afpLivsvarig;
	}

	public void setAfpLivsvarig(AfpLivsvarig afpLivsvarig) {
		this.afpLivsvarig = afpLivsvarig;
	}

	public Date getFodselsdato() {
		return fodselsdato;
	}

	public void setFodselsdato(Date fodselsdato) {
		this.fodselsdato = fodselsdato;
	}

	public ForholdstallUtvalg getForholdstallUtvalg() {
		return forholdstallUtvalg;
	}

	public void setForholdstallUtvalg(ForholdstallUtvalg forholdstallUtvalg) {
		this.forholdstallUtvalg = forholdstallUtvalg;
	}

	public DelingstallUtvalg getDelingstallUtvalg() {
		return delingstallUtvalg;
	}

	public void setDelingstallUtvalg(DelingstallUtvalg delingstallUtvalg) {
		this.delingstallUtvalg = delingstallUtvalg;
	}
}
