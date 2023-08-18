package no.nav.pensjon.regler.domain.kode;

import java.io.Serializable;

public class SatsTypeCti extends TypeCti implements Serializable {

    private static final long serialVersionUID = 6005472676083475303L;

    public SatsTypeCti(TypeCti typeCti) {
        super(typeCti);
    }

    public SatsTypeCti() {
    }

    public SatsTypeCti(String kode) {
        super(kode);
    }

}
