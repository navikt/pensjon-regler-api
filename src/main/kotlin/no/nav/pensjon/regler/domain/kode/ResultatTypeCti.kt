package no.nav.pensjon.regler.domain.kode

class ResultatTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(resultatTypeCti: ResultatTypeCti) : super(resultatTypeCti)
}