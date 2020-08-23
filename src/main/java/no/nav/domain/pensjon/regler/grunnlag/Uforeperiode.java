package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.beregning.BeregningUforeperiode;
import no.nav.domain.pensjon.regler.kode.FppGarantiKodeCti;
import no.nav.domain.pensjon.regler.kode.ProRataBeregningTypeCti;
import no.nav.domain.pensjon.regler.kode.UforeTypeCti;
import no.nav.domain.pensjon.regler.util.DateCompareUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Aasmund Nordstoga (Accenture) - PENPORT-3962
 * @author Swiddy de Louw (Capgemini) - PK-10228
 * @author Steinar Hjellvik (Decisive) - PK-6458
 * @author Magnus Bakken (Accenture) - PK-20759
 * @version $Id$
 */

public class Uforeperiode implements Comparable<Uforeperiode>, Serializable {

    private static final long serialVersionUID = 5820916129615202514L;
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

    private boolean PREG_nedsattUfg;

    /**
     * Referanse til påfølgende Uføreperiode. Intern PREG variabel.
     */
    private Uforeperiode PREG_nesteUFP;

    /**
     * Referanse til forrige Uføreperiode. Intern PREG variabel.
     */
    private Uforeperiode PREG_forrigeUFP;

    /**
     * Referanse til sammenfallende Uføreperiode for yrkesskade. Intern PREG variabel.
     */
    private Uforeperiode PREG_YP_UFP;
    /**
     * Angir om perioden er den første uføreperioden (ikke yrkesskade) i historikken.
     * Intern PREG variabel.
     */
    private boolean PREG_forsteUFP;
    /**
     * Angir om perioden er den sisste uføreperioden (ikke yrkesskade) i historikken.
     * Intern PREG variabel.
     */
    private boolean PREG_sissteUFP;
    /**
     * Angir forrige periode som ga opphav til nytt UFT.
     * Intern PREG variabel.
     */
    private Uforeperiode PREG_forrigeUFT;
    /**
     * Neste periode som gir opphav til nytt UFT.
     * Intern PREG variabel.
     */
    private Uforeperiode PREG_nesteUFT;

    private Uforeperiode PREG_tilhorendeUFT;

    private boolean PREG_opphor;
    private boolean PREG_erUFT;
    private Date PREG_ufgTom_intern;
    private boolean PREG_beregnSomMellomliggende;
    private boolean PREG_beregnSomOpphor;
    private int PREG_pafolgendeUforear;

    /**
     * Den siste uføreperioden med uførepensjon.
     * Intern PREG variabel.
     */
    private Uforeperiode PREG_sisteUFP_UP;

