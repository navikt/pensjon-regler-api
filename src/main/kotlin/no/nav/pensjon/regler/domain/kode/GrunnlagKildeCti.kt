package no.nav.pensjon.regler.domain.kode

class GrunnlagKildeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(grunnlagKildeCti: GrunnlagKildeCti) : super(grunnlagKildeCti)
}