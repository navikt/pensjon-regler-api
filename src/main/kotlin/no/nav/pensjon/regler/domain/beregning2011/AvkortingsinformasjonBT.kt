package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.AvviksjusteringEnum
import java.io.Serializable

/**
 * Angir detaljer rund avkortingen av barnetillegg.
 */
class AvkortingsinformasjonBT : AbstraktAvkortingsinformasjon(), Serializable {
    /**
     * Angir liste over fremtidige perioder.
     */
    var barnetilleggPeriodeListe: List<AbstraktBarnetilleggperiode> = mutableListOf()

    /**
     * Fribeløp for antall barn ved virk.
     */
    var fribelopVedVirk = 0

    /**
     * Hva gjenstår å utbetale for resten av året uten hensyn til justeringsbeløp.
     */
    var restTilUtbetalingForJustering = 0.0

    /**
     * Sum av alle avviksbeløp fra alle tidligere barnetilleggperioder i et år.
     */
    var avviksbelop = 0.0

    /**
     * nødvendig justering av avkortingsbeløp.
     */
    var justeringsbelopUbegrensetPerAr = 0.0

    /**
     * Det justeringsbeløpet som er praktisk mulig å effektuere.
     */
    var justeringsbelopPerAr = 0.0

    /**
     * Gitt at forventet inntekt ikke endres, hva blir forventet etteroppgjør.
     */
    var forventetEtteroppgjor = 0.0

    /**
     * Angir en konklusjon for behovsprøvingen. Innenfor eller utenfor rammene for justering. Kodeverk K_AVVIKSJUSTERING_T
     */
    var avviksjusteringTypeEnum: AvviksjusteringEnum? = null

    /**
     * Flagg som angir om inntekt er periodisert pga kortere periode med barnetillegg enn uføretrygd.
     */
    var inntektPeriodisert = false

    /**
     * Flagg som angir at fribeløp er periodisert pga barnetillegg i deler av året.
     */
    var fribelopPeriodisert = false

}