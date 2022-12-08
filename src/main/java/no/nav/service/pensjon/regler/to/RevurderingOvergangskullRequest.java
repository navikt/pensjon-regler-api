package no.nav.service.pensjon.regler.to;

import java.util.Date;
import java.util.Vector;

import no.nav.domain.pensjon.regler.beregning2011.AfpLivsvarig;
import no.nav.domain.pensjon.regler.beregning2011.SisteAldersberegning2011;
import no.nav.domain.pensjon.regler.grunnlag.DelingstallUtvalg;
import no.nav.domain.pensjon.regler.grunnlag.ForholdstallUtvalg;
import no.nav.domain.pensjon.regler.grunnlag.InfoPavirkendeYtelse;
import no.nav.domain.pensjon.regler.kode.ResultatTypeCti;
import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

public class RevurderingOvergangskullRequest extends ServiceRequest {
	

	private Kravhode kravhode;
	private Vector<VilkarsVedtak> vilkarsvedtakListe ;
	private InfoPavirkendeYtelse infoPavirkendeYtelse;
	private DelingstallUtvalg delingstallUtvalg;
	private ForholdstallUtvalg forholdstallUtvalg;
	private Date virkFom;
	private SisteAldersberegning2011 sisteAldersBeregning;
	private double nettoUPellerGJP;
	private ResultatTypeCti nettoUPellerGJPresultatType;
	private AfpLivsvarig afpLivsvarig;

	
}
