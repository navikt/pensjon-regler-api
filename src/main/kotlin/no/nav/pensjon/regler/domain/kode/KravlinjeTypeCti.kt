package no.nav.pensjon.regler.domain.kode

class KravlinjeTypeCti : TypeCti {
    /**
     * Denne er true dersom kravet er en hovedytelse (AP, UP osv).Default false.
     */
    var hovedKravlinje = false

    constructor(kravlinjeTypeCti: KravlinjeTypeCti) : super(kravlinjeTypeCti) {
        hovedKravlinje = kravlinjeTypeCti.hovedKravlinje
    }

    constructor() : super()
    constructor(kode: String?) : super(kode)
}