package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.RegelendringTypeCti;

import java.io.Serializable;
import java.util.Date;

public class Regelendring implements Serializable {



    /**
     * Datoen en regel- eller satsendring har virkningsdato.
     */
    private Date endringsdato;

    /**
     * Tekst som beskriver typen endring, ref. kodeverk.
     */
    private RegelendringTypeCti endringstype;


}
