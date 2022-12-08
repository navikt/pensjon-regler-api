package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

/**
 * Requestobjekt for BEF2001 Identifiser regelendringer.
 * 
 * @author and2812
 *
 */
public class IdentifiserRegelendringerRequest extends ServiceRequest {

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

}
