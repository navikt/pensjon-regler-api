package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.GuiPrompt;
import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

public class Skjermingstillegg extends Ytelseskomponent {

    private static final long serialVersionUID = -3535325741085042503L;

    @GuiPrompt(prompt = "Forholdstall ved 67 år for søkers årskull")
    private Double ft67Soker;

    @GuiPrompt(prompt = "Skjermingstillegg sats hentet fra satstabell")
    private Double skjermingsgrad;

    @GuiPrompt(prompt = "Uføregrad ved 67 år")
    private Integer ufg;

    @GuiPrompt(prompt = "Basis grunnpensjon brutto per år")
    private Double basGp_bruttoPerAr;

    @GuiPrompt(prompt = "Basis tilleggspensjon brutto per år")
    private Double basTp_bruttoPerAr;

    @GuiPrompt(prompt = "Basis pensjonstillegg brutto per år")
    private Double basPenT_bruttoPerAr;

    public Skjermingstillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("SKJERMT");
    }

    public Skjermingstillegg(Skjermingstillegg skjermingstillegg) {
        super(skjermingstillegg);
        ft67Soker = skjermingstillegg.ft67Soker;
        skjermingsgrad = skjermingstillegg.skjermingsgrad;
        ufg = skjermingstillegg.ufg;
        basGp_bruttoPerAr = skjermingstillegg.basGp_bruttoPerAr;
        basTp_bruttoPerAr = skjermingstillegg.basTp_bruttoPerAr;
        basPenT_bruttoPerAr = skjermingstillegg.basPenT_bruttoPerAr;
    }

    public Skjermingstillegg(double ft67Soker, double skjermingsgrad, int ufg, Double basGp_bruttoPerAr, Double basTp_bruttoPerAr, Double basPenT_bruttoPerAr) {
        super();
        this.ft67Soker = ft67Soker;
        this.skjermingsgrad = skjermingsgrad;
        this.ufg = ufg;
        this.basGp_bruttoPerAr = basGp_bruttoPerAr;
        this.basTp_bruttoPerAr = basTp_bruttoPerAr;
        this.basPenT_bruttoPerAr = basPenT_bruttoPerAr;
        ytelsekomponentType = new YtelsekomponentTypeCti("SKJERMT");
    }

    public Double getFt67Soker() {
        return ft67Soker;
    }

    public void setFt67Soker(Double ft67Soker) {
        this.ft67Soker = ft67Soker;
    }

    public Double getSkjermingsgrad() {
        return skjermingsgrad;
    }

    public void setSkjermingsgrad(Double skjermingsgrad) {
        this.skjermingsgrad = skjermingsgrad;
    }

    public Integer getUfg() {
        return ufg;
    }

    public void setUfg(Integer ufg) {
        this.ufg = ufg;
    }

    public Double getBasGp_bruttoPerAr() {
        return basGp_bruttoPerAr;
    }

    public void setBasGp_bruttoPerAr(Double basGp_bruttoPerAr) {
        this.basGp_bruttoPerAr = basGp_bruttoPerAr;
    }

    public Double getBasTp_bruttoPerAr() {
        return basTp_bruttoPerAr;
    }

    public void setBasTp_bruttoPerAr(Double basTp_bruttoPerAr) {
        this.basTp_bruttoPerAr = basTp_bruttoPerAr;
    }

    public Double getBasPenT_bruttoPerAr() {
        return basPenT_bruttoPerAr;
    }

    public void setBasPenT_bruttoPerAr(Double basPenT_bruttoPerAr) {
        this.basPenT_bruttoPerAr = basPenT_bruttoPerAr;
    }

}
