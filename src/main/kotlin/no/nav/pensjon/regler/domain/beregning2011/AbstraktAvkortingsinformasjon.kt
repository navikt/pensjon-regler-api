package no.nav.pensjon.regler.domain.beregning2011

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.enum.InntektsavkortingTypeEnum
import no.nav.pensjon.regler.domain.kode.InntektsavkortingTypeCti
import java.io.Serializable

/**
 * Inneholder felles felt for avkorting av både UT og BT. Enkelte felt fra tidligere klasse Avkortningsinformasjon.
 */
@JsonSubTypes(
    JsonSubTypes.Type(value = AvkortingsinformasjonUT::class),
    JsonSubTypes.Type(value = AvkortingsinformasjonBT::class),
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
abstract class AbstraktAvkortingsinformasjon : Serializable {
    /**
     * Antall måneder før virk.
     */
    var antallMndFor = 0

    /**
     * Antall måneder fom virk.
     */
    var antallMndEtter = 0

    /**
     * Inntekt over dette taket gir ingen ytelse.
     */
    var inntektstak = 0

    /**
     * Beregnet avkortingsbeløp før justering for tidligere fradrag per år.
     */
    var avkortingsbelopPerAr = 0

    /**
     * Angir den netto ytelse som gjenstår å utbetale for året
     */
    var restTilUtbetaling = 0

    /**
     * Angir om inntektsavkorting er gjort med hensyn til etteroppgjør, evt ved revurdering.
     */
    var inntektsavkortingType: InntektsavkortingTypeCti? = null

    var inntektsavkortingTypeEnum: InntektsavkortingTypeEnum? = null
}