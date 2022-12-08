package no.nav.domain.pensjon.regler.afpoppgjor;

import no.nav.domain.pensjon.regler.BatchStatus;
import no.nav.domain.pensjon.regler.kode.AFPetteroppgjorBehandlingskodeCti;
import no.nav.domain.pensjon.regler.kode.AFPetteroppgjorGruppeCti;

import java.io.Serializable;

public class AfpEtteroppgjorKategori implements Serializable {

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

}
