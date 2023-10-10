package no.nav.pensjon.regler.domain.kode

class InntektKode1Cti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(inntektKode1Cti: InntektKode1Cti) : super(inntektKode1Cti)
}