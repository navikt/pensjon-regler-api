package no.nav.pensjon.regler.domain.beregning2011

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent


@JsonSubTypes(
    JsonSubTypes.Type(value = FremskrevetAfpLivsvarig::class),
    JsonSubTypes.Type(value = AfpOffentligLivsvarig::class),
    JsonSubTypes.Type(value = AfpPrivatLivsvarig::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
abstract class AbstraktAfpLivsvarig : Ytelseskomponent()