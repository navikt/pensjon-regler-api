package no.nav.pensjon.regler.domain.beregning;

import no.nav.pensjon.regler.domain.IBeregning;
import no.nav.pensjon.regler.domain.beregning2011.Beregning2011;
import no.nav.pensjon.regler.domain.beregning2011.Uforetrygdberegning;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Aasmund Nordstoga (Acenture) - PKFEIL-2605
 */
public class BeregningRelasjon implements Serializable {

    private static final long serialVersionUID = 8527683471189333507L;

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

    /**
     * Referanse tilbake til beregning hvor beregningsrelasjon inngår i delberegningslisten.
     */
    private Beregning PREG_parentBeregning;

    /**
     * Referanse tilbake til beregning2011 hvor beregningsrelasjon inngår i delberegningslisten.
     */
    private Beregning2011 PREG_parentBeregning2011;

    /**
     * Copy Constructor
     * 
     * @param beregningRelasjon a <code>BeregningRelasjon</code> object
     */
    public BeregningRelasjon(BeregningRelasjon beregningRelasjon) {
        if (beregningRelasjon.beregning != null) {
            beregning = new Beregning(beregningRelasjon.beregning);
            beregning.setPREG_beregningsrelasjon(this);
        }
        beregning2011 = createBeregning2011UsingCopyConstructor(beregningRelasjon.beregning2011);
        if (beregning2011 != null) {
            beregning2011.setPREG_beregningsrelasjon(this);
        }
        bruk = beregningRelasjon.bruk;
    }

    public BeregningRelasjon() {
        super();
    }

    public BeregningRelasjon(Beregning beregning, boolean bruk) {
        super();
        this.beregning = beregning;
        if (this.beregning != null) {
            this.beregning.setPREG_beregningsrelasjon(this);
        }
        this.bruk = bruk;
    }

    public BeregningRelasjon(Beregning2011 beregning2011, boolean bruk) {
        super();
        this.beregning2011 = beregning2011;
        if (this.beregning2011 != null) {
            this.beregning2011.setPREG_beregningsrelasjon(this);
        }
        this.bruk = bruk;
    }

    public IBeregning getIBeregning() {
        if (beregning != null) {
            return beregning;
        } else {
            return beregning2011;
        }
    }

    public Beregning getBeregning() {
        return beregning;
    }

    public void setBeregning(Beregning beregning) {
        if (beregning != null) {
            if (beregning2011 != null) {
                throw new RuntimeException("Kan ikke sette beregning på BeregningRelasjon dersom beregning2011 er satt");
            } else {
                this.beregning = beregning;
                this.beregning.setPREG_beregningsrelasjon(this);
            }
        } else {
            throw new RuntimeException("Beregning på BeregningRelasjon kan ikke settes til null");
        }
    }

    public Beregning2011 getBeregning2011() {
        return beregning2011;
    }

    public void setBeregning2011(Beregning2011 beregning2011) {
        if (beregning2011 != null) {
            if (beregning != null) {
                throw new RuntimeException("Kan ikke sette beregning2011 på BeregningRelasjon dersom beregning er satt");
            } else {
                this.beregning2011 = beregning2011;
                this.beregning2011.setPREG_beregningsrelasjon(this);
            }
        } else {
            throw new RuntimeException("Beregning2011 på BeregningRelasjon kan ikke settes til null");
        }
    }

    public boolean isBruk() {
        return bruk;
    }

    public void setBruk(boolean bruk) {
        this.bruk = bruk;
    }

    /**
     * Oppretter ny beregning2011, ved å benytte riktig copyconstructor for den underliggende subklassen.
     * Reflection benyttes for å avgjøre hvilken constructor som skal benyttes.
     * 
     * @param beregning2011
     * @return beregning2011
     */
    private Beregning2011 createBeregning2011UsingCopyConstructor(Beregning2011 beregning2011) {
        if (beregning2011 != null) {
            Class<? extends Beregning2011> clazz = beregning2011.getClass();
            try {
                if(beregning2011 instanceof Uforetrygdberegning){
                    Constructor<? extends Beregning2011> constructor = clazz.getConstructor(new Class[] {clazz, boolean.class});
                    return constructor.newInstance(beregning2011,true);
                }
                else{
                    Constructor<? extends Beregning2011> constructor = clazz.getConstructor(new Class[] {clazz});
                    return constructor.newInstance(beregning2011);
                }
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException |
                     InstantiationException | IllegalArgumentException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public Beregning getPREG_parentBeregning() {
        return PREG_parentBeregning;
    }

    public void setPREG_parentBeregning(Beregning beregning) {
        PREG_parentBeregning = beregning;
    }

    public Beregning2011 getPREG_parentBeregning2011() {
        return PREG_parentBeregning2011;
    }

    public void setPREG_parentBeregning2011(Beregning2011 beregning2011) {
        PREG_parentBeregning2011 = beregning2011;
    }

}
