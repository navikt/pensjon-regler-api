package no.nav.pensjon.regler.domain.kode

/**
 * Angir søsken type. Se arkfane K_SOSKEN_T
 * pr sept 2007 så tabellen slik ut
 * HEL Helsøsken
 * HALV Halvsøsken
 */
class SoskenTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(soskenTypeCti: SoskenTypeCti) : super(soskenTypeCti)
}