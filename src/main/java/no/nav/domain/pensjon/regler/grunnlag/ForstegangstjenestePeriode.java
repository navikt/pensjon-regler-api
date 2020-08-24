package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.ForstegangstjenesteperiodeTypeCti;
import no.nav.domain.pensjon.regler.util.DateCompareUtil;

import java.io.Serializable;
import java.util.Date;

public class ForstegangstjenestePeriode implements Comparable<ForstegangstjenestePeriode>, Serializable {
    private static final long serialVersionUID = 3393598726609419168L;

    private Date fomDato;
    private Date tomDato;
    private ForstegangstjenesteperiodeTypeCti periodeType;

    public ForstegangstjenestePeriode() {
        super();
    }

    public ForstegangstjenestePeriode(ForstegangstjenestePeriode p) {
        super();

        if (p.fomDato != null){
            fomDato = (Date) p.fomDato.clone();
        }
        if (p.tomDato != null){
            tomDato = (Date) p.tomDato.clone();
        }
        if (p.periodeType != null) {
            periodeType = new ForstegangstjenesteperiodeTypeCti(p.periodeType);
        }
    }

    public Date getFomDato() {
        return fomDato;
    }

    public void setFomDato(Date fomDato) {
        this.fomDato = fomDato;
    }

    public Date getTomDato() {
        return tomDato;
    }

    public void setTomDato(Date tomDato) {
        this.tomDato = tomDato;
    }

    public ForstegangstjenesteperiodeTypeCti getPeriodeType() {
        return periodeType;
    }

    public void setPeriodeType(ForstegangstjenesteperiodeTypeCti periodeType) {
        this.periodeType = periodeType;
    }

    @Override
    public int compareTo(ForstegangstjenestePeriode o) {
        ForstegangstjenestePeriode forstegangstjenestePeriode = o;
        return DateCompareUtil.compareTo(fomDato, forstegangstjenestePeriode.getFomDato());
    }

}
