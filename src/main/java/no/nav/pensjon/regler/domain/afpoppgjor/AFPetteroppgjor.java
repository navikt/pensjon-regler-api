package no.nav.pensjon.regler.domain.afpoppgjor;

import no.nav.pensjon.regler.domain.BatchStatus;

import java.io.Serializable;
import java.util.Date;

public class AFPetteroppgjor implements Serializable {

    private static final long serialVersionUID = -8992404201281484726L;
    /**
     * Nøkkelfelt brukt av PEN tjenestene.
     * PREG skal ta denne inn og levere den tilbake i alle tjenestene sine.
     */
    private long vedtakId;
    /**
     * Id til personsobjektet fra PEN
     */
    private long penPersonId;
    /**
     * Datoen for uttak av AFP - hvis dette skjedde i oppgjørsperioden
     */
    private Date uttaksdato;
    /**
     * Datoen for opphør av AFP - hvis dette skjedde i oppgjørsperioden
     */
    private Date opphorsdato;
    /**
     * Full AFP pensjon i perioden
     */
    private int fullAFP;
    /**
     * Utbetalt AFP i perioden
     */
    private int utbetaltAFP;
    /**
     * Korrigert AFP for perioden
     */
    private int korrigertAFP;
    /**
     * Beløpet som skal tilbakekreves - hvis det er utbetalt for mye
     */
    private int forMyeUtbetalt;
    /**
     * Beløpet som skal utbetales - hvis det er utbetalt for lite
     */
    private int forLiteUtbetalt;
    /**
     * Mellomberegning: IIAP/beregnetTPI*fullAFP
     */
    private int fradragBeregnetArbeidsinntekt;
    /**
     * Beregnet TPI i AFP-perioden
     */
    private int beregnetTPI;
    /**
     * Status fra PREG per element
     */
    private BatchStatus status;

    public AFPetteroppgjor(long vedtakId, long penPersonId, Date uttaksdato, Date opphorsdato, int fullAFP, int utbetaltAFP, int korrigertAFP, int forMyeUtbetalt,
                           int forLiteUtbetalt, int fradragBeregnetArbeidsinntekt, int beregnetTPI, BatchStatus status) {
        super();
        this.vedtakId = vedtakId;
        this.penPersonId = penPersonId;
        this.uttaksdato = uttaksdato;
        this.opphorsdato = opphorsdato;
        this.fullAFP = fullAFP;
        this.utbetaltAFP = utbetaltAFP;
        this.korrigertAFP = korrigertAFP;
        this.forMyeUtbetalt = forMyeUtbetalt;
        this.forLiteUtbetalt = forLiteUtbetalt;
        this.fradragBeregnetArbeidsinntekt = fradragBeregnetArbeidsinntekt;
        this.beregnetTPI = beregnetTPI;
        this.status = status;
    }

    public AFPetteroppgjor() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getForLiteUtbetalt() {
        return forLiteUtbetalt;
    }

    public void setForLiteUtbetalt(int forLiteUtbetalt) {
        this.forLiteUtbetalt = forLiteUtbetalt;
    }

    public int getForMyeUtbetalt() {
        return forMyeUtbetalt;
    }

    public void setForMyeUtbetalt(int forMyeUtbetalt) {
        this.forMyeUtbetalt = forMyeUtbetalt;
    }

    public int getFullAFP() {
        return fullAFP;
    }

    public void setFullAFP(int fullAFP) {
        this.fullAFP = fullAFP;
    }

    public int getKorrigertAFP() {
        return korrigertAFP;
    }

    public void setKorrigertAFP(int korrigertAFP) {
        this.korrigertAFP = korrigertAFP;
    }

    public Date getOpphorsdato() {
        return opphorsdato;
    }

    public void setOpphorsdato(Date opphorsdato) {
        this.opphorsdato = opphorsdato;
    }

    public int getUtbetaltAFP() {
        return utbetaltAFP;
    }

    public void setUtbetaltAFP(int utbetaltAFP) {
        this.utbetaltAFP = utbetaltAFP;
    }

    public Date getUttaksdato() {
        return uttaksdato;
    }

    public void setUttaksdato(Date uttaksdato) {
        this.uttaksdato = uttaksdato;
    }

    public BatchStatus getStatus() {
        return status;
    }

    public void setStatus(BatchStatus status) {
        this.status = status;
    }

    public int getBeregnetTPI() {
        return beregnetTPI;
    }

    public void setBeregnetTPI(int beregnetTPI) {
        this.beregnetTPI = beregnetTPI;
    }

    public int getFradragBeregnetArbeidsinntekt() {
        return fradragBeregnetArbeidsinntekt;
    }

    public void setFradragBeregnetArbeidsinntekt(int fradragBeregnetArbeidsinntekt) {
        this.fradragBeregnetArbeidsinntekt = fradragBeregnetArbeidsinntekt;
    }

    public long getVedtakId() {
        return vedtakId;
    }

    public void setVedtakId(long vedtakId) {
        this.vedtakId = vedtakId;
    }

    public long getPenPersonId() {
        return penPersonId;
    }

    public void setPenPersonId(long penPersonId) {
        this.penPersonId = penPersonId;
    }

}
