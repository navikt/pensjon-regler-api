package no.nav.pensjon.regler.to;

import java.util.Date;

import no.nav.pensjon.regler.domain.beregning2011.AfpLivsvarig;
import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2016;
import no.nav.pensjon.regler.domain.grunnlag.DelingstallUtvalg;
import no.nav.pensjon.regler.domain.grunnlag.ForholdstallUtvalg;
import no.nav.pensjon.regler.domain.grunnlag.GarantitilleggsbeholdningGrunnlag;
import no.nav.pensjon.regler.domain.krav.Kravhode;
/**
 * 
 * @author Christian Arnesen
 *
 */
public class VilkarsprovAlderpensjon2016Request extends ServiceRequest {
	private static final long serialVersionUID = -4360124186327648054L;

	private Kravhode kravhode;
	private Date virkFom;
	private ForholdstallUtvalg forholdstallUtvalg;
	private DelingstallUtvalg delingstallUtvalg;
	private AfpLivsvarig afpLivsvarig;
	private Date afpVirkFom;
	private SisteAldersberegning2016 sisteBeregning;
	private boolean utforVilkarsberegning;
	private GarantitilleggsbeholdningGrunnlag garantitilleggsbeholdningGrunnlag;

	public VilkarsprovAlderpensjon2016Request() {
		super();
	}


	public GarantitilleggsbeholdningGrunnlag getGarantitilleggsbeholdningGrunnlag() {
		return garantitilleggsbeholdningGrunnlag;
	}


	public void setGarantitilleggsbeholdningGrunnlag(
			GarantitilleggsbeholdningGrunnlag garantitilleggsbeholdningGrunnlag) {
		this.garantitilleggsbeholdningGrunnlag = garantitilleggsbeholdningGrunnlag;
	}


	public Kravhode getKravhode() { 
		return kravhode; 
	}
	public void setKravhode(Kravhode kravhode) {
		this.kravhode = kravhode;
	}
	

	public Date getVirkFom() {
		return virkFom;
	}


	public void setVirkFom(Date virkFom) {
		this.virkFom = virkFom;
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


	public SisteAldersberegning2016 getSisteBeregning() {
		return sisteBeregning;
	}
	public void setSisteBeregning(SisteAldersberegning2016 sisteBeregning) {
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

}
