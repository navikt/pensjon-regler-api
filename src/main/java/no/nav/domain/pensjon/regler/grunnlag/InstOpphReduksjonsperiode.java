package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.JustertPeriodeCti;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Nabil Safadi (Decisive) - PK-8518
 * @author Øyvind Skytøen (Accenture) - PK-8518
 */

/**
 * Objektet inneholder informasjon om perioder der person har institusjonsopphold som kan medføre reduksjon av pensjon.
 */
public class InstOpphReduksjonsperiode implements Serializable {

    /**
     * Unik identifikasjon av objektet.
     */
    private long instOpphReduksjonsperiodeId;
    /**
     * Fra og med dato
     */
    private Date fom;
    /**
     * Til og med dato
     */
    private Date tom;
    /**
     * Angir om reduksjon er grunnet varighet.
     */
    private boolean reduksjonGrunnetVarighet;
    /**
     * Angir om institusjonsoppholdsperioden medfører en økning eller reduksjon av pensjonsytelsen.
     */
    private JustertPeriodeCti justertPeriodeType;

    /**
     * Angir om bruker har forsørgeransvar ved institusjonsopphold
     */
    private boolean forsorgeransvar;

}
