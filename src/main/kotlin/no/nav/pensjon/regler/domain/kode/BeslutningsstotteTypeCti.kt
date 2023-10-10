package no.nav.pensjon.regler.domain.kode

class BeslutningsstotteTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(beslutningsstotteTypeCti: BeslutningsstotteTypeCti) : super(beslutningsstotteTypeCti)
}