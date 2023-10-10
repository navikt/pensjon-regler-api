package no.nav.pensjon.regler.domain.kode

class FormelKodeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(formelKode: FormelKodeCti) : super(formelKode)
}