package no.nav.domain.pensjon.regler.krav;

import no.nav.domain.pensjon.regler.PenPerson;
import no.nav.domain.pensjon.regler.kode.KravlinjeTypeCti;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * En Kravlinje er en del av et KravHode. Eksempler på Kravlinje er GP, ET, UP
 * osv.
 */
public class Kravlinje implements Serializable {
    

    /**
     * Hvilken type kravlinjen gjelder, spesifisert som VilkarsvedtakType.
     */
    private KravlinjeTypeCti kravlinjeType;

    /**
     * Personen kravet relaterer seg til.
     */
    PenPerson relatertPerson;

}
