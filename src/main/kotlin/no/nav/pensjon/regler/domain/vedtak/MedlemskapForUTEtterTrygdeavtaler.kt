package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.grunnlag.OppfyltVedSammenlegging

class MedlemskapForUTEtterTrygdeavtaler : AbstraktVilkar() {
    /**
     * Inneholder informasjon om bruker har inngang gjennom sammenlegging av trygdetid i avtaleland og Norge.
     * Registreres manuelt av saksbehandler.
     */
    var oppfyltVedSammenlegging: OppfyltVedSammenlegging? = null

    /**
     * Inneholder informasjon om bruker har inngang gjennom sammenlegging av trygdetid i avtaleland og Norge på minst 5 år.
     * Registreres manuelt av saksbehandler.
     */
    var oppfyltVedSammenleggingFemAr: OppfyltVedSammenlegging? = null

}