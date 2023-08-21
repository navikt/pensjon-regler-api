package no.nav.pensjon.regler.to;

import java.util.Date;

import no.nav.pensjon.regler.domain.beregning2011.AfpLivsvarig;
import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2011;
import no.nav.pensjon.regler.domain.grunnlag.ForholdstallUtvalg;
import no.nav.pensjon.regler.domain.krav.Kravhode;

public class VilkarsprovAlderpensjon2011Request extends ServiceRequest {
	private static final long serialVersionUID = -4360124186327648054L;

	private Kravhode kravhode;
	private Date fom;
	private Date tom;
	private Date afpVirkFom;
	private ForholdstallUtvalg forholdstallUtvalg;
	private AfpLivsvarig afpLivsvarig;
	private SisteAldersberegning2011 sisteBeregning;
	
	private boolean utforVilkarsberegning;


	public VilkarsprovAlderpensjon2011Request() {
		super();
	}
	
	public VilkarsprovAlderpensjon2011Request(Kravhode kravhode, Date fom, Date tom, ForholdstallUtvalg forholdstallUtvalg, AfpLivsvarig afpLivsvarig, SisteAldersberegning2011 sisteBeregning, boolean utforVilkarsberegning, Date afpVirkFom) {
		super();
		this.kravhode = kravhode;
		this.fom = fom;
		this.tom = tom;
		this.afpVirkFom = afpVirkFom;
		this.forholdstallUtvalg = forholdstallUtvalg;
		this.afpLivsvarig = afpLivsvarig;
		this.sisteBeregning = sisteBeregning;
		this.utforVilkarsberegning = utforVilkarsberegning;	
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
	public Date getTom() {
		return tom;
	}
	public void setTom(Date tom) {
		this.tom = tom;
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
