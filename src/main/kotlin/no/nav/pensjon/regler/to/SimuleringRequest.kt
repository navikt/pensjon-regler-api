package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.simulering.Simulering
import java.time.LocalDate

class SimuleringRequest() : ServiceRequest() {
    var simulering: Simulering? = null
    var fomLd: LocalDate? = null
    var ektefelleMottarPensjon = false
    var beregnForsorgingstillegg = false
    var beregnInstitusjonsopphold = false

    @Deprecated("Use fomLd-constructor instead")
    constructor(
        simulering: Simulering?,
        // fom: Date?,
        ektefelleMottarPensjon: Boolean,
        beregnForsorgingstillegg: Boolean,
        beregnInstitusjonsopphold: Boolean
    ) : this() {
        this.simulering = simulering
//        this.fom = fom
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

    constructor(simulering: Simulering?, fom: LocalDate?) : this() {
        this.simulering = simulering
        this.fomLd = fom
    }
}
