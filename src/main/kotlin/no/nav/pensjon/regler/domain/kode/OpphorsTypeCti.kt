package no.nav.pensjon.regler.domain.kode

@Deprecated("Ikke i bruk")
class OpphorsTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(opphorsTypeCti: OpphorsTypeCti) : super(opphorsTypeCti)
}