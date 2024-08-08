package no.nav.pensjon.regler.domain.enum

// TODO Tatt inn AvtaleKritCode fra Pesys
enum class AvtaleKritEnum {
    /**
     * Ikke yrkesaktiv, 3 &aring;rs botid
     */
    IK_YRK_BO,

    /**
     * Ikke yrkesaktiv, 1 &aring;rs trygdetid
     */
    IK_YRK_TRYGD,

    /**
     * Omfattet av bestemmelsene i eksportavtale
     */
    OMF_BES_EKSP,

    /**
     * Yrkesaktiv, 1 &aring;rs arbeid
     */
    YRK_ARB,

    /**
     * Yrkesaktiv i Norge eller E&Oslash;S, ett &aring;rs medlemskap i Norge
     */
    YRK_MEDL,

    /**
     * Yrkesaktiv, 1 &aring;rs trygdetid
     */
    YRK_TRYGD,

    /**
     * Yrkesaktiv i Norge eller E&Oslash;S
     */
    YRK_MEDL_ALT;
}