package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.OppholdTypeCti;
import no.nav.domain.pensjon.regler.kode.VarighetTypeCti;

import java.io.Serializable;
import java.util.Date;

/**
 * En periode for et opphold på institusjon
 */
public class InstOpphPeriodegrunnlag implements Serializable {
    /**
     * Kun brukt i PEN
     */
    private long instOppholdId;

    /**
     * Kode som angir type opphold.
     */
    private OppholdTypeCti oppholdType;

    /**
     * Varighetstypen på institusjonsoppholdet.
     */
    private VarighetTypeCti varighetType;
    /**
     * Fradato for oppholdet
     */
    private Date fom;
    /**
     * Tildato for oppholdet
     */
    private Date tom;
    /**
     * Forventet tildato for oppholdet - oppholdet pågår.
     */
    private Date forventetTom;
    /**
     * Kun brukt i PEN
     */
    private String registerOpprettetAv;
    /**
     * Kun brukt i PEN
     */
    private String registerEndretAv;
    /**
     * Kun brukt i PEN
     */
    private Date registerOpprettetDato;
    /**
     * Kun brukt i PEN
     */
    private Date registerEndretDato;
    /**
     * Kun brukt i PEN
     */
    private String registerKilde;
    /**
     * Angir om institusjonsoppholdet er overført til en annen institusjon.
     */
    private boolean overfort;
    /**
     * Kun brukt i PEN
     */
    private boolean bruk;
}
