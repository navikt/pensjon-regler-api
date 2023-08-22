package no.nav.pensjon.regler.to;

import no.nav.pensjon.regler.domain.Pakkseddel;
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak;

import java.util.ArrayList;
import java.util.List;

public class VilkarsprovForsorgingstilleggResponse extends ServiceResponse {
    private List<VilkarsVedtak> vedtaksliste = new ArrayList<>();
    private Pakkseddel pakkseddel = new Pakkseddel(true, true);

    public VilkarsprovForsorgingstilleggResponse() {
        super();
    }

    public VilkarsprovForsorgingstilleggResponse(List<VilkarsVedtak> vedtaksliste) {
        super();
        this.vedtaksliste = vedtaksliste;
    }

    public List<VilkarsVedtak> getVedtaksliste() {
        return vedtaksliste;
    }

    public void setVedtaksliste(List<VilkarsVedtak> vedtaksliste) {
        this.vedtaksliste = vedtaksliste;
    }

    public Pakkseddel getPakkseddel() {
        return pakkseddel;
    }

    public void setPakkseddel(Pakkseddel pakkseddel) {
        this.pakkseddel = pakkseddel;
    }
}
