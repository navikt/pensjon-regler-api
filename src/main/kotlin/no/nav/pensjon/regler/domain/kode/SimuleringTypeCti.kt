package no.nav.pensjon.regler.domain.kode

class SimuleringTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(simuleringTypeCti: SimuleringTypeCti) : super(simuleringTypeCti)
}