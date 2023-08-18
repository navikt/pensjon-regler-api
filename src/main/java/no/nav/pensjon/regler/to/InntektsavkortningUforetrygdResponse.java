package no.nav.pensjon.regler.to;


import no.nav.pensjon.regler.domain.Pakkseddel;
import no.nav.pensjon.regler.domain.beregning2011.BeregningsresultatUforetrygd;

/**
 * @author Tatyana Lochehina
 */
public class InntektsavkortningUforetrygdResponse extends ServiceResponse {

    private static final long serialVersionUID = -7765743395365518675L;

    /**
     * Beregningsresultat med ny inntektsavkortning.
     */
    private BeregningsresultatUforetrygd beregningsresultatUforetrygd;

    /**
     * Pakkseddel
     */
    private Pakkseddel pakkseddel;

    public InntektsavkortningUforetrygdResponse() {
        super();
    }

    public InntektsavkortningUforetrygdResponse(BeregningsresultatUforetrygd res, Pakkseddel pakkseddel) {
        this();
        beregningsresultatUforetrygd = res;
        this.pakkseddel = pakkseddel;
    }

    public BeregningsresultatUforetrygd getBeregningsresultatUforetrygd() {
        return beregningsresultatUforetrygd;
    }

    public void setBeregningsresultatUforetrygd(BeregningsresultatUforetrygd beregningsresultatUforetrygd) {
        this.beregningsresultatUforetrygd = beregningsresultatUforetrygd;
    }

    public Pakkseddel getPakkseddel() {
        return pakkseddel;
    }

    public void setPakkseddel(Pakkseddel pakkseddel) {
        this.pakkseddel = pakkseddel;
    }

}
