package no.nav.pensjon.regler.domain.vedtak;

import no.nav.pensjon.regler.domain.beregning2011.JustertMinstePensjonsniva;

public class VilkarsprovInformasjon2011 extends VilkarsprovInformasjon {

    private static final long serialVersionUID = 882121574045797145L;
    private JustertMinstePensjonsniva mpn67;
    private JustertMinstePensjonsniva mpn67ProRata;

    public VilkarsprovInformasjon2011() {
        super();
    }

    public VilkarsprovInformasjon2011(VilkarsprovInformasjon2011 vilkarsprovInformasjon2011) {
        super(vilkarsprovInformasjon2011);
        if (vilkarsprovInformasjon2011.mpn67 != null) {
            mpn67 = new JustertMinstePensjonsniva(vilkarsprovInformasjon2011.mpn67);
        }
        if (vilkarsprovInformasjon2011.mpn67ProRata != null) {
            mpn67ProRata = new JustertMinstePensjonsniva(vilkarsprovInformasjon2011.mpn67ProRata);
        }
    }

    public JustertMinstePensjonsniva getMpn67() {
        return mpn67;
    }

    public void setMpn67(JustertMinstePensjonsniva mpn67) {
        this.mpn67 = mpn67;
    }

    public JustertMinstePensjonsniva getMpn67ProRata() {
        return mpn67ProRata;
    }

    public void setMpn67ProRata(JustertMinstePensjonsniva mpn67ProRata) {
        this.mpn67ProRata = mpn67ProRata;
    }

}
