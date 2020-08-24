package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DelingstallUtvalg implements Serializable {
    private static final long serialVersionUID = 4727993386155657137L;

    private double dt;
    private double PREG_dt67soker;
    private double PREG_dt67virk;
    private List<Delingstall> delingstallListe = new ArrayList<Delingstall>();

    public DelingstallUtvalg() {
    }

    public DelingstallUtvalg(double dt, List<Delingstall> delingstallListe) {
        super();
        this.dt = dt;
        this.delingstallListe = delingstallListe;
    }

    public DelingstallUtvalg(DelingstallUtvalg du) {
        dt = du.dt;
        PREG_dt67soker = du.PREG_dt67soker;
        PREG_dt67virk = du.PREG_dt67virk;
        if (du.delingstallListe != null) {
            for (Delingstall delingstall : du.delingstallListe) {
                delingstallListe.add(new Delingstall(delingstall));
            }
        }
    }

    public double getDt() {
        return dt;
    }

    public void setDt(double dt) {
        this.dt = dt;
    }

    public double getPREG_dt67soker() {
        return PREG_dt67soker;
    }

    public void setPREG_dt67soker(double preg_dt67soker) {
        PREG_dt67soker = preg_dt67soker;
    }

    public double getPREG_dt67virk() {
        return PREG_dt67virk;
    }

    public void setPREG_dt67virk(double preg_dt67virk) {
        PREG_dt67virk = preg_dt67virk;
    }

    public List<Delingstall> getDelingstallListe() {
        return delingstallListe;
    }

    public void setDelingstallListe(List<Delingstall> delingstallListe) {
        this.delingstallListe = delingstallListe;
    }

    /**
     * @deprecated
     * @return
     */
    @Deprecated
    public Delingstall[] retrieveSortedDelingstallListeAsArray() {
        Collections.sort(delingstallListe);
        return delingstallListe.toArray(new Delingstall[0]);
    }

    /**
     * Read only property for delingstallListe as sorted array.
     * 
     * @return array of Delingstall
     */
    public Delingstall[] getSortedDelingstallListeAsArray() {
        if (delingstallListe != null) {
            Collections.sort(delingstallListe);
            return delingstallListe.toArray(new Delingstall[delingstallListe.size()]);
        } else {
            return new Delingstall[0];
        }
    }

}
