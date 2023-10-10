package no.nav.pensjon.regler.domain.kode

class MinsteytelseNivaCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(minsteytelseNivaCti: MinsteytelseNivaCti) : super(minsteytelseNivaCti)
}