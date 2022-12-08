package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.kode.FormelKodeCti;
import no.nav.domain.pensjon.regler.kode.GPSatsTypeCti;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;
import no.nav.domain.pensjon.regler.trygdetid.AnvendtTrygdetid;

/**
 * Grunnpensjon
 */
public class Grunnpensjon extends Ytelseskomponent {



    /**
     * Prosentsatsen.
     */
    protected double pSats_gp;

    /**
     * Ordinær, forhøyet
     */
    protected GPSatsTypeCti satsType;

    protected boolean ektefelleInntektOver2G;

    /**
     * Denne er beholdt av hensyn til bakoverkompatibilitet med xml filer.
     * Skal ikke ha get/set og skal ikke brukes fra Blaze regelkoden.
     */
    protected double PREG_prorata_gp;

    /**
     * Trygdetid anvendt i beregning av grunnpensjon.
     */
    protected AnvendtTrygdetid anvendtTrygdetid;

}
