package no.nav.pensjon.regler.domain.kode

/**
 * Angir søsken type. Se arkfane K_SOSKEN_T
 * pr sept 2007 så tabellen slik ut
 * HEL Helsøsken
 * HALV Halvsøsken
 */
// TODO Klassen finnes i Pesys, men ikke i bruk av Regler. Kan denne deprecates?
class SoskenTypeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(soskenTypeCti: SoskenTypeCti) : super(soskenTypeCti)
}