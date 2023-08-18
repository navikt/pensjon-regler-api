package no.nav.pensjon.regler.domain.vedtak;

import no.nav.pensjon.regler.domain.kode.VilkarOppfyltUTCti;

/**
 * @author Magnus Bakken (Accenture), PK-10597, PKPYTON-1063
 */
public class UngUfor extends AbstraktVilkar {

    private static final long serialVersionUID = -6955449536852020254L;

    public UngUfor() {
        super();
    }

    public UngUfor(VilkarOppfyltUTCti resultat) {
        super(resultat);
    }

    public UngUfor(UngUfor ungUfor) {
        super(ungUfor);
    }

    public AbstraktVilkar dypKopi(AbstraktVilkar abs) {
        UngUfor uu = null;
        if(abs.getClass() == UngUfor.class) {
            uu = new UngUfor((UngUfor) abs);
        }
        return uu;
    }
}
