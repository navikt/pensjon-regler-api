package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.GuiPrompt;
import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;
import no.nav.domain.pensjon.regler.util.formula.Formel;
import no.nav.domain.pensjon.regler.util.formula.Formler;
import no.nav.domain.pensjon.regler.util.formula.IFormelProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Steinar Hjellvik (Decisive) PK-7113
 * @author Swiddy de Louw (Capgemini) PK-7113
 * @author Steinar Hjellvik (Decisive) - PK-11391
 * @author Swiddy de Louw (Capgemini) - PK-11041
 * @author Tatyana Lochehina PK-13673
 */
public class Gjenlevendetillegg extends Ytelseskomponent implements UforetrygdYtelseskomponent, IFormelProvider {

    private static final long serialVersionUID = -4631123447862835485L;

    /**
     * Årsbeløp for delytelsen fra tidligere vedtak (fra tilsvarende beregningsperiode)
     */
    private int tidligereBelopAr;

    /**
     * Årsbeløpet fra knvertert beregningsgrunnlag.
     */
    @GuiPrompt(prompt = "Årsbeløp konvertert beregningsgrunnlag")
    private double bgKonvertert;

    /**
     * Årsbeløpet fra konvertertberegningsgrunnlagGJT
     */
    @GuiPrompt(prompt = "Årsbeløp konvertert beregningsgrunnlag gjenlevendetillegg")
    private double bgGjenlevendetillegg;

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
    @GuiPrompt(prompt = "Inntektsavkortingsbeløp per år")
    private int avkortningsbelopPerAr;

    /**
     * Angir om gjenlevendetillegget er beregnet som konvertert
     * eller iht. nye regler for gjenlevendetillegg innvilget fom. 01.01.2015.
     */
    @GuiPrompt(prompt = "Gjenlevendetillegg beregnet etter nye regler")
    private boolean nyttGjenlevendetillegg;

    /**
     * Hvilken faktor gjenlevendetillegget er avkortet med uten hensyn til justering for tidligere avkortet/justert beløp
     */
    @GuiPrompt(prompt = "Avkortingsfaktor gjenlevendetillegg")
    private double avkortingsfaktorGJT;

    /**
     * Oppsummering av sentrale felt brukt i utregning av nytt gjenlevendetillegg.
     * Kun satt dersom nyttGjenlevendetillegg er true.
     */
    @GuiPrompt(prompt = "Gjenlevendetillegg informasjon")
    private GjenlevendetilleggInformasjon gjenlevendetilleggInformasjon;

    /**
     * Utrykker avviket mellom lignet og forventet beløp ved etteroppgjør.
     */
    @GuiPrompt(prompt = "Periodisert avvik etteroppgjør")
    private double periodisertAvvikEtteroppgjor;

    /**
     * Representerer reduksjon av UFI (brutto uføretrygd) pga eksport.
     */
    @GuiPrompt(prompt = "Eksportfaktor")
    private double eksportFaktor;

    /**
     * Grunnlaget for gjenlevendetillegget
     */
    private double grunnlagGjenlevendetillegg;

    /**
     * Map av formler brukt i beregning av Tilleggspensjon.
     */
    private final HashMap<String, Formel> formelMap;

    /**
     * Formler er grensesnittet mot formelrammeverket.
     */
    private final Formler formler = new Formler(this);

