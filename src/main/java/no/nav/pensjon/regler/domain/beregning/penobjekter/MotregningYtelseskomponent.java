package no.nav.pensjon.regler.domain.beregning.penobjekter;

/**
 * Created by N123422 on 06.11.2014.
 */
public abstract class MotregningYtelseskomponent extends BeregningYtelseskomponent {

    private static final long serialVersionUID = -675866734547173660L;
    private Integer dagsats = 0;
    private Integer antallDager = 0;

    public MotregningYtelseskomponent() {
        super();
    }

    public MotregningYtelseskomponent(MotregningYtelseskomponent motregningYtelseskomponent) {
        super(motregningYtelseskomponent);
        dagsats = motregningYtelseskomponent.dagsats;
        antallDager = motregningYtelseskomponent.antallDager;
    }

    public Integer getDagsats() {
        return dagsats;
    }

    public void setDagsats(Integer dagsats) {
        this.dagsats = dagsats;
    }

    public Integer getAntallDager() {
        return antallDager;
    }

    public void setAntallDager(Integer antallDager) {
        this.antallDager = antallDager;
    }
}
