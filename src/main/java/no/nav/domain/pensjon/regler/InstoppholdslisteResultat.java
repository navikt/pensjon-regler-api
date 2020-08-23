package no.nav.domain.pensjon.regler;

import no.nav.domain.pensjon.regler.grunnlag.InstOpphPeriodegrunnlag;

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

    /**
     * Read only property for instOpphPeriodegrunnlagListe as array
     * 
     * @return array of InstOpphPeriodegrunnlag
     */
    public InstOpphPeriodegrunnlag[] getInstOpphPeriodegrunnlagListeAsArray() {
        return instOpphPeriodegrunnlagListe != null ? instOpphPeriodegrunnlagListe.toArray(new InstOpphPeriodegrunnlag[instOpphPeriodegrunnlagListe.size()])
                : new InstOpphPeriodegrunnlag[0];
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
