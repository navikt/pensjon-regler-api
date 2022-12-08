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
     * Fribeløp for antall barn ved virk.
     */
    private int fribelopVedVirk;

    /**
     * Hva gjenstår å utbetale for resten av året uten hensyn til justeringsbeløp.
     */
    private double restTilUtbetalingForJustering;

    /**
     * Sum av alle avviksbeløp fra alle tidligere barnetilleggperioder i et år.
     */
    private double avviksbelop;

    /**
     * Nødvendig justering av avkortingsbeløp.
     */
    private double justeringsbelopUbegrensetPerAr;

    /**
     * Det justeringsbeløpet som er praktisk mulig å effektuere.
     */
    private double justeringsbelopPerAr;

    /**
     * Gitt at forventet inntekt ikke endres, hva blir forventet etteroppgjør.
     */
    private double forventetEtteroppgjor;

    /**
     * Angir en konklusjon for behovsprøvingen. Innenfor eller utenfor rammene for justering. Kodeverk K_AVVIKSJUSTERING_T
     */
    private AvviksjusteringCti avviksjusteringType;

    /**
     * Flagg som angir om inntekt er periodisert pga kortere periode med barnetillegg enn uføretrygd.
     */
    private boolean inntektPeriodisert;

    /**
     * Flagg som angir at fribeløp er periodisert pga barnetillegg i deler av året.
     */
    private boolean fribelopPeriodisert;

}
