package no.nav.pensjon.regler.domain.beregning2011;

import java.io.Serializable;

public class JustertGarantipensjonsniva implements Serializable {
    private static final long serialVersionUID = -7989051168459470757L;

    private Garantipensjonsniva garantipensjonsniva;
    private JusteringsInformasjon justeringsInformasjon;
    private double belop;

    public JustertGarantipensjonsniva() {
        super();
    }

    public JustertGarantipensjonsniva(JustertGarantipensjonsniva jgarPN) {
        super();
        belop = jgarPN.belop;
        if (jgarPN.garantipensjonsniva != null) {
            garantipensjonsniva = new Garantipensjonsniva(jgarPN.garantipensjonsniva);
        }
        if (jgarPN.justeringsInformasjon != null) {
            justeringsInformasjon = new JusteringsInformasjon(jgarPN.justeringsInformasjon);
        }
    }

    public JustertGarantipensjonsniva(Garantipensjonsniva garPN) {
        if (garPN != null) {
            garantipensjonsniva = new Garantipensjonsniva(garPN);
        }
    }

    public Garantipensjonsniva getGarantipensjonsniva() {
        return garantipensjonsniva;
    }

    public void setGarantipensjonsniva(Garantipensjonsniva garantipensjonsniva) {
        this.garantipensjonsniva = garantipensjonsniva;
    }

    public JusteringsInformasjon getJusteringsInformasjon() {
        return justeringsInformasjon;
    }

    public void setJusteringsInformasjon(JusteringsInformasjon justeringsInformasjon) {
        this.justeringsInformasjon = justeringsInformasjon;
    }

    public double getBelop() {
        return belop;
    }

    public void setBelop(double belop) {
        this.belop = belop;
    }

}
