package no.nav.pensjon.regler.domain.kode

class EksportlandCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(eksportlandCti: EksportlandCti) : super(eksportlandCti)
}