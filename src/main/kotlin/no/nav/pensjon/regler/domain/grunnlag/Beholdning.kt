package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.Opptjening
import no.nav.pensjon.regler.domain.beregning2011.LonnsvekstInformasjon
import no.nav.pensjon.regler.domain.beregning2011.ReguleringsInformasjon
import no.nav.pensjon.regler.domain.kode.BeholdningsTypeCti
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import java.io.Serializable

abstract class Beholdning protected constructor() : Serializable {
    var ar = 0
    var totalbelop = 0.0
    var opptjening: Opptjening? = null
    var lonnsvekstInformasjon: LonnsvekstInformasjon? = null
    var reguleringsInformasjon: ReguleringsInformasjon? = null
    var formelkode: FormelKodeCti? = null
    var beholdningsType: BeholdningsTypeCti? = null
    var merknadListe: MutableList<Merknad> = mutableListOf()
}