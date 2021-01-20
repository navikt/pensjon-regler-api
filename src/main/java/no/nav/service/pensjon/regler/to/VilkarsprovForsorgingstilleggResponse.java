package no.nav.service.pensjon.regler.to;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

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

    /**
     * Read only property for vedtaksliste as array
     * @return array of VilkarsVedtak
     */
    public VilkarsVedtak[] getVilkarsvedtakListeAsArray() {
        return (vedtaksliste != null ? this.vedtaksliste.toArray(new VilkarsVedtak[this.vedtaksliste.size()]) : new VilkarsVedtak[0]);
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
