package no.nav.domain.pensjon.regler.beregning.penobjekter;

import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

/**
 * Created by N123422 on 07.11.2014.
 */
public class SkattefriUforetrygdOrdiner extends BeregningYtelseskomponent {

    

    private Integer pensjonsgrad = 0;

    public SkattefriUforetrygdOrdiner() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("SKATT_F_UT_ORDINER");
    }


}
