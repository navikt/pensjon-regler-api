package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.grunnlag.Unntak;

/**
 * @author Magnus Bakken (Accenture), PK-9695, PKYPTON-923
 * @author Steinar Hjellvik Decisive,  PK-6559
 */
public class ForutgaendeMedlemskap extends AbstraktVilkar {

    /**
     * Minst tre års forutgående medlemskap i Norge med uføretidspunkt FOM 01.01.1994
     */
    private Boolean minstTreArsFMNorge;

    /**
     * Minst fem års forutgående medlemskap i Norge med uføretidspunkt FOM 01.01.1994 (regelprøvd ved førsteKravFremsattDato fom 01.01.2021)
     */
    private Boolean minstFemArsFMNorge;

    /**
     * Avdøde har minst ett års forutgående medlemskap i Norge med dødsdato før 01.01.1994 og virkningsdato FOM 01.01.1990
     */
    private Boolean minstEttArFMNorge;

    /**
     * Unntak fra forutgående medlemskap
     */
    private Unntak unntakFraForutgaendeMedlemskap;

    /**
     * Unntak fra forutgående trygdetid
     */
    private Unntak unntakFraForutgaendeTT;

    /**
     * Oppfylt etter gamle regler og virkningsdato før 01.01.1990
     */
    private Boolean oppfyltEtterGamleRegler;

}
