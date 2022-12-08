package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.EksportUnntakCti;
import no.nav.domain.pensjon.regler.kode.InngangUnntakCti;

import java.io.Serializable;

public class Unntak implements Serializable {

    

    /**
     * Angir om personen har unntak eller ikke.
     */
    boolean unntak;

    /**
     * Angir type unntak.
     */
    InngangUnntakCti unntakType;

    /**
     * Unntak fra eksportforbud.
     */
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
