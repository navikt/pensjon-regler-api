package no.nav.service.pensjon.regler.to;

import java.util.Date;

import no.nav.domain.pensjon.regler.beregning2011.AfpLivsvarig;
import no.nav.domain.pensjon.regler.beregning2011.SisteAldersberegning2011;
import no.nav.domain.pensjon.regler.grunnlag.ForholdstallUtvalg;
import no.nav.domain.pensjon.regler.krav.Kravhode;

public class VilkarsprovAlderpensjon2011Request extends ServiceRequest {


	private Kravhode kravhode;
	private Date fom;
	private Date tom;
	private Date afpVirkFom;
	private ForholdstallUtvalg forholdstallUtvalg;
	private AfpLivsvarig afpLivsvarig;
	private SisteAldersberegning2011 sisteBeregning;
	
	private boolean utforVilkarsberegning;



}
