package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.FormelKodeCti;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

public class AfpLivsvarig extends Ytelseskomponent {
    private int justeringsbelop;
    private double afpProsentgrad;
    private double afpForholdstall;

    public double getAfpForholdstall() {
        return afpForholdstall;
    }

    public void setAfpForholdstall(double afpForholdstall) {
        this.afpForholdstall = afpForholdstall;
    }

    public double getAfpProsentgrad() {
        return afpProsentgrad;
    }

    public void setAfpProsentgrad(double afpProsentgrad) {
        this.afpProsentgrad = afpProsentgrad;
    }

    public AfpLivsvarig() {
        super();
        setFormelKode(new FormelKodeCti("AFPx"));
        ytelsekomponentType = new YtelsekomponentTypeCti("AFP_LIVSVARIG");
    }


}
