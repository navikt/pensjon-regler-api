package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;
import java.util.*;

public class Forstegangstjeneste implements Serializable {
    private static final long serialVersionUID = -4440730766186673269L;

    private List<ForstegangstjenestePeriode> periodeListe;

    public Forstegangstjeneste() {
        super();
        periodeListe = new ArrayList<ForstegangstjenestePeriode>();
    }

    public Forstegangstjeneste(Forstegangstjeneste f) {
        this();
        if (f.periodeListe != null) {
            for (ForstegangstjenestePeriode p : f.periodeListe) {
                periodeListe.add(new ForstegangstjenestePeriode(p));
            }
        }
    }

    public List<ForstegangstjenestePeriode> getPeriodeListe() {
        return periodeListe;
    }

    public void setPeriodeListe(List<ForstegangstjenestePeriode> periodeListe) {
        this.periodeListe = periodeListe;
    }

    /**
     * Read only property for periodeListe as array.
     * 
     * @return array of ForstegangstjenestePeriode
     */
    public ForstegangstjenestePeriode[] getPeriodeListeAsArray() {
        return periodeListe != null ? periodeListe.toArray(new ForstegangstjenestePeriode[periodeListe.size()]) : new ForstegangstjenestePeriode[0];
    }

    public ForstegangstjenestePeriode[] getSortertPeriodeListeAsArray() {
        ArrayList<ForstegangstjenestePeriode> sortertPeriodeListe = new ArrayList<ForstegangstjenestePeriode>(periodeListe);
        Collections.sort(sortertPeriodeListe);
        return sortertPeriodeListe.toArray(new ForstegangstjenestePeriode[sortertPeriodeListe.size()]);
    }

    public Integer[] getForstegangstjenesteAr() {
        Set<Integer> arSet = new HashSet<Integer>();
        Calendar cal = Calendar.getInstance();
        for (ForstegangstjenestePeriode periode : periodeListe) {
            int start≈r = 0, slutt≈r = 0;
            if (periode.getFomDato() != null){
                cal.setTime(periode.getFomDato());
                start≈r = cal.get(Calendar.YEAR);
            }
            if (periode.getTomDato() != null){
                cal.setTime(periode.getTomDato());
                slutt≈r = cal.get(Calendar.YEAR);
            }
            for (int Âr = start≈r; Âr <= slutt≈r; Âr++) {
                arSet.add(Âr);
            }
        }
        return arSet.toArray(new Integer[arSet.size()]);
    }
}
