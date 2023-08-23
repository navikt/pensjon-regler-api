package no.nav.pensjon.regler.domain.kode

class InntektKode2Cti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(inntektKode2Cti: InntektKode2Cti) : super(inntektKode2Cti)
}