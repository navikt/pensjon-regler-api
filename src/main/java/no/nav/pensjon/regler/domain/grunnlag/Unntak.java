package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.GuiPrompt;
import no.nav.pensjon.regler.domain.kode.EksportUnntakCti;
import no.nav.pensjon.regler.domain.kode.InngangUnntakCti;

import java.io.Serializable;

public class Unntak implements Serializable {

    private static final long serialVersionUID = 5944758987735111664L;

    /**
     * Angir om personen har unntak eller ikke.
     */
    @GuiPrompt(prompt = "Unntak")
    boolean unntak;

    /**
     * Angir type unntak.
     */
    @GuiPrompt(prompt = "Unntaktype")
    InngangUnntakCti unntakType;

    /**
     * Unntak fra eksportforbud.
     */
    @GuiPrompt(prompt = "Unntak fra eksportforbud")
    EksportUnntakCti eksportUnntak;

    /**
     * Copy Constructor
     * 
     * @param unntak a <code>Unntak</code> object
     */
    public Unntak(Unntak unntak) {
        this.unntak = unntak.unntak;
        if (unntak.unntakType != null) {
            unntakType = new InngangUnntakCti(unntak.unntakType);
        }
        if (unntak.eksportUnntak != null) {
            eksportUnntak = new EksportUnntakCti(unntak.eksportUnntak);
        }
    }

    public Unntak() {
        super();
    }

    public Unntak(boolean unntak, InngangUnntakCti unntakType) {
        super();
        this.unntak = unntak;
        this.unntakType = unntakType;
    }

    public boolean isUnntak() {
        return unntak;
    }

    public void setUnntak(boolean unntak) {
        this.unntak = unntak;
    }

    public InngangUnntakCti getUnntakType() {
        return unntakType;
    }

    public void setUnntakType(InngangUnntakCti unntakType) {
        this.unntakType = unntakType;
    }

    public EksportUnntakCti getEksportUnntak() {
        return eksportUnntak;
    }

    public void setEksportUnntak(EksportUnntakCti eksportUnntak) {
        this.eksportUnntak = eksportUnntak;
    }

}
