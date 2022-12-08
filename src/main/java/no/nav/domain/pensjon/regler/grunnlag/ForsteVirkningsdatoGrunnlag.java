package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;
import java.util.Date;

import no.nav.domain.pensjon.regler.PenPerson;
import no.nav.domain.pensjon.regler.kode.KravlinjeTypeCti;

public class ForsteVirkningsdatoGrunnlag implements Serializable {

    private Date virkningsdato;

    private Date kravFremsattDato;

    private PenPerson bruker;

    private PenPerson annenPerson;

    private KravlinjeTypeCti kravlinjeType;

    public ForsteVirkningsdatoGrunnlag() {
    }
}
