package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.BeholdningsTypeCti;

public class Pensjonsbeholdning extends Beholdning {

    public Pensjonsbeholdning() {
        super();
        beholdningsType = new BeholdningsTypeCti("PEN_B");
    }

}
