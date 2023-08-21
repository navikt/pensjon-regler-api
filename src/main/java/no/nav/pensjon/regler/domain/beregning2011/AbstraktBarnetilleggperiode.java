package no.nav.pensjon.regler.domain.beregning2011;


import no.nav.pensjon.regler.domain.trygdetid.Brok;
import no.nav.pensjon.regler.domain.util.DateCompareUtil;

import java.io.Serializable;
import java.util.Date;

public abstract class AbstraktBarnetilleggperiode implements Serializable, Comparable<AbstraktBarnetilleggperiode> {

    private static final long serialVersionUID = 8492340648188578653L;
    /**
     * Start for periode med et antall barn.
     */

    private Date fomDato;

    /**
     * Stopp for periode med et antall barn.
     */

    private Date tomDato;

    /**
     * Periodens lengde i antall måneder.
     */

    private int lengde;

    /**
     * Antall barn det beregnes barnetillegg for i perioden.
     */

    private int antallBarn;

    /**
     * Fribeløpet for antall barn i perioden.
     */

    private int fribelop;

    /**
     * Brutto årlig barnetillegg, beregnet for antall barn (felles- og særkullsbarn) i perioden og eventuelt redusert mot tak.
     */

    private int bruttoPerAr;

    /**
     * Reguleringsfaktor dersom perioden gjelder for en annen G enn GvedVirk.
     */

    private Brok reguleringsfaktor;

    /**
     * Halvparten av inntekt overskytende fribeløp. Fastsatt som årlig beløp, dvs oppjustert til årlig beløp dersom fribeløp og inntekt er periodisert.
     */
    private int avkortingsbelopPerAr;


    public AbstraktBarnetilleggperiode() {
    }

    public AbstraktBarnetilleggperiode(AbstraktBarnetilleggperiode bp) {
        fomDato = bp.fomDato;
        tomDato = bp.tomDato;
        lengde = bp.lengde;
        antallBarn = bp.antallBarn;
        fribelop = bp.fribelop;
        bruttoPerAr = bp.bruttoPerAr;

        if (bp.reguleringsfaktor != null) {
            reguleringsfaktor = new Brok(bp.reguleringsfaktor);
        }

        avkortingsbelopPerAr = bp.avkortingsbelopPerAr;
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

    public int getLengde() {
        return lengde;
    }

    public void setLengde(int lengde) {
        this.lengde = lengde;
    }

    public int getAntallBarn() {
        return antallBarn;
    }

    public void setAntallBarn(int antallBarn) {
        this.antallBarn = antallBarn;
    }

    public int getFribelop() {
        return fribelop;
    }

    public void setFribelop(int fribelop) {
        this.fribelop = fribelop;
    }

    public int getBruttoPerAr() {
        return bruttoPerAr;
    }

    public void setBruttoPerAr(int bruttoPerAr) {
        this.bruttoPerAr = bruttoPerAr;
    }

    public Brok getReguleringsfaktor() {
        return reguleringsfaktor;
    }

    public void setReguleringsfaktor(Brok reguleringsfaktor) {
        this.reguleringsfaktor = reguleringsfaktor;
    }

    public int getAvkortingsbelopPerAr() {
        return avkortingsbelopPerAr;
    }

    public void setAvkortingsbelopPerAr(int avkortingsbelopPerAr) {
        this.avkortingsbelopPerAr = avkortingsbelopPerAr;
    }

    @Override
    public int compareTo(AbstraktBarnetilleggperiode periode) {
        return DateCompareUtil.compareTo(getFomDato(), periode.getFomDato());
    }

}
