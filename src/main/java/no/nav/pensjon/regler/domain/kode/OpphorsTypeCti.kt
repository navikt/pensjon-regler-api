package no.nav.pensjon.regler.domain.kode

class OpphorsTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(opphorsTypeCti: OpphorsTypeCti) : super(opphorsTypeCti)
}