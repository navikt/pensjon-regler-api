package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.AvviksjusteringCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Angir detaljer rund avkortingen av barnetillegg.
 */
public class AvkortingsinformasjonBT extends AbstraktAvkortingsinformasjon implements Serializable {

    /**
     * Angir liste over fremtidige perioder.
     */
    private List<AbstraktBarnetilleggperiode> barnetilleggPeriodeListe = new ArrayList<AbstraktBarnetilleggperiode>();

    /**
     * Fribel�p for antall barn ved virk.
     */
    private int fribelopVedVirk;

    /**
     * Hva gjenst�r � utbetale for resten av �ret uten hensyn til justeringsbel�p.
     */
    private double restTilUtbetalingForJustering;

    /**
     * Sum av alle avviksbel�p fra alle tidligere barnetilleggperioder i et �r.
     */
    private double avviksbelop;

    /**
     * N�dvendig justering av avkortingsbel�p.
     */
    private double justeringsbelopUbegrensetPerAr;

    /**
     * Det justeringsbel�pet som er praktisk mulig � effektuere.
     */
    private double justeringsbelopPerAr;

    /**
     * Gitt at forventet inntekt ikke endres, hva blir forventet etteroppgj�r.
     */
    private double forventetEtteroppgjor;

    /**
     * Angir en konklusjon for behovspr�vingen. Innenfor eller utenfor rammene for justering. Kodeverk K_AVVIKSJUSTERING_T
     */
    private AvviksjusteringCti avviksjusteringType;

    /**
     * Flagg som angir om inntekt er periodisert pga kortere periode med barnetillegg enn uf�retrygd.
     */
    private boolean inntektPeriodisert;

    /**
     * Flagg som angir at fribel�p er periodisert pga barnetillegg i deler av �ret.
     */
    private boolean fribelopPeriodisert;

}
