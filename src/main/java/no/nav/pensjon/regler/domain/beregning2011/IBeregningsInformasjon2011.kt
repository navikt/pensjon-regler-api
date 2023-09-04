package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Sluttpoengtall

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