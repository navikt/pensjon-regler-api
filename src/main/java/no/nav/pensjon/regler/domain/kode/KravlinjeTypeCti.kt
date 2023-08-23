package no.nav.pensjon.regler.domain.kode

class KravlinjeTypeCti : TypeCti {
    /**
     * Denne er true dersom kravet er en hovedytelse (AP, UP osv).Default false.
     */
    var isHovedKravlinje = false

    constructor(kravlinjeTypeCti: KravlinjeTypeCti) : super(kravlinjeTypeCti) {
        isHovedKravlinje = kravlinjeTypeCti.isHovedKravlinje
    }

    constructor() : super()
    constructor(kode: String?) : super(kode)
}