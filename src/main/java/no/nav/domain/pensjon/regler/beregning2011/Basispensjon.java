package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.FormelKodeCti;

import java.io.Serializable;

/**
 * Kopi av PEN 28/8/2009 - ruller tilbake til PREG domenemodell
 * 
 * @author Ørnulf Moen
 */

public class Basispensjon implements Serializable {

    /** Utgjør summen av basisgrunnpensjon, basistilleggspensjon og i basispensjonstillegg. */
    private double totalbelop;

    /** Basisgrunnpensjon slik det er definert i nytt regelverk på gammel opptjening (kapittel 19). */
    private BasisGrunnpensjon gp;

    /** Basistilleggspensjon slik det er definert i nytt regelverk på gammel opptjening (kapittel 19). */
    private BasisTilleggspensjon tp;

    /** Basispensjonstillegg slik det er definert i nytt regelverk på gammel opptjening (kapittel 19). */
    private BasisPensjonstillegg pt;

    /** Formelkode kun for bruk for restpensjon **/
    private FormelKodeCti formelKode;


}
