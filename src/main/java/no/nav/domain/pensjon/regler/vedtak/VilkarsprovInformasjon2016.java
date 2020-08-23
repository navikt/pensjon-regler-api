package no.nav.domain.pensjon.regler.vedtak;

public class VilkarsprovInformasjon2016 extends VilkarsprovInformasjon {

    private static final long serialVersionUID = -6399772600537494102L;
    private double vektetPensjonsniva;
    private double vektetPensjonsnivaProRata;
    private VilkarsprovInformasjon2011 vilkarsprovInformasjon2011;
    private VilkarsprovInformasjon2025 vilkarsprovInformasjon2025;

    public VilkarsprovInformasjon2016() {
        super();
    }

    public VilkarsprovInformasjon2016(VilkarsprovInformasjon2016 vilkarsprovInformasjon2016) {
        super(vilkarsprovInformasjon2016);
        vektetPensjonsniva = vilkarsprovInformasjon2016.vektetPensjonsniva;
        vektetPensjonsnivaProRata = vilkarsprovInformasjon2016.vektetPensjonsnivaProRata;
        if (vilkarsprovInformasjon2016.vilkarsprovInformasjon2011 != null) {
            vilkarsprovInformasjon2011 = new VilkarsprovInformasjon2011(vilkarsprovInformasjon2016.vilkarsprovInformasjon2011);
        }
        if (vilkarsprovInformasjon2016.vilkarsprovInformasjon2025 != null) {
            vilkarsprovInformasjon2025 = new VilkarsprovInformasjon2025(vilkarsprovInformasjon2016.vilkarsprovInformasjon2025);
        }
    }

    public double getVektetPensjonsniva() {
        return vektetPensjonsniva;
    }

    public void setVektetPensjonsniva(double vektetPensjonsniva) {
        this.vektetPensjonsniva = vektetPensjonsniva;
    }

    public double getVektetPensjonsnivaProRata() {
        return vektetPensjonsnivaProRata;
    }

    public void setVektetPensjonsnivaProRata(double vektetPensjonsnivaProRata) {
        this.vektetPensjonsnivaProRata = vektetPensjonsnivaProRata;
    }

    public VilkarsprovInformasjon2011 getVilkarsprovInformasjon2011() {
        return vilkarsprovInformasjon2011;
    }

    public void setVilkarsprovInformasjon2011(VilkarsprovInformasjon2011 vilkarsprovInformasjon2011) {
        this.vilkarsprovInformasjon2011 = vilkarsprovInformasjon2011;
    }

    public VilkarsprovInformasjon2025 getVilkarsprovInformasjon2025() {
        return vilkarsprovInformasjon2025;
    }

    public void setVilkarsprovInformasjon2025(VilkarsprovInformasjon2025 vilkarsprovInformasjon2025) {
        this.vilkarsprovInformasjon2025 = vilkarsprovInformasjon2025;
    }
}
