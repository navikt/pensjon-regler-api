package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.BarnetilleggVilkarTypeCti;

import java.io.Serializable;

/**
 * Representerer et vilkår for barnetillegg på uføretrygd. Saksbehandler gjør en vurdering av enkeltvilkår.
 * 
 * @author Lars Hartvigsen (Decisive) - PK-20946
 */
public class BarnetilleggVilkar implements Serializable {

    private BarnetilleggVilkarTypeCti btVilkarType;
    private boolean vurdertTil;


}
