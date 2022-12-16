package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.grunnlag.Unntak;

/**
 * @author Magnus Bakken (Accenture), PK-9695, PKYPTON-923
 * @author Steinar Hjellvik Decisive,  PK-6559
 */
public class ForutgaendeMedlemskap extends AbstraktVilkar {

    /**
     * Minst tre �rs forutg�ende medlemskap i Norge med uf�retidspunkt FOM 01.01.1994
     */
    private Boolean minstTreArsFMNorge;

    /**
     * Minst fem �rs forutg�ende medlemskap i Norge med uf�retidspunkt FOM 01.01.1994 (regelpr�vd ved f�rsteKravFremsattDato fom 01.01.2021)
     */
    private Boolean minstFemArsFMNorge;

    /**
     * Avd�de har minst ett �rs forutg�ende medlemskap i Norge med d�dsdato f�r 01.01.1994 og virkningsdato FOM 01.01.1990
     */
    private Boolean minstEttArFMNorge;

    /**
     * Unntak fra forutg�ende medlemskap
     */
    private Unntak unntakFraForutgaendeMedlemskap;

    /**
     * Unntak fra forutg�ende trygdetid
     */
    private Unntak unntakFraForutgaendeTT;

    /**
     * Oppfylt etter gamle regler og virkningsdato f�r 01.01.1990
     */
    private Boolean oppfyltEtterGamleRegler;

}
