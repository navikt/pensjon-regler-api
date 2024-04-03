package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat
import no.nav.pensjon.regler.domain.beregning2011.BeregningsresultatUforetrygd


class BeregnInstitusjonsoppholdResponse : ServiceResponse() {
    // bruker1
    var bruker1Beregning: Beregning? = null
    var bruker1BeregningsResultat: AbstraktBeregningsResultat? = null
    var bruker1BeregningTilRevurdering: Beregning? = null
    var bruker1BeregningsResultatTilRevurdering: AbstraktBeregningsResultat? = null

    /* Bruker 1s beregningsresultatUforetrygd som skal utbetales ved institusjonsopphold */
    var bruker1BeregningsresultatUforetrygd: BeregningsresultatUforetrygd? = null

    /* Bruker1s beregningsresultatUføretrgd som skal benyttes ved revurdering */
    var bruker1BeregningsresultatUforetrygdTilRevurdering: BeregningsresultatUforetrygd? = null

    // bruker2
    var bruker2Beregning: Beregning? = null
    var bruker2BeregningsResultat: AbstraktBeregningsResultat? = null
    var bruker2BeregningTilRevurdering: Beregning? = null
    var bruker2BeregningsResultatTilRevurdering: AbstraktBeregningsResultat? = null
}