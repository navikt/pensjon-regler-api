package no.nav.service.pensjon.regler.to;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.beregning2011.AfpLivsvarig;
import no.nav.domain.pensjon.regler.grunnlag.InfoPavirkendeYtelse;
import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;
/**
 * 
 * @author Christian Arnesen
 *
 */
public class KonverterAP1967TilAP2011Request extends ServiceRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3959229534766179901L;
	private Kravhode kravhode;
	private List<VilkarsVedtak> vilkarsvedtakListe = new Vector<VilkarsVedtak>();
	private InfoPavirkendeYtelse infoPavirkendeYtelse;
	private Beregning beregning;
	private Date virkFom;
	private boolean epsMottarPensjon;
	private AfpLivsvarig afpLivsvarig;
	
	public KonverterAP1967TilAP2011Request() {
		super();
	}

	public KonverterAP1967TilAP2011Request(Kravhode kravhode, List<VilkarsVedtak> vilkarsvedtakListe, InfoPavirkendeYtelse infoPavirkendeYtelse, Beregning beregning, Date virkFom, boolean epsMottarPensjon) {
		super();
		this.kravhode = kravhode;
		this.vilkarsvedtakListe = vilkarsvedtakListe;
		this.infoPavirkendeYtelse = infoPavirkendeYtelse;
		this.beregning = beregning;
		this.virkFom = virkFom;
		this.epsMottarPensjon = epsMottarPensjon;
	}
	
	public Beregning getBeregning() {
		return beregning;
	}
	public void setBeregning(Beregning beregning) {
		this.beregning = beregning;
	}
	public boolean isEpsMottarPensjon() {
		return epsMottarPensjon;
	}
	public void setEpsMottarPensjon(boolean epsMottarPensjon) {
		this.epsMottarPensjon = epsMottarPensjon;
	}
	public InfoPavirkendeYtelse getInfoPavirkendeYtelse() {
		return infoPavirkendeYtelse;
	}
	public void setInfoPavirkendeYtelse(InfoPavirkendeYtelse infoPavirkendeYtelse) {
		this.infoPavirkendeYtelse = infoPavirkendeYtelse;
	}
	public Kravhode getKravhode() {
		return kravhode;
	}
	public void setKravhode(Kravhode kravhode) {
		this.kravhode = kravhode;
	}
	public VilkarsVedtak[] getVilkarsvedtakListeAsArray() {
		return (vilkarsvedtakListe!=null?this.vilkarsvedtakListe.toArray(new VilkarsVedtak[vilkarsvedtakListe.size()]):new VilkarsVedtak[0]);
	}
	
	public List<VilkarsVedtak> getVilkarsvedtakListe() {
		return vilkarsvedtakListe;
	}

	public void setVilkarsvedtakListe(List<VilkarsVedtak> vilkarsvedtakListe) {
		this.vilkarsvedtakListe = vilkarsvedtakListe;
	}
	public Date getVirkFom() {
		return virkFom;
	}
	public void setVirkFom(Date virkFom) {
		this.virkFom = virkFom;
	}

	public AfpLivsvarig getAfpLivsvarig() {
		return afpLivsvarig;
	}

	public void setAfpLivsvarig(AfpLivsvarig afpLivsvarig) {
		this.afpLivsvarig = afpLivsvarig;
	}

}
