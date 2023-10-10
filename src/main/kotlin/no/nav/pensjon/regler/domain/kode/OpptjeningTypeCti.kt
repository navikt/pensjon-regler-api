package no.nav.pensjon.regler.domain.kode

class OpptjeningTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(opptjeningTypeCti: OpptjeningTypeCti) : super(opptjeningTypeCti)
}