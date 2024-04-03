package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAlderspensjon2011

class BeregnOvergangskullResponse : ServiceResponse() {
    var revurdertBeregningsResultat: BeregningsResultatAlderspensjon2011? = null
}