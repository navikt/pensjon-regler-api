package no.nav.pensjon.regler.domain.vedtak;

import no.nav.pensjon.regler.domain.beregning2011.JustertGarantipensjonsniva;
import no.nav.pensjon.regler.domain.grunnlag.Beholdninger;

public class VilkarsprovInformasjon2025 extends VilkarsprovInformasjon {

    private static final long serialVersionUID = 4154065835093240730L;
    private JustertGarantipensjonsniva garPN67;
    private JustertGarantipensjonsniva garPN67ProRata;
    private Beholdninger beholdningerVed67;

    public VilkarsprovInformasjon2025() {
        super();
    }

    public VilkarsprovInformasjon2025(VilkarsprovInformasjon2025 vilkarsprovInformasjon2025) {
        super(vilkarsprovInformasjon2025);
        if (vilkarsprovInformasjon2025.garPN67 != null) {
            garPN67 = new JustertGarantipensjonsniva(vilkarsprovInformasjon2025.garPN67);
        }
        if (vilkarsprovInformasjon2025.garPN67ProRata != null) {
            garPN67ProRata = new JustertGarantipensjonsniva(vilkarsprovInformasjon2025.garPN67ProRata);
        }
        if (vilkarsprovInformasjon2025.beholdningerVed67 != null) {
            beholdningerVed67 = new Beholdninger(vilkarsprovInformasjon2025.beholdningerVed67);
        }
    }

    public JustertGarantipensjonsniva getGarPN67() {
        return garPN67;
    }

    public void setGarPN67(JustertGarantipensjonsniva garPN67) {
        this.garPN67 = garPN67;
    }

    public JustertGarantipensjonsniva getGarPN67ProRata() {
        return garPN67ProRata;
    }

    public void setGarPN67ProRata(JustertGarantipensjonsniva garPN67ProRata) {
        this.garPN67ProRata = garPN67ProRata;
    }

    public Beholdninger getBeholdningerVed67() {
        return beholdningerVed67;
    }

    public void setBeholdningerVed67(Beholdninger beholdningerVed67) {
        this.beholdningerVed67 = beholdningerVed67;
    }

}
