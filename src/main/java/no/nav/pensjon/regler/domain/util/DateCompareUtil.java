package no.nav.pensjon.regler.domain.util;

import java.util.Date;

/**
 * Brukes for datosorteringer i alle periode og historikk-klasser
 * 
 * @author Christian Arnesen
 */
public class DateCompareUtil {
    public static final int BEFORE = -1;
    public static final int EQUAL = 0;
    public static final int AFTER = 1;

    /**
     * Returnerer resultat i forhold til compareTo standard
     * 
     * @param first - dato fra kallende klasse
     * @param second - dato fra argument til compareTo
     * @return
     */
    public static int compareTo(Date first, Date second) {
        // null sorteres foran
        if (first == null) {
            if (second == null) {
                return EQUAL;
            } else {
                return BEFORE;
            }
        } else if (second == null) {
            return AFTER;
        }
        return first.compareTo(second);
    }

}
