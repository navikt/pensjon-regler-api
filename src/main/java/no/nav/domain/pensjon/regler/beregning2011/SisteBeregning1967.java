package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Grunnpensjon;

/**
 * Håndterer "gammel" beregning
 */
public class SisteBeregning1967 extends SisteBeregning {

    private Grunnpensjon gp;
    private Grunnpensjon gpKapittel3;

    /*
     * CR????? - Nytt felt for å håndtere uavkortet, men pensjonsregulert grunnpensjon i de tilfeller
     * pensjonen er avkortet til 70% av tpi ved revurdering av AFP
     */
    private Grunnpensjon gpAfpPensjonsregulert;

    public SisteBeregning1967() {
        super();
    }

    public SisteBeregning1967(SisteBeregning1967 sb) {
        super(sb);
        if (sb.gp != null) {
            gp = new Grunnpensjon(sb.gp);
        }
        if (sb.gpKapittel3 != null) {
            gpKapittel3 = new Grunnpensjon(sb.gpKapittel3);
        }

        if (sb.gpAfpPensjonsregulert != null) {
            gpAfpPensjonsregulert = new Grunnpensjon(sb.gpAfpPensjonsregulert);
        }
    }

    public Grunnpensjon getGp() {
        return gp;
    }

    public void setGp(Grunnpensjon gp) {
        this.gp = gp;
    }

    public Grunnpensjon getGpKapittel3() {
        return gpKapittel3;
    }

    public void setGpKapittel3(Grunnpensjon gpKapittel3) {
        this.gpKapittel3 = gpKapittel3;
    }

    public Grunnpensjon getGpAfpPensjonsregulert() {
        return gpAfpPensjonsregulert;
    }

    public void setGpAfpPensjonsregulert(Grunnpensjon gpAfpPensjonsregulert) {
        this.gpAfpPensjonsregulert = gpAfpPensjonsregulert;
    }
}
