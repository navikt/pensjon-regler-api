package no.nav.pensjon.regler.domain.kode

class ForstegangstjenesteperiodeTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(avtaleTypeCti: ForstegangstjenesteperiodeTypeCti) : super(avtaleTypeCti)
}