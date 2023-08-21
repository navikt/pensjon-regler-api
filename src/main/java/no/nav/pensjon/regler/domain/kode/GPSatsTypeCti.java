package no.nav.pensjon.regler.domain.kode;

public class GPSatsTypeCti extends TypeCti {

    private static final long serialVersionUID = -143021596183424410L;

    public GPSatsTypeCti() {
        super();
    }

    public GPSatsTypeCti(String kode) {
        super(kode);
    }

    public GPSatsTypeCti(GPSatsTypeCti grunnlagsrolleCti) {
        super(grunnlagsrolleCti);
    }
}
