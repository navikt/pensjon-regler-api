package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.kode.BeholdningsTypeCti;

public class AfpOpptjening extends Beholdning {
    private static final long serialVersionUID = 7610344948141210936L;

    public AfpOpptjening() {
        super();
        beholdningsType = new BeholdningsTypeCti("AFP");
    }

    public AfpOpptjening(AfpOpptjening aAfpOpptjening) {
        super(aAfpOpptjening);
    }
}
