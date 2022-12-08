package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.beregning.BeregningUforeperiode;
import no.nav.domain.pensjon.regler.kode.FppGarantiKodeCti;
import no.nav.domain.pensjon.regler.kode.ProRataBeregningTypeCti;
import no.nav.domain.pensjon.regler.kode.UforeTypeCti;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Aasmund Nordstoga (Accenture) - PENPORT-3962
 * @author Swiddy de Louw (Capgemini) - PK-10228
 * @author Steinar Hjellvik (Decisive) - PK-6458
 * @author Magnus Bakken (Accenture) - PK-20759
 * @version $Id$
 */

public class Uforeperiode implements Serializable {


    /**
     * Uføregraden, heltall 0-100.
     */
    private Integer ufg;
    /**
     * Dato for uføretidspunktet.
     */
    private Date uft;
    /**
     * Angir om uføregraden er ren uføre,inneholder delvis yrke eller bare yrke.
     */
    private UforeTypeCti uforeType;

    /**
     * Framtidige pensjonspoengtall garanti, f.eks ung ufør har i dag en garanti på 3.3.
     */
    private Double fppGaranti;
    /**
     * Kode for fpp_garanti<br>
     * <code>A = UNG UFØR SOM VENTER PÅ RETT TIL 3.3 PENSJONSPOENG</code><br>
     * <code>B = UNG UFØR MED RETT TIL 3.3 PENSJONSPOENG</code><br>
     * <code>C = ung ufør som venter, og som ble ufør 20 år gammel</code><br>
     * <code>D = Ung ufør med rett til 3.3 poeng fra mai 1992</code><br>
     * <code>E = unge uføre før 1967</code>
     */
    private FppGarantiKodeCti fppGarantiKode;

    /**
     * Antall godskrevet framtidig poengtall, ikke full framtidig godskriving.
     */
    private Integer redusertAntFppAr;
    /**
     * Antall godskrevet framtidig poengtall, ikke full framtidig godskriving. EØS eller annen pro-rata beregning.
     */
    private Integer redusertAntFppAr_proRata;
    /**
     * Angir hva utfallet av pro-rata beregningen var. Hvis satt er EØS eneste alternativ eller bedre enn alternativet (Folketrygd).
     */
    private ProRataBeregningTypeCti proRataBeregningType;
    /**
     * Dato for virkningsåret for denne uføreperioden.
     */
    private Date virk;

    /**
     * Dato for når uføreperioden avsluttes.
     */
    private Date uftTom;

    /**
     * Dato for når uføregraden starter.
     */
    private Date ufgFom;

    /**
     * Dato for når uføregraden avsluttes.
     */
    private Date ufgTom;

    /**
     * Fødselsår for yngste barn.
     */
    private Integer fodselsArYngsteBarn;

    /**
     * Sluttpoengtall på tilleggspensjonen.
     */
    private Double spt;
    /**
     * Sluttpoengtall på tilleggspensjonen. Pro-rata beregning variant.
     */
    private Double spt_proRata;
    /**
     * Sluttpoengtall på tilleggspensjonen ved overkomp.
     */
    private Double opt;
    /**
     * Sluttpoengtall på tilleggspensjonen ved yrkesskade.
     */
    private Double ypt;
    /**
     * Antall poengår før 1992 på sluttpoengtallet.
     */
    private Integer spt_pa_f92;
    /**
     * Antall poengår etter 1991 på sluttpoengtallet
     */
    private Integer spt_pa_e91;
    /**
     * Antall poengår før 1992 på sluttpoengtallet.
     */
    private Integer proRata_teller;
    /**
     * Antall poengår etter 1991 på sluttpoengtallet
     */
    private Integer proRata_nevner;
    /**
     * Antall poengår før 1992 på sluttpoengtallet med overkomp
     */
    private Integer opt_pa_f92;
    /**
     * Antall poengår etter 1992 på sluttpoengtallet med overkomp
     */
    private Integer opt_pa_e91;
    /**
     * Antall poengår før 1992 på sluttpoengtallet ved yrkesskade
     */
    private Integer ypt_pa_f92;
    /**
     * Antall poengår etter 1992 på sluttpoengtallet ved yrkesskade
     */
    private Integer ypt_pa_e91;
    /**
     * Poengtall ut fra antatt årlig inntekt på skadetidspunktet
     */
    private Double paa;
    /**
     * Fremtidige pensjonspoeng
     */
    private Double fpp;
    /**
     * Fremtidige omregnete pensjonspoeng
     */
    private Double fpp_omregnet;

    /**
     * Sluttpoengtall i EØS
     */
    private Double spt_eos;
    /**
     * Antall poengår etter 1991 etter EØS-alternativet for sluttpoengtall
     */
    private Integer spt_pa_e91_eos;
    /**
     * Antall poengår før 1992 etter EØS-alternativet for sluttpoengtall
     */
    private Integer spt_pa_f92_eos;
    /**
     * Flag som angir om perioden angir en nedsettelse av grad. Intern PREG variabel.
     */

    /*
     * Det beregningsgrunnlag (årsbeløp) som ble gjeldende i perioden.
     * Dette er beregningsgrunnlagOrdinært når uforeType er UFORE eller UF_M_YRKE,
     * og beregningsgrunnlagYrkesskade når type er YRKE
     */
    private int beregningsgrunnlag;

    /*
     * Det uføretidspunkt som er angitt for perioden, men ikke nødvendigvis anvendt.
     */
    private Date angittUforetidspunkt;

    /**
     * Antatt årlig inntekt før uføretidspunktet (brukes i fastsettelse av opptjening til alderspensjon etter kapittel 19).
     */
    private double antattInntektFaktorKap19;

    /**
     * Antatt årlig inntekt før uføretidspunktet (brukes i fastsettelse av opptjening til alderspensjon etter kapittel 20).
     */
    private double antattInntektFaktorKap20;

}
