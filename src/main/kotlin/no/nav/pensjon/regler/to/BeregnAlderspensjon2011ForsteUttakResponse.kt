package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAlderspensjon2011

class BeregnAlderspensjon2011ForsteUttakResponse : ServiceResponse() {
    var beregningsResultat: BeregningsResultatAlderspensjon2011? = null
    var beregningsresultatTilRevurdering: BeregningsResultatAlderspensjon2011? = null
}