package no.nav.pensjon.regler.domain.kode

class InntektsavkortingTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(inntektsavkortingTypeCti: InntektsavkortingTypeCti) : super(inntektsavkortingTypeCti)
}