package no.nav.pensjon.regler.domain.kode

class VilkarsvedtakTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(vilkarsvedtakTypeCti: VilkarsvedtakTypeCti) : super(vilkarsvedtakTypeCti)
}