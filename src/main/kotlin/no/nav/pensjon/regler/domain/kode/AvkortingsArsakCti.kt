package no.nav.pensjon.regler.domain.kode

class AvkortingsArsakCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(avkortingsArsakCti: AvkortingsArsakCti) : super(avkortingsArsakCti)
}