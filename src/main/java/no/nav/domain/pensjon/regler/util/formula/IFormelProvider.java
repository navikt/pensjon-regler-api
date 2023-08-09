package no.nav.domain.pensjon.regler.util.formula;

import java.util.HashMap;

public interface IFormelProvider {
    HashMap<String, Formel> getFormelMap();

    String getFormelPrefix();
}
