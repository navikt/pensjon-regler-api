package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.Pakkseddel;

import java.io.Serializable;

public class PersonPensjonsbeholdning implements Serializable {


    private Pensjonsbeholdning pensjonsbeholdning;
    private Pakkseddel pakkseddel;
    private String fodselsnummer;

}
