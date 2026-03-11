package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.simulering.Simulering
import java.util.*
import java.time.LocalDate

class SimuleringRequest() : ServiceRequest() {
    var simulering: Simulering? = null
    @Deprecated("Use fomLd instead")
    var fom: Date? = null
    var fomLd: LocalDate? = null
    var ektefelleMottarPensjon = false
    var beregnForsorgingstillegg = false
    var beregnInstitusjonsopphold = false

    @Deprecated("Use fomLd-constructor instead")
    constructor(
        simulering: Simulering?,
        fom: Date?,
        ektefelleMottarPensjon: Boolean,
        beregnForsorgingstillegg: Boolean,
        beregnInstitusjonsopphold: Boolean
    ) : this() {
        this.simulering = simulering
        this.fom = fom
        this.ektefelleMottarPensjon = ektefelleMottarPensjon
        this.beregnForsorgingstillegg = beregnForsorgingstillegg
        this.beregnInstitusjonsopphold = beregnInstitusjonsopphold
    }

    constructor(
        simulering: Simulering?,
        fom: LocalDate?,
        ektefelleMottarPensjon: Boolean,
        beregnForsorgingstillegg: Boolean,
        beregnInstitusjonsopphold: Boolean
    ) : this() {
        this.simulering = simulering
        this.fomLd = fom
        this.ektefelleMottarPensjon = ektefelleMottarPensjon
        this.beregnForsorgingstillegg = beregnForsorgingstillegg
        this.beregnInstitusjonsopphold = beregnInstitusjonsopphold
    }

    @Deprecated("Use fomLd-constructor instead")
    constructor(simulering: Simulering?, fom: Date?) : this() {
        this.simulering = simulering
        this.fom = fom
    }

    constructor(simulering: Simulering?, fom: LocalDate?) : this() {
        this.simulering = simulering
        this.fomLd = fom
    }
}
