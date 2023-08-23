package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.kode.FppGarantiKodeCti
import no.nav.pensjon.regler.domain.kode.ProRataBeregningTypeCti
import no.nav.pensjon.regler.domain.kode.UforeTypeCti
import java.io.Serializable
import java.util.*

/**
 * @author Aasmund Nordstoga (Accenture) - PENPORT-3962
 * @author Swiddy de Louw (Capgemini) - PK-10228
 * @author Steinar Hjellvik (Decisive) - PK-6458
 * @author Magnus Bakken (Accenture) - PK-20759
 * @version $Id$
 */
class Uforeperiode : Serializable {
    /**
     * Uføregraden, heltall 0-100.
     */
    var ufg: Int? = null

    /**
     * Dato for uføretidspunktet.
     */
    var uft: Date? = null

    /**
     * Angir om Uføregraden er ren Uføre,inneholder delvis yrke eller bare yrke.
     */
    var uforeType: UforeTypeCti? = null

    /**
     * Framtidige pensjonspoengtall garanti, f.eks ung ufør har i dag en garanti på 3.3.
     */
    var fppGaranti: Double? = null

    /**
     * Kode for fpp_garanti<br></br>
     * `A = UNG Ufør SOM VENTER på RETT TIL 3.3 PENSJONSPOENG`<br></br>
     * `B = UNG Ufør MED RETT TIL 3.3 PENSJONSPOENG`<br></br>
     * `C = ung ufør som venter, og som ble ufør 20 år gammel`<br></br>
     * `D = Ung ufør med rett til 3.3 poeng fra mai 1992`<br></br>
     * `E = unge Uføre før 1967`
     */
    var fppGarantiKode: FppGarantiKodeCti? = null

    /**
     * Antall godskrevet framtidig poengtall, ikke full framtidig godskriving.
     */
    var redusertAntFppAr: Int? = null

    /**
     * Antall godskrevet framtidig poengtall, ikke full framtidig godskriving. EØS eller annen pro-rata beregning.
     */
    var redusertAntFppAr_proRata: Int? = null

    /**
     * Angir hva utfallet av pro-rata beregningen var. Hvis satt er EØS eneste alternativ eller bedre enn alternativet (Folketrygd).
     */
    var proRataBeregningType: ProRataBeregningTypeCti? = null

    /**
     * Dato for virkningsåret for denne Uføreperioden.
     */
    var virk: Date? = null

    /**
     * Dato for når Uføreperioden avsluttes.
     */
    var uftTom: Date? = null

    /**
     * Dato for når Uføregraden starter.
     */
    var ufgFom: Date? = null

    /**
     * Dato for når Uføregraden avsluttes.
     */
    var ufgTom: Date? = null

    /**
     * Fødselsår for yngste barn.
     */
    var fodselsArYngsteBarn: Int? = null

    /**
     * Sluttpoengtall på tilleggspensjonen.
     */
    var spt: Double? = null

    /**
     * Sluttpoengtall på tilleggspensjonen. Pro-rata beregning variant.
     */
    var spt_proRata: Double? = null

    /**
     * Sluttpoengtall på tilleggspensjonen ved overkomp.
     */
    var opt: Double? = null

    /**
     * Sluttpoengtall på tilleggspensjonen ved yrkesskade.
     */
    var ypt: Double? = null

    /**
     * Antall poengår før 1992 på sluttpoengtallet.
     */
    var spt_pa_f92: Int? = null

    /**
     * Antall poengår etter 1991 på sluttpoengtallet
     */
    var spt_pa_e91: Int? = null

    /**
     * Antall poengår før 1992 på sluttpoengtallet.
     */
    var proRata_teller: Int? = null

    /**
     * Antall poengår etter 1991 på sluttpoengtallet
     */
    var proRata_nevner: Int? = null

    /**
     * Antall poengår før 1992 på sluttpoengtallet med overkomp
     */
    var opt_pa_f92: Int? = null

    /**
     * Antall poengår etter 1992 på sluttpoengtallet med overkomp
     */
    var opt_pa_e91: Int? = null

