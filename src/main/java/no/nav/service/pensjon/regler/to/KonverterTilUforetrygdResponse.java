package no.nav.service.pensjon.regler.to;


import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsgrunnlagKonvertert;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsresultatUforetrygd;
import no.nav.domain.pensjon.regler.beregning2011.EktefelletilleggUT;
import no.nav.domain.pensjon.regler.beregning2011.OvergangsinfoUPtilUT;

/**
 * @author Magnus Bakken (Accenture) - PK-7799 - Utvidet response med konverterte beregningsgrunnlag.
 * @author Swiddy de Louw (Capgemini) - PK-8712 - Utvidet response med OvergangsinfoUPtilUT
 */

public class KonverterTilUforetrygdResponse extends ServiceResponse {


    private BeregningsgrunnlagKonvertert beregningsgrunnlagKonvertertOrdinertHjemme;

    private BeregningsgrunnlagKonvertert beregningsgrunnlagKonvertertYrkesskadeHjemme;

    private BeregningsresultatUforetrygd beregningsresultatUforetrygd;

    private Pakkseddel pakkseddel;

    private OvergangsinfoUPtilUT overgangsinfoUPtilUT;

}
