package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.grunnlag.Eksportforbud;
import no.nav.domain.pensjon.regler.grunnlag.Unntak;

/**
 * @author Magnus Bakken (Accenture), PK-10597, PKPYTON-1063
 * @author Steinar Hjellvik Decisive,  PK-6559
 */
public class FortsattMedlemskap extends AbstraktVilkar {


    /**
     * Fortsatt medlem i folketrygden
     */
    private Boolean fortsattMedlemFT;

    /**
     * Brukeren har minst 20 års botid i Norge
     */
    private Boolean minstTyveArBotidNorge;

    /**
     * Opptjent rett til tilleggspensjon etter folketrygdloven
     */
    private Boolean opptjentRettTilTPEtterFT;

    /**
     * Eksportforbud
     */
    private Eksportforbud eksportforbud;

    /**
     * Fri eksport fordi uførhet skyldes yrkesskade
     */
    private Boolean friEksportPgaYrkesskade;

    /**
     * Innvilget garantert tilleggspensjon til ung ufør/død skal eksporteres
     */
    private Boolean innvilgetGarantertTP;

    /**
     * Eksportrett garantert TP
     */
    private Unntak eksportrettGarantertTP;

}
