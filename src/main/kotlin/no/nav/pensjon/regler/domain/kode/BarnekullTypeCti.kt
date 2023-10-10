package no.nav.pensjon.regler.domain.kode

class BarnekullTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(barnekullTypeCti: BarnekullTypeCti) : super(barnekullTypeCti)
}