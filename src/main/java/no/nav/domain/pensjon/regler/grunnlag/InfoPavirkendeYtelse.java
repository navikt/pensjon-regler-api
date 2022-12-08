package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.YtelseTypeCti;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InfoPavirkendeYtelse implements Serializable {


    /**
     * Liste av alle vilk�rsvedtak for hovedytelse som EPS har l�pende.
     */
    private List<VilkarsVedtak> vilkarsvedtakEPSListe = new ArrayList<VilkarsVedtak>();
    /**
     * EPS uforegrad dersom EPS har uf�repensjon.
     */
    private int uforegradEPS;

    /**
     * Hvis vilkarsvedtakEPSListen er tom og det finnes en tjenestepensjon for ektefellen som
     * ikke blir beregnet av PESYS skal denne fylles ut.
     */
    private YtelseTypeCti tjenestepensjonsordningEps;

}
