package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.util.DateCompareUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Objektet representerer en periode som det er vurdert vilk�r for barnetillegg (p� uf�retrygd).
 * Objektet holder p� et sett av vilk�r som er relevante for perioden.
 * Disse benyttes videre i vilk�rspr�ving av barnetillegg.
 * 
 * @author Lars Hartvigsen (Decisive) - PK-20946
 */

public class BarnetilleggVurderingsperiode implements Serializable, Comparable<BarnetilleggVurderingsperiode> {
    private static final long serialVersionUID = -2963416509534737824L;
    private Date fomDato;
    private Date tomDato;
    private List<BarnetilleggVilkar> btVilkarListe;

    public BarnetilleggVurderingsperiode() {
        btVilkarListe = new ArrayList<BarnetilleggVilkar>();
    }

    public BarnetilleggVurderingsperiode(BarnetilleggVurderingsperiode b) {
        setFomDato(b.getFomDato());
        setTomDato(b.getTomDato());
        btVilkarListe = new ArrayList<BarnetilleggVilkar>();
        for (BarnetilleggVilkar bv : b.getBtVilkarListe()) {
            btVilkarListe.add(new BarnetilleggVilkar(bv));
        }
    }

    @Override
    public int compareTo(BarnetilleggVurderingsperiode o) {
        return DateCompareUtil.compareTo(getFomDato(), o.getFomDato());
    }

    public List<BarnetilleggVilkar> getBtVilkarListe() {
        return btVilkarListe;
    }

    public Date getFomDato() {
        return fomDato;
    }

    public Date getTomDato() {
        return tomDato;
    }

    public void setBtVilkarListe(List<BarnetilleggVilkar> btVilkarListe) {
        this.btVilkarListe = btVilkarListe;
    }

    public void setFomDato(Date fomDato) {
        this.fomDato = fomDato;
    }

    public void setTomDato(Date tomDato) {
        this.tomDato = tomDato;
    }

}
