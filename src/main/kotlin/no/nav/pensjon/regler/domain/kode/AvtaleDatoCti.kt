package no.nav.pensjon.regler.domain.kode

class AvtaleDatoCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(avtaleDatoCti: AvtaleDatoCti) : super(avtaleDatoCti)
}