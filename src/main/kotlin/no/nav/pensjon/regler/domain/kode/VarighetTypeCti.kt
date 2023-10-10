package no.nav.pensjon.regler.domain.kode

class VarighetTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(varighetTypeCti: VarighetTypeCti) : super(varighetTypeCti)
}