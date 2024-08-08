package no.nav.pensjon.regler.domain.beregning2011

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.PenPerson
import no.nav.pensjon.regler.domain.enum.BeregningsmetodeEnum
import no.nav.pensjon.regler.domain.enum.JustertPeriodeEnum
import no.nav.pensjon.regler.domain.enum.LandkodeEnum
import no.nav.pensjon.regler.domain.enum.ResultattypeEnum
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
    var beregningsMetodeEnum: BeregningsmetodeEnum?
    var ensligPensjonInstOpph: Boolean
    var instOppholdType: JustertPeriodeCti?
    var instOppholdTypeEnum: JustertPeriodeEnum?
    var instOpphAnvendt: Boolean
    var resultatType: ResultatTypeCti?
    var resultatTypeEnum: ResultattypeEnum?
    var trygdetid: Int?
    var tt_anv: Int
    var vurdertBosattland: LandCti?
    var landEnum: LandkodeEnum?
    var eksport: Boolean
}