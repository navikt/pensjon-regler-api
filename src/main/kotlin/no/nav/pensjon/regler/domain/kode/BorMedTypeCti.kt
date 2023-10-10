package no.nav.pensjon.regler.domain.kode

class BorMedTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(borMedTypeCti: BorMedTypeCti) : super(borMedTypeCti)
}