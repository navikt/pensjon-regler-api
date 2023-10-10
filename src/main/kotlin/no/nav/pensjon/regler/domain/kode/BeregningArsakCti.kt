package no.nav.pensjon.regler.domain.kode

class BeregningArsakCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(beregningArsakCti: BeregningArsakCti) : super(beregningArsakCti)
}