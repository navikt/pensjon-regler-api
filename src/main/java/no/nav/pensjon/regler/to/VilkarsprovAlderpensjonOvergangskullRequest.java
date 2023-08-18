package no.nav.pensjon.regler.to;

import java.util.Date;

import no.nav.pensjon.regler.domain.beregning2011.AfpLivsvarig;
import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2011;
import no.nav.pensjon.regler.domain.grunnlag.DelingstallUtvalg;
import no.nav.pensjon.regler.domain.grunnlag.ForholdstallUtvalg;
import no.nav.pensjon.regler.domain.krav.Kravhode;

public class VilkarsprovAlderpensjonOvergangskullRequest extends ServiceRequest {
	private static final long serialVersionUID = -4360124186327648054L;

	private Kravhode kravhode;
	private Date virkFom;
	private ForholdstallUtvalg forholdstallUtvalg;
	private DelingstallUtvalg delingstallUtvalg;
	private AfpLivsvarig afpLivsvarig;
	private Date afpVirkFom;
	private SisteAldersberegning2011 sisteBeregning;
	

	private boolean utforVilkarsberegning;

	/* AND2812 08.04.2010: Kan ikke se noen grunn til at disse skal være her, oppretter CR for å fjerne */
//	private List<VilkarsVedtak> vilkarsvedtakListe = new ArrayList<VilkarsVedtak>();
//	private VilkarsVedtak vilkarsvedtakEPS;

	public VilkarsprovAlderpensjonOvergangskullRequest() {
		super();
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


	/**
	 * Read only property for vilkarsvedtakListe as array
	 * @return array of VilkarsVedtak
	 */
//	public VilkarsVedtak[] getVilkarsvedtakListeAsArray() {
//		return (vilkarsvedtakListe != null ? this.vilkarsvedtakListe.toArray(new VilkarsVedtak[this.vilkarsvedtakListe.size()]) : new VilkarsVedtak[0]);
//	}
//	
//	public void setVilkarsvedtakListe(List<VilkarsVedtak> vilkarsvedtakListe) {
//		this.vilkarsvedtakListe = vilkarsvedtakListe;
//	}

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
