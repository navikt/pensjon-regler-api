package no.nav.service.pensjon.regler.to;

import java.util.Date;
import java.util.Vector;
import no.nav.domain.pensjon.regler.beregning2011.AfpLivsvarig;
import no.nav.domain.pensjon.regler.beregning2011.SisteAldersberegning2011;
import no.nav.domain.pensjon.regler.grunnlag.ForholdstallUtvalg;
import no.nav.domain.pensjon.regler.grunnlag.InfoPavirkendeYtelse;
import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

public class RevurderingAlderspensjon2011Request extends ServiceRequest {
	
	private static final long serialVersionUID = 8379245942724340959L;

	private Kravhode kravhode;
	private Vector<VilkarsVedtak> vilkarsvedtakListe ;
	private InfoPavirkendeYtelse infoPavirkendeYtelse;
	private boolean epsMottarPensjon;
	private ForholdstallUtvalg forholdstallUtvalg;
	private Date virkFom;
	private Date virkTom;
	private SisteAldersberegning2011 forrigeAldersBeregning;
	private AfpLivsvarig afpLivsvarig;
	
	public RevurderingAlderspensjon2011Request() {
		super();
		vilkarsvedtakListe = new Vector<VilkarsVedtak>();
	}

	public RevurderingAlderspensjon2011Request(Kravhode kravhode, Vector<VilkarsVedtak> vilkarsvedtakListe, InfoPavirkendeYtelse infoPavirkendeYtelse, boolean epsMottarPensjon, ForholdstallUtvalg forholdstallUtvalg, Date virkFom, Date virkTom, SisteAldersberegning2011 forrigeAldersBeregning, AfpLivsvarig afpLivsvarig) {
		this();
		this.kravhode = kravhode;
		this.vilkarsvedtakListe = vilkarsvedtakListe;
		this.infoPavirkendeYtelse = infoPavirkendeYtelse;
		this.epsMottarPensjon = epsMottarPensjon;
		this.forholdstallUtvalg = forholdstallUtvalg;
		this.virkFom = virkFom;
		this.virkTom = virkTom;
		this.forrigeAldersBeregning = forrigeAldersBeregning;
		this.afpLivsvarig = afpLivsvarig;
	}

	public boolean isEpsMottarPensjon() {
		return epsMottarPensjon;
	}

	public void setEpsMottarPensjon(boolean epsMottarPensjon) {
		this.epsMottarPensjon = epsMottarPensjon;
	}

	public ForholdstallUtvalg getForholdstallUtvalg() {
		return forholdstallUtvalg;
	}

	public void setForholdstallUtvalg(ForholdstallUtvalg forholdstallUtvalg) {
		this.forholdstallUtvalg = forholdstallUtvalg;
	}

	public SisteAldersberegning2011 getForrigeAldersBeregning() {
		return forrigeAldersBeregning;
	}

	public void setForrigeAldersBeregning(
			SisteAldersberegning2011 forrigeAldersBeregning) {
		this.forrigeAldersBeregning = forrigeAldersBeregning;
	}

	public Kravhode getKravhode() {
		return kravhode;
	}

	public void setKravhode(Kravhode kravhode) {
		this.kravhode = kravhode;
	}

	public Vector<VilkarsVedtak> getVilkarsvedtakListe() {
		return vilkarsvedtakListe;
	}

	/**
	 * Read only property for vilkarsvedtakListe as array
	 * @return array of VilkarsVedtak
	 */
	public VilkarsVedtak[] getVilkarsvedtakListeAsArray() {
		return (vilkarsvedtakListe != null ? this.vilkarsvedtakListe.toArray(new VilkarsVedtak[this.vilkarsvedtakListe.size()]) : new VilkarsVedtak[0]);
	}
	
	public void setVilkarsvedtakListe(Vector<VilkarsVedtak> vilkarsvedtakListe) {
		this.vilkarsvedtakListe = vilkarsvedtakListe;
	}

	public Date getVirkFom() {
		return virkFom;
	}

	public void setVirkFom(Date virkFom) {
		this.virkFom = virkFom;
	}

	public Date getVirkTom() {
		return virkTom;
	}

	public void setVirkTom(Date virkTom) {
		this.virkTom = virkTom;
	}

	public InfoPavirkendeYtelse getInfoPavirkendeYtelse() {
		return infoPavirkendeYtelse;
	}

	public void setInfoPavirkendeYtelse(InfoPavirkendeYtelse infoPavirkendeYtelse) {
		this.infoPavirkendeYtelse = infoPavirkendeYtelse;
	}

	public AfpLivsvarig getAfpLivsvarig() {
		return afpLivsvarig;
	}

	public void setAfpLivsvarig(AfpLivsvarig afpLivsvarig) {
		this.afpLivsvarig = afpLivsvarig;
	}
	
}
