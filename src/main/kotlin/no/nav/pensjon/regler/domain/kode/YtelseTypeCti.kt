package no.nav.pensjon.regler.domain.kode

class YtelseTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(ytelseTypeCti: YtelseTypeCti) : super(ytelseTypeCti)
}