package no.nav.pensjon.regler.domain.simulering;

import no.nav.pensjon.regler.domain.Merknad;
import no.nav.pensjon.regler.domain.beregning.Beregning;
import no.nav.pensjon.regler.domain.kode.VilkarsvedtakResultatCti;
import no.nav.pensjon.regler.domain.util.ToStringUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Hele resultatet av en simulering.
 */
public class Simuleringsresultat implements Serializable {

    private static final long serialVersionUID = 2984899935390358851L;

    /**
     * Status på vedtaket
     */
    private VilkarsvedtakResultatCti status;

    /**
     * Beregningen
     */
    private Beregning beregning;

    /**
     * Virkningstidspunkt
     */
    private Date virk;

    /**
     * Liste av merknader
     */
    private List<Merknad> merknadListe;

    public Simuleringsresultat() {
        merknadListe = new ArrayList<Merknad>();
    }

    public Beregning getBeregning() {
        return beregning;
    }

    public void setBeregning(Beregning beregning) {
        this.beregning = beregning;
    }

    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    public void setMerknadListe(List<Merknad> merknad) {
        merknadListe = merknad;
    }

    /**
     * @deprecated
     * @return
     */
    @Deprecated
    public Merknad[] retrieveMerknadListeAsArray() {
        return merknadListe.toArray(new Merknad[0]);
    }

    /**
     * Read only property for merknadListe as array.
     * 
     * @return array of Merknad
     */
    public Merknad[] getMerknadListeAsArray() {
        return merknadListe != null ? merknadListe.toArray(new Merknad[merknadListe.size()]) : new Merknad[0];
    }

    public VilkarsvedtakResultatCti getStatus() {
        return status;
    }

    public void setStatus(VilkarsvedtakResultatCti status) {
        this.status = status;
    }

    public Date getVirk() {
        return virk;
    }

    public void setVirk(Date virk) {
        this.virk = virk;
    }

    /*
     * Generic version. Uses reflection to print field names and values.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }
}
