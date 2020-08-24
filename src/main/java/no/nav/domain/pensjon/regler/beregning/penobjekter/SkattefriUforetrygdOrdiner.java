package no.nav.domain.pensjon.regler.beregning.penobjekter;

import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

/**
 * Created by N123422 on 07.11.2014.
 */
public class SkattefriUforetrygdOrdiner extends BeregningYtelseskomponent {

    private static final long serialVersionUID = -7452367185875832581L;

    private Integer pensjonsgrad = 0;

    public SkattefriUforetrygdOrdiner() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("SKATT_F_UT_ORDINER");
    }

    public SkattefriUforetrygdOrdiner(SkattefriUforetrygdOrdiner original) {
        super(original);
        pensjonsgrad = original.pensjonsgrad;
    }

    public Integer getPensjonsgrad() {
        return pensjonsgrad;
    }

    public void setPensjonsgrad(Integer pensjonsgrad) {
        this.pensjonsgrad = pensjonsgrad;
    }
}
