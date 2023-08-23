package no.nav.pensjon.regler.domain.kode

class InstReduksjonCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(instReduksjonCti: InstReduksjonCti) : super(instReduksjonCti)
}