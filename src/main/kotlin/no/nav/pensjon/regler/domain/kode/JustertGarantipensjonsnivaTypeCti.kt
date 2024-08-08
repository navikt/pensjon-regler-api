package no.nav.pensjon.regler.domain.kode

// TODO Klassen finnes i Pesys, men ikke i bruk av Regler. Kan denne deprecates?
class JustertGarantipensjonsnivaTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(t: JustertGarantipensjonsnivaTypeCti) : super(t)
}