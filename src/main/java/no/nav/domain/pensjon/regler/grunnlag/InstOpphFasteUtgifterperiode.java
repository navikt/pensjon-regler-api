package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;
import java.util.Date;

/**
 * Objektet inneholder informasjon om den månedlige faste utgiften en bruker har hatt i forbindelse med
 * opphold på en institusjon. Det inneholder også tidsrommet brukeren var innlagt.
 */
public class InstOpphFasteUtgifterperiode implements Serializable {



    /**
     * Unik identifikasjon av objektet
     */
    private long instOpphFasteUtgifterperiodeId;
    /**
     * Dato bruker ble innlagt
     */
    private Date fom;
    /**
     * Dato bruker ble skrevet ut
     */
    private Date tom;
    /**
     * Månedlig fast utgift bruker hadde på institusjonen
     */
    private int fasteUtgifter;
}
