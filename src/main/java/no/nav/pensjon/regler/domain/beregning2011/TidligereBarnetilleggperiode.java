package no.nav.pensjon.regler.domain.beregning2011;


public class TidligereBarnetilleggperiode extends AbstraktBarnetilleggperiode {

    private static final long serialVersionUID = -6866183043209335219L;
    /**
     * Hva barnetillegget i tidligere periode faktisk ble avkortet med per år.
     */
    private double faktiskFradragPerAr;

    /**
     * Periodens bidrag til avviksbeløp.
     */
    private double avviksbelop;

    public TidligereBarnetilleggperiode() {
    }

    public TidligereBarnetilleggperiode(TidligereBarnetilleggperiode tbtp) {
        super(tbtp);
        this.faktiskFradragPerAr = tbtp.faktiskFradragPerAr;
        this.avviksbelop = tbtp.avviksbelop;
    }

    public double getFaktiskFradragPerAr() {
        return faktiskFradragPerAr;
    }

    public void setFaktiskFradragPerAr(double faktiskFradragPerAr) {
        this.faktiskFradragPerAr = faktiskFradragPerAr;
    }

    public double getAvviksbelop() {
        return avviksbelop;
    }

    public void setAvviksbelop(double avviksbelop) {
        this.avviksbelop = avviksbelop;
    }
}
