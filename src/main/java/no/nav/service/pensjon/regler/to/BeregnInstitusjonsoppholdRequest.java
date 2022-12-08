package no.nav.service.pensjon.regler.to;

import java.util.Date;
import java.util.Vector;

import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.beregning2011.AbstraktBeregningsResultat;
import no.nav.domain.pensjon.regler.beregning2011.AfpLivsvarig;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsresultatUforetrygd;
import no.nav.domain.pensjon.regler.beregning2011.SisteAldersberegning2011;
import no.nav.domain.pensjon.regler.grunnlag.ForholdstallUtvalg;
import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

/**
 * @author PREG
 * @author Stian Kroknes (Accenture) PENPORT-1055
 * @author Nabil Safadi (Decisive) - PK-8518
 */
public class BeregnInstitusjonsoppholdRequest extends ServiceRequest {
	private Date fom;
	
	// bruker1 beregning1967
	private Beregning bruker1Beregning;
	private Kravhode bruker1Kravhode; 
	private Vector<VilkarsVedtak> bruker1VilkarsvedtakListe = new Vector<VilkarsVedtak>();
	
	// bruker1  beregningsResultat(dekker 2011,2016 og 2025)
	private AbstraktBeregningsResultat bruker1BeregningsResultat;
	private Kravhode bruker1Kravhode2011;
	private Vector<VilkarsVedtak> bruker1VilkarsvedtakListe2011 = new Vector<VilkarsVedtak>();
	private ForholdstallUtvalg bruker1ForholdstallUtvalg;
	private SisteAldersberegning2011 bruker1SisteAldersberegning2011;
    /* Informasjon om uføretrygdberegning for bruker1. Kun påkrevd dersom bruker1 har uføretrygd. */
    private BeregningsresultatUforetrygd bruker1BeregningsresultatUforetrygd;

    /* Informasjon om afpPrivatberegning for bruker1. Kun påkrevd dersom bruker1 har AfpPrivat. */
	private AfpLivsvarig bruker1afpLivsvarig;
	
	// bruker2 beregning1967
	private Beregning bruker2Beregning;
	private Kravhode bruker2Kravhode;
	private Vector<VilkarsVedtak> bruker2VilkarsvedtakListe = new Vector<VilkarsVedtak>();
	
	// bruker2  beregningsResultat(dekker 2011,2016 og 2025)
	private AbstraktBeregningsResultat bruker2BeregningsResultat;
	private Kravhode bruker2Kravhode2011;
	private Vector<VilkarsVedtak> bruker2VilkarsvedtakListe2011 = new Vector<VilkarsVedtak>();
	private ForholdstallUtvalg bruker2ForholdstallUtvalg;
	private SisteAldersberegning2011 bruker2SisteAldersberegning2011;

	/* Informasjon om afpPrivatberegning for bruker2. Kun påkrevd dersom bruker2 har AfpPrivat. */
	private AfpLivsvarig bruker2afpLivsvarig;
	

}
