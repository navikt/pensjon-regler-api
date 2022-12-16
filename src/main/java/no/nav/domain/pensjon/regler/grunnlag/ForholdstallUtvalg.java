package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ForholdstallUtvalg implements Serializable {


    private double ft;
    private List<Forholdstall> forholdstallListe = new ArrayList<Forholdstall>();


}
