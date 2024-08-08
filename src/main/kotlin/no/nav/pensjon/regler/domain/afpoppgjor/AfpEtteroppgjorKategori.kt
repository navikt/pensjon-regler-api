package no.nav.pensjon.regler.domain.afpoppgjor

import no.nav.pensjon.regler.domain.BatchStatus
import no.nav.pensjon.regler.domain.enum.AFPoppgjKategoriEnum
import no.nav.pensjon.regler.domain.enum.AfpEtteroppgjorBehandlingskodeEnum
import no.nav.pensjon.regler.domain.kode.AFPetteroppgjorBehandlingskodeCti
import no.nav.pensjon.regler.domain.kode.AFPetteroppgjorGruppeCti
import java.io.Serializable

class AfpEtteroppgjorKategori : Serializable {
    /**
     * Nøkkelfelt brukt av PEN tjenestene.
     * pensjon-regler skal ta denne inn og levere den tilbake i alle tjenestene sine.
     */
    var vedtakId: Long = 0

    /**
     * Id til personsobjektet fra PEN
     */
    var penPersonId: Long = 0

    /**
     * Beregnet inntekt etter opphør
     */
    var beregnetIEO = 0

    /**
     * Beregnet inntekt før uttak
     */
    var beregnetIFU = 0

    /**
     * Beregnet FPI i AFP-perioden
     */
    var beregnetFPI = 0

    /**
     * Beregnet inntekt i AFP-perioden
     */
    var beregnetIIAP = 0

    /**
     * Beregnet avvik mellom arbeidsinntekt (PGI) og inntekten pensjonen er beregnet etter.
     */
    var inntektsAvvik = 0

    /**
     * Settes til SPK hvis personen skal overfåres til SPK (med i SPK filen).
     * Personen har AFP_STAT og fylte 65 år forrige år.
     * Settes til ANDRE ellers.
     */
    var behandlingskode: AFPetteroppgjorBehandlingskodeCti? = null
    var behandlingskodeEnum: AfpEtteroppgjorBehandlingskodeEnum? = null

    /**
     * Gruppen dette oppgjøret er kategorisert som; Gruppe 1 - 4
     */
    var gruppe: AFPetteroppgjorGruppeCti? = null
    var gruppeEnum: AFPoppgjKategoriEnum? = null

    /**
     * Status fra pensjon-regler per element
     */
    var status: BatchStatus? = null
}