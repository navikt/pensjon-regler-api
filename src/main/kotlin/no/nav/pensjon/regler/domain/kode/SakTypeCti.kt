package no.nav.pensjon.regler.domain.kode

class SakTypeCti : TypeCti {
    constructor(typeCti: TypeCti) : super(typeCti)
    constructor()
    constructor(kode: String?) : super(kode)
}