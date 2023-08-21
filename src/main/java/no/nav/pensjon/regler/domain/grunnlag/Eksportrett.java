package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.GuiPrompt;
import no.nav.pensjon.regler.domain.kode.EksportlandCti;

import java.io.Serializable;

public class Eksportrett implements Serializable {

    private static final long serialVersionUID = 8850216059188972329L;

    /**
     * Angir om personen har eksportrett eller ikke.
     */
    @GuiPrompt(prompt = "Eksportrett")
    private boolean eksportrett;

    /**
     * Angir land personen bor i.
     */
    @GuiPrompt(prompt = "Bostedsland")
    EksportlandCti bostedsland;

    /**
     * Copy Constructor
     * 
     * @param eksportrett a <code>Eksportrett</code> object
     */
    public Eksportrett(Eksportrett eksportrett) {
        this.eksportrett = eksportrett.eksportrett;
        if (eksportrett.bostedsland != null) {
            bostedsland = new EksportlandCti(eksportrett.bostedsland);
        }
    }

    public Eksportrett() {
        super();
    }

    public Eksportrett(boolean eksportrett, EksportlandCti bostedsland) {
        super();
        this.eksportrett = eksportrett;
        this.bostedsland = bostedsland;
    }

    public EksportlandCti getBostedsland() {
        return bostedsland;
    }

    public void setBostedsland(EksportlandCti bostedsland) {
        this.bostedsland = bostedsland;
    }

    public boolean isEksportrett() {
        return eksportrett;
    }

    public void setEksportrett(boolean eksportrett) {
        this.eksportrett = eksportrett;
    }

}
