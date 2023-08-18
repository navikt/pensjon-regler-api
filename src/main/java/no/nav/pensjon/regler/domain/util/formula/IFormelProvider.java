package no.nav.pensjon.regler.domain.util.formula;

import java.util.HashMap;

public interface IFormelProvider {
    HashMap<String, Formel> getFormelMap();

    String getFormelPrefix();
}
