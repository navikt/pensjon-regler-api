package no.nav.pensjon.regler.domain.kode

class GarantipenNivaCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(t: GarantipenNivaCti) : super(t)
}