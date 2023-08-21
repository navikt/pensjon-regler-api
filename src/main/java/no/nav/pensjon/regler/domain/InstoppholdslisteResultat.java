package no.nav.pensjon.regler.domain;

import no.nav.pensjon.regler.domain.grunnlag.InstOpphPeriodegrunnlag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InstoppholdslisteResultat implements Serializable {

    private static final long serialVersionUID = -4822067508455657637L;
    /**
     * Merknaden innholder feilkoden fra regeltjenesten.
     */
    private Merknad merknad;
    /**
     * Returlisten av periodegrunnlagene. Utfylt når merknad er null.
     */
    private List<InstOpphPeriodegrunnlag> instOpphPeriodegrunnlagListe;

    public InstoppholdslisteResultat() {
        super();
        instOpphPeriodegrunnlagListe = new ArrayList<InstOpphPeriodegrunnlag>();
    }

    public InstoppholdslisteResultat(Merknad merknad, List<InstOpphPeriodegrunnlag> instOpphPeriodegrunnlagListe) {
        super();
        this.merknad = merknad;
        this.instOpphPeriodegrunnlagListe = instOpphPeriodegrunnlagListe;
    }

    public List<InstOpphPeriodegrunnlag> getInstOpphPeriodegrunnlagListe() {
        return instOpphPeriodegrunnlagListe;
    }

    public void setInstOpphPeriodegrunnlagListe(List<InstOpphPeriodegrunnlag> instOpphPeriodegrunnlagListe) {
        this.instOpphPeriodegrunnlagListe = instOpphPeriodegrunnlagListe;
    }

    public Merknad getMerknad() {
        return merknad;
    }

    public void setMerknad(Merknad merknad) {
        this.merknad = merknad;
    }
}
