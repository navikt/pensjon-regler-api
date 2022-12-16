package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.LandCti;

import java.io.Serializable;
import java.util.Date;

public class Utenlandsopphold implements Serializable {

    /**
     * Fra og med dato
     */
    private Date fom;
    /**
     * Til og med dato
     */
    private Date tom;
    /**
     * Landet hvor oppholdet har funnet sted
     */
    private LandCti land;
    /**
     * Hvilken pensjonsordning som skal brukes
     */
    private String pensjonsordning;
    /**
     * Har personen bodd i utlandet
     */
    private boolean bodd;
    /**
     * Har personen arbeidet i utlandet
     */
    private boolean arbeidet;

}
