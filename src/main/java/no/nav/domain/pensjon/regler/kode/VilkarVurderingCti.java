package no.nav.domain.pensjon.regler.kode;

/**
 * Beskriver hvilken vurdering saksbehandler har lagt til grunn for resultatvurderingen.
 * Se K_VILKAR_VURD_T.
 */
public class VilkarVurderingCti extends TypeCti {

    private static final long serialVersionUID = 8137611801947991746L;

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
