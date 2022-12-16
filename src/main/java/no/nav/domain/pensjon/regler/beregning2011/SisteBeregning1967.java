package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Grunnpensjon;

/**
 * H�ndterer "gammel" beregning
 */
public class SisteBeregning1967 extends SisteBeregning {

    private Grunnpensjon gp;
    private Grunnpensjon gpKapittel3;

    /*
     * CR????? - Nytt felt for � h�ndtere uavkortet, men pensjonsregulert grunnpensjon i de tilfeller
     * pensjonen er avkortet til 70% av tpi ved revurdering av AFP
     */
    private Grunnpensjon gpAfpPensjonsregulert;

}
