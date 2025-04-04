package no.nav.pensjon.regler.domain.beregning2011

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.enum.Beregningsarsak
import no.nav.pensjon.regler.domain.enum.BorMedTypeEnum
import no.nav.pensjon.regler.domain.enum.SivilstandEnum
import java.io.Serializable
import java.util.*

@JsonSubTypes(
    JsonSubTypes.Type(value = BeregningsresultatUforetrygd::class),
    JsonSubTypes.Type(value = BeregningsResultatAlderspensjon2016::class),
    JsonSubTypes.Type(value = BeregningsResultatAlderspensjon2025::class),
    JsonSubTypes.Type(value = BeregningsResultatAfpPrivat::class),
    JsonSubTypes.Type(value = BeregningsResultatAlderspensjon2011::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
abstract class AbstraktBeregningsResultat protected constructor() : Serializable {
    var virkFom: Date? = null
    var pensjonUnderUtbetaling: PensjonUnderUtbetaling? = null
    /**
     * @return the uttaksgrad
     */
    /**
     * @param uttaksgrad the uttaksgrad to set
     */
    var uttaksgrad = 0

    /**
     * Snittet av uttaksgradene i perioden fra (virk bakover i tid til 1 mai) og til (virk fremover i tid til 1 mai).
     */
    var brukersSivilstandEnum: SivilstandEnum? = null
    var benyttetSivilstandEnum: BorMedTypeEnum? = null
    var beregningArsakEnum: Beregningsarsak? = null
    var lonnsvekstInformasjon: LonnsvekstInformasjon? = null
    var merknadListe: List<Merknad> = mutableListOf()
    var gjennomsnittligUttaksgradSisteAr = 0.0

}