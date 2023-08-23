package no.nav.pensjon.regler.domain.kode

class GrunnlagsrolleCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(grunnlagsrolleCti: GrunnlagsrolleCti) : super(grunnlagsrolleCti)
}