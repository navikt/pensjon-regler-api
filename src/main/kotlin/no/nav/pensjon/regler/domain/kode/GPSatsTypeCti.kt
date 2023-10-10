package no.nav.pensjon.regler.domain.kode

class GPSatsTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(grunnlagsrolleCti: GPSatsTypeCti) : super(grunnlagsrolleCti)
}