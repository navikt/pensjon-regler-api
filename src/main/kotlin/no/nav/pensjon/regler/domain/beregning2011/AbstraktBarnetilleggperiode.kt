package no.nav.pensjon.regler.domain.beregning2011

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.trygdetid.Brok
import java.io.Serializable
import java.util.*
import java.time.LocalDate

@JsonSubTypes(
    JsonSubTypes.Type(value = TidligereBarnetilleggperiode::class),
    JsonSubTypes.Type(value = FremtidigBarnetilleggperiode::class),
    JsonSubTypes.Type(value = AvkortingsinformasjonBT::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
abstract class AbstraktBarnetilleggperiode : Serializable {
    /**
     * Start for periode med et antall barn.
     */
    @Deprecated("Use fomDatoLd instead")
    var fomDato: Date? = null
    var fomDatoLd: LocalDate? = null

    /**
     * Stopp for periode med et antall barn.
     */
    @Deprecated("Use tomDatoLd instead")
    var tomDato: Date? = null
    var tomDatoLd: LocalDate? = null

    /**
     * Periodens lengde i antall måneder.
     */
    var lengde = 0

    /**
     * Antall barn det beregnes barnetillegg for i perioden.
     */
    var antallBarn = 0

    /**
     * Fribeløpet for antall barn i perioden.
     */
    var fribelop = 0

    /**
     * Brutto årlig barnetillegg, beregnet for antall barn (felles- og særkullsbarn) i perioden og eventuelt redusert mot tak.
     */
    var bruttoPerAr = 0

    /**
     * Reguleringsfaktor dersom perioden gjelder for en annen G enn GvedVirk.
     */
    var reguleringsfaktor: Brok? = null

    /**
     * Halvparten av inntekt overskytende fribeløp. Fastsatt som årlig beløp, dvs oppjustert til årlig beløp dersom fribeløp og inntekt er periodisert.
     */
    var avkortingsbelopPerAr = 0

}