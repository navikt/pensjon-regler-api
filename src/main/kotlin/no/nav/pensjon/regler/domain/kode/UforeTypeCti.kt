package no.nav.pensjon.regler.domain.kode

class UforeTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(uforeTypeCti: UforeTypeCti) : super(uforeTypeCti)
}