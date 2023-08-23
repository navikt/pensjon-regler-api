package no.nav.pensjon.regler.domain.kode

class PoengtilleggCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(yrkeCti: PoengtilleggCti) : super(yrkeCti)
}