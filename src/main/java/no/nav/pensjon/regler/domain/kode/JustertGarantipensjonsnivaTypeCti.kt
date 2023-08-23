package no.nav.pensjon.regler.domain.kode

class JustertGarantipensjonsnivaTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(t: JustertGarantipensjonsnivaTypeCti) : super(t)
}