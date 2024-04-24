package no.nav.pensjon.regler.domain

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.beregning.BeregningRelasjon
import no.nav.pensjon.regler.domain.beregning2011.AfpPrivatBeregning
import no.nav.pensjon.regler.domain.beregning2011.AldersberegningKapittel19
import no.nav.pensjon.regler.domain.beregning2011.AldersberegningKapittel20
import no.nav.pensjon.regler.domain.beregning2011.Uforetrygdberegning

/**
 * Felles interface for Beregning og Beregning2011 klasser.
 */
@JsonSubTypes(
    JsonSubTypes.Type(value = Beregning::class),
    JsonSubTypes.Type(value = AldersberegningKapittel19::class),
    JsonSubTypes.Type(value = AldersberegningKapittel20::class),
    JsonSubTypes.Type(value = AfpPrivatBeregning::class),
    JsonSubTypes.Type(value = Uforetrygdberegning::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
interface IBeregning {
    val delberegningsListe: List<BeregningRelasjon>
}