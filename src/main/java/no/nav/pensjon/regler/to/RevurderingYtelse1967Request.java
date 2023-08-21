package no.nav.pensjon.regler.to;

import java.util.Date;
import java.util.Vector;

import no.nav.pensjon.regler.domain.beregning2011.SisteBeregning1967;
import no.nav.pensjon.regler.domain.grunnlag.InfoPavirkendeYtelse;
import no.nav.pensjon.regler.domain.krav.Kravhode;
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak;

public class RevurderingYtelse1967Request extends ServiceRequest {
	
	private static final long serialVersionUID = 8379245942724340959L;

	private Date virkFom;
	private Kravhode kravhode;
	private Vector<VilkarsVedtak> vilkarsvedtakListe ;
	private SisteBeregning1967 sisteBeregning1967;
	private InfoPavirkendeYtelse infoPavirkendeYtelse;
	private boolean epsMottarPensjon;
	private boolean beregnForsorgingstillegg;
	private boolean beregnInstitusjonsopphold;

	
	public RevurderingYtelse1967Request() {
		super();
		vilkarsvedtakListe = new Vector<VilkarsVedtak>();
	}

	public boolean isBeregnForsorgingstillegg() {
		return beregnForsorgingstillegg;
	}

	public void setBeregnForsorgingstillegg(boolean beregnForsorgingstillegg) {
		this.beregnForsorgingstillegg = beregnForsorgingstillegg;
	}

	public boolean isBeregnInstitusjonsopphold() {
		return beregnInstitusjonsopphold;
	}

	public void setBeregnInstitusjonsopphold(boolean beregnInstitusjonsopphold) {
		this.beregnInstitusjonsopphold = beregnInstitusjonsopphold;
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

	public SisteBeregning1967 getSisteBeregning1967() {
		return sisteBeregning1967;
	}

	public void setSisteBeregning1967(SisteBeregning1967 sisteBeregning1967) {
		this.sisteBeregning1967 = sisteBeregning1967;
	}

	public Vector<VilkarsVedtak> getVilkarsvedtakListe() {
		return vilkarsvedtakListe;
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

	/**
	 * Read only property for vilkarsvedtakListe as array
	 * @return array of VilkarsVedtak
	 */
	public VilkarsVedtak[] getVilkarsvedtakListeAsArray() {
		return (vilkarsvedtakListe != null ? this.vilkarsvedtakListe.toArray(new VilkarsVedtak[this.vilkarsvedtakListe.size()]) : new VilkarsVedtak[0]);
	}
	
	
}
