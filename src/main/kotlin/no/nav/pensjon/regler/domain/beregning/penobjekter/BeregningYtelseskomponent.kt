package no.nav.pensjon.regler.domain.beregning.penobjekter

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent

/**
 * Created by N123422 on 06.11.2014.
 */
@JsonSubTypes(
    JsonSubTypes.Type(value = MotregningYtelseskomponent::class),
    JsonSubTypes.Type(value = SkattefriGrunnpensjon::class),
    JsonSubTypes.Type(value = SkattefriUforetrygdOrdiner::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
abstract class BeregningYtelseskomponent : Ytelseskomponent() {
    //Benyttes i PEN domenemodell for MapKey in Beregning.
    private var ytelseKomponentTypeName: String? = null
    protected var beregning: Beregning? = null
}