package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.kode.BeholdningsTypeCti;

public class Pensjonsbeholdning extends Beholdning {
    private static final long serialVersionUID = 7664743814937303739L;

    public Pensjonsbeholdning() {
        super();
        beholdningsType = new BeholdningsTypeCti("PEN_B");
    }

    public Pensjonsbeholdning(Pensjonsbeholdning pb) {
        super(pb);
    }
}
