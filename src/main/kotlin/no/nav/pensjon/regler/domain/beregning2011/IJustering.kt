package no.nav.pensjon.regler.domain.beregning2011

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import java.util.*
import java.time.LocalDate

@JsonSubTypes(
    JsonSubTypes.Type(value = IFremskriving::class),
    JsonSubTypes.Type(value = ILonnsvekst::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
interface IJustering {
    var justeringsfaktor: Double
    @Deprecated("Use justeringTomDatoLd instead")
    var justeringTomDato: Date?
    var justeringTomDatoLd: LocalDate?
}