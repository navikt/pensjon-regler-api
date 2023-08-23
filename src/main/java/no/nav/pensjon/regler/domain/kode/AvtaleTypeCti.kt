package no.nav.pensjon.regler.domain.kode

class AvtaleTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(avtaleTypeCti: AvtaleTypeCti) : super(avtaleTypeCti)
}