package no.nav.pensjon.regler.domain.kode

class BeregningMetodeTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(beregningMetodeTypeCti: BeregningMetodeTypeCti) : super(beregningMetodeTypeCti)
}