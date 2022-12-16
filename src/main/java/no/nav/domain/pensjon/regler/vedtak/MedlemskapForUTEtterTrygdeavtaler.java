package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.grunnlag.OppfyltVedSammenlegging;

/**
 * @author Magnus Bakken (Accenture) PK-9695, PKPYTON-923
 */
public class MedlemskapForUTEtterTrygdeavtaler extends AbstraktVilkar{



    /**
     * Inneholder informasjon om bruker har inngang gjennom sammenlegging av trygdetid i avtaleland og Norge.
     * Registreres manuelt av saksbehandler.
     */
    private OppfyltVedSammenlegging oppfyltVedSammenlegging;

    /**
     * Inneholder informasjon om bruker har inngang gjennom sammenlegging av trygdetid i avtaleland og Norge på minst 5 år.
     * Registreres manuelt av saksbehandler.
     */
    private OppfyltVedSammenlegging oppfyltVedSammenleggingFemAr;

}
