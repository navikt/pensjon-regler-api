package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.util.ToStringUtil;

import java.io.Serializable;

public class EOSGrunnlag implements Serializable {

    /**
     * Foreløbig - skal ikke brukes
     */
    private static final long serialVersionUID = 4110850101047491682L;

    /**
     * Garantibeløp for alderspensjons
     */
    private int apgBelop;

    /**
     * faktisk trygdetid i Norge, i måneder
     */
    private int faktiskTT_Norge;

    /**
     * faktisk trygdetid i Norden, utenom Norge, i måneder
     */
    private int faktiskTT_Norden;

    /**
     * faktisk trygdetid i EØS land, i måneder
     */
    private int faktiskTT_EOS;

    /**
     * faktisk trygdetid i øvrige land med bilateral avtale, i måneder
     */
    private int faktiskTT_Ovrige;

    /**
     * Antall faktiske trygdetidsår - brukes ved bilaterale avtale med Canada
     */
    private int faktiskTT_Ar;

    /**
     * Copy Constructor
     * 
     * @param eOSGrunnlag a <code>EOSGrunnlag</code> object
     */
    public EOSGrunnlag(EOSGrunnlag eOSGrunnlag) {
        apgBelop = eOSGrunnlag.apgBelop;
        faktiskTT_Norge = eOSGrunnlag.faktiskTT_Norge;
        faktiskTT_Norden = eOSGrunnlag.faktiskTT_Norden;
        faktiskTT_EOS = eOSGrunnlag.faktiskTT_EOS;
        faktiskTT_Ovrige = eOSGrunnlag.faktiskTT_Ovrige;
        faktiskTT_Ar = eOSGrunnlag.faktiskTT_Ar;
    }

    public EOSGrunnlag() {
        super();
    }

    public EOSGrunnlag(int apgBelop, int faktiskTT_Norge, int faktiskTT_Norden, int faktiskTT_EOS, int faktiskTT_Ovrige, int faktiskTT_Ar) {
        super();
        this.apgBelop = apgBelop;
        this.faktiskTT_Norge = faktiskTT_Norge;
        this.faktiskTT_Norden = faktiskTT_Norden;
        this.faktiskTT_EOS = faktiskTT_EOS;
        this.faktiskTT_Ovrige = faktiskTT_Ovrige;
        this.faktiskTT_Ar = faktiskTT_Ar;
    }

    public int getApgBelop() {
        return apgBelop;
    }

    public void setApgBelop(int apgBelop) {
        this.apgBelop = apgBelop;
    }

    public int getFaktiskTT_Ar() {
        return faktiskTT_Ar;
    }

    public void setFaktiskTT_Ar(int faktiskTT_Ar) {
        this.faktiskTT_Ar = faktiskTT_Ar;
    }

    public int getFaktiskTT_EOS() {
        return faktiskTT_EOS;
    }

    public void setFaktiskTT_EOS(int faktiskTT_EOS) {
        this.faktiskTT_EOS = faktiskTT_EOS;
    }

    public int getFaktiskTT_Norden() {
        return faktiskTT_Norden;
    }

    public void setFaktiskTT_Norden(int faktiskTT_Norden) {
        this.faktiskTT_Norden = faktiskTT_Norden;
    }

    public int getFaktiskTT_Norge() {
        return faktiskTT_Norge;
    }

    public void setFaktiskTT_Norge(int faktiskTT_Norge) {
        this.faktiskTT_Norge = faktiskTT_Norge;
    }

    public int getFaktiskTT_Ovrige() {
        return faktiskTT_Ovrige;
    }

    public void setFaktiskTT_Ovrige(int faktiskTT_Ovrige) {
        this.faktiskTT_Ovrige = faktiskTT_Ovrige;
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }
}
