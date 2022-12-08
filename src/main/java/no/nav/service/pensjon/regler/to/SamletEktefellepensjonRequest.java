package no.nav.service.pensjon.regler.to;


import java.util.ArrayList;
import java.util.List;

import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.beregning2011.AbstraktBeregningsResultat;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsResultatAfpPrivat;
import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

public class SamletEktefellepensjonRequest extends ServiceRequest {
	private AbstraktBeregningsResultat soker1Beregningsresultat;
	private AbstraktBeregningsResultat soker2Beregningsresultat;
	private Beregning soker1Beregning;
	private Beregning soker2Beregning;
	private BeregningsResultatAfpPrivat soker1BeregningsresultatAfpPrivat;
	private BeregningsResultatAfpPrivat soker2BeregningsresultatAfpPrivat;
	private Kravhode soker1Kravhode;
	private Kravhode soker2Kravhode;
	private Kravhode soker1Kravhode2011;
	private Kravhode soker2Kravhode2011;
	private List<VilkarsVedtak> soker1VilkarsvedtakListe = new ArrayList<VilkarsVedtak>();
	private List<VilkarsVedtak> soker2VilkarsvedtakListe = new ArrayList<VilkarsVedtak>();
	private List<VilkarsVedtak> soker1VilkarsvedtakListe2011 = new ArrayList<VilkarsVedtak>();
	private List<VilkarsVedtak> soker2VilkarsvedtakListe2011 = new ArrayList<VilkarsVedtak>();
	 

	
}
