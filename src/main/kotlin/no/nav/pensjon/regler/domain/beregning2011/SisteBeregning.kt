package no.nav.pensjon.regler.domain.beregning2011

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.kode.BorMedTypeCti
import no.nav.pensjon.regler.domain.kode.ResultatTypeCti
import no.nav.pensjon.regler.domain.kode.SivilstandTypeCti
import java.io.Serializable
import java.util.*

/**
 * Felles grensesnitt for Siste beregninger slik som SisteBeregning1967, SisteAldersberegning2011, SisteGjenlevendeberegning
 */
@JsonSubTypes(
    JsonSubTypes.Type(value = SisteAldersberegning2011::class),
    JsonSubTypes.Type(value = SisteBeregning1967::class),
    JsonSubTypes.Type(value = SisteUforepensjonBeregning::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
abstract class SisteBeregning protected constructor() : Serializable {
    var virkDato: Date? = null
    var tt_anv = 0
    var resultatType: ResultatTypeCti? = null
    var sivilstandType: SivilstandTypeCti? = null
    var benyttetSivilstand: BorMedTypeCti? = null

}