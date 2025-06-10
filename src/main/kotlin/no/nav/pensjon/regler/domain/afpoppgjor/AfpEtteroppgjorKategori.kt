package no.nav.pensjon.regler.domain.afpoppgjor

import no.nav.pensjon.regler.domain.BatchStatus
import no.nav.pensjon.regler.domain.enum.AFPoppgjKategoriEnum
import no.nav.pensjon.regler.domain.enum.AfpEtteroppgjorBehandlingskodeEnum
import java.io.Serializable

class AfpEtteroppgjorKategori(
    /**
     * Beregnet inntekt etter opphør
     */
    var beregnetIEO: Int = 0,

    /**
     * Beregnet inntekt før uttak
     */
    var beregnetIFU: Int = 0,

    /**
     * Beregnet FPI i AFP-perioden
     */
    var beregnetFPI: Int = 0,

    /**
     * Beregnet inntekt i AFP-perioden
     */
    var beregnetIIAP: Int = 0,

    /**
     * Beregnet avvik mellom arbeidsinntekt (PGI) og inntekten pensjonen er beregnet etter.
     */
    var inntektsAvvik: Int = 0,

    /**
     * Settes til SPK hvis personen skal overfåres til SPK (med i SPK filen).
     * Personen har AFP_STAT og fylte 65 år forrige år.
     * Settes til ANDRE ellers.
     */
    var behandlingskodeEnum: AfpEtteroppgjorBehandlingskodeEnum? = null,

    /**
     * Gruppen dette oppgjøret er kategorisert som; Gruppe 1 - 4
     */
    var gruppeEnum: AFPoppgjKategoriEnum? = null,

    /**
     * Status fra pensjon-regler per element
     */
    var status: BatchStatus? = null
) : Serializable