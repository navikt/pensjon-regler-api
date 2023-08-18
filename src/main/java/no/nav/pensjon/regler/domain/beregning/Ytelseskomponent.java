package no.nav.pensjon.regler.domain.beregning;

import no.nav.pensjon.regler.domain.GuiPrompt;
import no.nav.pensjon.regler.domain.Merknad;
import no.nav.pensjon.regler.domain.beregning2011.ReguleringsInformasjon;
import no.nav.pensjon.regler.domain.kode.FormelKodeCti;
import no.nav.pensjon.regler.domain.kode.SakTypeCti;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;
import no.nav.pensjon.regler.domain.util.ToStringUtil;
import no.nav.pensjon.regler.domain.util.formula.IFormelProvider;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Superklasse for alle ytelser, Grunnpensjon, Sertillegg, AfpTillegg osv. For
 * alle ytelser gjelder at brutto - netto = fradrag.
 */
public abstract class Ytelseskomponent implements Serializable {

    private static final long serialVersionUID = 4357051135111680978L;

    /**
     * Brutto beløp.
     */
    @GuiPrompt(prompt = "Brutto")
    protected int brutto = 0;

    /**
     * Netto beløp.
     */
    @GuiPrompt(prompt = "Netto")
    protected int netto = 0;

    /**
     * Fradraget: brutto - netto
     */
    @GuiPrompt(prompt = "Fradrag")
    protected int fradrag = 0;

    /**
     * Ikke avrundet beløp, gjelder for hele året.
     */
    @GuiPrompt(prompt = "Brutto per år")
    protected double bruttoPerAr = 0.0;

    /**
     * Årlig netto utbetalt sum.
     */
    @GuiPrompt(prompt = "Netto per år")
    protected double nettoPerAr = 0.0;

    /**
     * Ytelsens fradrag per år.
     */
    @GuiPrompt(prompt = "Fradrag per år")
    protected double fradragPerAr = 0.0;

    /**
     * Type ytelse, verdi fra kodeverk.
     */
    protected YtelsekomponentTypeCti ytelsekomponentType;

    /**
     * Liste av merknader.
     */
    protected List<Merknad> merknadListe = new ArrayList<Merknad>();

    /**
     * Indikerer hvilken beregningsformel som ble brukt.
     */
    @GuiPrompt(prompt = "Formel")
    private FormelKodeCti formelKode;

    /**
     * Informasjon om regulering av ytelsen.
     */
    @GuiPrompt(prompt = "Reguleringsinformasjon")
    private ReguleringsInformasjon reguleringsInformasjon;

    /**
     * Angir om ytelseskomponenten går til utbetaling eller tilbakekreving.
     * Settes ikke i PREG, men mappes slik at vi ikke mister den ved kall til regeltjenester som returnerer kopier av innsendt ytelseskomponent (f.eks. faktoromregning).
     */
    protected Boolean fradragsTransaksjon = false;

    /**
     * Angir om ytelseskomponenten er opphørt.
     * Settes ikke i PREG, men mappes slik at vi ikke mister den ved kall til regeltjenester som returnerer kopier av innsendt ytelseskomponent (f.eks. faktoromregning).
     */
    protected Boolean opphort = false;

    /**
     * Angir sakentypen ytelseskomponenten er knyttet til.
     * Settes ikke i PREG, men mappes slik at vi ikke mister den ved kall til regeltjenester som returnerer kopier av innsendt ytelseskomponent (f.eks. faktoromregning).
     */
    protected SakTypeCti sakType;

