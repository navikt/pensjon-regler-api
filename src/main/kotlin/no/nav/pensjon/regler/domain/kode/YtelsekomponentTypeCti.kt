package no.nav.pensjon.regler.domain.kode

class YtelsekomponentTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(ytelseTypeCti: YtelsekomponentTypeCti) : super(ytelseTypeCti)
}