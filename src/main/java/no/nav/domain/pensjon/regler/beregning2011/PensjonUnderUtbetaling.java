package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.*;
import no.nav.domain.pensjon.regler.beregning.penobjekter.*;
import no.nav.domain.pensjon.regler.kode.FormelKodeCti;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Objektet inneholder den faktiske pensjonen under utbetaling, samt en liste
 * over delytelsene som denne består av.
 * 
 * @author Ørnulf Moen
 */
public class PensjonUnderUtbetaling implements Serializable {
    /**
     * Månedsbeløp netto, summen av alle delytelsene i ytelseskomponenter. Disse er
     * avrundet hver for seg til nærmeste krone. Dette medfører at
     * avrund(totalbelopNettoAr/12) vil kunne være forskjellig fra totalbelopNetto.
     */
    private int totalbelopNetto;

    /**
     * Årlig netto beløp under utbetaling
     */
    private double totalbelopNettoAr;

    /**
     * Angir sum brutto per måned.
     */
    private int totalbelopBrutto;

    /**
     * Angir sum brutto per år.
     */
    private double totalbelopBruttoAr;

    /**
     * Indikerer hvilken beregningsformel som ble brukt.
     */
    private FormelKodeCti formelKode = new FormelKodeCti("BPUx");

    private double pubReguleringFratrekk;

    private List<Ytelseskomponent> ytelseskomponenter = new ArrayList<Ytelseskomponent>();

    /**
     * Metode som benyttes av XStream og Java-serialisering for å
     * initialisere felt vi hopper over p.g.a sykliske avhengigheter.
     */
    private Object readResolve() throws ObjectStreamException {
        return this;
    }

    public PensjonUnderUtbetaling() {
        super();
    }
}
