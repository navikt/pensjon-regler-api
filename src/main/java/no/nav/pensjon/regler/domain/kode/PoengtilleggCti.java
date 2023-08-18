package no.nav.pensjon.regler.domain.kode;

public class PoengtilleggCti extends TypeCti {
    private static final long serialVersionUID = -3767084544159704622L;

    public PoengtilleggCti() {
        super();
    }

    public PoengtilleggCti(String kode) {
        super(kode);
    }

    public PoengtilleggCti(PoengtilleggCti yrkeCti) {
        super(yrkeCti);
    }
}
