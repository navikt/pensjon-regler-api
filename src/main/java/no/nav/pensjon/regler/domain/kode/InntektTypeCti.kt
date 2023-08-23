package no.nav.pensjon.regler.domain.kode

class InntektTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(inntektTypeCti: InntektTypeCti) : super(inntektTypeCti)
}