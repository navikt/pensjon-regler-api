package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.BeholdningsTypeCti;

public class AfpOpptjening extends Beholdning {

    public AfpOpptjening() {
        super();
        beholdningsType = new BeholdningsTypeCti("AFP");
    }

}
