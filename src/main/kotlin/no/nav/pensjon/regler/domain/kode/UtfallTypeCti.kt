package no.nav.pensjon.regler.domain.kode

class UtfallTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(kode: UtfallTypeCti) : super(kode)
}