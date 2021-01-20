package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import no.nav.domain.pensjon.regler.beregning2011.SisteBeregning;
import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

public class VilkarsprovRequest extends ServiceRequest{

	private static final long serialVersionUID = -1846433585527296713L;
	private  Kravhode kravhode;
    private SisteBeregning sisteBeregning;
	private Date fom;
	private Date tom;
	/**
	 * @uml.annotations  for <code>vilkarsvedtakliste</code>
	 *    collection_type="no.nav.domain.pensjon.kjerne.vedtak.Vilkarsvedtak"
	 */
	private List<VilkarsVedtak>  vilkarsvedtakliste;

	public VilkarsprovRequest() {
		super();
		this.vilkarsvedtakliste = new ArrayList<VilkarsVedtak>();
	}

	public VilkarsprovRequest(Kravhode kravhode, SisteBeregning sisteBeregning, Date fom, Date tom) {
		super();
		this.kravhode = kravhode;
        this.sisteBeregning = sisteBeregning;
		this.fom = fom;
		this.tom = tom;
		this.vilkarsvedtakliste = new ArrayList<VilkarsVedtak>();
	}

	public Kravhode getKravhode() {
		return kravhode;
	}

	public void setKravhode(Kravhode kravhode) {
		this.kravhode = kravhode;
	}

    public void setSisteBeregning(SisteBeregning sisteBeregning) {
        this.sisteBeregning = sisteBeregning;
    }

    public SisteBeregning getSisteBeregning() {
        return sisteBeregning;
    }

    public Date getFom() {
		return fom;
	}

	public void setFom(Date fom) {
		this.fom = fom;
	}

	public Date getTom() {
		return tom;
	}

	public void setTom(Date tom) {
		this.tom = tom;
	}

	public List<VilkarsVedtak> getVilkarsvedtakliste() {
		return vilkarsvedtakliste;
	}

	/**
	 * Read only property for vilkarsvedtakliste as array
	 * @return array of VilkarsVedtak
	 */
	public VilkarsVedtak[] getVilkarsvedtaklisteAsArray() {
		return (vilkarsvedtakliste != null ? this.vilkarsvedtakliste.toArray(new VilkarsVedtak[this.vilkarsvedtakliste.size()]) : new VilkarsVedtak[0]);
	}
	
	public void setVilkarsvedtakliste(List<VilkarsVedtak> vilkarsvedtakliste) {
		this.vilkarsvedtakliste = vilkarsvedtakliste;
	}
	
	public VilkarsVedtak[] getSortertVilkarsVedtakListeAsArray() {
		if (vilkarsvedtakliste != null) {
			ArrayList<VilkarsVedtak> sortedVv = new ArrayList<VilkarsVedtak>(vilkarsvedtakliste);
			Collections.sort(sortedVv);
			return sortedVv.toArray(new VilkarsVedtak[sortedVv.size()]);
		}
		return new VilkarsVedtak[0];
	}
}
