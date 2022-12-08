package no.nav.service.pensjon.regler.to;

import java.util.Date;

import no.nav.domain.pensjon.regler.kode.GrunnlagsrolleCti;
import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;


/**
 * @author Magnus Bakken (Accenture) PK-10597 Beslutningsstøtte for vilkår
 */
public class VilkarsprovHalvpensjonRequest extends ServiceRequest {
	
	private Kravhode kravhode;
	private Date fom;
	private Date tom;
	private GrunnlagsrolleCti grunnlagsrolle;

    /**
     * Vilkårsvedtak for uføretrygd.
     */
    private VilkarsVedtak vilkarsvedtak;

}
