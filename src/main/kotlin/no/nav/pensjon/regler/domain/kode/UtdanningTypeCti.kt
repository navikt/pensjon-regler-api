package no.nav.pensjon.regler.domain.kode

class UtdanningTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(utdanningTypeCti: UtdanningTypeCti) : super(utdanningTypeCti)
}