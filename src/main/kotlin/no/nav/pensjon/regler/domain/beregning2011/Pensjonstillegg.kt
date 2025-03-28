package no.nav.pensjon.regler.domain.beregning2011

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import no.nav.pensjon.regler.domain.enum.MinstePensjonsnivaSatsEnum
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum

@JsonSubTypes(
    JsonSubTypes.Type(value = BasisPensjonstillegg::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
open class Pensjonstillegg : Ytelseskomponent {
    @Deprecated("Avvikles. Erstattes av forholdstallVedNormertPensjonsalder.")
    var forholdstall67 = 0.0
    var forholdstallVedNormertPensjonsalder = 0.0
    var minstepensjonsnivaSats = 0.0
    var minstepensjonsnivaSatsTypeEnum: MinstePensjonsnivaSatsEnum? = null
    var justertMinstePensjonsniva: JustertMinstePensjonsniva? = null

    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.PT

    constructor() {
        formelKodeEnum = FormelKodeEnum.PenTx
    }

    constructor(pt: Pensjonstillegg) : super(pt) {
        forholdstall67 = pt.forholdstall67
        forholdstallVedNormertPensjonsalder = pt.forholdstallVedNormertPensjonsalder
        minstepensjonsnivaSats = pt.minstepensjonsnivaSats
        if (pt.minstepensjonsnivaSatsTypeEnum != null) {
            minstepensjonsnivaSatsTypeEnum = pt.minstepensjonsnivaSatsTypeEnum
        }
        if (pt.justertMinstePensjonsniva != null) {
            justertMinstePensjonsniva = JustertMinstePensjonsniva(pt.justertMinstePensjonsniva!!)
        }
    }
}