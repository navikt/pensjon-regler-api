package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.beregning2011.BeregningsresultatUforetrygd


class BeregnUforetrygdResponse : ServiceResponse() {
    var beregningsresultatUforetrygd: BeregningsresultatUforetrygd? = null
}