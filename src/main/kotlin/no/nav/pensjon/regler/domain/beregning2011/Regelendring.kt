package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.RegelendringTypeEnum
import java.io.Serializable
import java.util.*
import java.time.LocalDate

class Regelendring : Serializable {
    /**
     * Datoen en regel- eller satsendring har virkningsdato.
     */
    @Deprecated("Use endringsdatoLd instead")
    var endringsdato: Date? = null
    var endringsdatoLd: LocalDate? = null

    /**
     * Tekst som beskriver typen endring, ref. kodeverk.
     */
    var endringstypeEnum: RegelendringTypeEnum? = null

}