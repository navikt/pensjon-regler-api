package no.nav.pensjon.regler.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Beskriver resultatet for en g-omregning.
 * Hvert element i resultatlisten fra en g-omregning har en instans av dette objektet.
 * 
 * @author utvikler
 */
public class BatchStatus implements Serializable {
    private static final long serialVersionUID = 1314218851734363223L;

    private boolean statusOK;

    /**
     * Liste av merknader. Beskriver hvorfor g-omregningen feilet for det gjeldende objektet.
     * Dersom statusOK er true finnes ingen merknader.
     */
    protected List<Merknad> merknadListe;

    public BatchStatus(boolean statusOK) {
        this();
        this.statusOK = statusOK;
    }

    public BatchStatus() {
        super();
        merknadListe = new ArrayList<Merknad>();
    }

    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    /**
     * @deprecated
     * @return
     */
    @Deprecated
    public Merknad[] retrieveMerknadListe() {
        return merknadListe.toArray(new Merknad[0]);
    }

    public void setMerknadListe(List<Merknad> merknadListe) {
        this.merknadListe = merknadListe;
    }

    public boolean isStatusOK() {
        return statusOK;
    }

    public void setStatusOK(boolean statusOK) {
        this.statusOK = statusOK;
    }
}