    public Gjenlevendetillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_GJT");
        formelMap = new HashMap<>();
    }

    public Gjenlevendetillegg(Gjenlevendetillegg gjenlevendetillegg) {
        super(gjenlevendetillegg);
        bgKonvertert = gjenlevendetillegg.bgKonvertert;
        bgGjenlevendetillegg = gjenlevendetillegg.bgGjenlevendetillegg;
        nettoAkk = gjenlevendetillegg.nettoAkk;
        nettoRestAr = gjenlevendetillegg.nettoRestAr;
        avkortningsbelopPerAr = gjenlevendetillegg.avkortningsbelopPerAr;
        nyttGjenlevendetillegg = gjenlevendetillegg.nyttGjenlevendetillegg;
        avkortingsfaktorGJT = gjenlevendetillegg.avkortingsfaktorGJT;
        if (gjenlevendetillegg.gjenlevendetilleggInformasjon != null) {
            gjenlevendetilleggInformasjon = new GjenlevendetilleggInformasjon(gjenlevendetillegg.gjenlevendetilleggInformasjon);
        }
        periodisertAvvikEtteroppgjor = gjenlevendetillegg.periodisertAvvikEtteroppgjor;
        eksportFaktor = gjenlevendetillegg.eksportFaktor;
        tidligereBelopAr = gjenlevendetillegg.tidligereBelopAr;
        grunnlagGjenlevendetillegg = gjenlevendetillegg.grunnlagGjenlevendetillegg;

        formelMap = new HashMap<>();
        if (gjenlevendetillegg.formelMap != null && !gjenlevendetillegg.formelMap.isEmpty()) {
            for (Map.Entry<String, Formel> pair : gjenlevendetillegg.formelMap.entrySet()) {
                formelMap.put(pair.getKey(), new Formel(pair.getValue()));
            }
        }
    }

    public double getBgKonvertert() {
        return bgKonvertert;
    }

    public void setBgKonvertert(double bgKonvertert) {
        this.bgKonvertert = bgKonvertert;
    }

    public double getBgGjenlevendetillegg() {
        return bgGjenlevendetillegg;
    }

    public void setBgGjenlevendetillegg(double bgAvdod) {
        bgGjenlevendetillegg = bgAvdod;
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

    public boolean isNyttGjenlevendetillegg() {
        return nyttGjenlevendetillegg;
    }

    public void setNyttGjenlevendetillegg(boolean nyttGjenlevendetillegg) {
        this.nyttGjenlevendetillegg = nyttGjenlevendetillegg;
    }

    public GjenlevendetilleggInformasjon getGjenlevendetilleggInformasjon() {
        return gjenlevendetilleggInformasjon;
    }

    /**
     * @return the avkortingsfaktorGJT
     */
    public double getAvkortingsfaktorGJT() {
        return avkortingsfaktorGJT;
    }

    /**
     * @param avkortingsfaktorGJT the avkortingsfaktorGJT to set
     */
    public void setAvkortingsfaktorGJT(double avkortingsfaktorGJT) {
        this.avkortingsfaktorGJT = avkortingsfaktorGJT;
    }

    public void setGjenlevendetilleggInformasjon(GjenlevendetilleggInformasjon gjenlevendetilleggInformasjon) {
        this.gjenlevendetilleggInformasjon = gjenlevendetilleggInformasjon;
    }

    public double getPeriodisertAvvikEtteroppgjor() {
        return periodisertAvvikEtteroppgjor;
    }

    public void setPeriodisertAvvikEtteroppgjor(double periodisertAvvikEtteroppgjor) {
        this.periodisertAvvikEtteroppgjor = periodisertAvvikEtteroppgjor;
    }

    public double getEksportFaktor() {
        return eksportFaktor;
    }

    public void setEksportFaktor(double eksportFaktor) {
        this.eksportFaktor = eksportFaktor;
    }

    @Override
    public int getTidligereBelopAr() {
        return tidligereBelopAr;
    }

    @Override
    public void setTidligereBelopAr(int tidligereBelopAr) {
        this.tidligereBelopAr = tidligereBelopAr;
    }

    public double getGrunnlagGjenlevendetillegg() {
        return grunnlagGjenlevendetillegg;
    }

    public void setGrunnlagGjenlevendetillegg(double grunnlagGjenlevendetillegg) {
        this.grunnlagGjenlevendetillegg = grunnlagGjenlevendetillegg;
    }

    @Override
    public HashMap<String, Formel> getFormelMap() {
        return formelMap;
    }

    @Override
    public Formler getFormler() {
        return formler;
    }

    @Override
    public String getFormelPrefix() {
        return ytelsekomponentType.getKode();
    }
}
