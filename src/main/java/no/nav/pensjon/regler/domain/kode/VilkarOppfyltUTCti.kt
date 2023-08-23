package no.nav.pensjon.regler.domain.kode

/**
 * Beskriver hvorvidt saksbehandler mener vilkår er oppfylt.
 */
class VilkarOppfyltUTCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(vilkarOppfyltUTCti: VilkarOppfyltUTCti) : super(vilkarOppfyltUTCti)
}