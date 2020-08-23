package no.nav.domain.pensjon.regler.afpoppgjor;

import no.nav.domain.pensjon.regler.kode.AfpOrdningTypeCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AFPEtteroppgjorgrunnlag implements Serializable {

    private static final long serialVersionUID = -8279250603362367039L;
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
     * Personens fødselsdato
     */
    private Date fodselsdato;
    /**
     * AFPordningen personen er eller var medlem av
     */
    private AfpOrdningTypeCti afpOrdning;
    /**
     * Skal settes til true når personen har gått over til en annen type pensjon midt i
     * oppgjørsåret
     */
    private boolean overgangTilAnnenPensjon;
    /**
     * Liste av Utbetalingsperioder.
     */
    private List<AfpUtbetalingsperiode> afpUtbetalingsperiodeList;
    /**
     * Brukerregistrert inntekt etter opphør
     */
    private int ieo;
    /**
     * Brukerregistrert inntekt før uttak
     */
    private int ifu;
    /**
     * Pensjonsgivende inntekt i preioden (fra SKD)
     */
    private int pgi;

    private Date uttaksdato;
    /**
     * Hvis pensjonen opphørte midt i oppgjørsåret skal denne settes til opphørsdato
     */
    private Date opphorsdato;
    /**
     * Beskriver hvilken kategori etteroppgjøret er, samt inntektene som ble beregnet.
     * Skal være null ved kall til KategoriserAFPOppgjor.
     */
    private AfpEtteroppgjorKategori afpEtteroppgjorKategori;

    public AFPEtteroppgjorgrunnlag(long vedtakId, long penPersonId, Date fodselsdato, AfpOrdningTypeCti afpOrdning, boolean overgangTilAnnenPensjon,
                                   List<AfpUtbetalingsperiode> afpUtbetalingsperiodeList, int ieo, int ifu, int pgi, Date uttaksdato, Date opphorsdato,
                                   AfpEtteroppgjorKategori afpEtteroppgjorKategori) {
        super();
        this.vedtakId = vedtakId;
        this.penPersonId = penPersonId;
        this.fodselsdato = fodselsdato;
        this.afpOrdning = afpOrdning;
        this.overgangTilAnnenPensjon = overgangTilAnnenPensjon;
        this.afpUtbetalingsperiodeList = afpUtbetalingsperiodeList;
        this.ieo = ieo;
        this.ifu = ifu;
        this.pgi = pgi;
        this.uttaksdato = uttaksdato;
        this.opphorsdato = opphorsdato;
        this.afpEtteroppgjorKategori = afpEtteroppgjorKategori;
    }

    public AFPEtteroppgjorgrunnlag() {
        super();
        // initialiser alle lister
        afpUtbetalingsperiodeList = new ArrayList<AfpUtbetalingsperiode>();

    }

    public AfpEtteroppgjorKategori getAfpEtteroppgjorKategori() {
        return afpEtteroppgjorKategori;
    }

    /**
     * @deprecated
     * @return Returns the afpUtbetalingsperiode as array.
     */
    @Deprecated
    public AfpUtbetalingsperiode[] retrieveAfpUtbetalingsperiodeListAsArray() {
        return afpUtbetalingsperiodeList.toArray(new AfpUtbetalingsperiode[0]);
    }

    /**
     * Read only property for afpUtbetalingsperiodeListe as array.
     * 
     * @return array of AfpUtbetalingsperiode
     */
    public AfpUtbetalingsperiode[] getAfpUtbetalingsperiodeListeAsArray() {
        return afpUtbetalingsperiodeList != null ? afpUtbetalingsperiodeList.toArray(new AfpUtbetalingsperiode[afpUtbetalingsperiodeList.size()]) : new AfpUtbetalingsperiode[0];
    }

    public void setAfpEtteroppgjorKategori(AfpEtteroppgjorKategori afpEtteroppgjorKategori) {
        this.afpEtteroppgjorKategori = afpEtteroppgjorKategori;
    }

    public AfpOrdningTypeCti getAfpOrdning() {
        return afpOrdning;
    }

    public void setAfpOrdning(AfpOrdningTypeCti afpOrdning) {
        this.afpOrdning = afpOrdning;
    }

    public List<AfpUtbetalingsperiode> getAfpUtbetalingsperiodeList() {
        return afpUtbetalingsperiodeList;
    }

    public void setAfpUtbetalingsperiodeList(List<AfpUtbetalingsperiode> afpUtbetalingsperiodeList) {
        this.afpUtbetalingsperiodeList = afpUtbetalingsperiodeList;
    }

    public Date getFodselsdato() {
        return fodselsdato;
    }

    public void setFodselsdato(Date fodselsdato) {
        this.fodselsdato = fodselsdato;
    }

    public Date getOpphorsdato() {
        return opphorsdato;
    }

    public void setOpphorsdato(Date opphorsdato) {
        this.opphorsdato = opphorsdato;
    }

    public boolean isOvergangTilAnnenPensjon() {
        return overgangTilAnnenPensjon;
    }

    public void setOvergangTilAnnenPensjon(boolean overgangTilAnnenPensjon) {
        this.overgangTilAnnenPensjon = overgangTilAnnenPensjon;
    }

    public Date getUttaksdato() {
        return uttaksdato;
    }

    public void setUttaksdato(Date uttaksdato) {
        this.uttaksdato = uttaksdato;
    }

    public int getIeo() {
        return ieo;
    }

    public void setIeo(int ieo) {
        this.ieo = ieo;
    }

    public int getIfu() {
        return ifu;
    }

    public void setIfu(int ifu) {
        this.ifu = ifu;
    }

    public int getPgi() {
        return pgi;
    }

    public void setPgi(int pgi) {
        this.pgi = pgi;
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
