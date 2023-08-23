package no.nav.pensjon.regler.domain.kode

class PoengtallTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(poengtallTypeCti: PoengtallTypeCti) : super(poengtallTypeCti)
}