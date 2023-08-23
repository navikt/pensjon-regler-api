package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.grunnlag.Unntak

/**
 * @author Magnus Bakken (Accenture), PK-9695, PKYPTON-923
 * @author Steinar Hjellvik Decisive,  PK-6559
 */
class ForutgaendeMedlemskap : AbstraktVilkar() {
    /**
     * Minst tre års forutgående medlemskap i Norge med uføretidspunkt FOM 01.01.1994
     */
    var minstTreArsFMNorge: Boolean? = null

    /**
     * Minst fem års forutgående medlemskap i Norge med uføretidspunkt FOM 01.01.1994 (regelprøvd ved FørsteKravFremsattDato fom 01.01.2021)
     */
    var minstFemArsFMNorge: Boolean? = null

    /**
     * Avdøde har minst ett års forutgående medlemskap i Norge med dødsdato før 01.01.1994 og virkningsdato FOM 01.01.1990
     */
    var minstEttArFMNorge: Boolean? = null

    /**
     * Unntak fra forutgående medlemskap
     */
    var unntakFraForutgaendeMedlemskap: Unntak? = null

    /**
     * Unntak fra forutgående trygdetid
     */
    var unntakFraForutgaendeTT: Unntak? = null

    /**
     * Oppfylt etter gamle regler og virkningsdato før 01.01.1990
     */
    var oppfyltEtterGamleRegler: Boolean? = null
}