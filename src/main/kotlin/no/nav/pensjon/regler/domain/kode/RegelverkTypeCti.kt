package no.nav.pensjon.regler.domain.kode

class RegelverkTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(regelverkTypeCti: RegelverkTypeCti) : super(regelverkTypeCti)
}