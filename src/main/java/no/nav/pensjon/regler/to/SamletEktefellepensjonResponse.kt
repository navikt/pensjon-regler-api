package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat
import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAfpPrivat
import java.io.Serializable

class SamletEktefellepensjonResponse : Serializable {
    //return soker1Beregningsresultat;
    var soker1Beregningsresultat: AbstraktBeregningsResultat? = null

    //return soker2Beregningsresultat;
    var soker2Beregningsresultat: AbstraktBeregningsResultat? = null
    var soker1Beregning: Beregning? = null
    var soker2Beregning: Beregning? = null
    var soker1BeregningsresultatAfpPrivat: BeregningsResultatAfpPrivat? = null
    var soker2BeregningsresultatAfpPrivat: BeregningsResultatAfpPrivat? = null
    var pakkseddel: Pakkseddel? = null
}