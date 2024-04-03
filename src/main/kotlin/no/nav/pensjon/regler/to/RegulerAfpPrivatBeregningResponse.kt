package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAfpPrivat


class RegulerAfpPrivatBeregningResponse : ServiceResponse() {
    var beregningsResultat: BeregningsResultatAfpPrivat? = null
}