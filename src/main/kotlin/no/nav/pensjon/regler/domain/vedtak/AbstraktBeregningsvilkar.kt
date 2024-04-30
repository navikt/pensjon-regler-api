package no.nav.pensjon.regler.domain.vedtak

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.Merknad
import java.io.Serializable

@JsonSubTypes(
    JsonSubTypes.Type(value = Alderspensjon2011VedDod::class),
    JsonSubTypes.Type(value = TrygdetidBeregningsvilkar::class),
    JsonSubTypes.Type(value = TidligereGjenlevendePensjon::class),
    JsonSubTypes.Type(value = Yrkesskadegrad::class),
    JsonSubTypes.Type(value = InntektVedSkadetidspunktet::class),
    JsonSubTypes.Type(value = InntektEtterUforhet::class),
    JsonSubTypes.Type(value = Skadetidspunkt::class),
    JsonSubTypes.Type(value = Uforetidspunkt::class),
    JsonSubTypes.Type(value = InntektForUforhet::class),
    JsonSubTypes.Type(value = Uforegrad::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
abstract class AbstraktBeregningsvilkar protected constructor() : Serializable {
    var merknadListe: List<Merknad> = mutableListOf()
}