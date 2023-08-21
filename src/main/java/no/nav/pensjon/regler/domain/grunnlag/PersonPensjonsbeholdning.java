package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.Pakkseddel;

import java.io.Serializable;

public class PersonPensjonsbeholdning implements Serializable {
    private static final long serialVersionUID = 3343235974683290934L;

    private Pensjonsbeholdning pensjonsbeholdning;
    private Pakkseddel pakkseddel;
    private String fodselsnummer;

    public PersonPensjonsbeholdning() {
        super();
    }

    public PersonPensjonsbeholdning(PersonPensjonsbeholdning o) {
        this();
        if (o.pensjonsbeholdning != null) {
            pensjonsbeholdning = new Pensjonsbeholdning(o.pensjonsbeholdning);
        }
        if (o.pakkseddel != null) {
            pakkseddel = new Pakkseddel(o.pakkseddel);
        }
        fodselsnummer = o.fodselsnummer;
    }

    public Pensjonsbeholdning getPensjonsbeholdning() {
        return pensjonsbeholdning;
    }

    public void setPensjonsbeholdning(Pensjonsbeholdning pensjonsbeholdning) {
        this.pensjonsbeholdning = pensjonsbeholdning;
    }

    public Pakkseddel getPakkseddel() {
        return pakkseddel;
    }

    public void setPakkseddel(Pakkseddel pakkseddel) {
        this.pakkseddel = pakkseddel;
    }

    public String getFodselsnummer() {
        return fodselsnummer;
    }

    public void setFodselsnummer(String fodselsnummer) {
        this.fodselsnummer = fodselsnummer;
    }

}
