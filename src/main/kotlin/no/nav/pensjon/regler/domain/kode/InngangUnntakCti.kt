package no.nav.pensjon.regler.domain.kode

class InngangUnntakCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(inngangUnntakCti: InngangUnntakCti) : super(inngangUnntakCti)
}