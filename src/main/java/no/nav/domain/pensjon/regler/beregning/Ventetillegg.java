package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

/**
 * Ventetillegg. netto=brutto=venteTillegg_GP+venteTillegg_TP
 */
public class Ventetillegg extends Ytelseskomponent {

    

    /**
     * Ventetillegget for GP
     */
    private int venteTillegg_GP;

    /**
     * Ventetillegget for tillegspensjon
     */
    private int venteTillegg_TP;

    /**
     * Prosenten
     */
    private double venteTilleggProsent;

    /**
     * Copy Constructor
     * 
     * @param ventetillegg a <code>Ventetillegg</code> object
     */
    public Ventetillegg(Ventetillegg ventetillegg) {
        super(ventetillegg);
        venteTillegg_GP = ventetillegg.venteTillegg_GP;
        venteTillegg_TP = ventetillegg.venteTillegg_TP;
        venteTilleggProsent = ventetillegg.venteTilleggProsent;
    }

    public Ventetillegg(int venteTillegg_GP, int venteTillegg_TP, double venteTilleggProsent) {
        this();
        this.venteTillegg_GP = venteTillegg_GP;
        this.venteTillegg_TP = venteTillegg_TP;
        this.venteTilleggProsent = venteTilleggProsent;
    }

    public Ventetillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("VT");
    }

    public int getVenteTillegg_GP() {
        return venteTillegg_GP;
    }

    public void setVenteTillegg_GP(int venteTillegg_GP) {
        this.venteTillegg_GP = venteTillegg_GP;
    }

    public int getVenteTillegg_TP() {
        return venteTillegg_TP;
    }

    public void setVenteTillegg_TP(int venteTillegg_TP) {
        this.venteTillegg_TP = venteTillegg_TP;
    }

    public double getVenteTilleggProsent() {
        return venteTilleggProsent;
    }

    public void setVenteTilleggProsent(double venteTilleggProsent) {
        this.venteTilleggProsent = venteTilleggProsent;
    }

}
