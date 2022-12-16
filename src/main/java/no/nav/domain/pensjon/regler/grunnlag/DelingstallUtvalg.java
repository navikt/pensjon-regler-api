package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DelingstallUtvalg implements Serializable {


    private double dt;
    private double PREG_dt67soker;
    private double PREG_dt67virk;
    private List<Delingstall> delingstallListe = new ArrayList<Delingstall>();
}
