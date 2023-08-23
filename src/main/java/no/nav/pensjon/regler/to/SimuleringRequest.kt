package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.simulering.Simulering
import java.util.*

class SimuleringRequest {
    var simulering: Simulering? = null
    var fom: Date? = null
    var isEktefelleMottarPensjon = false
    var isBeregnForsorgingstillegg = false
    var isBeregnInstitusjonsopphold = false

    constructor()
    constructor(
        simulering: Simulering?,
        fom: Date?,
        ektefelleMottarPensjon: Boolean,
        beregnForsorgingstillegg: Boolean,
        beregnInstitusjonsopphold: Boolean
    ) {
        this.simulering = simulering
        this.fom = fom
        this.isEktefelleMottarPensjon = ektefelleMottarPensjon
        this.isBeregnForsorgingstillegg = beregnForsorgingstillegg
        this.isBeregnInstitusjonsopphold = beregnInstitusjonsopphold
    }

    constructor(simulering: Simulering?, fom: Date?) {
        this.simulering = simulering
        this.fom = fom
    }
}