package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.beregning2011.BeregningsgrunnlagKonvertert
import no.nav.pensjon.regler.domain.beregning2011.BeregningsresultatUforetrygd
import no.nav.pensjon.regler.domain.beregning2011.OvergangsinfoUPtilUT
import java.io.Serializable

class KonverterTilUforetrygdResponse : Serializable {
    var beregningsgrunnlagKonvertertOrdinertHjemme: BeregningsgrunnlagKonvertert? = null
    var beregningsgrunnlagKonvertertYrkesskadeHjemme: BeregningsgrunnlagKonvertert? = null
    var beregningsresultatUforetrygd: BeregningsresultatUforetrygd? = null
    var pakkseddel: Pakkseddel? = null
    var overgangsinfoUPtilUT: OvergangsinfoUPtilUT? = null
}