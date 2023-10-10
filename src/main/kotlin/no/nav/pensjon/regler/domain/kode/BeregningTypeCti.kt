package no.nav.pensjon.regler.domain.kode

class BeregningTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(beregningTypeCti: BeregningTypeCti) : super(beregningTypeCti)
}