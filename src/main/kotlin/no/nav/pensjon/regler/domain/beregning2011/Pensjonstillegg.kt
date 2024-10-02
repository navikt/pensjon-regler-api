package no.nav.pensjon.regler.domain.beregning2011

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import no.nav.pensjon.regler.domain.enum.MinstePensjonsnivaSatsEnum
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.MinstepenNivaCti
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

@JsonSubTypes(
    JsonSubTypes.Type(value = BasisPensjonstillegg::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
open class Pensjonstillegg : Ytelseskomponent {
    var forholdstall67 = 0.0
    var minstepensjonsnivaSats = 0.0
    var minstepensjonsnivaSatsType: MinstepenNivaCti? = null
    var minstepensjonsnivaSatsTypeEnum: MinstePensjonsnivaSatsEnum? = null
    var justertMinstePensjonsniva: JustertMinstePensjonsniva? = null

    override var ytelsekomponentType: YtelsekomponentTypeCti = YtelsekomponentTypeCti("PT")
    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.PT

    constructor() {
        formelKode = FormelKodeCti("PenTx")
        formelKodeEnum = FormelKodeEnum.PenTx
    }

    constructor(pt: Pensjonstillegg) : super(pt) {
        forholdstall67 = pt.forholdstall67
        minstepensjonsnivaSats = pt.minstepensjonsnivaSats
        if (pt.minstepensjonsnivaSatsType != null) {
            minstepensjonsnivaSatsType = MinstepenNivaCti(pt.minstepensjonsnivaSatsType!!)
        }
        if (pt.minstepensjonsnivaSatsTypeEnum != null) {
            minstepensjonsnivaSatsTypeEnum = pt.minstepensjonsnivaSatsTypeEnum
        }
        if (pt.justertMinstePensjonsniva != null) {
            justertMinstePensjonsniva = JustertMinstePensjonsniva(pt.justertMinstePensjonsniva!!)
        }
    }
}