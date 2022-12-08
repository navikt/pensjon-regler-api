package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class BeregnetUtbetalingsperiode implements Serializable {
    /**
     * Periodens startdato.
     */
    private Date fomDato;

    /**
     * Periodens sluttdato.
     */
    private Date tomDato;

    /**
     * Uf�regrad for perioden
     */
    private int uforegrad;

    /**
     * Yrkesskadegrad for perioden
     */
    private int yrkesskadegrad;

    /**
     * Antall fellesbarn det er innvilget barnetillegg for i perioden.
     * Vil kun v�re angitt for fremtidige perioder i kontekst av etteroppgj�r
     */
    private int antallFellesbarn;

    /**
     * Antall s�rkullsbarn det er innvilget barnetillegg for i perioden.
     * Vil kun v�re angitt for fremtidige perioder i kontekst av etteroppgj�r
     */
    private int antallSerkullsbarn;

    private Map<String, Ytelseskomponent> ytelseskomponenter = new HashMap<String, Ytelseskomponent>();

}
