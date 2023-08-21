package no.nav.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import no.nav.pensjon.regler.domain.krav.Kravhode;
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak;

/**
 * Requestobjekt for BEF2001 Identifiser regelendringer.
 * 
 * @author and2812
 *
 */
public class IdentifiserRegelendringerRequest extends ServiceRequest {

	/**
	 * Generated serial version UID.
	 */
	private static final long serialVersionUID = 9065534571193374334L;

	/** 
	 * Må minimum inneholde: fullt persongrunnlag for brukeren, med persondetaljer, 
	 * uførehistorikk, instopphold etc og persongrunnlaget til 
	 * ektefelle/partner/samboer med persondetaljer. Ref. design for detaljer.
	 */
	private Kravhode kravhode;

	/** 
	 * Alle vedtakene som er innvilget og gyldige i perioden. 
	 */
	private List<VilkarsVedtak> vilkarsvedtakListe = new ArrayList<VilkarsVedtak>();
	
	/**
	 *  Angir om brukeren har AFP-privat 
	 * (dvs. AFP-livsvarig del og eventuellt kronetillegg/kompensasjonstillegg). 
	 * */
	private boolean afpPrivat;
	
	/** 
	 * Fra og med dato for regelendringer. 
	*/
	private Date fom;
	
	/**
	 *  Til og med dato for regelendringer. Ved uviss tom-dato kan dagens dato benyttes. 
	 */
	private Date tom;

	/**
	 *  Default constructor
	 */
	public IdentifiserRegelendringerRequest() {
		super();
	}

	/**
	 * Copy-constructor
	 * 
	 * @param identifiserRegelendringerRequest
	 */
	public IdentifiserRegelendringerRequest(IdentifiserRegelendringerRequest identifiserRegelendringerRequest) {
		super();
		if (identifiserRegelendringerRequest.getKravhode() != null) {
			this.kravhode = new Kravhode(identifiserRegelendringerRequest.getKravhode());
		}
		if (identifiserRegelendringerRequest.getVilkarsvedtakListe() != null) {	
			for (VilkarsVedtak vilkarsvedtak : identifiserRegelendringerRequest.getVilkarsvedtakListe()) {
				this.vilkarsvedtakListe.add(new VilkarsVedtak(vilkarsvedtak));
			}
		}
		afpPrivat = identifiserRegelendringerRequest.isAfpPrivat();
		if (identifiserRegelendringerRequest.getFom() != null) {
			this.fom = new Date(identifiserRegelendringerRequest.getFom().getTime());
		}
		if (identifiserRegelendringerRequest.getTom() != null) {
			this.tom = new Date(identifiserRegelendringerRequest.getTom().getTime());
		}
	}
	
	/**
	 * Constructor
	 * 
	 * @param kravhode
	 * @param vedtaksListe
	 * @param afpPrivat
	 * @param fom
	 * @param tom
	 */
	public IdentifiserRegelendringerRequest(Kravhode kravhode, List<VilkarsVedtak> vedtaksListe, boolean afpPrivat, Date fom, Date tom) {
		super();
		this.kravhode = kravhode;
		this.vilkarsvedtakListe = vedtaksListe;
		this.afpPrivat = afpPrivat;
		this.fom = fom;
		this.tom = tom;
	}
	
	public boolean isAfpPrivat() {
		return afpPrivat;
	}

	public void setAfpPrivat(boolean afpPrivat) {
		this.afpPrivat = afpPrivat;
	}

	public Date getFom() {
		return fom;
	}

	public void setFom(Date fom) {
		this.fom = fom;
	}

	public Kravhode getKravhode() {
		return kravhode;
	}

	public void setKravhode(Kravhode kravhode) {
		this.kravhode = kravhode;
	}

	public Date getTom() {
		return tom;
	}

	public void setTom(Date tom) {
		this.tom = tom;
	}

	public List<VilkarsVedtak> getVilkarsvedtakListe() {
		return vilkarsvedtakListe;
	}

	public void setVilkarsvedtakListe(List<VilkarsVedtak> vedtaksListe) {
		this.vilkarsvedtakListe = vedtaksListe;
	}

	/**
	 * Read only property for vilkarsvedtakListe as array
	 * @return array of VilkarsVedtak
	 */
	public VilkarsVedtak[] getVilkarsvedtakListeAsArray() {
		return (vilkarsvedtakListe != null ? this.vilkarsvedtakListe.toArray(new VilkarsVedtak[this.vilkarsvedtakListe.size()]) : new VilkarsVedtak[0]);
	}	

}
