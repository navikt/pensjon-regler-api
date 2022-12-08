package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.AvtalelandCti;

import java.io.Serializable;
import java.util.Date;

/**
 * Klassen beskriver et poengår opptjent i utlandet. Settes av saksbehandler.
 */
public class PoengarManuell implements Serializable {


    /**
     * Poengåret fra og med dato.
     */
    private Date fom;

    /**
     * Poengåret til og med dato.
     */
    private Date tom;

    /**
     * Angir om poengåret skal brukes i pro rata beregning.
     */
    private boolean ikkeProrata;

    /**
     * Angir om poengåret skal brukes i alternativ pro rata beregning.
     */
    private boolean ikkeAlternativProrata;

    /**
     * Avtaleland som poengår ble opptjent i.
     */
    private AvtalelandCti avtaleland;

}
