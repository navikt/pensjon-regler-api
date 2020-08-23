package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.GuiPrompt;
import no.nav.domain.pensjon.regler.grunnlag.Uforeperiode;
import no.nav.domain.pensjon.regler.kode.FppGarantiKodeCti;
import no.nav.domain.pensjon.regler.kode.ProRataBeregningTypeCti;
import no.nav.domain.pensjon.regler.kode.UforeTypeCti;

import java.io.Serializable;
import java.util.Date;

/* 
 * @author Swiddy de Louw (Capgemin) - PK-10228
 * @author Steinar Hjellvik (Decisive) - PK-6458
 * @author Magnus Bakken (Accenture) - PK-20759
 */
public class BeregningUforeperiode implements Serializable {

    private static final long serialVersionUID = 5820916129615202514L;
    /**
     * Uføregraden, heltall 0-100.
     */
    @GuiPrompt(prompt = "Uføregrad")
    private Integer ufg;
    /**
     * Dato for uføretidspunktet.
     */
    @GuiPrompt(prompt = "Uføretidspunkt")
    private Date uft;
    /**
     * Angir om uføregraden er ren uføre,inneholder delvis yrke eller bare yrke.
     */
    @GuiPrompt(prompt = "Uføretype")
    private UforeTypeCti uforeType;

    /**
     * Framtidige pensjonspoengtall garanti, f.eks ung ufør har i dag en garanti på 3.3.
     */
    @GuiPrompt(prompt = "Framtidige pensjonspoengtall garanti")
    private Double fppGaranti;

    /**
     * Kode for fpp_garanti<br>
     * <code>A = UNG UFØR SOM VENTER PÅ RETT TIL 3.3 PENSJONSPOENG</code><br>
     * <code>B = UNG UFØR MED RETT TIL 3.3 PENSJONSPOENG</code><br>
     * <code>C = ung ufør som venter, og som ble ufør 20 år gammel</code><br>
     * <code>D = Ung ufør med rett til 3.3 poeng fra mai 1992</code><br>
     * <code>E = unge uføre før 1967</code>
     */
    @GuiPrompt(prompt = "Kode for framtidige pensjonspoengtall garanti")
    private FppGarantiKodeCti fppGarantiKode;

    /**
     * Antall godskrevet framtidig poengtall, ikke full framtidig godskriving.
     */
    @GuiPrompt(prompt = "Redusert antall fpp år")
    private Integer redusertAntFppAr;

    /**
     * Antall godskrevet framtidig poengtall, ikke full framtidig godskriving. EØS eller annen pro-rata beregning.
     */
    @GuiPrompt(prompt = "Redusert antall fpp år pro rata")
    private Integer redusertAntFppAr_proRata;

    /**
     * Angir hva utfallet av pro-rata beregningen var. Hvis satt er EØS eneste alternativ eller bedre enn alternativet (Folketrygd).
     */
    @GuiPrompt(prompt = "Pro rata beregning type")
    private ProRataBeregningTypeCti proRataBeregningType;

    /**
     * Dato for virkningsåret for denne uføreperioden.
     */
    @GuiPrompt(prompt = "Virkningsdato")
    private Date virk;

    /**
     * Dato for når uføreperioden avsluttes.
     */
    @GuiPrompt(prompt = "Dato uføreperiode avsluttes")
    private Date uftTom;

    /**
     * Dato for når uføregraden starter.
     */
    @GuiPrompt(prompt = "Dato uføregraden starter")
    private Date ufgFom;

    /**
     * Dato for når uføregraden avsluttes.
     */
    @GuiPrompt(prompt = "Dato uføregraden avslutter")
    private Date ufgTom;

    /**
     * Fødselsår for yngste barn.
     */
    @GuiPrompt(prompt = "Fødselsår yngste barn")
    private Integer fodselsArYngsteBarn;

    /**
     * Sluttpoengtall på tilleggspensjonen.
     */
    @GuiPrompt(prompt = "Sluttpoengtall")
    private Double spt;

    /**
     * Sluttpoengtall på tilleggspensjonen. Pro-rata beregning variant.
     */
    @GuiPrompt(prompt = "Pro rata sluttpoengtall")
    private Double spt_proRata;

    /**
     * Sluttpoengtall på tilleggspensjonen ved overkomp.
     */
    @GuiPrompt(prompt = "Overkompensasjon poengtall")
    private Double opt;

