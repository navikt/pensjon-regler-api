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
 * over delytelsene som denne best�r av.
 * 
 * @author �rnulf Moen
 */
public class PensjonUnderUtbetaling implements Serializable {
    /**
     * M�nedsbel�p netto, summen av alle delytelsene i ytelseskomponenter. Disse er
     * avrundet hver for seg til n�rmeste krone. Dette medf�rer at
     * avrund(totalbelopNettoAr/12) vil kunne v�re forskjellig fra totalbelopNetto.
     */
    private int totalbelopNetto;

    /**
     * �rlig netto bel�p under utbetaling
     */
    private double totalbelopNettoAr;

    /**
     * Angir sum brutto per m�ned.
     */
    private int totalbelopBrutto;

    /**
     * Angir sum brutto per �r.
     */
    private double totalbelopBruttoAr;

    /**
     * Indikerer hvilken beregningsformel som ble brukt.
     */
    private FormelKodeCti formelKode = new FormelKodeCti("BPUx");

    private double pubReguleringFratrekk;

    private List<Ytelseskomponent> ytelseskomponenter = new ArrayList<Ytelseskomponent>();

    /**
     * Metode som benyttes av XStream og Java-serialisering for �
     * initialisere felt vi hopper over p.g.a sykliske avhengigheter.
     */
    private Object readResolve() throws ObjectStreamException {
        return this;
    }

    public PensjonUnderUtbetaling() {
        super();
    }
}