    /**
     * Copy Constructor
     * 
     * @param uforeperiode a <code>BeregningUforeperiode</code> object
     */
    public Uforeperiode(BeregningUforeperiode uforeperiode) {
        if (uforeperiode.getUfg() != null) {
            ufg = Integer.valueOf(uforeperiode.getUfg());
        }
        if (uforeperiode.getUft() != null) {
            uft = (Date) uforeperiode.getUft().clone();
        }
        if (uforeperiode.getUforeType() != null) {
            uforeType = new UforeTypeCti(uforeperiode.getUforeType());
        }
        if (uforeperiode.getFppGaranti() != null) {
            fppGaranti = new Double(uforeperiode.getFppGaranti());
        }
        if (uforeperiode.getFppGarantiKode() != null) {
            fppGarantiKode = new FppGarantiKodeCti(uforeperiode.getFppGarantiKode());
        }
        if (uforeperiode.getRedusertAntFppAr() != null) {
            redusertAntFppAr = Integer.valueOf(uforeperiode.getRedusertAntFppAr());
        }
        if (uforeperiode.getVirk() != null) {
            virk = (Date) uforeperiode.getVirk().clone();
        }
        if (uforeperiode.getUftTom() != null) {
            uftTom = (Date) uforeperiode.getUftTom().clone();
        }
        if (uforeperiode.getUfgFom() != null) {
            ufgFom = (Date) uforeperiode.getUfgFom().clone();
        }
        if (uforeperiode.getUfgTom() != null) {
            ufgTom = (Date) uforeperiode.getUfgTom().clone();
        }
        if (uforeperiode.getFodselsArYngsteBarn() != null) {
            fodselsArYngsteBarn = Integer.valueOf(uforeperiode.getFodselsArYngsteBarn());
        }
        if (uforeperiode.getSpt() != null) {
            spt = new Double(uforeperiode.getSpt());
        }
        if (uforeperiode.getOpt() != null) {
            opt = new Double(uforeperiode.getOpt());
        }
        if (uforeperiode.getYpt() != null) {
            ypt = new Double(uforeperiode.getYpt());
        }
        if (uforeperiode.getSpt_pa_f92() != null) {
            spt_pa_f92 = Integer.valueOf(uforeperiode.getSpt_pa_f92());
        }
        if (uforeperiode.getSpt_pa_e91() != null) {
            spt_pa_e91 = Integer.valueOf(uforeperiode.getSpt_pa_e91());
        }
        if (uforeperiode.getOpt_pa_f92() != null) {
            opt_pa_f92 = Integer.valueOf(uforeperiode.getOpt_pa_f92());
        }
        if (uforeperiode.getOpt_pa_e91() != null) {
            opt_pa_e91 = Integer.valueOf(uforeperiode.getOpt_pa_e91());
        }
        if (uforeperiode.getYpt_pa_f92() != null) {
            ypt_pa_f92 = Integer.valueOf(uforeperiode.getYpt_pa_f92());
        }
        if (uforeperiode.getYpt_pa_e91() != null) {
            ypt_pa_e91 = Integer.valueOf(uforeperiode.getYpt_pa_e91());
        }
        if (uforeperiode.getPaa() != null) {
            paa = new Double(uforeperiode.getPaa());
        }
        if (uforeperiode.getFpp() != null) {
            fpp = new Double(uforeperiode.getFpp());
        }
        if (uforeperiode.getFpp_omregnet() != null) {
            fpp_omregnet = new Double(uforeperiode.getFpp_omregnet());
        }
        if (uforeperiode.getSpt_eos() != null) {
            spt_eos = new Double(uforeperiode.getSpt_eos());
        }
        if (uforeperiode.getSpt_pa_e91_eos() != null) {
            spt_pa_e91_eos = Integer.valueOf(uforeperiode.getSpt_pa_e91_eos());
        }
        if (uforeperiode.getSpt_pa_f92_eos() != null) {
            spt_pa_f92_eos = Integer.valueOf(uforeperiode.getSpt_pa_f92_eos());
        }
        if (uforeperiode.getRedusertAntFppAr_proRata() != null) {
            redusertAntFppAr_proRata = Integer.valueOf(uforeperiode.getRedusertAntFppAr_proRata());
        }
        if (uforeperiode.getProRataBeregningType() != null) {
            proRataBeregningType = new ProRataBeregningTypeCti(uforeperiode.getProRataBeregningType().getKode());
        }
        if (uforeperiode.getProRata_teller() != null) {
            proRata_teller = Integer.valueOf(uforeperiode.getProRata_teller());
        }
        if (uforeperiode.getProRata_nevner() != null) {
            proRata_nevner = Integer.valueOf(uforeperiode.getProRata_nevner());
        }
        if (uforeperiode.getSpt_proRata() != null) {
            spt_proRata = new Double(uforeperiode.getSpt_proRata());
        }
        if (uforeperiode.getAngittUforetidspunkt() != null) {
            angittUforetidspunkt = (Date) uforeperiode.getAngittUforetidspunkt().clone();
        }
        beregningsgrunnlag = uforeperiode.getBeregningsgrunnlag();
        antattInntektFaktorKap19 = uforeperiode.getAntattInntektFaktorKap19();
        antattInntektFaktorKap20 = uforeperiode.getAntattInntektFaktorKap20();
    }

