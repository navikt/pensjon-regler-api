package no.nav.pensjon.regler.domain.kode

class AfpOrdningTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(afpOrdningTypeCti: AfpOrdningTypeCti) : super(afpOrdningTypeCti)
}