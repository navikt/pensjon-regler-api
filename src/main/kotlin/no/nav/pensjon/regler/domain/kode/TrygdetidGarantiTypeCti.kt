package no.nav.pensjon.regler.domain.kode

class TrygdetidGarantiTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(typeCti: TypeCti) : super(typeCti)
}