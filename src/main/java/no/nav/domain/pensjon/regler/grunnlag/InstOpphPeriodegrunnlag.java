package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.OppholdTypeCti;
import no.nav.domain.pensjon.regler.kode.VarighetTypeCti;
import no.nav.domain.pensjon.regler.util.DateCompareUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * En periode for et opphold på institusjon
 */
public class InstOpphPeriodegrunnlag implements Comparable<InstOpphPeriodegrunnlag>, Serializable {

    private static final long serialVersionUID = 1316439454051447836L;
    /**
     * Kun brukt i PEN
     */
    private long instOppholdId;

    /**
     * Kode som angir type opphold.
     */
    private OppholdTypeCti oppholdType;

    /**
     * Kun brukt i PEN
     */
    private String tssEksternId;

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

    /**
     * Copy Constructor
     * 
     * @param instOpphPeriodegrunnlag a <code>InstOpphPeriodegrunnlag</code> object
     */
    public InstOpphPeriodegrunnlag(InstOpphPeriodegrunnlag instOpphPeriodegrunnlag) {
        instOppholdId = instOpphPeriodegrunnlag.instOppholdId;
        if (instOpphPeriodegrunnlag.oppholdType != null) {
            oppholdType = new OppholdTypeCti(instOpphPeriodegrunnlag.oppholdType);
        }
        tssEksternId = instOpphPeriodegrunnlag.tssEksternId;
        if (instOpphPeriodegrunnlag.varighetType != null) {
            varighetType = new VarighetTypeCti(instOpphPeriodegrunnlag.varighetType);
        }
        if (instOpphPeriodegrunnlag.fom != null) {
            fom = (Date) instOpphPeriodegrunnlag.fom.clone();
        }
        if (instOpphPeriodegrunnlag.tom != null) {
            tom = (Date) instOpphPeriodegrunnlag.tom.clone();
        }
        if (instOpphPeriodegrunnlag.forventetTom != null) {
            forventetTom = (Date) instOpphPeriodegrunnlag.forventetTom.clone();
        }
        registerOpprettetAv = instOpphPeriodegrunnlag.registerOpprettetAv;
        registerEndretAv = instOpphPeriodegrunnlag.registerEndretAv;
        if (instOpphPeriodegrunnlag.registerOpprettetDato != null) {
            registerOpprettetDato = (Date) instOpphPeriodegrunnlag.registerOpprettetDato.clone();
        }
        if (instOpphPeriodegrunnlag.registerEndretDato != null) {
            registerEndretDato = (Date) instOpphPeriodegrunnlag.registerEndretDato.clone();
        }
        registerKilde = instOpphPeriodegrunnlag.registerKilde;
        overfort = instOpphPeriodegrunnlag.overfort;
        bruk = instOpphPeriodegrunnlag.bruk;
    }

    public InstOpphPeriodegrunnlag(long instOppholdId, OppholdTypeCti oppholdType, String tssEksternId, VarighetTypeCti varighetType, Date fom, Date tom, Date forventetTom,
                                   String registerOpprettetAv, String registerEndretAv, Date registerOpprettetDato, Date registerEndretDato, String registerKilde,
                                   boolean overfort, boolean bruk) {
        super();
        this.instOppholdId = instOppholdId;
        this.oppholdType = oppholdType;
        this.tssEksternId = tssEksternId;
        this.varighetType = varighetType;
        this.fom = fom;
        this.tom = tom;
        this.forventetTom = forventetTom;
        this.registerOpprettetAv = registerOpprettetAv;
        this.registerEndretAv = registerEndretAv;
        this.registerOpprettetDato = registerOpprettetDato;
        this.registerEndretDato = registerEndretDato;
        this.registerKilde = registerKilde;
        this.overfort = overfort;
        this.bruk = bruk;
    }

    public InstOpphPeriodegrunnlag() {
        super();
        bruk = true;
    }

