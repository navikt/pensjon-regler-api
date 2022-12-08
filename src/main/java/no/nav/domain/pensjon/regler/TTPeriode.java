package no.nav.domain.pensjon.regler;

import no.nav.domain.pensjon.regler.kode.GrunnlagKildeCti;
import no.nav.domain.pensjon.regler.kode.LandCti;

import java.io.Serializable;
import java.util.Date;

public class TTPeriode implements Serializable {

    /**
     * Fra-og-med dato for perioden.
     */
    private Date fom;

    /**
     * Til-og-med dato for perioden.
     */
    private Date tom;

    /**
     * Skal bruker ha poeng for hele året i fom-datoen
     */
    private boolean poengIInnAr;

    /**
     * Skal bruker ha poeng for hele året i tom-datoen
     */
    private boolean poengIUtAr;

    /**
     * Hvilket land perioden er opptjent i.
     */
    private LandCti land;

    /**
     * Om det skal regnes pro rata. Gjelder ved utenlandssaker.
     */
    private boolean ikkeProRata;

    /**
     * Angir om trygdetidsperioden brukes somm grunnlag på kravet.
     */
    private boolean bruk;

    /**
     * Kilden til trygdetidsperioden.
     */
    private GrunnlagKildeCti grunnlagKilde;

}
