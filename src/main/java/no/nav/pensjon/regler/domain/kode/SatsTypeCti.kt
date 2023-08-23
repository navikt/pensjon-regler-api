package no.nav.pensjon.regler.domain.kode

import java.io.Serializable

class SatsTypeCti : TypeCti, Serializable {
    constructor(typeCti: TypeCti) : super(typeCti)
    constructor()
    constructor(kode: String?) : super(kode)
}