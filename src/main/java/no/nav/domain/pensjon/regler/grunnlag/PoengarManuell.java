package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.AvtalelandCti;

import java.io.Serializable;
import java.util.Date;

/**
 * Klassen beskriver et poeng�r opptjent i utlandet. Settes av saksbehandler.
 */
public class PoengarManuell implements Serializable {


    /**
     * Poeng�ret fra og med dato.
     */
    private Date fom;

    /**
     * Poeng�ret til og med dato.
     */
    private Date tom;

    /**
     * Angir om poeng�ret skal brukes i pro rata beregning.
     */
    private boolean ikkeProrata;

    /**
     * Angir om poeng�ret skal brukes i alternativ pro rata beregning.
     */
    private boolean ikkeAlternativProrata;

    /**
     * Avtaleland som poeng�r ble opptjent i.
     */
    private AvtalelandCti avtaleland;

}
