package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.PenPerson
import no.nav.pensjon.regler.domain.kode.BeregningMetodeTypeCti
import no.nav.pensjon.regler.domain.kode.JustertPeriodeCti
import no.nav.pensjon.regler.domain.kode.LandCti
import no.nav.pensjon.regler.domain.kode.ResultatTypeCti

interface IBeregningsInformasjon {
    var penPerson: PenPerson?
    var beregningsMetode: BeregningMetodeTypeCti?
    var isEnsligPensjonInstOpph: Boolean
    var instOppholdType: JustertPeriodeCti?
    var isInstOpphAnvendt: Boolean
    var resultatType: ResultatTypeCti?
    var trygdetid: Int?
    var tt_anv: Int
    var vurdertBosattland: LandCti?
    var isEksport: Boolean
}