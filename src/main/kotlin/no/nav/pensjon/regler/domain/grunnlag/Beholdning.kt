package no.nav.pensjon.regler.domain.grunnlag

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.Opptjening
import no.nav.pensjon.regler.domain.beregning2011.LonnsvekstInformasjon
import no.nav.pensjon.regler.domain.beregning2011.ReguleringsInformasjon
import no.nav.pensjon.regler.domain.kode.BeholdningsTypeCti
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import java.io.Serializable

@JsonSubTypes(
    JsonSubTypes.Type(value = Garantitilleggsbeholdning::class),
    JsonSubTypes.Type(value = AfpOpptjening::class),
    JsonSubTypes.Type(value = Garantipensjonsbeholdning::class),
    JsonSubTypes.Type(value = Pensjonsbeholdning::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
abstract class Beholdning protected constructor() : Serializable {
    var ar = 0
    var totalbelop = 0.0
    var opptjening: Opptjening? = null
    var lonnsvekstInformasjon: LonnsvekstInformasjon? = null
    var reguleringsInformasjon: ReguleringsInformasjon? = null
    var formelkode: FormelKodeCti? = null
    var beholdningsType: BeholdningsTypeCti? = null
    var merknadListe: List<Merknad> = mutableListOf()
}