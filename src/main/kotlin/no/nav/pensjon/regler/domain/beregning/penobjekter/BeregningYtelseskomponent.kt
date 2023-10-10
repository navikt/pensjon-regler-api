package no.nav.pensjon.regler.domain.beregning.penobjekter

import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent

/**
 * Created by N123422 on 06.11.2014.
 */
abstract class BeregningYtelseskomponent : Ytelseskomponent() {
    //Benyttes i PEN domenemodell for MapKey in Beregning.
    private var ytelseKomponentTypeName: String? = null
    protected var beregning: Beregning? = null
}