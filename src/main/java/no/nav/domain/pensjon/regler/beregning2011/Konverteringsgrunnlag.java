package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Grunnpensjon;
import no.nav.domain.pensjon.regler.beregning.Sertillegg;
import no.nav.domain.pensjon.regler.beregning.Tilleggspensjon;

import java.io.Serializable;

/**
 * Grunnlag for konvertering
 * 
 * @author Swiddy de Louw (Capgemini) - PK-7113
 */

public class Konverteringsgrunnlag implements Serializable {
    /**
     * Grunnpensjon for dette konverteringsgrunnlaget
     */
    private Grunnpensjon gp;

    /**
     * Tilleggspensjon for dette konverteringsgrunnlaget
     */
    private Tilleggspensjon tp;

    /**
     * Særtillegg for dette konverteringsgrunnlaget
     * Betinget, hvis uførepensjon er beregnet med særtillegg
     */
    private Sertillegg st;

}