    /**
     * Copy Constructor
     * 
     * @param uforeperiode a <code>Uforeperiode</code> object
     */
    public Uforeperiode(Uforeperiode uforeperiode) {
        if (uforeperiode.ufg != null) {
            ufg = Integer.valueOf(uforeperiode.ufg);
        }
        if (uforeperiode.uft != null) {
            uft = (Date) uforeperiode.uft.clone();
        }
        if (uforeperiode.uforeType != null) {
            uforeType = new UforeTypeCti(uforeperiode.uforeType);
        }
        if (uforeperiode.fppGaranti != null) {
            fppGaranti = new Double(uforeperiode.fppGaranti);
        }
        if (uforeperiode.fppGarantiKode != null) {
            fppGarantiKode = new FppGarantiKodeCti(uforeperiode.fppGarantiKode);
        }
        if (uforeperiode.redusertAntFppAr != null) {
            redusertAntFppAr = Integer.valueOf(uforeperiode.redusertAntFppAr);
        }
        if (uforeperiode.virk != null) {
            virk = (Date) uforeperiode.virk.clone();
        }
        if (uforeperiode.uftTom != null) {
            uftTom = (Date) uforeperiode.uftTom.clone();
        }
        if (uforeperiode.ufgFom != null) {
            ufgFom = (Date) uforeperiode.ufgFom.clone();
        }
        if (uforeperiode.ufgTom != null) {
            ufgTom = (Date) uforeperiode.ufgTom.clone();
        }
        if (uforeperiode.fodselsArYngsteBarn != null) {
            fodselsArYngsteBarn = Integer.valueOf(uforeperiode.fodselsArYngsteBarn);
        }
        if (uforeperiode.spt != null) {
            spt = new Double(uforeperiode.spt);
        }
        if (uforeperiode.opt != null) {
            opt = new Double(uforeperiode.opt);
        }
        if (uforeperiode.ypt != null) {
            ypt = new Double(uforeperiode.ypt);
        }
        if (uforeperiode.spt_pa_f92 != null) {
            spt_pa_f92 = Integer.valueOf(uforeperiode.spt_pa_f92);
        }
        if (uforeperiode.spt_pa_e91 != null) {
            spt_pa_e91 = Integer.valueOf(uforeperiode.spt_pa_e91);
        }
        if (uforeperiode.opt_pa_f92 != null) {
            opt_pa_f92 = Integer.valueOf(uforeperiode.opt_pa_f92);
        }
        if (uforeperiode.opt_pa_e91 != null) {
            opt_pa_e91 = Integer.valueOf(uforeperiode.opt_pa_e91);
        }
        if (uforeperiode.ypt_pa_f92 != null) {
            ypt_pa_f92 = Integer.valueOf(uforeperiode.ypt_pa_f92);
        }
        if (uforeperiode.ypt_pa_e91 != null) {
            ypt_pa_e91 = Integer.valueOf(uforeperiode.ypt_pa_e91);
        }
        if (uforeperiode.paa != null) {
            paa = new Double(uforeperiode.paa);
        }
        if (uforeperiode.fpp != null) {
            fpp = new Double(uforeperiode.fpp);
        }
        if (uforeperiode.fpp_omregnet != null) {
            fpp_omregnet = new Double(uforeperiode.fpp_omregnet);
        }
        if (uforeperiode.spt_eos != null) {
            spt_eos = new Double(uforeperiode.spt_eos);
        }
        if (uforeperiode.spt_pa_e91_eos != null) {
            spt_pa_e91_eos = Integer.valueOf(uforeperiode.spt_pa_e91_eos);
        }
        if (uforeperiode.spt_pa_f92_eos != null) {
            spt_pa_f92_eos = Integer.valueOf(uforeperiode.spt_pa_f92_eos);
        }
        if (uforeperiode.redusertAntFppAr_proRata != null) {
            redusertAntFppAr_proRata = Integer.valueOf(uforeperiode.redusertAntFppAr_proRata);
        }
        if (uforeperiode.proRataBeregningType != null) {
            proRataBeregningType = new ProRataBeregningTypeCti(uforeperiode.proRataBeregningType);
        }
        if (uforeperiode.getProRata_teller() != null) {
            proRata_teller = Integer.valueOf(uforeperiode.getProRata_teller());
        }
        if (uforeperiode.getProRata_nevner() != null) {
            proRata_nevner = Integer.valueOf(uforeperiode.getProRata_nevner());
        }
        if (uforeperiode.getSpt_proRata() != null) {
            spt_proRata = new Double(uforeperiode.getSpt_proRata());
        }
        if (uforeperiode.angittUforetidspunkt != null) {
            angittUforetidspunkt = (Date) uforeperiode.angittUforetidspunkt.clone();
        }
        beregningsgrunnlag = uforeperiode.beregningsgrunnlag;
        antattInntektFaktorKap19 = uforeperiode.antattInntektFaktorKap19;
        antattInntektFaktorKap20 = uforeperiode.antattInntektFaktorKap20;

        this.PREG_ufgTom_intern = uforeperiode.PREG_ufgTom_intern;
    }

