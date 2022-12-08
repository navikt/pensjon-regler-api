package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.MinstepensjonTypeCti;
import no.nav.domain.pensjon.regler.kode.ResultatKildeCti;
import no.nav.domain.pensjon.regler.trygdetid.AnvendtTrygdetid;

import java.io.Serializable;

/**
 * Informasjon mht overgang fra UP til UT
 * 
 * @author Swiddy de Louw - Capgemini- PK-8712
 * @author Swiddy de Louw - Capgemini- PK-7113
 */

public class OvergangsinfoUPtilUT implements Serializable {

    /**
     * Konvertert beregningsgrunnlag for Ordin�r beregning
     */
    private BeregningsgrunnlagKonvertert konvertertBeregningsgrunnlagOrdiner;

    /**
     * Konvertert beregningsgrunnlag for Yrkesskade beregning
     */
    private BeregningsgrunnlagKonvertert konvertertBeregningsgrunnlagYrkesskade;

    /**
     * Uf�retrygd ektefelletilleg
     */
    private EktefelletilleggUT ektefelletilleggUT;

    /**
     * Inntektsgrense for Friintektsdato
     */
    private int inntektsgrenseorFriinntektsdato;

    /**
     * Konvertert beregningsgrunnlag for gjenlevendetillegg hvis fastsatt
     */
    private BeregningsgrunnlagKonvertert konvertertBeregningsgrunnlagGJT;

    /**
     * Anvendt trygdetid fra konvertert uf�repensjon
     */
    private AnvendtTrygdetid anvendtTrygdetidUP;

    /**
     * Anvendt trygdetid fra hjemmeberegningen til konvertert uf�repensjon
     */
    private AnvendtTrygdetid anvendtTrygdetidUPHjemme;

    /**
     * Egen anvendt trygdetid fra UP
     */
    private AnvendtTrygdetid anvendtTrygdetidUP_egen;


    /**
     * Hvorvidt utbetalt uf�repensjonen per 31.12.2014 ble definert som minstepensjon.
     */
    private MinstepensjonTypeCti minstepensjonType;


    /**
     * Hvorvidt utbetalt uf�repensjonen per 31.12.2014 ble manuelt overstyrt eller ikke.
     */
    private ResultatKildeCti resultatKilde;

    /**
     * Netto s�rtillegg i utbetalt uf�repensjonen per 31.12.2014.
     */
    private int sertilleggNetto;



}
