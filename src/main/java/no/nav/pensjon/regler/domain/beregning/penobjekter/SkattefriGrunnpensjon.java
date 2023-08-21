package no.nav.pensjon.regler.domain.beregning.penobjekter;

import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

/**
 * Created by N123422 on 07.11.2014.
 */
public class SkattefriGrunnpensjon extends BeregningYtelseskomponent {

    private static final long serialVersionUID = -5242405294762663752L;

    private Integer pensjonsgrad = 0;

    public SkattefriGrunnpensjon() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("SKATT_F_GP");
    }

    public SkattefriGrunnpensjon(SkattefriGrunnpensjon skattefriGrunnpensjon) {
        super(skattefriGrunnpensjon);
        setPensjonsgrad(skattefriGrunnpensjon.getPensjonsgrad());
    }

    public Integer getPensjonsgrad() {
        return pensjonsgrad;
    }

    public void setPensjonsgrad(Integer pensjonsgrad) {
        this.pensjonsgrad = pensjonsgrad;
    }
}
