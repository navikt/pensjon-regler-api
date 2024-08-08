package no.nav.pensjon.regler.domain.kode

@Deprecated("Ikke i bruk")
class BarnekullTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(barnekullTypeCti: BarnekullTypeCti) : super(barnekullTypeCti)
}