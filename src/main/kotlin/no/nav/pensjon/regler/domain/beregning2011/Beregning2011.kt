package no.nav.pensjon.regler.domain.beregning2011

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.PenPerson
import no.nav.pensjon.regler.domain.beregning.BeregningRelasjon
import no.nav.pensjon.regler.domain.kode.BeregningGjelderTypeCti
import no.nav.pensjon.regler.domain.kode.BeregningMetodeTypeCti
import no.nav.pensjon.regler.domain.kode.BeregningTypeCti
import no.nav.pensjon.regler.domain.kode.ResultatTypeCti
import java.io.Serializable

@JsonSubTypes(
    JsonSubTypes.Type(value = Uforetrygdberegning::class),
    JsonSubTypes.Type(value = AfpPrivatBeregning::class),
    JsonSubTypes.Type(value = AldersberegningKapittel20::class),
    JsonSubTypes.Type(value = AldersberegningKapittel19::class),
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
abstract class Beregning2011 : Serializable {
    var gjelderPerson: PenPerson? = null
    open var grunnbelop = 0
    var tt_anv = 0
    var resultatType: ResultatTypeCti? = null
    var beregningsMetode: BeregningMetodeTypeCti? = null
    var beregningType: BeregningTypeCti? = null
    var delberegning2011Liste: List<BeregningRelasjon> = mutableListOf()
    var merknadListe: List<Merknad> = mutableListOf()

    val delberegningsListe: List<BeregningRelasjon>
        get() = delberegning2011Liste

    /**
     * Feltet støtter navngivning av beregningen i beregningstreet.
     * Ifbm. Gjenlevendetillegg settes koden avhengig av hvilke grunnlagsroller som beregningen angår.
     */
    var beregningGjelderType: BeregningGjelderTypeCti? = null
}