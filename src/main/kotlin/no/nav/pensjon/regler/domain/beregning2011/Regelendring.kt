package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.RegelendringTypeEnum
import java.io.Serializable
import java.util.*

class Regelendring : Serializable {
    /**
     * Datoen en regel- eller satsendring har virkningsdato.
     */
    var endringsdato: Date? = null

    /**
     * Tekst som beskriver typen endring, ref. kodeverk.
     */
    var endringstypeEnum: RegelendringTypeEnum? = null

}