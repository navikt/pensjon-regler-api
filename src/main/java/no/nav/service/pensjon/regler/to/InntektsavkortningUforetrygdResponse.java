package no.nav.service.pensjon.regler.to;


import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsresultatUforetrygd;

/**
 * @author Tatyana Lochehina
 */
public class InntektsavkortningUforetrygdResponse extends ServiceResponse {


    /**
     * Beregningsresultat med ny inntektsavkortning.
     */
    private BeregningsresultatUforetrygd beregningsresultatUforetrygd;

    /**
     * Pakkseddel
     */
    private Pakkseddel pakkseddel;


}
