package no.nav.pensjon.regler.domain.kode

class AvtaleKritCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(avtaleKritCti: AvtaleKritCti) : super(avtaleKritCti)
}