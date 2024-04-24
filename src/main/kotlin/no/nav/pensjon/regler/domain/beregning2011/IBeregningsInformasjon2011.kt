package no.nav.pensjon.regler.domain.beregning2011

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.beregning.Sluttpoengtall

@JsonSubTypes(
    JsonSubTypes.Type(value = BeregningsInformasjon::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
interface IBeregningsInformasjon2011 : IBeregningsInformasjon {
    var avdodesTilleggspensjonBrukt: Boolean
    var avdodesTrygdetidBrukt: Boolean
    var forholdstall67: Double
    var forholdstallUttak: Double
    var gjenlevenderettAnvendt: Boolean
    var grunnpensjonAvkortet: Boolean
    var mottarMinstePensjonsniva: Boolean
    var minstepensjonArsak: String?
    var opt: Sluttpoengtall?
    var rettPaGjenlevenderett: Boolean
    var spt: Sluttpoengtall?
    var ungUfor: Boolean
    var ungUforAnvendt: Boolean
    var ypt: Sluttpoengtall?
    var yrkesskadeAnvendt: Boolean
    var yrkesskadegrad: Int
    var yrkesskadeRegistrert: Boolean
}