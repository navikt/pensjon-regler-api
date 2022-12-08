package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.kode.VilkarOppfyltUTCti;

/**
 * @author Magnus Bakken (Accenture), PK-10597, PKPYTON-1063
 */
public class Yrkesskade extends AbstraktVilkar {

    

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
