package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.RegelendringTypeCti;

import java.io.Serializable;
import java.util.Date;

public class Regelendring implements Serializable, Comparable<Regelendring> {

    private static final long serialVersionUID = -4695527013120848530L;

    /**
     * Datoen en regel- eller satsendring har virkningsdato.
     */
    private Date endringsdato;

    /**
     * Tekst som beskriver typen endring, ref. kodeverk.
     */
    private RegelendringTypeCti endringstype;

    /**
     * Default constructor.
     */
    public Regelendring() {
        super();
    }

    /**
     * Copy-constructor
     * 
     * @param regelendring
     */
    public Regelendring(Regelendring regelendring) {
        super();
        if (regelendring.endringsdato != null) {
            endringsdato = (Date) regelendring.endringsdato.clone();
        }
        if (regelendring.getEndringstype() != null) {
            endringstype = new RegelendringTypeCti(regelendring.endringstype);
        }
    }

    /**
     * @param endringsdato
     * @param endringstype
     */
    public Regelendring(Date endringsdato, RegelendringTypeCti endringstype) {
        super();
        this.endringsdato = endringsdato;
        this.endringstype = endringstype;
    }

    public Date getEndringsdato() {
        return endringsdato;
    }

    public void setEndringsdato(Date endringsdato) {
        this.endringsdato = endringsdato;
    }

    public RegelendringTypeCti getEndringstype() {
        return endringstype;
    }

    public void setEndringstype(RegelendringTypeCti endringstype) {
        this.endringstype = endringstype;
    }

    @Override
    public int compareTo(Regelendring regelendring) {
        //Sorterer primært på dato
        if (regelendring != null && regelendring.getEndringsdato() != null && getEndringsdato() != null) {
            int dateCompare = getEndringsdato().compareTo(regelendring.getEndringsdato());
            if (dateCompare != 0) {
                return dateCompare;
            }
        }
        //Sorterer sekundært alfabetisk på regelendringstype
        if (regelendring != null && regelendring.getEndringstype() != null && regelendring.getEndringstype().getKode() != null && getEndringstype() != null
            && getEndringstype().getKode() != null) {
            return getEndringstype().getKode().compareTo(regelendring.getEndringstype().getKode());
        }
        //Nullpointer på dato eller regelendringtype, eller helt like endringer.
        else {
            return 0;
        }
    }
}
