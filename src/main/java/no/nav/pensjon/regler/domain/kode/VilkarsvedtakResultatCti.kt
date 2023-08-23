package no.nav.pensjon.regler.domain.kode

class VilkarsvedtakResultatCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(vilkarsvedtakResultatCti: VilkarsvedtakResultatCti) : super(vilkarsvedtakResultatCti)
}