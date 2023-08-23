package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.PenPerson
import no.nav.pensjon.regler.domain.beregning.Sluttpoengtall
import no.nav.pensjon.regler.domain.kode.BeregningMetodeTypeCti
import no.nav.pensjon.regler.domain.kode.JustertPeriodeCti
import no.nav.pensjon.regler.domain.kode.LandCti
import no.nav.pensjon.regler.domain.kode.ResultatTypeCti
import java.io.Serializable

class BeregningsInformasjon : Serializable, IBeregningsInformasjon2011 {
    //Fra IBeregningsInformasjon2011
    override var forholdstallUttak = 0.0
    override var forholdstall67 = 0.0
    var delingstallUttak = 0.0
    var delingstall67 = 0.0
    override var spt: Sluttpoengtall? = null
    override var opt: Sluttpoengtall? = null
    override var ypt: Sluttpoengtall? = null
    override var isGrunnpensjonAvkortet = false
    var merknadListe: List<Merknad> = mutableListOf()
    override var isMottarMinstePensjonsniva = false
    override var minstepensjonArsak: String? = null
    override var isRettPaGjenlevenderett = false
    override var isGjenlevenderettAnvendt = false
    override var isAvdodesTilleggspensjonBrukt = false
    override var isAvdodesTrygdetidBrukt = false
    override var isUngUfor = false
    override var isUngUforAnvendt = false
    override var isYrkesskadeRegistrert = false
    override var isYrkesskadeAnvendt = false
    override var yrkesskadegrad = 0

    // Fra IBeregningsInformasjon
    override var penPerson: PenPerson? = null

    // Fra IBeregningsInformasjon
    override var beregningsMetode: BeregningMetodeTypeCti? = null
    override var isEksport = false
    override var resultatType: ResultatTypeCti? = null
    var tapendeBeregningsmetodeListe: List<TapendeBeregningsmetode> = mutableListOf()
    override var trygdetid: Int? = null
    override var tt_anv = 0
    override var vurdertBosattland: LandCti? = null
    override var isEnsligPensjonInstOpph = false
    override var instOppholdType: JustertPeriodeCti? = null
    override var isInstOpphAnvendt = false

    // Avdødes tilleggspensjon
    var tp = 0.0
    var ttBeregnetForGrunnlagsrolle = 0
    var isUngUforGarantiFrafalt = false
}