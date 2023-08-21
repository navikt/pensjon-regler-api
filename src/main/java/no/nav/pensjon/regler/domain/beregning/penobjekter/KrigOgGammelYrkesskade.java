package no.nav.pensjon.regler.domain.beregning.penobjekter;

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

import java.io.Serializable;

/**
 * Brukes i PREG kun ved g-omregning
 */
public class KrigOgGammelYrkesskade extends Ytelseskomponent implements Serializable {

    private static final long serialVersionUID = -439514969688932894L;
    /**
     * Pensjonsgraden
     */
    private int pensjonsgrad;
    /**
     * grunnlag for utbetaling;
     */
    private int grunnlagForUtbetaling;
    /**
     * Kapital utløsning
     */
    private int kapitalutlosning;
    /**
     * poengtall
     */
    private double ps;
    /**
     * forholdstall yg
     */
    private double yg;
    /**
     * Men del
     */
    private int mendel;

    public KrigOgGammelYrkesskade() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("KRIG_GY");
    }

    /**
     * Copy Constructor
     * 
     * @param krigOgGammelYrkesskade a <code>KrigOgGammelYrkesskade</code> object
     */
    public KrigOgGammelYrkesskade(KrigOgGammelYrkesskade krigOgGammelYrkesskade) {
        super(krigOgGammelYrkesskade);
        pensjonsgrad = krigOgGammelYrkesskade.pensjonsgrad;
        grunnlagForUtbetaling = krigOgGammelYrkesskade.grunnlagForUtbetaling;
        kapitalutlosning = krigOgGammelYrkesskade.kapitalutlosning;
        ps = krigOgGammelYrkesskade.ps;
        yg = krigOgGammelYrkesskade.yg;
        mendel = krigOgGammelYrkesskade.mendel;
    }

    public KrigOgGammelYrkesskade(int pensjonsgrad, int grunnlagForUtbetaling, int kapitalutlosning, double ps, double yg, int mendel) {
        super();
        this.pensjonsgrad = pensjonsgrad;
        this.grunnlagForUtbetaling = grunnlagForUtbetaling;
        this.kapitalutlosning = kapitalutlosning;
        this.ps = ps;
        this.yg = yg;
        this.mendel = mendel;
        ytelsekomponentType = new YtelsekomponentTypeCti("KRIG_GY");
    }

    public int getGrunnlagForUtbetaling() {
        return grunnlagForUtbetaling;
    }

    public void setGrunnlagForUtbetaling(int grunnlagForUtbetaling) {
        this.grunnlagForUtbetaling = grunnlagForUtbetaling;
    }

    public int getKapitalutlosning() {
        return kapitalutlosning;
    }

    public void setKapitalutlosning(int kapitalutlosning) {
        this.kapitalutlosning = kapitalutlosning;
    }

    public int getMendel() {
        return mendel;
    }

    public void setMendel(int mendel) {
        this.mendel = mendel;
    }

    public int getPensjonsgrad() {
        return pensjonsgrad;
    }

    public void setPensjonsgrad(int pensjonsgrad) {
        this.pensjonsgrad = pensjonsgrad;
    }

    public double getPs() {
        return ps;
    }

    public void setPs(double ps) {
        this.ps = ps;
    }

    public double getYg() {
        return yg;
    }

    public void setYg(double yg) {
        this.yg = yg;
    }
}
