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
     * Avdødes beregningsgrunnlag.
     */
    private AbstraktBeregningsgrunnlag beregningsgrunnlagAvdodOrdiner;

    /**
     * Avdødes anvendte trygdetid.
     */
    private AnvendtTrygdetid anvendtTrygdetid;

    /**
     * Dødsdato.
     */
    private Date dodstidspunkt;

    /**
     * Hvis ufør ved død er dette gjeldende uføretidspunkt.
     */
    private Date uforetidspunkt;

    /**
     * Hvilken ytelse avdød mottok ved sin død.
     */
    private YtelseVedDodCti ytelseVedDod;

    /**
     * Angir om avdøde ga opphav til gjenlevendepensjon.
     */
    private boolean gjenlevendepensjon;

    /**
     * Angir om ung ufør ble anvendt for avdøde.
     */
    private boolean minsteYtelseBenyttetUngUfor;

    /**
     * Minsteytelsen med avdødes egen trygdetid.
     */
    private int minsteYtelseArsbelop;

    /**
     * Avdødes minsteytelsesats basert på gjenlevendes sivilstand.
     */
    private double minsteYtelseSats;

    /**
     * Yrkesskade beregnet for avdød.
     */
    private boolean yrkesskade;

    /**
     * Avdødes beregningsgrunnlag for yrkesskade.
     */
    private AbstraktBeregningsgrunnlag beregningsgrunnlagAvdodYrkesskade;

    /**
     * Skadetidspunkt ved yrkesskade.
     */
    private Date skadetidspunkt;

    /**
     * Avdødes yrkesskadegrad.
     */
    private int yrkesskadegrad;

}
