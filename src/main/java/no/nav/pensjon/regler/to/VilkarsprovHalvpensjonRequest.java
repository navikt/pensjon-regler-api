package no.nav.pensjon.regler.to;

import java.util.Date;

import no.nav.pensjon.regler.domain.kode.GrunnlagsrolleCti;
import no.nav.pensjon.regler.domain.krav.Kravhode;
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak;


/**
 * @author Magnus Bakken (Accenture) PK-10597 Beslutningsstøtte for vilkår
 */
public class VilkarsprovHalvpensjonRequest extends ServiceRequest {
	private static final long serialVersionUID = 6324205016081838135L;
	
	private Kravhode kravhode;
	private Date fom;
	private Date tom;
	private GrunnlagsrolleCti grunnlagsrolle;

    /**
     * Vilkårsvedtak for uføretrygd.
     */
    private VilkarsVedtak vilkarsvedtak;

	public VilkarsprovHalvpensjonRequest() {
		super();
	}

	public VilkarsprovHalvpensjonRequest(Kravhode kravhode, Date fom, Date tom,
			GrunnlagsrolleCti grunnlagsrolle) {
		super();
		this.kravhode = kravhode;
		this.fom = fom;
		this.tom = tom;
		this.grunnlagsrolle = grunnlagsrolle;
        this.vilkarsvedtak = new VilkarsVedtak(vilkarsvedtak);
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

	public void setTom(Date tom) {
		this.tom = tom;
	}

	public Date getTom() {
		return tom;
	}

	public GrunnlagsrolleCti getGrunnlagsrolle() {
		return grunnlagsrolle;
	}

	public void setGrunnlagsrolle(GrunnlagsrolleCti grunnlagsrolle) {
		this.grunnlagsrolle = grunnlagsrolle;
	}

    public VilkarsVedtak getVilkarsvedtak() {
        return vilkarsvedtak;
    }

    public void setVilkarsvedtak(VilkarsVedtak vilkarsvedtak) {
        this.vilkarsvedtak = vilkarsvedtak;
    }
}
