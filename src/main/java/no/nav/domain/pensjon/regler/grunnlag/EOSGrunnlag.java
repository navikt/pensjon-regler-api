package no.nav.domain.pensjon.regler.grunnlag;



import java.io.Serializable;

public class EOSGrunnlag implements Serializable {

    /**
     * Forel�big - skal ikke brukes
     */


    /**
     * Garantibel�p for alderspensjons
     */
    private int apgBelop;

    /**
     * faktisk trygdetid i Norge, i m�neder
     */
    private int faktiskTT_Norge;

    /**
     * faktisk trygdetid i Norden, utenom Norge, i m�neder
     */
    private int faktiskTT_Norden;

    /**
     * faktisk trygdetid i E�S land, i m�neder
     */
    private int faktiskTT_EOS;

    /**
     * faktisk trygdetid i �vrige land med bilateral avtale, i m�neder
     */
    private int faktiskTT_Ovrige;

    /**
     * Antall faktiske trygdetids�r - brukes ved bilaterale avtale med Canada
     */
    private int faktiskTT_Ar;

}
