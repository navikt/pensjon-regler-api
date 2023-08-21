package no.nav.pensjon.regler.to;


import no.nav.pensjon.regler.domain.Pakkseddel;
import no.nav.pensjon.regler.domain.vedtak.EtteroppgjorResultat;

public class FerdigstillEtteroppgjorUforetrygdResponse extends ServiceResponse {

    private static final long serialVersionUID = -8177753432038161640L;
    private EtteroppgjorResultat etteroppgjorResultat;
    private Pakkseddel pakkseddel;

    public Pakkseddel getPakkseddel() {
        return pakkseddel;
    }

    public void setPakkseddel(Pakkseddel pakkseddel) {
        this.pakkseddel = pakkseddel;
    }

    public EtteroppgjorResultat getEtteroppgjorResultat() {
        return etteroppgjorResultat;
    }

    public void setEtteroppgjorResultat(EtteroppgjorResultat etteroppgjorResultat) {
        this.etteroppgjorResultat = etteroppgjorResultat;
    }
}
