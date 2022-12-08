package no.nav.domain.pensjon.regler.kode;

/**
 * Beskriver hvilken vurdering saksbehandler har lagt til grunn for resultatvurderingen.
 * Se K_VILKAR_VURD_T.
 */
public class VilkarVurderingCti extends TypeCti {

    

    public VilkarVurderingCti() {
        super();
    }

    public VilkarVurderingCti(String kode) {
        super(kode);
    }

    public VilkarVurderingCti(VilkarVurderingCti vilkarVurderingCti) {
        super(vilkarVurderingCti);
    }
}
