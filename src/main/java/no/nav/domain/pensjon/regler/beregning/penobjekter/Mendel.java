package no.nav.domain.pensjon.regler.beregning.penobjekter;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

import java.io.Serializable;

/**
 * Brukes kun til G-omregning i BEF270.
 * 
 * @author Andreas Nilsen
 */
public class Mendel extends Ytelseskomponent implements Serializable {

    private static final long serialVersionUID = -6043801067268076589L;

    public Mendel(Mendel mendel) {
        super(mendel);
    }

    public Mendel() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("MENDEL");
    }

}
