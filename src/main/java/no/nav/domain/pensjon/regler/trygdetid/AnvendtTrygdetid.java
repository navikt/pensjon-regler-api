package no.nav.domain.pensjon.regler.trygdetid;

import java.io.Serializable;

/**
 * Anvendt trygdetid i beregning av grunnpensjon med mer.
 */
public class AnvendtTrygdetid implements Serializable {

    

    /**
     * Anvendt trygdetid i antall �r.
     */
    private int tt_anv;

    /**
     * Anvendt pro rata br�k hvis grunnpensjon er pro rata beregnet.
     * Teller er lik antall m�neder faktisk trygdetid i Norge.
     * Nevner er lik antall m�neder faktisk trygdetid i Norge og i avtaleland.
     */
    private Brok pro_rata;


}
