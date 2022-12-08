package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.ForstegangstjenesteperiodeTypeCti;

import java.io.Serializable;
import java.util.Date;

public class ForstegangstjenestePeriode implements Serializable {

    private Date fomDato;
    private Date tomDato;
    private ForstegangstjenesteperiodeTypeCti periodeType;


}
