package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.beregning.Sluttpoengtall

interface IBeregningsInformasjon2011 : IBeregningsInformasjon {
    var isAvdodesTilleggspensjonBrukt: Boolean
    var isAvdodesTrygdetidBrukt: Boolean
    var forholdstall67: Double
    var forholdstallUttak: Double
    var isGjenlevenderettAnvendt: Boolean
    var isGrunnpensjonAvkortet: Boolean
    var isMottarMinstePensjonsniva: Boolean
    var minstepensjonArsak: String?
    var opt: Sluttpoengtall?
    var isRettPaGjenlevenderett: Boolean
    var spt: Sluttpoengtall?
    var isUngUfor: Boolean
    var isUngUforAnvendt: Boolean
    var ypt: Sluttpoengtall?
    var isYrkesskadeAnvendt: Boolean
    var yrkesskadegrad: Int
    var isYrkesskadeRegistrert: Boolean
}