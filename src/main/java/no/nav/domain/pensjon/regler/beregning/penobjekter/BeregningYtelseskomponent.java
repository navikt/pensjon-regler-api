package no.nav.domain.pensjon.regler.beregning.penobjekter;

import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;

/**
 * Created by N123422 on 06.11.2014.
 */
public abstract class BeregningYtelseskomponent extends Ytelseskomponent {


    //Benyttes i PEN domenemodell for MapKey in Beregning.
    private String ytelseKomponentTypeName;

    private Beregning beregning;

}
