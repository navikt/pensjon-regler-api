package no.nav.pensjon.regler.domain.kode

class ResultatKildeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(resultatKildeCti: ResultatKildeCti) : super(resultatKildeCti)
}