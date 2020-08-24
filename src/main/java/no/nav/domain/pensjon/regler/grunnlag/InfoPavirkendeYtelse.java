package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.YtelseTypeCti;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InfoPavirkendeYtelse implements Serializable {
    private static final long serialVersionUID = 4203077204628426581L;

    /**
     * Liste av alle vilkårsvedtak for hovedytelse som EPS har løpende.
     */
    private List<VilkarsVedtak> vilkarsvedtakEPSListe = new ArrayList<VilkarsVedtak>();
    /**
     * EPS uforegrad dersom EPS har uførepensjon.
     */
    private int uforegradEPS;

    /**
     * Hvis vilkarsvedtakEPSListen er tom og det finnes en tjenestepensjon for ektefellen som
     * ikke blir beregnet av PESYS skal denne fylles ut.
     */
    private YtelseTypeCti tjenestepensjonsordningEps;

    public InfoPavirkendeYtelse() {
    }

    public InfoPavirkendeYtelse(List<VilkarsVedtak> vilkarsvedtakEPSListe, int uforegradEPS) {
        super();
        this.vilkarsvedtakEPSListe = vilkarsvedtakEPSListe;
        this.uforegradEPS = uforegradEPS;
    }

    /**
     * Copy constructor
     */
    public InfoPavirkendeYtelse(InfoPavirkendeYtelse obj) {
        this();
        uforegradEPS = obj.uforegradEPS;
        if (obj.tjenestepensjonsordningEps != null) {
            tjenestepensjonsordningEps = new YtelseTypeCti(obj.tjenestepensjonsordningEps);
        }
        for (VilkarsVedtak v : obj.vilkarsvedtakEPSListe) {
            vilkarsvedtakEPSListe.add(new VilkarsVedtak(v));
        }
    }

    public int getUforegradEPS() {
        return uforegradEPS;
    }

    public void setUforegradEPS(int uforegradEPS) {
        this.uforegradEPS = uforegradEPS;
    }

    public List<VilkarsVedtak> getVilkarsvedtakEPSListe() {
        return vilkarsvedtakEPSListe;
    }

    public void setVilkarsvedtakEPSListe(List<VilkarsVedtak> vilkarsvedtakEPSListe) {
        this.vilkarsvedtakEPSListe = vilkarsvedtakEPSListe;
    }

    public VilkarsVedtak[] getVilkarsvedtakEPSListeAsArray() {
        return vilkarsvedtakEPSListe != null ? vilkarsvedtakEPSListe.toArray(new VilkarsVedtak[vilkarsvedtakEPSListe.size()]) : new VilkarsVedtak[0];
    }

    public void setTjenestepensjonsordningEps(YtelseTypeCti tjenestepensjonsordningEps) {
        this.tjenestepensjonsordningEps = tjenestepensjonsordningEps;
    }

    public YtelseTypeCti getTjenestepensjonsordningEps() {
        return tjenestepensjonsordningEps;
    }
}
