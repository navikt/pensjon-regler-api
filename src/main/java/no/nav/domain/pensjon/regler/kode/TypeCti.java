package no.nav.domain.pensjon.regler.kode;

import java.io.Serializable;
import java.util.Date;

public class TypeCti implements Serializable {


    protected String kode;

    protected String dekode;

    protected Date dato_fom;

    protected Date dato_tom;

    protected boolean er_gyldig = true;

    protected String kommentar;

    public TypeCti(String kode) {
        this.kode = kode;
    }
}
