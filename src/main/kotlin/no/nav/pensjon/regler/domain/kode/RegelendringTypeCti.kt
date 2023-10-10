package no.nav.pensjon.regler.domain.kode

/**
 * Dataholder for type regelendring til tjenesten BEF2001 Identifiser Regelendringer.
 * Er per tidspunkt for utvikling av tjenesten ikke en del av det offisielle kodeverket, kun en utility-klasse.
 */
class RegelendringTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(regelendringTypeCti: RegelendringTypeCti) : super(regelendringTypeCti)
}