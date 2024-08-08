package no.nav.pensjon.regler.domain.kode

@Deprecated("Ikke i bruk")
class BeregningsnivaCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(beregningsnivaCti: BeregningsnivaCti) : super(beregningsnivaCti)
}