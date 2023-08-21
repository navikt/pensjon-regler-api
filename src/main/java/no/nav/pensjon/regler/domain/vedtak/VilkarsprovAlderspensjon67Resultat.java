package no.nav.pensjon.regler.domain.vedtak;

import no.nav.pensjon.regler.domain.beregning.Beregning;

public class VilkarsprovAlderspensjon67Resultat extends AbstraktVilkarsprovResultat {
    private static final long serialVersionUID = -4967773381406059634L;

    private Beregning beregningVedUttak;
    private int halvMinstePensjon;

    public VilkarsprovAlderspensjon67Resultat() {
    }

    public VilkarsprovAlderspensjon67Resultat(Beregning beregningVedUttak, int halvMinstePensjon) {
        super();
        this.beregningVedUttak = beregningVedUttak;
        this.halvMinstePensjon = halvMinstePensjon;
    }

    public VilkarsprovAlderspensjon67Resultat(VilkarsprovAlderspensjon67Resultat r) {
        if (r != null) {
            beregningVedUttak = new Beregning(r.beregningVedUttak);
            halvMinstePensjon = r.halvMinstePensjon;
        }
    }

    public Beregning getBeregningVedUttak() {
        return beregningVedUttak;
    }

    public void setBeregningVedUttak(Beregning beregningVedUttak) {
        this.beregningVedUttak = beregningVedUttak;
    }

    public int getHalvMinstePensjon() {
        return halvMinstePensjon;
    }

    public void setHalvMinstePensjon(int halvMinstePensjon) {
        this.halvMinstePensjon = halvMinstePensjon;
    }

}
