package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.beregning2011.BeregningsgrunnlagKonvertert
import no.nav.pensjon.regler.domain.beregning2011.BeregningsresultatUforetrygd
import no.nav.pensjon.regler.domain.beregning2011.EktefelletilleggUT
import no.nav.pensjon.regler.domain.beregning2011.OvergangsinfoUPtilUT
import java.io.Serializable

/**
 * @author Magnus Bakken (Accenture) - PK-7799 - Utvidet response med konverterte beregningsgrunnlag.
 * @author Swiddy de Louw (Capgemini) - PK-8712 - Utvidet response med OvergangsinfoUPtilUT
 */
class KonverterTilUforetrygdResponse : Serializable {
    var beregningsgrunnlagKonvertertOrdinertHjemme: BeregningsgrunnlagKonvertert? = null
    var beregningsgrunnlagKonvertertYrkesskadeHjemme: BeregningsgrunnlagKonvertert? = null
    var beregningsresultatUforetrygd: BeregningsresultatUforetrygd? = null
    var pakkseddel: Pakkseddel? = null
    var overgangsinfoUPtilUT: OvergangsinfoUPtilUT? = null
}