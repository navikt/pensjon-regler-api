package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.simulering.Simulering
import java.util.*

class SimuleringRequest : ServiceRequest {
    var simulering: Simulering? = null
    var fom: Date? = null
    var ektefelleMottarPensjon = false
    var beregnForsorgingstillegg = false
    var beregnInstitusjonsopphold = false

    constructor(
        simulering: Simulering?,
        fom: Date?,
        ektefelleMottarPensjon: Boolean,
        beregnForsorgingstillegg: Boolean,
        beregnInstitusjonsopphold: Boolean
    ) {
        this.simulering = simulering
        this.fom = fom
        this.ektefelleMottarPensjon = ektefelleMottarPensjon
        this.beregnForsorgingstillegg = beregnForsorgingstillegg
        this.beregnInstitusjonsopphold = beregnInstitusjonsopphold
    }

    constructor(simulering: Simulering?, fom: Date?) {
        this.simulering = simulering
        this.fom = fom
    }
}
