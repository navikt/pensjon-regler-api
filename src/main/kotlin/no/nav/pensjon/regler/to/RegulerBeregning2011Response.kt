package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat


class RegulerBeregning2011Response : ServiceResponse() {
    var beregningsResultat: AbstraktBeregningsResultat? = null
}