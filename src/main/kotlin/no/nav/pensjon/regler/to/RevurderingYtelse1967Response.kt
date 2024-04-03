package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.beregning.Beregning


class RevurderingYtelse1967Response : ServiceResponse() {
    var beregning1967: Beregning? = null
    var beregning1967TilRevurdering: Beregning? = null
}