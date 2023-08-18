package no.nav.pensjon.regler.domain.beregning;


import no.nav.pensjon.regler.domain.GuiPrompt;
import no.nav.pensjon.regler.domain.kode.FormelKodeCti;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;
import no.nav.pensjon.regler.domain.util.formula.Formel;
import no.nav.pensjon.regler.domain.util.formula.IFormelProvider;

import java.util.HashMap;
import java.util.Map;

/*
 * Tilleggspensjon
 */

public class Tilleggspensjon extends Ytelseskomponent implements IFormelProvider {

    private static final long serialVersionUID = -6560474253190480563L;

    /**
     * Det ordinære sluttpoengtallet.
     */
    @GuiPrompt(prompt = "Sluttpoengtall")
    protected Sluttpoengtall spt;

    /**
     * Sluttpoengtallet for yrkesskaden.Denne blir utfylt dersom det foreligger
     * yrkesskadegrunnlag i persongrunnlaget. ypt.pt er beregnet på grunnlag av
     * a) tilhørende poengtall (ypt.poengrekke.poengtallListe ) eller b) paa (
     * poeng etter antatt årlig inntekt ). Poengtall-listen er da tom. I alle
     * tilfeller er YPT.pt >= SPT.pt. Det vanligste tilfellet hvor YPT.pt >
     * SPT.pt skyldes yrkessadegrunnlag.antattArligInntekt.
     */
    @GuiPrompt(prompt = "Sluttpoengtall for yrkesskade")
    protected Sluttpoengtall ypt;

    /**
     * Sluttpoengtallet for overkompensasjon.
     */
    @GuiPrompt(prompt = "Sluttpoengtall for overkompensasjon")
    protected Sluttpoengtall opt;

    /**
     * Den skiltes del av avdødes tilleggspensjon. Angis i prosent.
     */
    @GuiPrompt(prompt = "Den skiltes del av avdødes tilleggspensjon")
    protected int skiltesDelAvAdodesTP;

    /**
     * Bevarer ST brutto i tilfelle Sertillegg objektet avkortes bort.
     * Verdien er nødvendig dersom Tilleggspensjonen skal ytterligere avkorte ST i evt SAMBER.
     */
    protected int PREG_uavkortetSTBrutto;
    /**
     * Bevarer ST brutto per år i tilfelle Sertillegg objektet avkortes bort.
     * Verdien er nødvendig dersom Tilleggspensjonen skal ytterligere avkorte ST i evt SAMBER.
     */
    protected double PREG_uavkortetSTBruttoPerAr;

    /**
     * Andel av tilleggspensjon beregnet med restgrad uføre (UFG - YUG).
     */
    protected int PREG_tp_up;

    /**
     * Andel av tilleggspensjon beregnet med yrkesskadegrad.
     */
    protected int PREG_tp_yp;

    /**
     * Map av formler brukt i beregning av Tilleggspensjon.
     */
    private HashMap<String, Formel> formelMap;

    public Tilleggspensjon() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("TP");
        setFormelKode(new FormelKodeCti("TPx"));
        formelMap = new HashMap<>();
    }

    /**
     * Copy Constructor
     *
     * @param tilleggspensjon a <code>Tilleggspensjon</code> object
     */
    public Tilleggspensjon(Tilleggspensjon tilleggspensjon) {
        super(tilleggspensjon);

        if (tilleggspensjon.spt != null) {
            spt = new Sluttpoengtall(tilleggspensjon.spt);
        }
        if (tilleggspensjon.ypt != null) {
            ypt = new Sluttpoengtall(tilleggspensjon.ypt);
        }
        if (tilleggspensjon.opt != null) {
            opt = new Sluttpoengtall(tilleggspensjon.opt);
        }
        skiltesDelAvAdodesTP = tilleggspensjon.skiltesDelAvAdodesTP;

        formelMap = new HashMap<>( );
        if (tilleggspensjon.formelMap != null && !tilleggspensjon.formelMap.isEmpty()) {
            for (Map.Entry<String, Formel> pair : tilleggspensjon.formelMap.entrySet()) {
                formelMap.put( pair.getKey(), new Formel( pair.getValue() ));
            }
        }

        PREG_uavkortetSTBrutto = tilleggspensjon.PREG_uavkortetSTBrutto;
        PREG_uavkortetSTBruttoPerAr = tilleggspensjon.PREG_uavkortetSTBruttoPerAr;
    }

    public Tilleggspensjon(Sluttpoengtall spt, Sluttpoengtall ypt, Sluttpoengtall opt, int skiltesDelAvAdodesTP) {
        this();
        this.spt = spt;
        this.ypt = ypt;
        this.opt = opt;
        this.skiltesDelAvAdodesTP = skiltesDelAvAdodesTP;
        formelMap = new HashMap<>();
    }

    public Sluttpoengtall getOpt() {
        return opt;
    }

    public void setOpt(Sluttpoengtall opt) {
        this.opt = opt;
    }

    public Sluttpoengtall getSpt() {
        return spt;
    }

    public void setSpt(Sluttpoengtall spt) {
        this.spt = spt;
    }

    public Sluttpoengtall getYpt() {
        return ypt;
    }

    public void setYpt(Sluttpoengtall ypt) {
        this.ypt = ypt;
    }

    public int getSkiltesDelAvAdodesTP() {
        return skiltesDelAvAdodesTP;
    }

    public void setSkiltesDelAvAdodesTP(int skiltesDelAvAdodesTP) {
        this.skiltesDelAvAdodesTP = skiltesDelAvAdodesTP;
    }

    public int getPREG_uavkortetSTBrutto() {
        return PREG_uavkortetSTBrutto;
    }

    public void setPREG_uavkortetSTBrutto(int brutto) {
        PREG_uavkortetSTBrutto = brutto;
    }

    public double getPREG_uavkortetSTBruttoPerAr() {
        return PREG_uavkortetSTBruttoPerAr;
    }

    public void setPREG_uavkortetSTBruttoPerAr(double bruttoPerAr) {
        PREG_uavkortetSTBruttoPerAr = bruttoPerAr;
    }

    public int getPREG_tp_up() {
        return PREG_tp_up;
    }

    public void setPREG_tp_up(int PREG_tp_up) {
        this.PREG_tp_up = PREG_tp_up;
    }

    public int getPREG_tp_yp() {
        return PREG_tp_yp;
    }

    public void setPREG_tp_yp(int PREG_tp_yp) {
        this.PREG_tp_yp = PREG_tp_yp;
    }

    @Override
    public HashMap<String, Formel> getFormelMap() {
        return formelMap;
    }

    @Override
    public String getFormelPrefix() {
        return ytelsekomponentType.getKode();
    }
}


