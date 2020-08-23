package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.GuiPrompt;
import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

/**
 * Ytelseskomponent for uføretrygd.
 * 
 * @author Steinar Hjellvik (Decisive) PK-6172
 * @author Aasmund Nordstoga (Accenture) PK-9029
 * @author Tatyana Lochehina PK-13673
 */
public class UforetrygdOrdiner extends Ytelseskomponent implements UforetrygdYtelseskomponent {
    private static final long serialVersionUID = -306330279995225899L;

    /**
     * Brukers minsteytelse.
     */
    @GuiPrompt(prompt = "Brukers minsteytelse")
    private Minsteytelse minsteytelse;

    /**
     * Brukers uføretrygd før inntektsavkorting.
     */
    @GuiPrompt(prompt = "Egenopptjent uføretrygd")
    private EgenopptjentUforetrygd egenopptjentUforetrygd;

    /**
     * Angir om egenopptjentUforetrygd er best.
     */
    @GuiPrompt(prompt = "Egenopptjent uføretrygd gunstigst")
    private boolean egenopptjentUforetrygdBest;

    /**
     * Angir detaljer rundt inntektsavkortingen.
     */
    @GuiPrompt(prompt = "Detaljer om inntektsavkorting")
    private AvkortingsinformasjonUT avkortingsinformasjon;

    /**
     * Akkumulert netto hittil i året eksklusiv måned for beregningsperiodens fomDato.
     */
    @GuiPrompt(prompt = "Akkumulert netto")
    private int nettoAkk;

    /**
     * gjenstående beløp brukeren har rett på for året som beregningsperioden starter,
     * og inkluderer måneden det beregnes fra.
     */
    @GuiPrompt(prompt = "Gjenstående netto for året")
    private int nettoRestAr;

    /**
     * Inntektsavkortningsbeløp per år, før justering med differansebeløp
     */
    @GuiPrompt(prompt = "Inntektsavkortningsbeløp per år")
    private int avkortningsbelopPerAr;

    /**
     * Utrykker avviket mellom lignet og forventet beløp ved etteroppgjør.
     */
    @GuiPrompt(prompt = "Periodisert avvik ved etteroppgjør")
    private double periodisertAvvikEtteroppgjor;

    /**
     * Angir fradragPerAr dersom det ikke hadde vært arbeidsforsøk i perioden.
     */
    @GuiPrompt(prompt = "Fradrag per år uten arbeidsforsøk")
    private double fradragPerArUtenArbeidsforsok;

    /**
     * Årsbeløp for delytelsen fra tidligere vedtak (fra tilsvarende beregningsperiode)
     */
    private int tidligereBelopAr;

    public UforetrygdOrdiner() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_ORDINER");
    }

    public UforetrygdOrdiner(UforetrygdOrdiner ut) {
        super(ut);
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_ORDINER");
        egenopptjentUforetrygdBest = ut.egenopptjentUforetrygdBest;
        nettoAkk = ut.nettoAkk;
        nettoRestAr = ut.nettoRestAr;
        avkortningsbelopPerAr = ut.avkortningsbelopPerAr;

        if (ut.minsteytelse != null) {
            minsteytelse = new Minsteytelse(ut.minsteytelse);
        }
        if (ut.egenopptjentUforetrygd != null) {
            egenopptjentUforetrygd = new EgenopptjentUforetrygd(ut.egenopptjentUforetrygd);
        }
        if (ut.avkortingsinformasjon != null) {
            avkortingsinformasjon = new AvkortingsinformasjonUT(ut.avkortingsinformasjon);
        }
        periodisertAvvikEtteroppgjor = ut.periodisertAvvikEtteroppgjor;
        fradragPerArUtenArbeidsforsok = ut.fradragPerArUtenArbeidsforsok;
        tidligereBelopAr = ut.tidligereBelopAr;
    }

    public Minsteytelse getMinsteytelse() {
        return minsteytelse;
    }

    public void setMinsteytelse(Minsteytelse minsteytelse) {
        this.minsteytelse = minsteytelse;
    }

    public EgenopptjentUforetrygd getEgenopptjentUforetrygd() {
        return egenopptjentUforetrygd;
    }

    public void setEgenopptjentUforetrygd(EgenopptjentUforetrygd egenopptjentUforetrygd) {
        this.egenopptjentUforetrygd = egenopptjentUforetrygd;
    }

    public boolean isEgenopptjentUforetrygdBest() {
        return egenopptjentUforetrygdBest;
    }

    public void setEgenopptjentUforetrygdBest(boolean egenopptjentUforetrygdBest) {
        this.egenopptjentUforetrygdBest = egenopptjentUforetrygdBest;
    }

    public AvkortingsinformasjonUT getAvkortingsinformasjon() {
        return avkortingsinformasjon;
    }

    public void setAvkortingsinformasjon(AvkortingsinformasjonUT avkortingsinformasjon) {
        this.avkortingsinformasjon = avkortingsinformasjon;
    }

    public int getNettoAkk() {
        return nettoAkk;
    }

    public void setNettoAkk(int nettoAkk) {
        this.nettoAkk = nettoAkk;
    }

    public int getNettoRestAr() {
        return nettoRestAr;
    }

    public void setNettoRestAr(int nettoRestAr) {
        this.nettoRestAr = nettoRestAr;
    }

    public int getAvkortningsbelopPerAr() {
        return avkortningsbelopPerAr;
    }

    public void setAvkortningsbelopPerAr(int avkortningsbelopPerAr) {
        this.avkortningsbelopPerAr = avkortningsbelopPerAr;
    }

    public double getPeriodisertAvvikEtteroppgjor() {
        return periodisertAvvikEtteroppgjor;
    }

    public void setPeriodisertAvvikEtteroppgjor(double periodisertAvvikEtteroppgjor) {
        this.periodisertAvvikEtteroppgjor = periodisertAvvikEtteroppgjor;
    }

    public double getFradragPerArUtenArbeidsforsok() {
        return fradragPerArUtenArbeidsforsok;
    }

    public void setFradragPerArUtenArbeidsforsok(double fradragPerArUtenArbeidsforsok) {
        this.fradragPerArUtenArbeidsforsok = fradragPerArUtenArbeidsforsok;
    }

    @Override
    public int getTidligereBelopAr() {
        return tidligereBelopAr;
    }

    @Override
    public void setTidligereBelopAr(int tidligereBelopAr) {
        this.tidligereBelopAr = tidligereBelopAr;
    }
}
