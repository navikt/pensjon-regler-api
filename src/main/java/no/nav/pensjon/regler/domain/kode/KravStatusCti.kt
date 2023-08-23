package no.nav.pensjon.regler.domain.kode

class KravStatusCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(kravStatusCti: KravStatusCti) : super(kravStatusCti)
}