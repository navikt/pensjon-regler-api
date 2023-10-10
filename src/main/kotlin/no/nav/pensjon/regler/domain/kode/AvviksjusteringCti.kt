package no.nav.pensjon.regler.domain.kode

class AvviksjusteringCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(avviksjusteringCti: AvviksjusteringCti) : super(avviksjusteringCti)
}