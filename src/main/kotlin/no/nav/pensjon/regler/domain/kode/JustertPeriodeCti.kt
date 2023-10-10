package no.nav.pensjon.regler.domain.kode

/**
 * Tilsvarer kodeverktype K_JUST_PERIODE.
 */
class JustertPeriodeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(justertPeriodeCti: JustertPeriodeCti) : super(justertPeriodeCti)
}