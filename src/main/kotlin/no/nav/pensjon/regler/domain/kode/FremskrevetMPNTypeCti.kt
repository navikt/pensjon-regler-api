package no.nav.pensjon.regler.domain.kode

class FremskrevetMPNTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(fremskrevetMPNTypeCti: FremskrevetMPNTypeCti) : super(fremskrevetMPNTypeCti)
}