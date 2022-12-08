package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.grunnlag.Beholdninger;
import no.nav.domain.pensjon.regler.trygdetid.Brok;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ørnulf Moen (Decisive), Pensjonsprosjektet
 * @author Lars Hartvigsen (Decisive), PK-9169
 * @author Tatyana Lochehina PK-9502
 */
public class AldersberegningKapittel20 extends Beregning2011 {
    private double delingstall;
    private Beholdninger beholdninger;
    private PensjonUnderUtbetaling pensjonUnderUtbetaling;
    private List<FtDtArsak> dtBenyttetArsakListe;

    /**
     * De faktiske beholdningene som ble brukt i beregningen ved førstegangsuttaket
     */
    private Beholdninger beholdningerForForsteuttak;

    /**
     * Anvendt proratabrøk i trygdeavtaleberegninger.
     */
    private Brok prorataBrok;


}
