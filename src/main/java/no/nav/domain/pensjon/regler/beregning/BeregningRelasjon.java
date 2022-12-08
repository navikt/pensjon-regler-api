package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.beregning2011.Beregning2011;
import no.nav.domain.pensjon.regler.beregning2011.Uforetrygdberegning;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Aasmund Nordstoga (Acenture) - PKFEIL-2605
 */
public class BeregningRelasjon implements Serializable {

    /**
     * 1967 beregningen som det relateres til
     */
    private Beregning beregning;

    /**
     * Beregning 2011 som det relateres til
     */
    private Beregning2011 beregning2011;

    /**
     * Angir om beregningen er brukt (helt eller delvis) i beregningen den tilhører.
     */
    private boolean bruk;

}
