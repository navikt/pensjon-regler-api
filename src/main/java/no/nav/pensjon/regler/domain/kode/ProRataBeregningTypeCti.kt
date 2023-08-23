package no.nav.pensjon.regler.domain.kode

class ProRataBeregningTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(proRataBeregningTypeCti: ProRataBeregningTypeCti) : super(proRataBeregningTypeCti)
}