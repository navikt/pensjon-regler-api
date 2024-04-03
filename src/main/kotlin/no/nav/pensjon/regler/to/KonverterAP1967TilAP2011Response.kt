package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAlderspensjon2011


class KonverterAP1967TilAP2011Response : ServiceResponse() {
    var revurdertBeregningsresultat: BeregningsResultatAlderspensjon2011? = null
}