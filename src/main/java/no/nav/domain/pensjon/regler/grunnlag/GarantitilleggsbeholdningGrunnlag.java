package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;

public class GarantitilleggsbeholdningGrunnlag implements Serializable {

    

    /**
     * Delingstall ved fylte 67 år for årskull født 1962.
     */
    private double dt67_1962;

    /**
     * Forholdstall ved fylte 67 år for årskull født 1962.
     */
    private double ft67_1962;

    public GarantitilleggsbeholdningGrunnlag() {
    }

    public GarantitilleggsbeholdningGrunnlag(GarantitilleggsbeholdningGrunnlag garantitilleggsbeholdningGrunnlag) {
        dt67_1962 = garantitilleggsbeholdningGrunnlag.dt67_1962;
        ft67_1962 = garantitilleggsbeholdningGrunnlag.ft67_1962;
    }

    public double getDt67_1962() {
        return dt67_1962;
    }

    public void setDt67_1962(double dt67_1962) {
        this.dt67_1962 = dt67_1962;
    }

    public double getFt67_1962() {
        return ft67_1962;
    }

    public void setFt67_1962(double ft67_1962) {
        this.ft67_1962 = ft67_1962;
    }

}
