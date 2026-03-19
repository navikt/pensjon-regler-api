package no.nav.pensjon.regler.to

import com.fasterxml.jackson.annotation.JsonAlias
import no.nav.pensjon.regler.domain.simulering.Simulering
import java.util.*
import java.time.LocalDate

class SimuleringRequest() : ServiceRequest() {
    var simulering: Simulering? = null
    @Deprecated("Use virkLd instead")
    @JsonAlias("fom")
    var virk: Date? = null
    @JsonAlias("fomLd")
    var virkLd: LocalDate? = null
    var ektefelleMottarPensjon = false
    var beregnForsorgingstillegg = false
    var beregnInstitusjonsopphold = false

    @Deprecated("Use virkLd-constructor instead")
    constructor(
        simulering: Simulering?,
        virk: Date?,
        ektefelleMottarPensjon: Boolean,
        beregnForsorgingstillegg: Boolean,
        beregnInstitusjonsopphold: Boolean
    ) : this() {
        this.simulering = simulering
        this.virk = virk
        this.ektefelleMottarPensjon = ektefelleMottarPensjon
        this.beregnForsorgingstillegg = beregnForsorgingstillegg
        this.beregnInstitusjonsopphold = beregnInstitusjonsopphold
    }

    constructor(
        simulering: Simulering?,
        virk: LocalDate?,
        ektefelleMottarPensjon: Boolean,
        beregnForsorgingstillegg: Boolean,
        beregnInstitusjonsopphold: Boolean
    ) : this() {
        this.simulering = simulering
        this.virkLd = virk
        this.ektefelleMottarPensjon = ektefelleMottarPensjon
        this.beregnForsorgingstillegg = beregnForsorgingstillegg
        this.beregnInstitusjonsopphold = beregnInstitusjonsopphold
    }

    @Deprecated("Use virkLd-constructor instead")
    constructor(simulering: Simulering?, virk: Date?) : this() {
        this.simulering = simulering
        this.virk = virk
    }

    constructor(simulering: Simulering?, virk: LocalDate?) : this() {
        this.simulering = simulering
        this.virkLd = virk
    }
}
