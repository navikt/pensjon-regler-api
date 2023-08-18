package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.kode.BarnetilleggVilkarTypeCti;

import java.io.Serializable;

/**
 * Representerer et vilk�r for barnetillegg p� uf�retrygd. Saksbehandler gj�r en vurdering av enkeltvilk�r.
 * 
 * @author Lars Hartvigsen (Decisive) - PK-20946
 */
public class BarnetilleggVilkar implements Serializable {
    private static final long serialVersionUID = -8971555764832550652L;
    private BarnetilleggVilkarTypeCti btVilkarType;
    private boolean vurdertTil;

    public BarnetilleggVilkar() {
    }

    public BarnetilleggVilkar(BarnetilleggVilkar b) {
        this.setBtVilkarType(b.getBtVilkarType());
        this.setVurdertTil(b.isVurdertTil());
    }

    public BarnetilleggVilkarTypeCti getBtVilkarType() {
        return btVilkarType;
    }

    public boolean isVurdertTil() {
        return vurdertTil;
    }

    public void setBtVilkarType(BarnetilleggVilkarTypeCti btVilkarType) {
        this.btVilkarType = btVilkarType;
    }

    public void setVurdertTil(boolean vurdertTil) {
        this.vurdertTil = vurdertTil;
    }

}
