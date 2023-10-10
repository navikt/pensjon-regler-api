package no.nav.pensjon.regler.domain.kode

class LandCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(landCti: LandCti) : super(landCti)
}