package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.GuiPrompt;
import no.nav.pensjon.regler.domain.beregning.Grunnpensjon;
import no.nav.pensjon.regler.domain.beregning.Sertillegg;
import no.nav.pensjon.regler.domain.beregning.Tilleggspensjon;

import java.io.Serializable;

/**
 * Grunnlag for konvertering
 * 
 * @author Swiddy de Louw (Capgemini) - PK-7113
 */

public class Konverteringsgrunnlag implements Serializable {

    private static final long serialVersionUID = -6110698769041981099L;

    /**
     * Grunnpensjon for dette konverteringsgrunnlaget
     */
    @GuiPrompt(prompt = "Grunnpensjon")
    private Grunnpensjon gp;

    /**
     * Tilleggspensjon for dette konverteringsgrunnlaget
     */
    @GuiPrompt(prompt = "Tilleggspensjon")
    private Tilleggspensjon tp;

    /**
     * Særtillegg for dette konverteringsgrunnlaget
     * Betinget, hvis uførepensjon er beregnet med særtillegg
     */
    @GuiPrompt(prompt = "Særtillegg")
    private Sertillegg st;

    /**
     * Default constructor
     */
    public Konverteringsgrunnlag() {
        super();
    }

    /**
     * Constructor using fields
     * 
     * @param gp
     * @param tp
     * @param st
     */
    public Konverteringsgrunnlag(Grunnpensjon gp, Tilleggspensjon tp, Sertillegg st) {
        super();
        this.gp = gp;
        this.tp = tp;
        this.st = st;
    }

    /**
     * Copy constructor
     */
    public Konverteringsgrunnlag(Konverteringsgrunnlag kg) {
        this();
        if (kg.gp != null) {
            gp = new Grunnpensjon(kg.gp);
        }
        if (kg.tp != null) {
            tp = new Tilleggspensjon(kg.tp);
        }
        if (kg.st != null) {
            st = new Sertillegg(kg.st);
        }
    }

    /**
     * @return the gp
     */
    public Grunnpensjon getGp() {
        return gp;
    }

    /**
     * @param gp the gp to set
     */
    public void setGp(Grunnpensjon gp) {
        this.gp = gp;
    }

    /**
     * @return the tp
     */
    public Tilleggspensjon getTp() {
        return tp;
    }

    /**
     * @param tp the tp to set
     */
    public void setTp(Tilleggspensjon tp) {
        this.tp = tp;
    }

    /**
     * @return the st
     */
    public Sertillegg getSt() {
        return st;
    }

    /**
     * @param st the st to set
     */
    public void setSt(Sertillegg st) {
        this.st = st;
    }
}
