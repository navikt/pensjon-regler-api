package no.nav.domain.pensjon.regler.grunnlag;



import java.io.Serializable;

public class EOSGrunnlag implements Serializable {

    /**
     * Foreløbig - skal ikke brukes
     */


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

}
