package no.nav.pensjon.regler.domain.beregning2011;

public class JustertMinstePensjonsniva implements java.io.Serializable {
    private static final long serialVersionUID = -377818334414250198L;

    private MinstePensjonsniva minstePensjonsniva;
    private JusteringsInformasjon justeringsInformasjon;
    private double belop;

    public JustertMinstePensjonsniva() {
        super();
    }

    public JustertMinstePensjonsniva(JustertMinstePensjonsniva fmpn) {
        super();
        belop = fmpn.belop;
        if (fmpn.minstePensjonsniva != null) {
            minstePensjonsniva = new MinstePensjonsniva(fmpn.minstePensjonsniva);
        }
        if (fmpn.justeringsInformasjon != null) {
            justeringsInformasjon = new JusteringsInformasjon(fmpn.justeringsInformasjon);
        }
    }

    public JustertMinstePensjonsniva(MinstePensjonsniva mpn) {
        if (mpn != null) {
            minstePensjonsniva = new MinstePensjonsniva(mpn);
        }
    }

    public JusteringsInformasjon getJusteringsInformasjon() {
        return justeringsInformasjon;
    }

    public void setJusteringsInformasjon(JusteringsInformasjon justeringsInformasjon) {
        this.justeringsInformasjon = justeringsInformasjon;
    }

    public MinstePensjonsniva getMinstePensjonsniva() {
        return minstePensjonsniva;
    }

    public void setMinstePensjonsniva(MinstePensjonsniva minstePensjonsniva) {
        this.minstePensjonsniva = minstePensjonsniva;
    }

    public double getBelop() {
        return belop;
    }

    public void setBelop(double belop) {
        this.belop = belop;
    }

}
