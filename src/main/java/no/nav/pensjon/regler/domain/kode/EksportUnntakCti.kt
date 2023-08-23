package no.nav.pensjon.regler.domain.kode

class EksportUnntakCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(eksportUnntakCti: EksportUnntakCti) : super(eksportUnntakCti)
}