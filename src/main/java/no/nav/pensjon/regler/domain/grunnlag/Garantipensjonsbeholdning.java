package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.beregning2011.JustertGarantipensjonsniva;
import no.nav.pensjon.regler.domain.kode.BeholdningsTypeCti;
import no.nav.pensjon.regler.domain.kode.GarantipenNivaCti;

public class Garantipensjonsbeholdning extends Beholdning {
    private static final long serialVersionUID = 7094272502601985660L;

    private JustertGarantipensjonsniva justertGarantipensjonsniva;
    private double pensjonsbeholdning;
    private double delingstall67;

    /**
     * Satstype brukt i garantipensjonsnivå.
     */
    private GarantipenNivaCti satsType;

    /**
     * Garantipensjonsnivå sats
     */
    private double sats;

    /**
     * Garantipensjonsnivå justert for trygdetid
     */
    private double garPN_tt_anv;

    /**
     * Garantipensjonsnivå fremskrevet.
     */
    private double garPN_justert;

    public Garantipensjonsbeholdning() {
        super();
        beholdningsType = new BeholdningsTypeCti("GAR_PEN_B");
    }
    public Garantipensjonsbeholdning(Garantipensjonsbeholdning garb) {
        super(garb);
        pensjonsbeholdning = garb.pensjonsbeholdning;
        delingstall67 = garb.delingstall67;
        sats = garb.sats;
        garPN_tt_anv = garb.garPN_tt_anv;
        garPN_justert = garb.garPN_justert;
        if (garb.satsType != null) {
            satsType = new GarantipenNivaCti(garb.satsType);
        }
        if (garb.justertGarantipensjonsniva != null) {
            justertGarantipensjonsniva = new JustertGarantipensjonsniva(garb.justertGarantipensjonsniva);
        }
    }

    public JustertGarantipensjonsniva getJustertGarantipensjonsniva() {
        return justertGarantipensjonsniva;
    }

    public void setJustertGarantipensjonsniva(JustertGarantipensjonsniva justertGarantipensjonsniva) {
        this.justertGarantipensjonsniva = justertGarantipensjonsniva;
    }

    public double getDelingstall67() {
        return delingstall67;
    }

    public void setDelingstall67(double delingstall67) {
        this.delingstall67 = delingstall67;
    }

    public double getPensjonsbeholdning() {
        return pensjonsbeholdning;
    }

    public void setPensjonsbeholdning(double pensjonsbeholdning) {
        this.pensjonsbeholdning = pensjonsbeholdning;
    }

    public GarantipenNivaCti getSatsType() {
        return satsType;
    }

    public void setSatsType(GarantipenNivaCti satsType) {
        this.satsType = satsType;
    }

    public double getSats() {
        return sats;
    }

    public void setSats(double sats) {
        this.sats = sats;
    }

    public double getGarPN_tt_anv() {
        return garPN_tt_anv;
    }

    public void setGarPN_tt_anv(double garPN_tt_anv) {
        this.garPN_tt_anv = garPN_tt_anv;
    }

    public double getGarPN_justert() {
        return garPN_justert;
    }

    public void setGarPN_justert(double garPN_justert) {
        this.garPN_justert = garPN_justert;
    }
}
