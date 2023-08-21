package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent;
import no.nav.pensjon.regler.domain.kode.FormelKodeCti;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

public class AfpLivsvarig extends Ytelseskomponent {
    private static final long serialVersionUID = 8482215632698056210L;

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

    public AfpLivsvarig(AfpLivsvarig o) {
        super(o);
        afpForholdstall = o.afpForholdstall;
        afpProsentgrad = o.afpProsentgrad;
        justeringsbelop = o.justeringsbelop;
    }

    public int getJusteringsbelop() {
        return justeringsbelop;
    }

    public void setJusteringsbelop(int justeringsbelop) {
        this.justeringsbelop = justeringsbelop;
    }

}
