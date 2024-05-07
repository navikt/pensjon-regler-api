package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.PenPerson
import no.nav.pensjon.regler.domain.beregning.Sluttpoengtall
import no.nav.pensjon.regler.domain.kode.BeregningMetodeTypeCti
import no.nav.pensjon.regler.domain.kode.JustertPeriodeCti
import no.nav.pensjon.regler.domain.kode.LandCti
import no.nav.pensjon.regler.domain.kode.ResultatTypeCti
import java.io.Serializable

class BeregningsInformasjon : Serializable {
    var forholdstallUttak = 0.0
    var forholdstall67 = 0.0
    var delingstallUttak = 0.0
    var delingstall67 = 0.0
    var spt: Sluttpoengtall? = null
    var opt: Sluttpoengtall? = null
    var ypt: Sluttpoengtall? = null
    var grunnpensjonAvkortet = false
    var merknadListe: List<Merknad> = mutableListOf()
    var mottarMinstePensjonsniva = false
    var minstepensjonArsak: String? = null
    var rettPaGjenlevenderett = false
    var gjenlevenderettAnvendt = false
    var avdodesTilleggspensjonBrukt = false
    var avdodesTrygdetidBrukt = false
    var ungUfor = false
    var ungUforAnvendt = false
    var yrkesskadeRegistrert = false
    var yrkesskadeAnvendt = false
    var yrkesskadegrad = 0
    var penPerson: PenPerson? = null
    var beregningsMetode: BeregningMetodeTypeCti? = null
    var eksport = false
    var resultatType: ResultatTypeCti? = null
    var tapendeBeregningsmetodeListe: List<TapendeBeregningsmetode> = mutableListOf()
    var trygdetid: Int? = null
    var tt_anv = 0
    var vurdertBosattland: LandCti? = null
    var ensligPensjonInstOpph = false
    var instOppholdType: JustertPeriodeCti? = null
    var instOpphAnvendt = false
    var tp = 0.0
    var ttBeregnetForGrunnlagsrolle = 0
    var ungUforGarantiFrafalt = false
}