package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.Merknad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Sluttpoengtall
 */
public class Sluttpoengtall implements Serializable {

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

}
