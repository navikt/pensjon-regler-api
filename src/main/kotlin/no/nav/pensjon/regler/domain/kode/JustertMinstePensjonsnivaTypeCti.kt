package no.nav.pensjon.regler.domain.kode

class JustertMinstePensjonsnivaTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(fremskrevetMPNTypeCti: JustertMinstePensjonsnivaTypeCti) : super(fremskrevetMPNTypeCti)
}