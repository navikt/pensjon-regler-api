package no.nav.pensjon.regler.domain.kode

class KravVelgTypeCti : TypeCti {
    /**
     * Kode som angir detaljering av kravet.
     * Se K_KRAV_VELG_T
     */
    var hovedKravlinje = false

    constructor(kravVelgTypeCti: KravVelgTypeCti) : super(kravVelgTypeCti) {
        hovedKravlinje = kravVelgTypeCti.hovedKravlinje
    }

    constructor() : super()
    constructor(kode: String?) : super(kode)
}