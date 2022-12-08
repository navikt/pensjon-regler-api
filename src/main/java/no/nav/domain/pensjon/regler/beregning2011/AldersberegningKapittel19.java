package no.nav.domain.pensjon.regler.beregning2011;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ørnulf Moen, Decisive, Pensjonsprosjektet
 * @author Lars Hartvigsen (Decisive) - PK-12169 HL3 2015
 * @author Magnus Bakken (Accenture), PK-20716
 */

public class AldersberegningKapittel19 extends Beregning2011 {


    private Basispensjon restpensjon;
    private Basispensjon basispensjon;

    /**
     * Basispensjon regnet uten gjenlevenderettighet.
     */
    private Basispensjon basispensjonUtenGJR;

    /**
     * Restpensjon regnet uten gjenlevenderettighet.
     */
    private Basispensjon restpensjonUtenGJR;

    private double forholdstall;
    private List<FtDtArsak> ftBenyttetArsakListe;

}