    public Uforeperiode(Integer ufg, Date uft, UforeTypeCti uforeType, Date frysDato, Integer garantigrad, Integer garantigradYrke, Double fppGaranti,
                        FppGarantiKodeCti fppGarantiKode, Integer redusertAntFppAr, Date virk, Date uftTom, Date ufgFom, Date ufgTom, Integer fodselsArYngsteBarn, Double spt,
                        Double opt, Double ypt, Integer spt_pa_f92, Integer spt_pa_e91, Integer opt_pa_f92, Integer opt_pa_e91, Integer ypt_pa_f92, Integer ypt_pa_e91, Double paa,
                        Double fpp, Double fpp_omregnet, Double spt_eos, Integer spt_pa_e91_eos, Integer spt_pa_f92_eos, Integer redusertAntFppAr_proRata,
                        ProRataBeregningTypeCti proRataBeregningType, Integer proRata_teller, Integer proRata_nevner, Double spt_proRata, int beregningsgrunnlag,
                        Date angittUforetidspunkt) {
        super();
        this.ufg = ufg;
        this.uft = uft;
        this.uforeType = uforeType;
        this.fppGaranti = fppGaranti;
        this.fppGarantiKode = fppGarantiKode;
        this.redusertAntFppAr = redusertAntFppAr;
        this.virk = virk;
        this.uftTom = uftTom;
        this.ufgFom = ufgFom;
        this.ufgTom = ufgTom;
        this.fodselsArYngsteBarn = fodselsArYngsteBarn;
        this.spt = spt;
        this.opt = opt;
        this.ypt = ypt;
        this.spt_pa_f92 = spt_pa_f92;
        this.spt_pa_e91 = spt_pa_e91;
        this.opt_pa_f92 = opt_pa_f92;
        this.opt_pa_e91 = opt_pa_e91;
        this.ypt_pa_f92 = ypt_pa_f92;
        this.ypt_pa_e91 = ypt_pa_e91;
        this.paa = paa;
        this.fpp = fpp;
        this.fpp_omregnet = fpp_omregnet;
        this.spt_eos = spt_eos;
        this.spt_pa_e91_eos = spt_pa_e91_eos;
        this.spt_pa_f92_eos = spt_pa_f92_eos;
        this.redusertAntFppAr_proRata = redusertAntFppAr_proRata;
        this.proRataBeregningType = proRataBeregningType;
        this.proRata_teller = proRata_teller;
        this.proRata_nevner = proRata_nevner;
        this.spt_proRata = spt_proRata;
        this.beregningsgrunnlag = beregningsgrunnlag;
        this.angittUforetidspunkt = angittUforetidspunkt;
    }

