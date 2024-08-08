package no.nav.pensjon.regler.domain.kode

// TODO Klassen finnes i Pesys, men ikke i bruk av Regler. Kan denne deprecates?
class KravStatusCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(kravStatusCti: KravStatusCti) : super(kravStatusCti)
}