    /**
     * Copy Constructor
     *
     * @param ytelseskomponent a <code>Ytelseskomponent</code> object
     */
    public Ytelseskomponent(Ytelseskomponent ytelseskomponent) {
        brutto = ytelseskomponent.brutto;
        netto = ytelseskomponent.netto;
        fradrag = ytelseskomponent.fradrag;
        bruttoPerAr = ytelseskomponent.bruttoPerAr;
        nettoPerAr = ytelseskomponent.nettoPerAr;
        fradragPerAr = ytelseskomponent.fradragPerAr;
        if (ytelseskomponent.ytelsekomponentType != null) {
            ytelsekomponentType = new YtelsekomponentTypeCti(ytelseskomponent.ytelsekomponentType);
        }
        if (ytelseskomponent.formelKode != null) {
            formelKode = new FormelKodeCti(ytelseskomponent.formelKode);
        }
        if (ytelseskomponent.merknadListe != null) {
            for (Merknad merknad : ytelseskomponent.merknadListe) {
                merknadListe.add(new Merknad(merknad));
            }
        }
        if (ytelseskomponent.reguleringsInformasjon != null) {
            reguleringsInformasjon = new ReguleringsInformasjon(ytelseskomponent.reguleringsInformasjon);
        }
        fradragsTransaksjon = ytelseskomponent.fradragsTransaksjon;
        opphort = ytelseskomponent.opphort;
        if (ytelseskomponent.sakType != null) {
            sakType = new SakTypeCti(ytelseskomponent.sakType);
        }
    }

    /**
     * Angir om ytelseskomponenten implementerer interfacet IFormelProvider.
     * Dette dekker opp for mangel i Blaze Advisor som ikke kan sjekke om en klasse er et interface.
     */
    public boolean isIFormelProvider() {
        return (this instanceof IFormelProvider);
    }

    protected Ytelseskomponent() {
        merknadListe = new ArrayList<Merknad>();
    }

    public int getBrutto() {
        return brutto;
    }

    public void setBrutto(int brutto) {
        this.brutto = brutto;
    }

    public double getBruttoPerAr() {
        return bruttoPerAr;
    }

    public void setBruttoPerAr(double bruttoPerAr) {
        this.bruttoPerAr = bruttoPerAr;
    }

    public int getFradrag() {
        return fradrag;
    }

    public void setFradrag(int fradrag) {
        this.fradrag = fradrag;
    }

    public int getNetto() {
        return netto;
    }

    public void setNetto(int netto) {
        this.netto = netto;
    }

    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    public void setMerknadListe(List<Merknad> merknadListe) {
        this.merknadListe = merknadListe;
    }

    public double getNettoPerAr() {
        return nettoPerAr;
    }

    public void setNettoPerAr(double nettoPerAr) {
        this.nettoPerAr = nettoPerAr;
    }

    public double getFradragPerAr() {
        return fradragPerAr;
    }

    public void setFradragPerAr(double fradragPerAr) {
        this.fradragPerAr = fradragPerAr;
    }

    /**
     * @return Returns the merknadListe as array.
     * @deprecated
     */
    @Deprecated
    public Merknad[] retrieveMerknadListeAsArray() {
        return merknadListe.toArray(new Merknad[0]);
    }

    /**
     * Read only property for merknadListe as array.
     *
     * @return array of Merknad
     */
    public Merknad[] getMerknadListeAsArray() {
        return merknadListe != null ? merknadListe.toArray(new Merknad[merknadListe.size()]) : new Merknad[0];
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }

    public YtelsekomponentTypeCti getYtelsekomponentType() {
        return ytelsekomponentType;
    }

    public void setYtelsekomponentType(YtelsekomponentTypeCti ytelsekomponentType) {
        this.ytelsekomponentType = ytelsekomponentType;
    }

    public FormelKodeCti getFormelKode() {
        return formelKode;
    }

    public void setFormelKode(FormelKodeCti formelKode) {
        this.formelKode = formelKode;
    }

    public ReguleringsInformasjon getReguleringsInformasjon() {
        return reguleringsInformasjon;
    }

    public void setReguleringsInformasjon(ReguleringsInformasjon reguleringsInformasjon) {
        this.reguleringsInformasjon = reguleringsInformasjon;
    }

    public Boolean getFradragsTransaksjon() {
        return fradragsTransaksjon;
    }

    public void setFradragsTransaksjon(Boolean fradragsTransaksjon) {
        this.fradragsTransaksjon = fradragsTransaksjon;
    }

    public Boolean getOpphort() {
        return opphort;
    }

    public void setOpphort(Boolean opphort) {
        this.opphort = opphort;
    }

    public SakTypeCti getSakType() {
        return sakType;
    }

    public void setSakType(SakTypeCti sakType) {
        this.sakType = sakType;
    }
}
