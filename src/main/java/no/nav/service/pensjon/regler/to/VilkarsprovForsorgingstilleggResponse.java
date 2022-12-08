package no.nav.service.pensjon.regler.to;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

import java.util.ArrayList;
import java.util.List;

public class VilkarsprovForsorgingstilleggResponse extends ServiceResponse {
    private List<VilkarsVedtak> vedtaksliste = new ArrayList<>();
    private Pakkseddel pakkseddel = new Pakkseddel(true, true);

}
