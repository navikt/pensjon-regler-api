package no.nav.pensjon.regler.domain.kode

class DagpengeTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(t: DagpengeTypeCti) : super(t)

}