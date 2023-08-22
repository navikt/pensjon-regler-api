package no.nav.pensjon.regler.domain.beregning2011;


import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent;
import no.nav.pensjon.regler.domain.util.Copyable;
import no.nav.pensjon.regler.domain.util.DateCompareUtil;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class BeregnetUtbetalingsperiode implements Serializable, Comparable<BeregnetUtbetalingsperiode>, Copyable<BeregnetUtbetalingsperiode> {
    private static final long serialVersionUID = 1816382377190210574L;
    /**
     * Periodens startdato.
     */

    private Date fomDato;

    /**
     * Periodens sluttdato.
     */

    private Date tomDato;

    /**
     * Uføregrad for perioden
     */

    private int uforegrad;

    /**
     * Yrkesskadegrad for perioden
     */

    private int yrkesskadegrad;

    /**
     * Antall fellesbarn det er innvilget barnetillegg for i perioden.
     * Vil kun være angitt for fremtidige perioder i kontekst av etteroppgjør
     */

    private int antallFellesbarn;

    /**
     * Antall særkullsbarn det er innvilget barnetillegg for i perioden.
     * Vil kun være angitt for fremtidige perioder i kontekst av etteroppgjør
     */

    private int antallSerkullsbarn;

    private Map<String, Ytelseskomponent> ytelseskomponenter = new HashMap<String, Ytelseskomponent>();

    public BeregnetUtbetalingsperiode() {
    }

    public BeregnetUtbetalingsperiode(BeregnetUtbetalingsperiode bup) {
        super();
        fomDato = bup.fomDato;
        tomDato = bup.tomDato;
        uforegrad = bup.uforegrad;
        yrkesskadegrad = bup.yrkesskadegrad;
        antallFellesbarn = bup.antallFellesbarn;
        antallSerkullsbarn = bup.antallSerkullsbarn;

        if (!bup.ytelseskomponenter.isEmpty()) {
            ytelseskomponenter = new HashMap<>();
            for (Ytelseskomponent yk : bup.ytelseskomponenter.values()) {
                Ytelseskomponent ykcopy;
                try {
                    ykcopy = (Ytelseskomponent) Class.forName(yk.getClass().getName()).getConstructor(yk.getClass()).newInstance(yk);
                    ytelseskomponenter.put(ykcopy.getYtelsekomponentType().getKode(), ykcopy);
                } catch (IllegalArgumentException | ClassNotFoundException | NoSuchMethodException |
                         InvocationTargetException | IllegalAccessException | InstantiationException |
                         SecurityException ignored) {
                }
            }
        }
    }

    public void addYtelseskomponent(Ytelseskomponent yk) {
        ytelseskomponenter.put(yk.getYtelsekomponentType().getKode(), yk);
    }

    @Override
    public int compareTo(BeregnetUtbetalingsperiode periode) {
        return DateCompareUtil.compareTo(getFomDato(), periode.getFomDato());
    }

    public Date getFomDato() {
        return fomDato;
    }

    public Date getTomDato() {
        return tomDato;
    }

    public int getUforegrad() {
        return uforegrad;
    }

    public int getYrkesskadegrad() {
        return yrkesskadegrad;
    }

    @SuppressWarnings("unchecked")
    public <E extends Ytelseskomponent> E getYtelseskomponent(String kode) {
        return (E) ytelseskomponenter.get(kode);
    }

    public Map<String, Ytelseskomponent> getYtelseskomponenter() {
        return ytelseskomponenter;
    }

    public List<Ytelseskomponent> getYtelseskomponentListe() {
        return new ArrayList<Ytelseskomponent>(ytelseskomponenter.values());
    }

    public void setFomDato(Date fomDato) {
        this.fomDato = fomDato;
    }

    public void setTomDato(Date tomDato) {
        this.tomDato = tomDato;
    }

    public void setUforegrad(int uforegrad) {
        this.uforegrad = uforegrad;
    }

    public void setYrkesskadegrad(int yrkesskadegrad) {
        this.yrkesskadegrad = yrkesskadegrad;
    }

    public int getAntallFellesbarn() {
        return antallFellesbarn;
    }

    public void setAntallFellesbarn(int antallFellesbarn) {
        this.antallFellesbarn = antallFellesbarn;
    }

    public int getAntallSerkullsbarn() {
        return antallSerkullsbarn;
    }

    public void setAntallSerkullsbarn(int antallSerkullsbarn) {
        this.antallSerkullsbarn = antallSerkullsbarn;
    }

    public void setYtelseskomponenter(Map<String, Ytelseskomponent> ytelseskomponenter) {
        this.ytelseskomponenter = ytelseskomponenter;
    }

    @Override
    public BeregnetUtbetalingsperiode deepCopy() {
        return new BeregnetUtbetalingsperiode(this);
    }
}
