package no.nav.pensjon.regler.domain.kode

class OpptjeningPOPPTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(opptjeningPOPPTypeCti: OpptjeningPOPPTypeCti) : super(opptjeningPOPPTypeCti)
}