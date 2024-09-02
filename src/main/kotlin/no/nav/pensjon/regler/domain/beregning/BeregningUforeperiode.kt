package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.enum.FppGarantiKodeEnum
import no.nav.pensjon.regler.domain.enum.ProRataBeregningTypeEnum
import no.nav.pensjon.regler.domain.enum.UforetypeEnum
import no.nav.pensjon.regler.domain.kode.FppGarantiKodeCti
import no.nav.pensjon.regler.domain.kode.ProRataBeregningTypeCti
import no.nav.pensjon.regler.domain.kode.UforeTypeCti
import java.io.Serializable
import java.util.*

class BeregningUforeperiode : Serializable {
    /**
     * Uføregraden, heltall 0-100.
     */
    @JvmField
    var ufg: Int? = null

    /**
     * Dato for uføretidspunktet.
     */
    @JvmField
    var uft: Date? = null

    /**
     * Angir om Uføregraden er ren Uføre,inneholder delvis yrke eller bare yrke.
     */
    @JvmField
    var uforeType: UforeTypeCti? = null
    @JvmField
    var uforeTypeEnum: UforetypeEnum? = null

    /**
     * Framtidige pensjonspoengtall garanti, f.eks ung ufør har i dag en garanti på 3.3.
     */
    @JvmField
    var fppGaranti: Double? = null

    /**
     * Kode for fpp_garanti<br></br>
     * `A = UNG Ufør SOM VENTER på RETT TIL 3.3 PENSJONSPOENG`<br></br>
     * `B = UNG Ufør MED RETT TIL 3.3 PENSJONSPOENG`<br></br>
     * `C = ung ufør som venter, og som ble ufør 20 år gammel`<br></br>
     * `D = Ung ufør med rett til 3.3 poeng fra mai 1992`<br></br>
     * `E = unge Uføre før 1967`
     */
    @JvmField
    var fppGarantiKode: FppGarantiKodeCti? = null
    @JvmField
    var fppGarantiKodeEnum: FppGarantiKodeEnum? = null

    /**
     * Antall godskrevet framtidig poengtall, ikke full framtidig godskriving.
     */
    @JvmField
    var redusertAntFppAr: Int? = null

    /**
     * Antall godskrevet framtidig poengtall, ikke full framtidig godskriving. EØS eller annen pro-rata beregning.
     */
    @JvmField
    var redusertAntFppAr_proRata: Int? = null

    /**
     * Angir hva utfallet av pro-rata beregningen var. Hvis satt er EØS eneste alternativ eller bedre enn alternativet (Folketrygd).
     */
    @JvmField
    var proRataBeregningType: ProRataBeregningTypeCti? = null
    @JvmField
    var proRataBeregningTypeEnum: ProRataBeregningTypeEnum? = null

    /**
     * Dato for virkningsåret for denne Uføreperioden.
     */
    @JvmField
    var virk: Date? = null

    /**
     * Dato for når Uføreperioden avsluttes.
     */
    @JvmField
    var uftTom: Date? = null

    /**
     * Dato for når Uføregraden starter.
     */
    @JvmField
    var ufgFom: Date? = null

    /**
     * Dato for når Uføregraden avsluttes.
     */
    @JvmField
    var ufgTom: Date? = null

    /**
     * Fødselsår for yngste barn.
     */
    @JvmField
    var fodselsArYngsteBarn: Int? = null

    /**
     * Sluttpoengtall på tilleggspensjonen.
     */
    @JvmField
    var spt: Double? = null

    /**
     * Sluttpoengtall på tilleggspensjonen. Pro-rata beregning variant.
     */
    @JvmField
    var spt_proRata: Double? = null

    /**
     * Sluttpoengtall på tilleggspensjonen ved overkomp.
     */
    @JvmField
    var opt: Double? = null

    /**
     * Sluttpoengtall på tilleggspensjonen ved yrkesskade.
     */
    @JvmField
    var ypt: Double? = null

    /**
     * Antall poengår før 1992 på sluttpoengtallet.
     */
    @JvmField
    var spt_pa_f92: Int? = null

    /**
     * Antall poengår etter 1991 på sluttpoengtallet
     */
    @JvmField
    var spt_pa_e91: Int? = null

    /**
     * Antall poengår før 1992 på sluttpoengtallet.
     */
    @JvmField
    var proRata_teller: Int? = null

    /**
     * Antall poengår etter 1991 på sluttpoengtallet
     */
    @JvmField
    var proRata_nevner: Int? = null

    /**
     * Antall poengår før 1992 på sluttpoengtallet med overkomp
     */
    @JvmField
    var opt_pa_f92: Int? = null

    /**
     * Antall poengår etter 1992 på sluttpoengtallet med overkomp
     */
    @JvmField
    var opt_pa_e91: Int? = null

    /**
     * Antall poengår før 1992 på sluttpoengtallet ved yrkesskade
     */
    @JvmField
    var ypt_pa_f92: Int? = null

    /**
     * Antall poengår etter 1992 på sluttpoengtallet ved yrkesskade
     */
    @JvmField
    var ypt_pa_e91: Int? = null

    /**
     * Poengtall ut fra antatt årlig inntekt på skadetidspunktet
     */
    @JvmField
    var paa: Double? = null

    /**
     * Fremtidige pensjonspoeng
     */
    @JvmField
    var fpp: Double? = null

    /**
     * Fremtidige omregnete pensjonspoeng
     */
    @JvmField
    var fpp_omregnet: Double? = null

    /**
     * Sluttpoengtall i EØS
     */
    @JvmField
    var spt_eos: Double? = null

    /**
     * Antall poengår etter 1991 etter EØS-alternativet for sluttpoengtall
     */
    @JvmField
    var spt_pa_e91_eos: Int? = null

    /**
     * Antall poengår før 1992 etter EØS-alternativet for sluttpoengtall
     */
    @JvmField
    var spt_pa_f92_eos: Int? = null
    /**
     * @return the beregningsgrunnlag
     */
    /**
     * @param beregningsgrunnlag the beregningsgrunnlag to set
     */
    /*
            * Det beregningsgrunnlag (årsbeløp) som ble gjeldende i perioden.
            * Dette er beregningsgrunnlagOrdinårt når uforeType er UFORE eller UF_M_YRKE
            * og beregningsgrunnlagYrkesskade når type er YRKE
            */
    @JvmField
    var beregningsgrunnlag = 0
    /**
     * @return the angittUforetidspunkt
     */
    /**
     * @param angittUforetidspunkt the angittUforetidspunkt to set
     * Det uføretidspunkt som er angitt for perioden, men ikke nødvendigvis anvendt.
     * **/
    @JvmField
    var angittUforetidspunkt: Date? = null

    /**
     * Antatt årlig inntekt før uføretidspunktet (brukes i fastsettelse av opptjening til alderspensjon etter kapittel 19).
     */
    @JvmField
    var antattInntektFaktorKap19 = 0.0

    /**
     * Antatt årlig inntekt før uføretidspunktet (brukes i fastsettelse av opptjening til alderspensjon etter kapittel 20).
     */
    @JvmField
    var antattInntektFaktorKap20 = 0.0

}