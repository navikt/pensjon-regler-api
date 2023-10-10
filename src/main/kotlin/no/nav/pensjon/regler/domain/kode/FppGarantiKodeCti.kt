package no.nav.pensjon.regler.domain.kode

class FppGarantiKodeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(fppGarantiKodeCti: FppGarantiKodeCti) : super(fppGarantiKodeCti)
}