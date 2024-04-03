package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAlderspensjon2016


class RevurderingOvergangskullResponse : ServiceResponse() {
    var revurdertBeregningsResultat: BeregningsResultatAlderspensjon2016? = null
}