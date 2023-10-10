package no.nav.pensjon.regler.domain.kode

class SivilstandTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(sivilstandTypeCti: SivilstandTypeCti) : super(sivilstandTypeCti)
}