    /**
     * Sluttpoengtall på tilleggspensjonen ved yrkesskade.
     */
    @GuiPrompt(prompt = "Yrkesskade poengtall")
    private Double ypt;

    /**
     * Antall poengår før 1992 på sluttpoengtallet.
     */
    @GuiPrompt(prompt = "Poengår før 1992")
    private Integer spt_pa_f92;

    /**
     * Antall poengår etter 1991 på sluttpoengtallet
     */
    @GuiPrompt(prompt = "Poengår etter 1991")
    private Integer spt_pa_e91;

    /**
     * Antall poengår før 1992 på sluttpoengtallet.
     */
    @GuiPrompt(prompt = "Pro rata brøk teller")
    private Integer proRata_teller;

    /**
     * Antall poengår etter 1991 på sluttpoengtallet
     */
    @GuiPrompt(prompt = "Pro rata brøk nevner")
    private Integer proRata_nevner;

    /**
     * Antall poengår før 1992 på sluttpoengtallet med overkomp
     */
    @GuiPrompt(prompt = "Overkompensasjon poengår før 1992")
    private Integer opt_pa_f92;

    /**
     * Antall poengår etter 1992 på sluttpoengtallet med overkomp
     */
    @GuiPrompt(prompt = "Overkompensasjon poengår etter 1991")
    private Integer opt_pa_e91;

    /**
     * Antall poengår før 1992 på sluttpoengtallet ved yrkesskade
     */
    @GuiPrompt(prompt = "Yrkesskade poengår før 1992")
    private Integer ypt_pa_f92;

    /**
     * Antall poengår etter 1992 på sluttpoengtallet ved yrkesskade
     */
    @GuiPrompt(prompt = "Yrkesskade poengår etter 1991")
    private Integer ypt_pa_e91;

    /**
     * Poengtall ut fra antatt årlig inntekt på skadetidspunktet
     */
    @GuiPrompt(prompt = "Poengtall antatt årlig inntekt")
    private Double paa;

    /**
     * Fremtidige pensjonspoeng
     */
    @GuiPrompt(prompt = "Fremtidig pensjonspoeng")
    private Double fpp;

    /**
     * Fremtidige omregnete pensjonspoeng
     */
    @GuiPrompt(prompt = "Fremtidig pensjonspoeng omregnet")
    private Double fpp_omregnet;

    /**
     * Sluttpoengtall i EØS
     */
    @GuiPrompt(prompt = "Sluttpoengtall EØS")
    private Double spt_eos;

    /**
     * Antall poengår etter 1991 etter EØS-alternativet for sluttpoengtall
     */
    @GuiPrompt(prompt = "EØS poengår etter 1991")
    private Integer spt_pa_e91_eos;

    /**
     * Antall poengår før 1992 etter EØS-alternativet for sluttpoengtall
     */
    @GuiPrompt(prompt = "EØS poengår før 1992")
    private Integer spt_pa_f92_eos;

    /*
     * Det beregningsgrunnlag (årsbeløp) som ble gjeldende i perioden.
     * Dette er beregningsgrunnlagOrdinært når uforeType er UFORE eller UF_M_YRKE
     * og beregningsgrunnlagYrkesskade når type er YRKE
     */
    @GuiPrompt(prompt = "Beregningsgrunnlag (årsbeløp)")
    private int beregningsgrunnlag;

    /*
     * Det uføretidspunkt som er angitt for perioden, men ikke nødvendigvis anvendt.
     */
    @GuiPrompt(prompt = "Angitt uføretidspunkt")
    private Date angittUforetidspunkt;

    /**
     * Antatt årlig inntekt før uføretidspunktet (brukes i fastsettelse av opptjening til alderspensjon etter kapittel 19).
     */
    @GuiPrompt(prompt = "Antatt årlig inntekt før uføretidspunkt, kapittel 19")
    private double antattInntektFaktorKap19;

    /**
     * Antatt årlig inntekt før uføretidspunktet (brukes i fastsettelse av opptjening til alderspensjon etter kapittel 20).
     */
    @GuiPrompt(prompt = "Antatt årlig inntekt før uføretidspunkt, kapittel 20")
    private double antattInntektFaktorKap20;

    /**
     * Default Constructor
     */
    public BeregningUforeperiode() {
        super();
    }

