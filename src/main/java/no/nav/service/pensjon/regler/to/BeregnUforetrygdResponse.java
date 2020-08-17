package no.nav.service.pensjon.regler.to;

import no.stelvio.common.transferobject.ServiceResponse;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsresultatUforetrygd;

public class BeregnUforetrygdResponse extends ServiceResponse {

    private static final long serialVersionUID = -1331526003111588210L;

    private BeregningsresultatUforetrygd beregningsresultatUforetrygd;

    private Pakkseddel pakkseddel;

    public BeregnUforetrygdResponse() {
        super();
    }

    public BeregnUforetrygdResponse(BeregningsresultatUforetrygd beregningsresultatUforetrygd, Pakkseddel pakkseddel) {
        super();
        this.beregningsresultatUforetrygd = beregningsresultatUforetrygd;
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
