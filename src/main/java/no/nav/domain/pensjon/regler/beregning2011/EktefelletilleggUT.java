package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.GuiPrompt;
import no.nav.domain.pensjon.regler.beregning.Ektefelletillegg;
import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

/* PREG domeneklasse for ytelseskomponent Ektefelletillegg Uføretrygd
 *
 * @author Magnus Bakken - PKFEIL-3285: Feilretting av kopikonstruktør.
 * @author Swiddy de Louw - PKYTON-369 PK-6582 / PK-7106
 */

public class EktefelletilleggUT extends Ytelseskomponent implements UforetrygdYtelseskomponent{

    private static final long serialVersionUID = 8521270172851585927L;

    /**
     * Årsbeløp for delytelsen fra tidligere vedtak (fra tilsvarende beregningsperiode)
     */
    private int tidligereBelopAr;

    /**
     * Akkumulert netto hittil i året eksklusiv måned for beregningsperiodens fomDato.
     */
    @GuiPrompt(prompt = "Netto akkumulert")
    private int nettoAkk;

    /**
     * gjenstående beløp brukeren har rett på for året som beregningsperioden starter,
     * og inkluderer måneden det beregnes fra.
     */
    @GuiPrompt(prompt = "Netto gjenstående")
    private int nettoRestAr;

    /**
     * Inntektsavkortningsbeløp per år, før justering med differansebeløp
     */
    @GuiPrompt(prompt = "Avkortningsbeløp per år")
    private int avkortningsbelopPerAr;

	/**
	 * netto ektefelletillegg per måned før konvertering * 12
	 */
    @GuiPrompt(prompt = "Ektefelletillegg før skattekompensasjon")
    private double etForSkattekomp;

	/**
	 * brukers oppjusterte uførepensjon før skattekompensasjon
	 */
    @GuiPrompt(prompt = "Brukers oppjusterte uførepensjon før skattekompensasjon")
	private double upForSkattekomp;

    public EktefelletilleggUT() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_ET");
    }

    public EktefelletilleggUT(EktefelletilleggUT ektefelletilleggUT) {
        super(ektefelletilleggUT);
        nettoAkk = ektefelletilleggUT.nettoAkk;
        nettoRestAr = ektefelletilleggUT.nettoRestAr;
        avkortningsbelopPerAr = ektefelletilleggUT.avkortningsbelopPerAr;
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_ET");
        etForSkattekomp = ektefelletilleggUT.etForSkattekomp;
        upForSkattekomp = ektefelletilleggUT.upForSkattekomp;
        tidligereBelopAr = ektefelletilleggUT.tidligereBelopAr;
    }

    public EktefelletilleggUT(Ektefelletillegg ektefelletillegg) {
        super(ektefelletillegg);
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_ET");
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

    public double getEtForSkattekomp() {
        return etForSkattekomp;
    }

    public void setEtForSkattekomp(double etForSkattekomp) {
        this.etForSkattekomp = etForSkattekomp;
    }

    public double getUpForSkattekomp() {
        return upForSkattekomp;
    }

    public void setUpForSkattekomp(double upForSkattekomp) {
        this.upForSkattekomp = upForSkattekomp;
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
