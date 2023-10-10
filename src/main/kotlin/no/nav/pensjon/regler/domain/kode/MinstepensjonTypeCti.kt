package no.nav.pensjon.regler.domain.kode

class MinstepensjonTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(minstepensjonTypeCti: MinstepensjonTypeCti) : super(minstepensjonTypeCti)
}