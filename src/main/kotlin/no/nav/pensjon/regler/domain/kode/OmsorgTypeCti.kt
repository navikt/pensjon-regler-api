package no.nav.pensjon.regler.domain.kode

class OmsorgTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(t: OmsorgTypeCti) : super(t)
}