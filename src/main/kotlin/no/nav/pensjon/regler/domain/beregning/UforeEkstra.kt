package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.enum.FppGarantiKodeEnum
import no.nav.pensjon.regler.domain.enum.InntektKode1Enum
import no.nav.pensjon.regler.domain.enum.InntektKode2Enum
import java.io.Serializable

/**
 * Denne klassen inneholder spesielle data fra en beregning av uførepensjon.
 */
class UforeEkstra : Serializable {
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
    var inntektkode1Enum: InntektKode1Enum = InntektKode1Enum.INT_NIV_UF

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
    var inntektkode2Enum: InntektKode2Enum = InntektKode2Enum.INT_IKKE_BER

    /**
     * Inntektstak ved uførepensjon.Angir den Høyeste pensjonsgivende inntekt uførepensjonisten
     * kan ha uten at uføregraden skal revurderes.
     */
    var tak = 0

    /**
     * Inntektsgrense før friinntektsdato ved uførepensjon.
     * Angir den Høyeste pensjonsgivende inntekt uførepensjonisten kan ha før friinntektsdato uten at uføregraden skal revurderes.
     */
    var inntektsgrenseForFriinntektsdato = 0

    /**
     * Fremtidig pensjonspoengtall.
     */
    var fpp = 0.0

    /**
     * Framtidige pensjonspoengtall garanti, f.eks ung ufør har i dag en garanti på 3.3. i FPP.
     */
    var fppGaranti = 0.0

    /**
     * Kode for fpp_garanti.<br></br>
     * `UNG_UF_VEN_R_T_33_PP = UNG Ufør SOM VENTER på RETT TIL 3.3 PENSJONSPOENG`<br></br>
     * `UNG_UF_MR_33_PO = UNG Ufør MED RETT TIL 3.3 PENSJONSPOENG`<br></br>
     * `UNG_UF_VEN = ung ufør som venter, og som ble ufør 20 år gammel`<br></br>
     * `UNG_UF_MR_33_FR_92 = Ung ufør med rett til 3.3 poeng fra 0592`<br></br>
     * `UNG_UF_FOR_67 = unge uføre før 1967`
     */
    var fppGarantiKodeEnum: FppGarantiKodeEnum? = null

    /**
     * Antall godskrevet framtidig poengtall, ikke full framtidig godskriving.
     */
    var redusertAntFppAr = 0

    /**
     * Uforeperioden som skal benyttes i historikken hvis/når Uføregrunnlaget blir historisk.
     */
    var uforeperiode: BeregningUforeperiode? = null

    /**
     * Uforeperioden for ysk som skal benyttes i historikken hvis/når Uføregrunnlaget blir historisk.
     */
    var uforeperiodeYSK: BeregningUforeperiode? = null

}