package no.nav.pensjon.regler.to;

import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAfpPrivat;
import no.nav.pensjon.regler.domain.krav.Kravhode;
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak;

import java.util.ArrayList;
import java.util.Date;

public class BeregnAfpPrivatRequest extends ServiceRequest  { 
	private static final long serialVersionUID = -5519872985990364386L;
	
	private Kravhode kravhode;
	private ArrayList<VilkarsVedtak> vilkarsvedtakListe;
	private Date virkFom;
	private double ft;
	private int justeringsbelop;
	private int referansebelop;
	private double ftKompensasjonstillegg;
	private BeregningsResultatAfpPrivat sisteAfpPrivatBeregning;
	private Date virkFomAfpPrivatUttak;

	public BeregnAfpPrivatRequest() {
		super();
		vilkarsvedtakListe = new ArrayList<VilkarsVedtak>();
	}
	
	public double getFt() {
		return ft;
	}

	public void setFt(double ft) {
		this.ft = ft;
	}

	public double getFtKompensasjonstillegg() {
		return ftKompensasjonstillegg;
	}

	public void setFtKompensasjonstillegg(double ftKompensasjonstillegg) {
		this.ftKompensasjonstillegg = ftKompensasjonstillegg;
	}

	public int getJusteringsbelop() {
		return justeringsbelop;
	}

	public void setJusteringsbelop(int justeringsbelop) {
		this.justeringsbelop = justeringsbelop;
	}

	public Kravhode getKravhode() {
		return kravhode;
	}

	public void setKravhode(Kravhode kravhode) {
		this.kravhode = kravhode;
	}

	public int getReferansebelop() { 
		return referansebelop;
	}

	public void setReferansebelop(int referansebelop) {
		this.referansebelop = referansebelop;
	}

	public ArrayList<VilkarsVedtak> getVilkarsvedtakListe() {
		return vilkarsvedtakListe;
	}
	
	/**
	 * Read only property for vilkarsvedtakListe as array
	 * @return array of VilkarsVedtak
	 */
	public VilkarsVedtak[] getVilkarsvedtakListeAsArray() {
		return (vilkarsvedtakListe != null ? vilkarsvedtakListe.toArray(new VilkarsVedtak[vilkarsvedtakListe.size()]) : new VilkarsVedtak[0]);
	}
	
	public void setVilkarsvedtakListe(ArrayList<VilkarsVedtak> vilkarsvedtakListe) {
		this.vilkarsvedtakListe = vilkarsvedtakListe;
	}

	public Date getVirkFom() {
		return virkFom;
	}

	public void setVirkFom(Date virkFom) {
		this.virkFom = virkFom;
	}

	public BeregningsResultatAfpPrivat getSisteAfpPrivatBeregning() {
		return sisteAfpPrivatBeregning;
	}

	public void setSisteAfpPrivatBeregning(
			BeregningsResultatAfpPrivat sisteAfpPrivatBeregning) {
		this.sisteAfpPrivatBeregning = sisteAfpPrivatBeregning;
	}

	public Date getVirkFomAfpPrivatUttak() {
		return virkFomAfpPrivatUttak;
	}

	public void setVirkFomAfpPrivatUttak(Date virkFomAfpPrivatUttak) {
		this.virkFomAfpPrivatUttak = virkFomAfpPrivatUttak;
	}

	
}
