package no.nav.pensjon.regler.domain.kode

class BeholdningsTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(t: BeholdningsTypeCti) : super(t)
}