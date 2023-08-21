package no.nav.pensjon.regler.domain.beregning.penobjekter;

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

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
