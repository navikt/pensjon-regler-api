package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.grunnlag.Beholdninger
import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag
import no.nav.pensjon.regler.domain.kode.BeregningMetodeTypeCti
import no.nav.pensjon.regler.domain.kode.RegelverkTypeCti
import no.nav.pensjon.regler.domain.trygdetid.Brok
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak

/**
 * Beregning på nytt regelverk
 * Denne benyttes av 2011, 2016 og 2025
 * For 2016 vil alle feltene være aktuelle
 */
open class SisteAldersberegning2011 : SisteBeregning() {
    var regelverkType: RegelverkTypeCti? = null // Dene benyttes for å avgjøre om det er på 2011, 2016 eller 2025.
    var basispensjon: Basispensjon? = null // 2011
    var restpensjon: Basispensjon? = null // 2011
    var pensjonUnderUtbetaling: PensjonUnderUtbetaling? = null
    var pensjonUnderUtbetaling2025AltKonv: PensjonUnderUtbetaling? =
        null // PensjonUnderUtbetaling for tapende konvensjon i siste aldersberegning.
    var beholdninger: Beholdninger? = null // 2025
    var beholdningerAltKonv: Beholdninger? = null // Beholdninger for tapende konvensjon i siste aldersberegning.
    var eps: Persongrunnlag? = null
    var isEpsMottarPensjon = false
    var vilkarsvedtakEktefelletillegg: VilkarsVedtak? = null
    var avdodesPersongrunnlag: Persongrunnlag? = null
    var isGjenlevenderettAnvendt = false
    var anvendtGjenlevenderettVedtak: VilkarsVedtak? = null
    var beregningsMetode: BeregningMetodeTypeCti? = null
    var tt_anv_kap_20 = 0
    var prorataBrok_kap_20: Brok? = null
    var tt_anv_kap_20AltKonv = 0
    var prorataBrok_kap_20AltKonv: Brok? = null

}