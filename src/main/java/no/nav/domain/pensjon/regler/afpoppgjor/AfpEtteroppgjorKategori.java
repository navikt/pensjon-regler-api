package no.nav.domain.pensjon.regler.afpoppgjor;

import no.nav.domain.pensjon.regler.BatchStatus;
import no.nav.domain.pensjon.regler.kode.AFPetteroppgjorBehandlingskodeCti;
import no.nav.domain.pensjon.regler.kode.AFPetteroppgjorGruppeCti;

import java.io.Serializable;

public class AfpEtteroppgjorKategori implements Serializable {

    private static final long serialVersionUID = 8260790601675584999L;
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
     * Beregnet inntekt etter opphør
     */
    private int beregnetIEO;
    /**
     * Beregnet inntekt før uttak
     */
    private int beregnetIFU;
    /**
     * Beregnet FPI i AFP-perioden
     */
    private int beregnetFPI;
    /**
     * Beregnet inntekt i AFP-perioden
     */
    private int beregnetIIAP;
    /**
     * Beregnet avvik mellom arbeidsinntekt (PGI) og inntekten pensjonen er beregnet etter.
     */
    private int inntektsAvvik;
    /**
     * Settes til SPK hvis personen skal overføres til SPK (med i SPK filen).
     * Personen har AFP_STAT og fylte 65 år forrige år.
     * Settes til ANDRE ellers.
     */
    private AFPetteroppgjorBehandlingskodeCti behandlingskode;
    /**
     * Gruppen dette oppgjøret er kategorisert som; Gruppe 1 - 4
     */
    private AFPetteroppgjorGruppeCti gruppe;
    /**
     * Status fra PREG per element
     */
    private BatchStatus status;

    public AfpEtteroppgjorKategori(long vedtakId, long penPersonId, int beregnetIEO, int beregnetIFU, int beregnetFPI, int beregnetIIAP, int inntektsAvvik,
                                   AFPetteroppgjorBehandlingskodeCti behandlingskode, AFPetteroppgjorGruppeCti gruppe, BatchStatus status) {
        super();
        this.vedtakId = vedtakId;
        this.penPersonId = penPersonId;
        this.beregnetIEO = beregnetIEO;
        this.beregnetIFU = beregnetIFU;
        this.beregnetFPI = beregnetFPI;
        this.beregnetIIAP = beregnetIIAP;
        this.inntektsAvvik = inntektsAvvik;
        this.behandlingskode = behandlingskode;
        this.gruppe = gruppe;
        this.status = status;
    }

    public AfpEtteroppgjorKategori() {
        super();
        // TODO Auto-generated constructor stub
    }

    public AFPetteroppgjorBehandlingskodeCti getBehandlingskode() {
        return behandlingskode;
    }

    public void setBehandlingskode(AFPetteroppgjorBehandlingskodeCti behandlingskode) {
        this.behandlingskode = behandlingskode;
    }

    public AFPetteroppgjorGruppeCti getGruppe() {
        return gruppe;
    }

    public void setGruppe(AFPetteroppgjorGruppeCti gruppe) {
        this.gruppe = gruppe;
    }

    public int getInntektsAvvik() {
        return inntektsAvvik;
    }

    public void setInntektsAvvik(int inntektsAvvik) {
        this.inntektsAvvik = inntektsAvvik;
    }

    public BatchStatus getStatus() {
        return status;
    }

    public void setStatus(BatchStatus status) {
        this.status = status;
    }

    public int getBeregnetFPI() {
        return beregnetFPI;
    }

    public void setBeregnetFPI(int beregnetFPI) {
        this.beregnetFPI = beregnetFPI;
    }

    public int getBeregnetIEO() {
        return beregnetIEO;
    }

    public void setBeregnetIEO(int beregnetIEO) {
        this.beregnetIEO = beregnetIEO;
    }

    public int getBeregnetIFU() {
        return beregnetIFU;
    }

    public void setBeregnetIFU(int beregnetIFU) {
        this.beregnetIFU = beregnetIFU;
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

    public int getBeregnetIIAP() {
        return beregnetIIAP;
    }

    public void setBeregnetIIAP(int beregnetIIAP) {
        this.beregnetIIAP = beregnetIIAP;
    }

}
