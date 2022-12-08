package no.nav.service.pensjon.regler.to;


import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.beregning2011.AbstraktBeregningsResultat;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsResultatAfpPrivat;

public class SamletEktefellepensjonResponse extends ServiceResponse  {
	private AbstraktBeregningsResultat soker1Beregningsresultat;
	private AbstraktBeregningsResultat soker2Beregningsresultat;
	private Beregning soker1Beregning;
	private Beregning soker2Beregning;
	private BeregningsResultatAfpPrivat soker1BeregningsResultatAfpPrivat;
	private BeregningsResultatAfpPrivat soker2BeregningsResultatAfpPrivat;
	private Pakkseddel pakkseddel;


}
