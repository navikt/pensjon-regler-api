package no.nav.pensjon.regler.domain.vedtak;

import no.nav.pensjon.regler.domain.kode.VilkarOppfyltUTCti;

/**
 * @author Magnus Bakken (Accenture), PK-10597, PKPYTON-1063
 */
public class Yrkesskade extends AbstraktVilkar {

    private static final long serialVersionUID = 1492253936130233077L;

    public Yrkesskade() {
        super();
    }

    public Yrkesskade(Yrkesskade yrkesskade) {
        super(yrkesskade);
    }

    public Yrkesskade(VilkarOppfyltUTCti resultat) {
        super(resultat);
    }

    public AbstraktVilkar dypKopi(AbstraktVilkar abs) {
        Yrkesskade fm = null;
        if(abs.getClass() == Yrkesskade.class) {
            fm = new Yrkesskade((Yrkesskade) abs);
        }
        return fm;
    }
}
