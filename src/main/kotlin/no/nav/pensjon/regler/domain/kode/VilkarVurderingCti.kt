package no.nav.pensjon.regler.domain.kode

/**
 * Beskriver hvilken vurdering saksbehandler har lagt til grunn for resultatvurderingen.
 * Se K_VILKAR_VURD_T.
 */
class VilkarVurderingCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(vilkarVurderingCti: VilkarVurderingCti) : super(vilkarVurderingCti)
}