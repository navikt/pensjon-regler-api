package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.kode.FtDtArsakCti;

import java.io.Serializable;

/**
 * @author Lars Hartvigsen (Decisive), PK-9169
 * @author Magnus Bakken (Accenture), PK-9169
 */
public class FtDtArsak implements Serializable {

    private static final long serialVersionUID = -3357256277849829561L;

    // Angir �rsaker til at delingstall eller forholdstall er benyttet i beregninger
    private FtDtArsakCti ftDtArsak;

    public FtDtArsak() {
        super();
    }

    public FtDtArsak(FtDtArsak arsak) {
        if (arsak.getFtDtArsak() != null) {
            ftDtArsak = new FtDtArsakCti(arsak.getFtDtArsak());
        }
    }

    public FtDtArsakCti getFtDtArsak() {
        return ftDtArsak;
    }

    public void setFtDtArsak(FtDtArsakCti ftDtArsak) {
        this.ftDtArsak = ftDtArsak;
    }
}
