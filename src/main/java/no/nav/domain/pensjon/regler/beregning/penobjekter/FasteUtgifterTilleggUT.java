package no.nav.domain.pensjon.regler.beregning.penobjekter;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

public class FasteUtgifterTilleggUT extends Ytelseskomponent {

    private static final long serialVersionUID = 6387403658340806257L;

    private Integer nettoAkk;
    private Integer nettoRestAr;
    private Integer avkortningsbelopPerAr;

    public FasteUtgifterTilleggUT() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_FAST_UTGIFT_T");
    }

    public FasteUtgifterTilleggUT(FasteUtgifterTilleggUT fasteUtgifterTilleggUT) {
        super(fasteUtgifterTilleggUT);
        nettoAkk = fasteUtgifterTilleggUT.nettoAkk;
        nettoRestAr = fasteUtgifterTilleggUT.nettoRestAr;
        avkortningsbelopPerAr = fasteUtgifterTilleggUT.avkortningsbelopPerAr;
    }

    public Integer getNettoAkk() {
        return nettoAkk;
    }

    public void setNettoAkk(Integer nettoAkk) {
        this.nettoAkk = nettoAkk;
    }

    public Integer getNettoRestAr() {
        return nettoRestAr;
    }

    public void setNettoRestAr(Integer nettoRestAr) {
        this.nettoRestAr = nettoRestAr;
    }

    public Integer getAvkortningsbelopPerAr() {
        return avkortningsbelopPerAr;
    }

    public void setAvkortningsbelopPerAr(Integer avkortningsbelopPerAr) {
        this.avkortningsbelopPerAr = avkortningsbelopPerAr;
    }
}
