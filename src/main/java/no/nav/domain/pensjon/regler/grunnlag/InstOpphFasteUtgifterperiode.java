package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;
import java.util.Date;

/**
 * Objektet inneholder informasjon om den m�nedlige faste utgiften en bruker har hatt i forbindelse med
 * opphold p� en institusjon. Det inneholder ogs� tidsrommet brukeren var innlagt.
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
     * M�nedlig fast utgift bruker hadde p� institusjonen
     */
    private int fasteUtgifter;
}
