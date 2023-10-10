package no.nav.pensjon.regler.domain.kode

class AvtalelandCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(avtalelandCti: AvtalelandCti) : super(avtalelandCti)
}