package no.nav.domain.pensjon.regler.kode;

import java.io.Serializable;

public class SatsTypeCti extends TypeCti implements Serializable {



    public SatsTypeCti(TypeCti typeCti) {
        super(typeCti);
    }

    public SatsTypeCti() {
    }

    public SatsTypeCti(String kode) {
        super(kode);
    }

}
