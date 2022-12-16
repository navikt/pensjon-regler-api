package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.grunnlag.Eksportrett;

/**
 * @author Magnus Bakken (Accenture) PK-9695
 */
public class RettTilEksportEtterTrygdeavtaler extends AbstraktVilkar {


    /**
     * Eksportrett etter E�S forordning
     */
    private Eksportrett eksportrettEtterEOSForordning;

    /**
     * Eksportrett etter trygdeavtaler E�S
     */
    private Eksportrett eksportrettEtterTrygdeavtalerEOS;

    /**
     * Eksportrett etter andre trygdeavtaler.
     */
    private Eksportrett eksportrettEtterAndreTrygdeavtaler;
}
