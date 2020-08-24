package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.util.DateCompareUtil;

import java.io.Serializable;
import java.util.Date;

public class GarantiTrygdetid implements Serializable, Comparable<GarantiTrygdetid> {

    private static final long serialVersionUID = 8259361870410195242L;

    private int trygdetid_garanti;
    private Date fomDato;
    private Date tomDato;

    public GarantiTrygdetid() {
        super();
    }

    public GarantiTrygdetid(GarantiTrygdetid garantiTrygdetid) {
        super();
        fomDato = garantiTrygdetid.getFomDato();
        tomDato = garantiTrygdetid.getTomDato();
        trygdetid_garanti = garantiTrygdetid.getTrygdetid_garanti();
    }

    @Override
    public int compareTo(GarantiTrygdetid garantiTrygdetid) {
        return DateCompareUtil.compareTo(getFomDato(), garantiTrygdetid.getFomDato());
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

    public int getTrygdetid_garanti() {
        return trygdetid_garanti;
    }

    public void setTrygdetid_garanti(int trygdetid_garanti) {
        this.trygdetid_garanti = trygdetid_garanti;
    }

}