    /**
     * @param ufg
     * @param uft
     * @param uforeType
     * @param fppGaranti
     * @param fppGarantiKode
     * @param redusertAntFppAr
     * @param redusertAntFppAr_proRata
     * @param proRataBeregningType
     * @param virk
     * @param uftTom
     * @param ufgFom
     * @param ufgTom
     * @param fodselsArYngsteBarn
     * @param spt
     * @param spt_proRata
     * @param opt
     * @param ypt
     * @param spt_pa_f92
     * @param spt_pa_e91
     * @param proRata_teller
     * @param proRata_nevner
     * @param opt_pa_f92
     * @param opt_pa_e91
     * @param ypt_pa_f92
     * @param ypt_pa_e91
     * @param paa
     * @param fpp
     * @param fpp_omregnet
     * @param spt_eos
     * @param spt_pa_e91_eos
     * @param spt_pa_f92_eos
     * @param beregningsgrunnlag
     * @param angittUforetidspunkt
     */
    public BeregningUforeperiode(Integer ufg, Date uft, UforeTypeCti uforeType, Double fppGaranti, FppGarantiKodeCti fppGarantiKode, Integer redusertAntFppAr,
                                 Integer redusertAntFppAr_proRata, ProRataBeregningTypeCti proRataBeregningType, Date virk, Date uftTom, Date ufgFom, Date ufgTom,
                                 Integer fodselsArYngsteBarn, Double spt, Double spt_proRata, Double opt, Double ypt, Integer spt_pa_f92, Integer spt_pa_e91,
                                 Integer proRata_teller, Integer proRata_nevner, Integer opt_pa_f92, Integer opt_pa_e91, Integer ypt_pa_f92, Integer ypt_pa_e91, Double paa,
                                 Double fpp, Double fpp_omregnet, Double spt_eos, Integer spt_pa_e91_eos, Integer spt_pa_f92_eos, int beregningsgrunnlag, Date angittUforetidspunkt) {
        super();
        this.ufg = ufg;
        this.uft = uft;
        this.uforeType = uforeType;
        this.fppGaranti = fppGaranti;
        this.fppGarantiKode = fppGarantiKode;
        this.redusertAntFppAr = redusertAntFppAr;
        this.redusertAntFppAr_proRata = redusertAntFppAr_proRata;
        this.proRataBeregningType = proRataBeregningType;
        this.virk = virk;
        this.uftTom = uftTom;
        this.ufgFom = ufgFom;
        this.ufgTom = ufgTom;
        this.fodselsArYngsteBarn = fodselsArYngsteBarn;
        this.spt = spt;
        this.spt_proRata = spt_proRata;
        this.opt = opt;
        this.ypt = ypt;
        this.spt_pa_f92 = spt_pa_f92;
        this.spt_pa_e91 = spt_pa_e91;
        this.proRata_teller = proRata_teller;
        this.proRata_nevner = proRata_nevner;
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
        this.beregningsgrunnlag = beregningsgrunnlag;
        this.angittUforetidspunkt = angittUforetidspunkt;
    }