    /**
     * Antall poengår før 1992 på sluttpoengtallet ved yrkesskade
     */
    var ypt_pa_f92: Int? = null

    /**
     * Antall poengår etter 1992 på sluttpoengtallet ved yrkesskade
     */
    var ypt_pa_e91: Int? = null

    /**
     * Poengtall ut fra antatt årlig inntekt på skadetidspunktet
     */
    var paa: Double? = null

    /**
     * Fremtidige pensjonspoeng
     */
    var fpp: Double? = null

    /**
     * Fremtidige omregnete pensjonspoeng
     */
    var fpp_omregnet: Double? = null

    /**
     * Sluttpoengtall i EØS
     */
    var spt_eos: Double? = null

    /**
     * Antall poengår etter 1991 etter EØS-alternativet for sluttpoengtall
     */
    var spt_pa_e91_eos: Int? = null

    /**
     * Antall poengår før 1992 etter EØS-alternativet for sluttpoengtall
     */
    var spt_pa_f92_eos: Int? = null
    /**
     * @return the beregningsgrunnlag
     */
    /**
     * @param beregningsgrunnlag the beregningsgrunnlag to set
     */
    /**
     * Flag som angir om perioden angir en nedsettelse av grad. Intern PREG variabel.
     */
    /*
     * Det beregningsgrunnlag (årsbeløp) som ble gjeldende i perioden.
     * Dette er beregningsgrunnlagOrdinårt når uforeType er UFORE eller UF_M_YRKE,
     * og beregningsgrunnlagYrkesskade når type er YRKE
     */
    var beregningsgrunnlag = 0
    /**
     * @return the angittUforetidspunkt
     */
    /**
     * @param angittUforetidspunkt the angittUforetidspunkt to set
     */
    /*
          * Det uføretidspunkt som er angitt for perioden, men ikke nødvendigvis anvendt.
          */
    var angittUforetidspunkt: Date? = null

    /**
     * Antatt årlig inntekt før uføretidspunktet (brukes i fastsettelse av opptjening til alderspensjon etter kapittel 19).
     */
    var antattInntektFaktorKap19 = 0.0

    /**
     * Antatt årlig inntekt før uføretidspunktet (brukes i fastsettelse av opptjening til alderspensjon etter kapittel 20).
     */
    var antattInntektFaktorKap20 = 0.0
    var isPREG_nedsattUfg = false

    /**
     * Referanse til påfålgende Uføreperiode. Intern PREG variabel.
     */
    var pREG_nesteUFP: Uforeperiode? = null

    /**
     * Referanse til forrige Uføreperiode. Intern PREG variabel.
     */
    var pREG_forrigeUFP: Uforeperiode? = null

    /**
     * Referanse til sammenfallende Uføreperiode for yrkesskade. Intern PREG variabel.
     */
    var pREG_YP_UFP: Uforeperiode? = null

    /**
     * Angir om perioden er den Første Uføreperioden (ikke yrkesskade) i historikken.
     * Intern PREG variabel.
     */
    var isPREG_forsteUFP = false

    /**
     * Angir om perioden er den sisste Uføreperioden (ikke yrkesskade) i historikken.
     * Intern PREG variabel.
     */
    var isPREG_sissteUFP = false

    /**
     * Angir forrige periode som ga opphav til nytt UFT.
     * Intern PREG variabel.
     */
    var pREG_forrigeUFT: Uforeperiode? = null

    /**
     * Neste periode som gir opphav til nytt UFT.
     * Intern PREG variabel.
     */
    var pREG_nesteUFT: Uforeperiode? = null
    var pREG_tilhorendeUFT: Uforeperiode? = null
    var isPREG_opphor = false
    var isPREG_erUFT = false
    var pREG_ufgTom_intern: Date? = null
    var isPREG_beregnSomMellomliggende = false
    var isPREG_beregnSomOpphor = false
    var pREG_pafolgendeUforear = 0

    /**
     * Den siste Uføreperioden med uførepensjon.
     * Intern PREG variabel.
     */
    var pREG_sisteUFP_UP: Uforeperiode? = null
}