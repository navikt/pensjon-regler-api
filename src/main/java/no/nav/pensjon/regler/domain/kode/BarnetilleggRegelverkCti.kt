package no.nav.pensjon.regler.domain.kode

class BarnetilleggRegelverkCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(typeCti: TypeCti) : super(typeCti)
}