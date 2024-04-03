package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat
import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAfpPrivat


class SamletEktefellepensjonResponse : ServiceResponse() {
    //return soker1Beregningsresultat;
    var soker1Beregningsresultat: AbstraktBeregningsResultat? = null

    //return soker2Beregningsresultat;
    var soker2Beregningsresultat: AbstraktBeregningsResultat? = null
    var soker1Beregning: Beregning? = null
    var soker2Beregning: Beregning? = null
    var soker1BeregningsresultatAfpPrivat: BeregningsResultatAfpPrivat? = null
    var soker2BeregningsresultatAfpPrivat: BeregningsResultatAfpPrivat? = null
}