package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.kode.VilkarOppfyltUTCti;

import java.io.Serializable;

/**
 * @author Magnus Bakken (Accenture), PK-10597, PKPYTON-1063
 */
public abstract class AbstraktVilkar implements Serializable {
    private VilkarOppfyltUTCti resultat;

}