    /**
     * Default Constructor
     */
    public Uforeperiode() {
        super();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Uforeperiode uforeperiode) {
        return DateCompareUtil.compareTo(getVirk(), uforeperiode.getVirk());
    }

    public Integer getFodselsArYngsteBarn() {
        return fodselsArYngsteBarn;
    }

    public void setFodselsArYngsteBarn(Integer fodselsArYngsteBarn) {
        this.fodselsArYngsteBarn = fodselsArYngsteBarn;
    }

    public Double getFpp() {
        return fpp;
    }

    public void setFpp(Double fpp) {
        this.fpp = fpp;
    }

    public Double getFpp_omregnet() {
        return fpp_omregnet;
    }

    public void setFpp_omregnet(Double fpp_omregnet) {
        this.fpp_omregnet = fpp_omregnet;
    }

    public Double getFppGaranti() {
        return fppGaranti;
    }

    public void setFppGaranti(Double fppGaranti) {
        this.fppGaranti = fppGaranti;
    }

    public FppGarantiKodeCti getFppGarantiKode() {
        return fppGarantiKode;
    }

    public void setFppGarantiKode(FppGarantiKodeCti fppGarantiKode) {
        this.fppGarantiKode = fppGarantiKode;
    }

    public Double getOpt() {
        return opt;
    }

    public void setOpt(Double opt) {
        this.opt = opt;
    }

    public Integer getOpt_pa_e91() {
        return opt_pa_e91;
    }

    public void setOpt_pa_e91(Integer opt_pa_e91) {
        this.opt_pa_e91 = opt_pa_e91;
    }

    public Integer getOpt_pa_f92() {
        return opt_pa_f92;
    }

    public void setOpt_pa_f92(Integer opt_pa_f92) {
        this.opt_pa_f92 = opt_pa_f92;
    }

    public Double getPaa() {
        return paa;
    }

    public void setPaa(Double paa) {
        this.paa = paa;
    }

    public boolean isPREG_erUFT() {
        return PREG_erUFT;
    }

    public void setPREG_erUFT(boolean preg_eruft) {
        PREG_erUFT = preg_eruft;
    }

    public Uforeperiode getPREG_forrigeUFP() {
        return PREG_forrigeUFP;
    }

    public void setPREG_forrigeUFP(Uforeperiode preg_forrigeufp) {
        PREG_forrigeUFP = preg_forrigeufp;
    }

    public Uforeperiode getPREG_forrigeUFT() {
        return PREG_forrigeUFT;
    }

    public void setPREG_forrigeUFT(Uforeperiode preg_forrigeuft) {
        PREG_forrigeUFT = preg_forrigeuft;
    }

    public boolean isPREG_forsteUFP() {
        return PREG_forsteUFP;
    }

    public void setPREG_forsteUFP(boolean preg_forsteufp) {
        PREG_forsteUFP = preg_forsteufp;
    }

    public boolean isPREG_nedsattUfg() {
        return PREG_nedsattUfg;
    }

    public void setPREG_nedsattUfg(boolean ufg) {
        PREG_nedsattUfg = ufg;
    }

    public Uforeperiode getPREG_nesteUFP() {
        return PREG_nesteUFP;
    }

    public void setPREG_nesteUFP(Uforeperiode preg_nesteufp) {
        PREG_nesteUFP = preg_nesteufp;
    }

    public Uforeperiode getPREG_nesteUFT() {
        return PREG_nesteUFT;
    }

    public void setPREG_nesteUFT(Uforeperiode preg_nesteuft) {
        PREG_nesteUFT = preg_nesteuft;
    }

    public boolean isPREG_opphor() {
        return PREG_opphor;
    }

