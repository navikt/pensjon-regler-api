package no.nav.domain.pensjon.regler.beregning.penobjekter;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

import java.io.Serializable;

/**
 * Brukes i PREG kun ved g-omregning
 */
public class KrigOgGammelYrkesskade extends Ytelseskomponent implements Serializable {

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
}
