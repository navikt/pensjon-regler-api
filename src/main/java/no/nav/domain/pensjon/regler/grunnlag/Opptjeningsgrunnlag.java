package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.GrunnlagKildeCti;
import no.nav.domain.pensjon.regler.kode.OpptjeningTypeCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Opptjeningsgrunnlag
 * 
 * @author Swiddy de Louw PK-7973 PKPYTON-526
 */

public class Opptjeningsgrunnlag implements Serializable {


    /**
     * År for opptjeningen.
     */
    private int ar;

    /**
     * Pensjonsgivende inntekt.
     */
    private int pi;

    /**
     * Anvendt pensjonsgivende inntekt.Redusert pi etter 1/3-regelen.
     * Brukes ved beregning av poengtallene.<br>
     * <code>0 =< pia <= 8.33G (som int)</code>
     */
    private int pia;

    /**
     * Beregnet pensjonspoeng.
     */
    private double pp;

    /**
     * Angir type opptjening. Se K_OPPTJN_T.
     * Pr september 2007 så tabellen slik ut:
     * OSFE Omsorg for syke/funksjonshemmede/eldre
     * OBO7H Omsorg for barn over 7 år med hjelpestønad sats 3 eller 4
     * OBU7 Omsorg for barn under 7 år
     * PPI Pensjonsgivende inntekt
     */
    private OpptjeningTypeCti opptjeningType;

    /**
     * Maks uføregrad for dette året
     */
    private int maksUforegrad;
    /**
     * Angir om opptjeningsgrunnlaget brukes somm grunnlag på kravet.
     */
    private boolean bruk;
    /**
     * Kilden til opptjeningsgrunnlaget.
     */
    private GrunnlagKildeCti grunnlagKilde;

    /*
     * Inneholder alle inntektstyper for dette året
     */
    private List<OpptjeningTypeMapping> opptjeningTypeListe;

}
