package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.YtelseVedDodCti;
import no.nav.domain.pensjon.regler.trygdetid.AnvendtTrygdetid;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Steinar Hjellvik (Decisive) - PK-11391
 */
public class GjenlevendetilleggInformasjon implements Serializable {



    /**
     * Avd�des beregningsgrunnlag.
     */
    private AbstraktBeregningsgrunnlag beregningsgrunnlagAvdodOrdiner;

    /**
     * Avd�des anvendte trygdetid.
     */
    private AnvendtTrygdetid anvendtTrygdetid;

    /**
     * D�dsdato.
     */
    private Date dodstidspunkt;

    /**
     * Hvis uf�r ved d�d er dette gjeldende uf�retidspunkt.
     */
    private Date uforetidspunkt;

    /**
     * Hvilken ytelse avd�d mottok ved sin d�d.
     */
    private YtelseVedDodCti ytelseVedDod;

    /**
     * Angir om avd�de ga opphav til gjenlevendepensjon.
     */
    private boolean gjenlevendepensjon;

    /**
     * Angir om ung uf�r ble anvendt for avd�de.
     */
    private boolean minsteYtelseBenyttetUngUfor;

    /**
     * Minsteytelsen med avd�des egen trygdetid.
     */
    private int minsteYtelseArsbelop;

    /**
     * Avd�des minsteytelsesats basert p� gjenlevendes sivilstand.
     */
    private double minsteYtelseSats;

    /**
     * Yrkesskade beregnet for avd�d.
     */
    private boolean yrkesskade;

    /**
     * Avd�des beregningsgrunnlag for yrkesskade.
     */
    private AbstraktBeregningsgrunnlag beregningsgrunnlagAvdodYrkesskade;

    /**
     * Skadetidspunkt ved yrkesskade.
     */
    private Date skadetidspunkt;

    /**
     * Avd�des yrkesskadegrad.
     */
    private int yrkesskadegrad;

}
