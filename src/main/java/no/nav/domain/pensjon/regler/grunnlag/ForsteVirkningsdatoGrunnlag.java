package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;
import java.util.Date;

import no.nav.domain.pensjon.regler.PenPerson;
import no.nav.domain.pensjon.regler.kode.KravlinjeTypeCti;
import no.nav.domain.pensjon.regler.util.DateCompareUtil;

public class ForsteVirkningsdatoGrunnlag implements Serializable, Comparable<ForsteVirkningsdatoGrunnlag> {
    private static final long serialVersionUID = 8376138604433396886L;

    private Date virkningsdato;

    private Date kravFremsattDato;

    private PenPerson bruker;

    private PenPerson annenPerson;

    private KravlinjeTypeCti kravlinjeType;

    public ForsteVirkningsdatoGrunnlag() {
    }

    public ForsteVirkningsdatoGrunnlag(ForsteVirkningsdatoGrunnlag forsteVirkningsdatoGrunnlag) {
        this.virkningsdato = forsteVirkningsdatoGrunnlag.virkningsdato;
        this.kravFremsattDato = forsteVirkningsdatoGrunnlag.kravFremsattDato;
        this.bruker = forsteVirkningsdatoGrunnlag.bruker;
        this.annenPerson = forsteVirkningsdatoGrunnlag.annenPerson;
        this.kravlinjeType = forsteVirkningsdatoGrunnlag.kravlinjeType;
    }

    public ForsteVirkningsdatoGrunnlag(Date virkningsdato, Date kravFremsattDato, PenPerson bruker, PenPerson annenPerson, KravlinjeTypeCti kravlinjeType) {
        this.virkningsdato = virkningsdato;
        this.kravFremsattDato = kravFremsattDato;
        this.bruker = bruker;
        this.annenPerson = annenPerson;
        this.kravlinjeType = kravlinjeType;
    }

    public Date getVirkningsdato() {
        return virkningsdato;
    }

    public void setVirkningsdato(Date virkningsdato) {
        this.virkningsdato = virkningsdato;
    }

    public Date getKravFremsattDato() {
        return kravFremsattDato;
    }

    public void setKravFremsattDato(Date kravFremsattDato) {
        this.kravFremsattDato = kravFremsattDato;
    }

    public PenPerson getBruker() {
        return bruker;
    }

    public void setBruker(PenPerson bruker) {
        this.bruker = bruker;
    }

    public PenPerson getAnnenPerson() {
        return annenPerson;
    }

    public void setAnnenPerson(PenPerson annenPerson) {
        this.annenPerson = annenPerson;
    }

    public KravlinjeTypeCti getKravlinjeType() {
        return kravlinjeType;
    }

    public void setKravlinjeType(KravlinjeTypeCti kravlinjeType) {
        this.kravlinjeType = kravlinjeType;
    }

    @Override
    public int compareTo(ForsteVirkningsdatoGrunnlag other) {
        return DateCompareUtil.compareTo(getKravFremsattDato(), other.getKravFremsattDato());
    }
}
