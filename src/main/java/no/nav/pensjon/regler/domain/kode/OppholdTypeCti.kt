package no.nav.pensjon.regler.domain.kode

class OppholdTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(oppholdTypeCti: OppholdTypeCti) : super(oppholdTypeCti)
}