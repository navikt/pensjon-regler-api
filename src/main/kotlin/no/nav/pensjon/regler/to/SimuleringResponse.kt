package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.simulering.Simuleringsresultat


class SimuleringResponse : ServiceResponse() {
    var simuleringsResultat: Simuleringsresultat? = null
}