package no.nav.service.pensjon.regler.to;

import java.util.Date;

import no.nav.domain.pensjon.regler.beregning2011.AfpLivsvarig;
import no.nav.domain.pensjon.regler.beregning2011.SisteAldersberegning2011;
import no.nav.domain.pensjon.regler.grunnlag.DelingstallUtvalg;
import no.nav.domain.pensjon.regler.grunnlag.ForholdstallUtvalg;
import no.nav.domain.pensjon.regler.grunnlag.GarantitilleggsbeholdningGrunnlag;
import no.nav.domain.pensjon.regler.krav.Kravhode;

public class VilkarsprovAlderpensjon2025Request extends ServiceRequest {
	private static final long serialVersionUID = -4360124186327648054L;

	private Kravhode kravhode;
	private Date fom;
	private ForholdstallUtvalg forholdstallUtvalg;
	private DelingstallUtvalg delingstallUtvalg;
	private AfpLivsvarig afpLivsvarig;
	private Date afpVirkFom;
	private SisteAldersberegning2011 sisteBeregning;
	private boolean utforVilkarsberegning;
	private GarantitilleggsbeholdningGrunnlag garantitilleggsbeholdningGrunnlag;

	public VilkarsprovAlderpensjon2025Request() {
		super();
	}


	public Kravhode getKravhode() { 
		return kravhode; 
	}
	public void setKravhode(Kravhode kravhode) {
		this.kravhode = kravhode;
	}
	public Date getFom() {
		return fom;
	}
	public void setFom(Date fom) {
		this.fom = fom;
	}

	public Kravhode getKravHode() {
		return kravhode;
	}
	public void setKravHode(Kravhode kravhode) {
		this.kravhode = kravhode;
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


	public SisteAldersberegning2011 getSisteBeregning() {
		return sisteBeregning;
	}
	public void setSisteBeregning(SisteAldersberegning2011 sisteBeregning) {
		this.sisteBeregning = sisteBeregning;
	}
	public AfpLivsvarig getAfpLivsvarig() {
		return afpLivsvarig;
	}
	public void setAfpLivsvarig(AfpLivsvarig afpLivsvarig) {
		this.afpLivsvarig = afpLivsvarig;
	}

	public boolean isUtforVilkarsberegning() {
		return utforVilkarsberegning;
	}

	public void setUtforVilkarsberegning(boolean utforVilkarsberegning) {
		this.utforVilkarsberegning = utforVilkarsberegning;
	}

	public Date getAfpVirkFom() {
		return afpVirkFom;
	}

	public void setAfpVirkFom(Date afpVirkFom) {
		this.afpVirkFom = afpVirkFom;
	}


	public GarantitilleggsbeholdningGrunnlag getGarantitilleggsbeholdningGrunnlag() {
		return garantitilleggsbeholdningGrunnlag;
	}


	public void setGarantitilleggsbeholdningGrunnlag(
			GarantitilleggsbeholdningGrunnlag garantitilleggsbeholdningGrunnlag) {
		this.garantitilleggsbeholdningGrunnlag = garantitilleggsbeholdningGrunnlag;
	}

}
