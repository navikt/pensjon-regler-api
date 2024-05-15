package no.nav.pensjon.regler.domain.util.formula

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.beregning.Tilleggspensjon
import no.nav.pensjon.regler.domain.beregning2011.Gjenlevendetillegg
import no.nav.pensjon.regler.domain.beregning2011.GjenlevendetilleggAP
import no.nav.pensjon.regler.domain.beregning2011.GjenlevendetilleggAPKap19

@JsonSubTypes(
    JsonSubTypes.Type(value = Tilleggspensjon::class),
    JsonSubTypes.Type(value = Gjenlevendetillegg::class),
    JsonSubTypes.Type(value = GjenlevendetilleggAP::class),
    JsonSubTypes.Type(value = GjenlevendetilleggAPKap19::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
interface IFormelProvider {
    val formelMap: HashMap<String, Formel>
}