    /**
     * Copyconstructor
     */
    public BeregningUforeperiode(BeregningUforeperiode b) {
        this();
        if (b.fodselsArYngsteBarn != null) {
            fodselsArYngsteBarn = new Integer(b.fodselsArYngsteBarn);
        }
        if (b.fpp != null) {
            fpp = new Double(b.fpp);
        }
        if (b.fpp_omregnet != null) {
            fpp_omregnet = new Double(b.fpp_omregnet);
        }
        if (b.fppGaranti != null) {
            fppGaranti = new Double(b.fppGaranti);
        }
        if (b.fppGarantiKode != null) {
            fppGarantiKode = new FppGarantiKodeCti(b.fppGarantiKode);
        }
        if (b.opt != null) {
            opt = new Double(b.opt);
        }
        if (b.opt_pa_e91 != null) {
            opt_pa_e91 = new Integer(b.opt_pa_e91);
        }
        if (b.opt_pa_f92 != null) {
            opt_pa_f92 = new Integer(b.opt_pa_f92);
        }
        if (b.paa != null) {
            paa = new Double(b.paa);
        }
        if (b.proRata_nevner != null) {
            proRata_nevner = new Integer(b.proRata_nevner);
        }
        if (b.proRata_teller != null) {
            proRata_teller = new Integer(b.proRata_teller);
        }
        if (b.proRataBeregningType != null) {
            proRataBeregningType = new ProRataBeregningTypeCti(b.proRataBeregningType);
        }
        if (b.redusertAntFppAr != null) {
            redusertAntFppAr = new Integer(b.redusertAntFppAr);
        }
        if (b.redusertAntFppAr_proRata != null) {
            redusertAntFppAr_proRata = new Integer(b.redusertAntFppAr_proRata);
        }
        if (b.spt != null) {
            spt = new Double(b.spt);
        }
        if (b.spt_pa_e91 != null) {
            spt_pa_e91 = new Integer(b.spt_pa_e91);
        }
        if (b.spt_pa_e91_eos != null) {
            spt_pa_e91_eos = new Integer(b.spt_pa_e91_eos);
        }
        if (b.spt_pa_f92 != null) {
            spt_pa_f92 = new Integer(b.spt_pa_f92);
        }
        if (b.spt_pa_f92_eos != null) {
            spt_pa_f92_eos = new Integer(b.spt_pa_f92_eos);
        }
        if (b.spt_proRata != null) {
            spt_proRata = new Double(b.spt_proRata);
        }
        if (b.ufg != null) {
            ufg = new Integer(b.ufg);
        }
        if (b.ufgFom != null) {
            ufgFom = (Date) b.ufgFom.clone();
        }
        if (b.ufgTom != null) {
            ufgTom = (Date) b.ufgTom.clone();
        }
        if (b.uforeType != null) {
            uforeType = new UforeTypeCti(b.uforeType);
        }
        if (b.uft != null) {
            uft = (Date) b.uft.clone();
        }
        if (b.uftTom != null) {
            uftTom = (Date) b.uftTom.clone();
        }
        if (b.virk != null) {
            virk = (Date) b.virk.clone();
        }
        if (b.ypt != null) {
            ypt = new Double(b.ypt);
        }
        if (b.ypt_pa_e91 != null) {
            ypt_pa_e91 = new Integer(b.ypt_pa_e91);
        }
        if (b.ypt_pa_f92 != null) {
            ypt_pa_f92 = new Integer(b.ypt_pa_f92);
        }
        beregningsgrunnlag = b.beregningsgrunnlag;
        if (b.angittUforetidspunkt != null) {
            angittUforetidspunkt = (Date) b.angittUforetidspunkt.clone();
        }
        antattInntektFaktorKap19 = b.antattInntektFaktorKap19;

        antattInntektFaktorKap20 = b.antattInntektFaktorKap20;
    }

    /*
     * @param Uforeperiode the uforeperiode used to instantiate a new Beregninguforeperiode
     */
    public BeregningUforeperiode(Uforeperiode up) {
        super();
        ufg = up.getUfg();
        uft = up.getUft();
        uforeType = up.getUforeType();
        fppGaranti = up.getFppGaranti();
        fppGarantiKode = up.getFppGarantiKode();
        redusertAntFppAr = up.getRedusertAntFppAr();
        redusertAntFppAr_proRata = up.getRedusertAntFppAr_proRata();
        proRataBeregningType = up.getProRataBeregningType();
        virk = up.getVirk();
        uftTom = up.getUftTom();
        ufgFom = up.getUfgFom();
        ufgTom = up.getUfgTom();
        fodselsArYngsteBarn = up.getFodselsArYngsteBarn();
        spt = up.getSpt();
        spt_proRata = up.getSpt_proRata();
        opt = up.getOpt();
        ypt = up.getYpt();
        spt_pa_f92 = up.getSpt_pa_f92();
        spt_pa_e91 = up.getSpt_pa_e91();
        proRata_teller = up.getProRata_teller();
        proRata_nevner = up.getProRata_nevner();
        opt_pa_f92 = up.getOpt_pa_f92();
        opt_pa_e91 = up.getOpt_pa_e91();
        ypt_pa_f92 = up.getYpt_pa_f92();
        ypt_pa_e91 = up.getYpt_pa_e91();
        paa = up.getPaa();
        fpp = up.getFpp();
        fpp_omregnet = up.getFpp_omregnet();
        spt_eos = up.getSpt_eos();
        spt_pa_e91_eos = up.getSpt_pa_e91_eos();
        spt_pa_f92_eos = up.getSpt_pa_f92_eos();
        beregningsgrunnlag = up.getBeregningsgrunnlag();
        angittUforetidspunkt = up.getAngittUforetidspunkt();
        antattInntektFaktorKap19 = up.getAntattInntektFaktorKap19();
        antattInntektFaktorKap20 = up.getAntattInntektFaktorKap20();
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
