package no.nav.pensjon.regler.domain.kode

class KravVelgTypeCti : TypeCti {
    /**
     * Kode som angir detaljering av kravet.
     * Se K_KRAV_VELG_T
     */
    var isHovedKravlinje = false

    constructor(kravVelgTypeCti: KravVelgTypeCti) : super(kravVelgTypeCti) {
        isHovedKravlinje = kravVelgTypeCti.isHovedKravlinje
    }

    constructor() : super()
    constructor(kode: String?) : super(kode)
}