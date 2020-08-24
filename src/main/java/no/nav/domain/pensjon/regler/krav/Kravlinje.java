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
    private static final long serialVersionUID = -4157386793912444992L;

    /**
     * Hvilken type kravlinjen gjelder, spesifisert som VilkarsvedtakType.
     */
    private KravlinjeTypeCti kravlinjeType;

    /**
     * Personen kravet relaterer seg til.
     */
    PenPerson relatertPerson;

    /**
     * Copy Constructor
     * 
     * @param kravlinje a <code>Kravlinje</code> object
     */
    public Kravlinje(Kravlinje kravlinje) {
        if (kravlinje.kravlinjeType != null) {
            kravlinjeType = new KravlinjeTypeCti(kravlinje.kravlinjeType);
        }
        if (kravlinje.relatertPerson != null) {
            relatertPerson = new PenPerson(kravlinje.relatertPerson);
        }
    }

    public Kravlinje(KravlinjeTypeCti kravlinjeType, PenPerson relatertPerson) {
        super();
        if (kravlinjeType != null) {
            this.kravlinjeType = new KravlinjeTypeCti(kravlinjeType);
        }
        this.relatertPerson = relatertPerson;
    }

    public Kravlinje() {
        super();
    }

    /*
     * Generic version. Uses reflection to print field names and values.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append(this.getClass().getName());
        result.append(" Object {");
        result.append(newLine);

        // determine fields declared in this class only (no fields of
        // superclass)
        Field[] fields = this.getClass().getDeclaredFields();

        // print field names paired with their values
        for (Field field : fields) {
            String fieldName = field.getName();
            if (fieldName.compareTo("serialVersionUID") != 0) {
                result.append("  ");
                result.append(fieldName);
                result.append(": ");
                try {
                    result.append(field.get(this));
                } catch (IllegalAccessException ex) {
                    System.out.println(ex);
                }
                result.append(newLine);
            }
        }
        result.append("}");

        return result.toString();
    }

    public KravlinjeTypeCti getKravlinjeType() {
        return kravlinjeType;
    }

    public void setKravlinjeType(KravlinjeTypeCti kravlinjeType) {
        this.kravlinjeType = kravlinjeType;
    }

    public PenPerson getRelatertPerson() {
        return relatertPerson;
    }

    public void setRelatertPerson(PenPerson relatertPerson) {
        this.relatertPerson = relatertPerson;
    }

}
