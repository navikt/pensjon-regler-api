package no.nav.pensjon.regler.domain.grunnlag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ForholdstallUtvalg implements Serializable {
    private static final long serialVersionUID = 3264788693720512852L;

    private double ft;
    private double PREG_ft67soker;
    private double PREG_ft67virk;
    private double PREG_reguleringsfaktor;

    private List<Forholdstall> forholdstallListe = new ArrayList<Forholdstall>();

    public ForholdstallUtvalg() {
    }

    public ForholdstallUtvalg(double ft, List<Forholdstall> forholdstallListe) {
        super();
        this.ft = ft;
        this.forholdstallListe = forholdstallListe;
    }

    public ForholdstallUtvalg(ForholdstallUtvalg fu) {
        ft = fu.ft;
        /**
         * PREG variable
         */
        PREG_ft67soker = fu.PREG_ft67soker;
        PREG_ft67virk = fu.PREG_ft67virk;
        PREG_reguleringsfaktor = fu.PREG_reguleringsfaktor;

        if (fu.forholdstallListe != null) {
            for (Forholdstall forholdstall : fu.forholdstallListe) {
                forholdstallListe.add(new Forholdstall(forholdstall));
            }
        }
    }

    public double getFt() {
        return ft;
    }

    public double getPREG_ft67virk() {
        return PREG_ft67virk;
    }

    public double getPREG_ft67soker() {
        return PREG_ft67soker;
    }

    public double getPREG_reguleringsfaktor() {
        return PREG_reguleringsfaktor;
    }

    public void setPREG_reguleringsfaktor(double reguleringsfaktor) {
        PREG_reguleringsfaktor = reguleringsfaktor;
    }

    public void setFt(double ft) {
        this.ft = ft;
    }

    /**
     * @deprecated
     * @return
     */
    @Deprecated
    public Forholdstall[] retrieveSortedForholdstallListeAsArray() {
        Collections.sort(forholdstallListe);
        return forholdstallListe.toArray(new Forholdstall[0]);
    }

    /**
     * Read only property for forholdstallListe as sorted array.
     * 
     * @return array of Forholdstall
     */
    public Forholdstall[] getSortedForholdstallListeAsArray() {
        if (forholdstallListe != null) {
            Collections.sort(forholdstallListe);
            return forholdstallListe.toArray(new Forholdstall[forholdstallListe.size()]);
        } else {
            return new Forholdstall[0];
        }
    }

    /**
     * @deprecated
     * @return
     */
    @Deprecated
    public Double[] retrieveSortedForholdstallListeAsDoubleArray() {
        Collections.sort(forholdstallListe);
        ArrayList<Double> forholdstallDouble = new ArrayList<Double>();
        for (Forholdstall ft : forholdstallListe) {
            forholdstallDouble.add(new Double(ft.getForholdstall()));
        }
        return forholdstallDouble.toArray(new Double[0]);
    }

    /**
     * Read only property for forholdstallListe as sorted array of double.
     * 
     * @return array of Double
     */
    public Double[] getSortedForholdstallListeAsDoubleArray() {
        Collections.sort(forholdstallListe);
        ArrayList<Double> forholdstallDouble = new ArrayList<Double>();
        for (Forholdstall ft : forholdstallListe) {
            forholdstallDouble.add(new Double(ft.getForholdstall()));
        }
        return forholdstallDouble.toArray(new Double[forholdstallDouble.size()]);
    }

    public List<Forholdstall> getForholdstallListe() {
        return forholdstallListe;
    }

    public void setForholdstallListe(List<Forholdstall> forholdstallListe) {
        this.forholdstallListe = forholdstallListe;
    }

    public void setPREG_ft67soker(double preg_ft67soker) {
        PREG_ft67soker = preg_ft67soker;
    }

    public void setPREG_ft67virk(double preg_ft67virk) {
        PREG_ft67virk = preg_ft67virk;
    }

}
