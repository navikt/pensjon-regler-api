package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAlderspensjon2025


class BeregnAlderspensjon2025ForsteUttakResponse : ServiceResponse() {
    var beregningsResultat: BeregningsResultatAlderspensjon2025? = null
    var beregningsResultatTilRevurdering: BeregningsResultatAlderspensjon2025? = null
}