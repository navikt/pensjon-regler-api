package no.nav.pensjon.regler.domain.kode

class FtDtArsakCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(t: FtDtArsakCti) : super(t)
}