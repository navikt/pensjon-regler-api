package no.nav.pensjon.regler.domain.beregning;

import no.nav.pensjon.regler.domain.Merknad;
import no.nav.pensjon.regler.domain.util.ToStringUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Sluttpoengtall
 */
public class Sluttpoengtall implements Serializable {

    private static final long serialVersionUID = -9023910983413352095L;

    /**
     * sluttpoengtallet
     */
    private double pt;

    /**
     * Obsolete:
     */
    private double pt_eos;
    private double pt_a10;

    /**
     * poengtillegg - brukes før 01.04.1984. Legges til poengtallet
     */
    private double poengTillegg;

    /**
     * Liste av merknader.
     */
    private List<Merknad> merknadListe;

    /**
     * Beregnet gjennomsnittlig SPT*UFG for en som går fra UP over til AP og har
     * EØS-fordeler i UP.
     */
    private double fpp_grad_eos;

    /**
     * Poengrekken som ligger til grunn for sluttpoengtallet.
     */
    private Poengrekke poengrekke;

    /**
     * Copy Constructor
     * 
     * @param sluttpoengtall a <code>Sluttpoengtall</code> object
     */
    public Sluttpoengtall(Sluttpoengtall sluttpoengtall) {
        pt = sluttpoengtall.pt;
        poengTillegg = sluttpoengtall.poengTillegg;
        merknadListe = new ArrayList<Merknad>();
        if (sluttpoengtall.merknadListe != null) {
            for (Merknad merknad : sluttpoengtall.merknadListe) {
                merknadListe.add(new Merknad(merknad));
            }
        }
        fpp_grad_eos = sluttpoengtall.fpp_grad_eos;
        if (sluttpoengtall.poengrekke != null) {
            poengrekke = new Poengrekke(sluttpoengtall.poengrekke);
        }
    }

    public Sluttpoengtall(double pt, double poengTillegg, double pt_eos, double pt_a10, double fpp_grad_eos, Poengrekke poengrekke) {
        super();
        this.pt = pt;
        this.poengTillegg = poengTillegg;
        this.fpp_grad_eos = fpp_grad_eos;
        this.poengrekke = poengrekke;
    }

    public Sluttpoengtall() {
        merknadListe = new ArrayList<Merknad>();
    }

    /**
     * @return Returns the merknad.
     */
    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    /**
     * @param merknad
     *            The merknad to set.
     */
    public void setMerknadListe(List<Merknad> merknad) {
        merknadListe = merknad;
    }

    public double getFpp_grad_eos() {
        return fpp_grad_eos;
    }

    public void setFpp_grad_eos(double fpp_grad_eos) {
        this.fpp_grad_eos = fpp_grad_eos;
    }

    public Poengrekke getPoengrekke() {
        return poengrekke;
    }

    public void setPoengrekke(Poengrekke poengrekke) {
        this.poengrekke = poengrekke;
    }

    /*
     * Generic version. Uses reflection to print field names and values.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }

    public double getPt() {
        return pt;
    }

    public void setPt(double pt) {
        this.pt = pt;
    }

    public double getPoengTillegg() {
        return poengTillegg;
    }

    public void setPoengTillegg(double poengTillegg) {
        this.poengTillegg = poengTillegg;
    }

}
