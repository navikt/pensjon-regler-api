package no.nav.pensjon.regler.domain.beregning2011

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.PenPerson
import no.nav.pensjon.regler.domain.kode.BeregningMetodeTypeCti
import no.nav.pensjon.regler.domain.kode.JustertPeriodeCti
import no.nav.pensjon.regler.domain.kode.LandCti
import no.nav.pensjon.regler.domain.kode.ResultatTypeCti

@JsonSubTypes(
    JsonSubTypes.Type(value = BeregningsInformasjon::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
interface IBeregningsInformasjon {
    var penPerson: PenPerson?
    var beregningsMetode: BeregningMetodeTypeCti?
    var ensligPensjonInstOpph: Boolean
    var instOppholdType: JustertPeriodeCti?
    var instOpphAnvendt: Boolean
    var resultatType: ResultatTypeCti?
    var trygdetid: Int?
    var tt_anv: Int
    var vurdertBosattland: LandCti?
    var eksport: Boolean
}