    public void setPREG_opphor(boolean preg_opphor) {
        PREG_opphor = preg_opphor;
    }

    public boolean isPREG_sissteUFP() {
        return PREG_sissteUFP;
    }

    public void setPREG_sissteUFP(boolean preg_sissteufp) {
        PREG_sissteUFP = preg_sissteufp;
    }

    public Uforeperiode getPREG_YP_UFP() {
        return PREG_YP_UFP;
    }

    public void setPREG_YP_UFP(Uforeperiode preg_yp_ufp) {
        PREG_YP_UFP = preg_yp_ufp;
    }

    public Integer getRedusertAntFppAr() {
        return redusertAntFppAr;
    }

    public void setRedusertAntFppAr(Integer redusertAntFppAr) {
        this.redusertAntFppAr = redusertAntFppAr;
    }

    public Double getSpt() {
        return spt;
    }

    public void setSpt(Double spt) {
        this.spt = spt;
    }

    public Integer getSpt_pa_e91() {
        return spt_pa_e91;
    }

    public void setSpt_pa_e91(Integer spt_pa_e91) {
        this.spt_pa_e91 = spt_pa_e91;
    }

    public Integer getSpt_pa_f92() {
        return spt_pa_f92;
    }

    public void setSpt_pa_f92(Integer spt_pa_f92) {
        this.spt_pa_f92 = spt_pa_f92;
    }

    public Integer getUfg() {
        return ufg;
    }

    public void setUfg(Integer ufg) {
        this.ufg = ufg;
    }

    public Date getUfgFom() {
        return ufgFom;
    }

    public void setUfgFom(Date ufgFom) {
        this.ufgFom = ufgFom;
    }

    public Date getUfgTom() {
        return ufgTom;
    }

    public void setUfgTom(Date ufgTom) {
        this.ufgTom = ufgTom;
    }

    public UforeTypeCti getUforeType() {
        return uforeType;
    }

    public void setUforeType(UforeTypeCti uforeType) {
        this.uforeType = uforeType;
    }

    public Date getUft() {
        return uft;
    }

    public void setUft(Date uft) {
        this.uft = uft;
    }

    public Date getUftTom() {
        return uftTom;
    }

    public void setUftTom(Date uftTom) {
        this.uftTom = uftTom;
    }

    public Date getVirk() {
        return virk;
    }

    public void setVirk(Date virk) {
        this.virk = virk;
    }

    public Double getYpt() {
        return ypt;
    }

    public void setYpt(Double ypt) {
        this.ypt = ypt;
    }

    public Integer getYpt_pa_e91() {
        return ypt_pa_e91;
    }

    public void setYpt_pa_e91(Integer ypt_pa_e91) {
        this.ypt_pa_e91 = ypt_pa_e91;
    }

    public Integer getYpt_pa_f92() {
        return ypt_pa_f92;
    }

    public void setYpt_pa_f92(Integer ypt_pa_f92) {
        this.ypt_pa_f92 = ypt_pa_f92;
    }

    public Double getSpt_eos() {
        return spt_eos;
    }

    public void setSpt_eos(Double spt_eos) {
        this.spt_eos = spt_eos;
    }

    public Integer getSpt_pa_e91_eos() {
        return spt_pa_e91_eos;
    }

    public void setSpt_pa_e91_eos(Integer spt_pa_e91_eos) {
        this.spt_pa_e91_eos = spt_pa_e91_eos;
    }

    public Integer getSpt_pa_f92_eos() {
        return spt_pa_f92_eos;
    }

    public void setSpt_pa_f92_eos(Integer spt_pa_f92_eos) {
        this.spt_pa_f92_eos = spt_pa_f92_eos;
    }

    public Integer getProRata_nevner() {
        return proRata_nevner;
    }

    public void setProRata_nevner(Integer proRata_nevner) {
        this.proRata_nevner = proRata_nevner;
    }

