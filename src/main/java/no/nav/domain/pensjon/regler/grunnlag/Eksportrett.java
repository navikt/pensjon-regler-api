package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.EksportlandCti;

import java.io.Serializable;

public class Eksportrett implements Serializable {



    /**
     * Angir om personen har eksportrett eller ikke.
     */
    private boolean eksportrett;

    /**
     * Angir land personen bor i.
     */
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
