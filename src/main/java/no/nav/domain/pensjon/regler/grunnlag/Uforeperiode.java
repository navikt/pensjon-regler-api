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
     * Uf�regraden, heltall 0-100.
     */
    private Integer ufg;
    /**
     * Dato for uf�retidspunktet.
     */
    private Date uft;
    /**
     * Angir om uf�regraden er ren uf�re,inneholder delvis yrke eller bare yrke.
     */
    private UforeTypeCti uforeType;

    /**
     * Framtidige pensjonspoengtall garanti, f.eks ung uf�r har i dag en garanti p� 3.3.
     */
    private Double fppGaranti;
    /**
     * Kode for fpp_garanti<br>
     * <code>A = UNG UF�R SOM VENTER P� RETT TIL 3.3 PENSJONSPOENG</code><br>
     * <code>B = UNG UF�R MED RETT TIL 3.3 PENSJONSPOENG</code><br>
     * <code>C = ung uf�r som venter, og som ble uf�r 20 �r gammel</code><br>
     * <code>D = Ung uf�r med rett til 3.3 poeng fra mai 1992</code><br>
     * <code>E = unge uf�re f�r 1967</code>
     */
    private FppGarantiKodeCti fppGarantiKode;

    /**
     * Antall godskrevet framtidig poengtall, ikke full framtidig godskriving.
     */
    private Integer redusertAntFppAr;
    /**
     * Antall godskrevet framtidig poengtall, ikke full framtidig godskriving. E�S eller annen pro-rata beregning.
     */
    private Integer redusertAntFppAr_proRata;
    /**
     * Angir hva utfallet av pro-rata beregningen var. Hvis satt er E�S eneste alternativ eller bedre enn alternativet (Folketrygd).
     */
    private ProRataBeregningTypeCti proRataBeregningType;
    /**
     * Dato for virknings�ret for denne uf�reperioden.
     */
    private Date virk;

    /**
     * Dato for n�r uf�reperioden avsluttes.
     */
    private Date uftTom;

    /**
     * Dato for n�r uf�regraden starter.
     */
    private Date ufgFom;

    /**
     * Dato for n�r uf�regraden avsluttes.
     */
    private Date ufgTom;

    /**
     * F�dsels�r for yngste barn.
     */
    private Integer fodselsArYngsteBarn;

    /**
     * Sluttpoengtall p� tilleggspensjonen.
     */
    private Double spt;
    /**
     * Sluttpoengtall p� tilleggspensjonen. Pro-rata beregning variant.
     */
    private Double spt_proRata;
    /**
     * Sluttpoengtall p� tilleggspensjonen ved overkomp.
     */
    private Double opt;
    /**
     * Sluttpoengtall p� tilleggspensjonen ved yrkesskade.
     */
    private Double ypt;
    /**
     * Antall poeng�r f�r 1992 p� sluttpoengtallet.
     */
    private Integer spt_pa_f92;
    /**
     * Antall poeng�r etter 1991 p� sluttpoengtallet
     */
    private Integer spt_pa_e91;
    /**
     * Antall poeng�r f�r 1992 p� sluttpoengtallet.
     */
    private Integer proRata_teller;
    /**
     * Antall poeng�r etter 1991 p� sluttpoengtallet
     */
    private Integer proRata_nevner;
    /**
     * Antall poeng�r f�r 1992 p� sluttpoengtallet med overkomp
     */
    private Integer opt_pa_f92;
    /**
     * Antall poeng�r etter 1992 p� sluttpoengtallet med overkomp
     */
    private Integer opt_pa_e91;
    /**
     * Antall poeng�r f�r 1992 p� sluttpoengtallet ved yrkesskade
     */
    private Integer ypt_pa_f92;
    /**
     * Antall poeng�r etter 1992 p� sluttpoengtallet ved yrkesskade
     */
    private Integer ypt_pa_e91;
    /**
     * Poengtall ut fra antatt �rlig inntekt p� skadetidspunktet
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
     * Sluttpoengtall i E�S
     */
    private Double spt_eos;
    /**
     * Antall poeng�r etter 1991 etter E�S-alternativet for sluttpoengtall
     */
    private Integer spt_pa_e91_eos;
    /**
     * Antall poeng�r f�r 1992 etter E�S-alternativet for sluttpoengtall
     */
    private Integer spt_pa_f92_eos;
    /**
     * Flag som angir om perioden angir en nedsettelse av grad. Intern PREG variabel.
     */

    /*
     * Det beregningsgrunnlag (�rsbel�p) som ble gjeldende i perioden.
     * Dette er beregningsgrunnlagOrdin�rt n�r uforeType er UFORE eller UF_M_YRKE,
     * og beregningsgrunnlagYrkesskade n�r type er YRKE
     */
    private int beregningsgrunnlag;

    /*
     * Det uf�retidspunkt som er angitt for perioden, men ikke n�dvendigvis anvendt.
     */
    private Date angittUforetidspunkt;

    /**
     * Antatt �rlig inntekt f�r uf�retidspunktet (brukes i fastsettelse av opptjening til alderspensjon etter kapittel 19).
     */
    private double antattInntektFaktorKap19;

    /**
     * Antatt �rlig inntekt f�r uf�retidspunktet (brukes i fastsettelse av opptjening til alderspensjon etter kapittel 20).
     */
    private double antattInntektFaktorKap20;

}
