package no.nav.pensjon.regler.domain.beregning2011

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

/**
 * PK-27754: Innførte nytt felt som skal være på alle uføretrygdytelser.
 */
@JsonSubTypes(
    JsonSubTypes.Type(value = EktefelletilleggUT::class),
    JsonSubTypes.Type(value = UforetrygdOrdiner::class),
    JsonSubTypes.Type(value = AbstraktBarnetilleggUT::class),
    JsonSubTypes.Type(value = Gjenlevendetillegg::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
interface UforetrygdYtelseskomponent {
    var tidligereBelopAr: Int
}
