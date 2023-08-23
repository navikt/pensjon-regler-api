package no.nav.pensjon.regler.domain.kode

class JusteringsTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(t: JusteringsTypeCti) : super(t)
}