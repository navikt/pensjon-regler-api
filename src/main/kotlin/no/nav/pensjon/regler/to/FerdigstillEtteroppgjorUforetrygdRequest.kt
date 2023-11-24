package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.PenPerson
import no.nav.pensjon.regler.domain.beregning2011.BeregnetUtbetalingsperiode

class FerdigstillEtteroppgjorUforetrygdRequest {
    var beregnetUtbetalingsperiodeListe: MutableList<BeregnetUtbetalingsperiode> = mutableListOf()
    var etteroppgjorsar = 0

    /**
     * Unik id for personen det gjelder.
     * Lagt til av hensyn til arbeid med logger og feilanalyse.
     */
    var penPerson: PenPerson? = null
}