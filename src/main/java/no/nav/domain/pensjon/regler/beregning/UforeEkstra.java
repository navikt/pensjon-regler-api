package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.grunnlag.EosEkstra;
import no.nav.domain.pensjon.regler.kode.FppGarantiKodeCti;
import no.nav.domain.pensjon.regler.kode.InntektKode1Cti;
import no.nav.domain.pensjon.regler.kode.InntektKode2Cti;

import java.io.Serializable;

/**
 * Denne klassen inneholder spesielle data fra en beregning av uførepensjon.
 */
public class UforeEkstra implements Serializable {

    

    /**
     * Beskriver hvordan inntektstaket (tak) er beregnet. Se K_INNTEKT1_T
     * LONN_TILSK
     * YRKE_30_50
     * GRADERT_95_50
     * KOMB_VURD_11_12
     * INT_NIV_UF - default
     * UFOR_100
     * REAK_UF_50
     * UNT_VENT
     * UFGRAD_50
     * UFGRAD_50_REAK
     * YRKODE_18_HJEMMV
     */
    private InntektKode1Cti inntektkode1;

    /**
     * Beskriver om inntektstaket (tak) inneholder et fribeløp eller ikke.
     * INT_IKKE_BER - default
     * OPPJ_INNT_U_FRI_U_TK
     * OPPJ_INNT_M_FRI_U_TK
     * OPPJ_INNT_U_FRI_M_TK
     * OPPJ_INNT_M_FRI_M_TK
     * INT_U_FRI_GML_REGL
     * INT_M_FRI_GML_REGL
     */
    private InntektKode2Cti inntektkode2;

    /**
     * Inntektstak ved uførepensjon.Angir den høyeste pensjonsgivende inntekt uførepensjonisten
     * kan ha uten at uføregraden skal revurderes.
     */
    private int tak;

    /**
     * Inntektsgrense før friinntektsdato ved uførepensjon.
     * Angir den høyeste pensjonsgivende inntekt uførepensjonisten kan ha før friinntektsdato uten at uføregraden skal revurderes.
     */
    private int inntektsgrenseForFriinntektsdato;

    /**
     * Fremtidig pensjonspoengtall.
     */
    private double fpp;

    /**
     * Framtidige pensjonspoengtall garanti, f.eks ung ufør har i dag en garanti på 3.3. i FPP.
     */
    private double fppGaranti;

    /**
     * Kode for fpp_garanti.<br>
     * <code>UNG_UF_VEN_R_T_33_PP = UNG UFØR SOM VENTER PÅ RETT TIL 3.3 PENSJONSPOENG</code><br>
     * <code>UNG_UF_MR_33_PO = UNG UFØR MED RETT TIL 3.3 PENSJONSPOENG</code><br>
     * <code>UNG_UF_VEN = ung ufør som venter, og som ble ufør 20 år gammel</code><br>
     * <code>UNG_UF_MR_33_FR_92 = Ung ufør med rett til 3.3 poeng fra 0592</code><br>
     * <code>UNG_UF_FOR_67 = unge uføre før 1967</code>
     */
    private FppGarantiKodeCti fppGarantiKode;

    /**
     * Antall godskrevet framtidig poengtall, ikke full framtidig godskriving.
     */
    private int redusertAntFppAr;

    /**
     * Uforeperioden som skal benyttes i historikken hvis/når Uføregrunnlaget blir historisk.
     */
    private BeregningUforeperiode uforeperiode;

    /**
     * Uforeperioden for ysk som skal benyttes i historikken hvis/når Uføregrunnlaget blir historisk.
     */
    private BeregningUforeperiode uforeperiodeYSK;


}
