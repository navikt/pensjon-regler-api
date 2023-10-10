package no.nav.pensjon.regler.domain.kode

class MinstepenNivaCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(minstepensjonTypeCti: MinstepenNivaCti) : super(minstepensjonTypeCti)
}