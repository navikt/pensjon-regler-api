package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.Merknad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Framtidig pensjonspoengtall.
 * Brukes ved beregning av uførepensjon,gjenlevendepensjon og AFP.
 */
public class FramtidigPensjonspoengtall implements Serializable {
    /**
     * Poengtallet
     */
    private double pt;
    /**
     * Poengtallene som ligger til grunn for poengtallet.
     */
    private List<Poengtall> poengtallListe;
    /**
     * Liste av merknader.
     */
    private List<Merknad> merknadListe;


}