    public Integer getProRata_teller() {
        return proRata_teller;
    }

    public void setProRata_teller(Integer proRata_teller) {
        this.proRata_teller = proRata_teller;
    }

    public ProRataBeregningTypeCti getProRataBeregningType() {
        return proRataBeregningType;
    }

    public void setProRataBeregningType(ProRataBeregningTypeCti proRataBeregningType) {
        this.proRataBeregningType = proRataBeregningType;
    }

    public Integer getRedusertAntFppAr_proRata() {
        return redusertAntFppAr_proRata;
    }

    public void setRedusertAntFppAr_proRata(Integer redusertAntFppAr_proRata) {
        this.redusertAntFppAr_proRata = redusertAntFppAr_proRata;
    }

    public Double getSpt_proRata() {
        return spt_proRata;
    }

    public void setSpt_proRata(Double spt_proRata) {
        this.spt_proRata = spt_proRata;
    }

    public Date getPREG_ufgTom_intern() {
        return PREG_ufgTom_intern;
    }

    public void setPREG_ufgTom_intern(Date tom_intern) {
        PREG_ufgTom_intern = tom_intern;
    }

    public Uforeperiode getPREG_tilhorendeUFT() {
        return PREG_tilhorendeUFT;
    }

    public void setPREG_tilhorendeUFT(Uforeperiode pREG_tilhorendeUFT) {
        PREG_tilhorendeUFT = pREG_tilhorendeUFT;
    }

    public boolean isPREG_beregnSomMellomliggende() {
        return PREG_beregnSomMellomliggende;
    }

    public void setPREG_beregnSomMellomliggende(boolean somMellomliggende) {
        PREG_beregnSomMellomliggende = somMellomliggende;
    }

    public int getPREG_pafolgendeUforear() {
        return PREG_pafolgendeUforear;
    }

    public void setPREG_pafolgendeUforear(int uforear) {
        PREG_pafolgendeUforear = uforear;
    }

    public boolean isPREG_beregnSomOpphor() {
        return PREG_beregnSomOpphor;
    }

    public void setPREG_beregnSomOpphor(boolean pREG_beregnSomOpphor) {
        PREG_beregnSomOpphor = pREG_beregnSomOpphor;
    }

    public Uforeperiode getPREG_sisteUFP_UP() {
        return PREG_sisteUFP_UP;
    }

    public void setPREG_sisteUFP_UP(Uforeperiode PREG_sisteUFP_UP) {
        this.PREG_sisteUFP_UP = PREG_sisteUFP_UP;
    }

    /**
     * @return the beregningsgrunnlag
     */
    public int getBeregningsgrunnlag() {
        return beregningsgrunnlag;
    }

    /**
     * @param beregningsgrunnlag the beregningsgrunnlag to set
     */
    public void setBeregningsgrunnlag(int beregningsgrunnlag) {
        this.beregningsgrunnlag = beregningsgrunnlag;
    }

    /**
     * @return the angittUforetidspunkt
     */
    public Date getAngittUforetidspunkt() {
        return angittUforetidspunkt;
    }

    /**
     * @param angittUforetidspunkt the angittUforetidspunkt to set
     */
    public void setAngittUforetidspunkt(Date angittUforetidspunkt) {
        this.angittUforetidspunkt = angittUforetidspunkt;
    }

    public double getAntattInntektFaktorKap19() {
        return antattInntektFaktorKap19;
    }

    public void setAntattInntektFaktorKap19(double antattInntektFaktorKap19) {
        this.antattInntektFaktorKap19 = antattInntektFaktorKap19;
    }

    public double getAntattInntektFaktorKap20() {
        return antattInntektFaktorKap20;
    }

    public void setAntattInntektFaktorKap20(double antattInntektFaktorKap20) {
        this.antattInntektFaktorKap20 = antattInntektFaktorKap20;
    }
}
