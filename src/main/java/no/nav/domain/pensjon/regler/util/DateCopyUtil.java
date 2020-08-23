package no.nav.domain.pensjon.regler.util;

import java.util.Date;

public class DateCopyUtil {
    public static Date copyDate(Date date) {
        if (date != null) {
            return new Date(date.getTime());
        }
        return null;
    }
}