    public boolean isBruk() {
        return bruk;
    }

    public void setBruk(boolean bruk) {
        this.bruk = bruk;
    }

    public Date getFom() {
        return fom;
    }

    public void setFom(Date fom) {
        this.fom = fom;
    }

    public Date getForventetTom() {
        return forventetTom;
    }

    public void setForventetTom(Date forventetTom) {
        this.forventetTom = forventetTom;
    }

    public OppholdTypeCti getOppholdType() {
        return oppholdType;
    }

    public void setOppholdType(OppholdTypeCti oppholdType) {
        this.oppholdType = oppholdType;
    }

    public boolean isOverfort() {
        return overfort;
    }

    public void setOverfort(boolean overfort) {
        this.overfort = overfort;
    }

    public String getRegisterEndretAv() {
        return registerEndretAv;
    }

    public void setRegisterEndretAv(String registerEndretAv) {
        this.registerEndretAv = registerEndretAv;
    }

    public Date getRegisterEndretDato() {
        return registerEndretDato;
    }

    public void setRegisterEndretDato(Date registerEndretDato) {
        this.registerEndretDato = registerEndretDato;
    }

    public String getRegisterKilde() {
        return registerKilde;
    }

    public void setRegisterKilde(String registerKilde) {
        this.registerKilde = registerKilde;
    }

    public String getRegisterOpprettetAv() {
        return registerOpprettetAv;
    }

    public void setRegisterOpprettetAv(String registerOpprettetAv) {
        this.registerOpprettetAv = registerOpprettetAv;
    }

    public Date getRegisterOpprettetDato() {
        return registerOpprettetDato;
    }

    public void setRegisterOpprettetDato(Date registerOpprettetDato) {
        this.registerOpprettetDato = registerOpprettetDato;
    }

    public Date getTom() {
        return tom;
    }

    public void setTom(Date tom) {
        this.tom = tom;
    }

    public String getTssEksternId() {
        return tssEksternId;
    }

    public void setTssEksternId(String tssEksternId) {
        this.tssEksternId = tssEksternId;
    }

    public VarighetTypeCti getVarighetType() {
        return varighetType;
    }

    public void setVarighetType(VarighetTypeCti varighetType) {
        this.varighetType = varighetType;
    }

    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     * 
     * @return a <code>String</code> representation
     *         of this object.
     */
    @Override
    public String toString() {
        final String TAB = "    ";

        StringBuilder retValue = new StringBuilder();

        retValue.append("InstOpphPeriodegrunnlag ( ").append(super.toString()).append(TAB).append("instOpphPeriodegrunnlagId = ").append(instOppholdId).append(TAB)
                .append("oppholdType = ").append(oppholdType).append(TAB).append("tssEksternId = ").append(tssEksternId).append(TAB).append("varighetType = ").append(varighetType)
                .append(TAB).append("fom = ").append(fom).append(TAB).append("tom = ").append(tom).append(TAB).append("forventetTom = ").append(forventetTom).append(TAB)
                .append("registerOpprettetAv = ").append(registerOpprettetAv).append(TAB).append("registerEndretAv = ").append(registerEndretAv).append(TAB)
                .append("registerOpprettetDato = ").append(registerOpprettetDato).append(TAB).append("registerEndretDato = ").append(registerEndretDato).append(TAB)
                .append("registerKilde = ").append(registerKilde).append(TAB).append("overfort = ").append(overfort).append(TAB).append("bruk = ").append(bruk).append(TAB)
                .append(" )");

        return retValue.toString();
    }

    public long getInstOppholdId() {
        return instOppholdId;
    }

    public void setInstOppholdId(long instOppholdId) {
        this.instOppholdId = instOppholdId;
    }

    @Override
    public int compareTo(InstOpphPeriodegrunnlag instOpph) {
        return DateCompareUtil.compareTo(getFom(), instOpph.getFom());
    }
}
