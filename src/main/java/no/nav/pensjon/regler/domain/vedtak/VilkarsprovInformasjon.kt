package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.beregning2011.AfpLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.FremskrevetAfpLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.FremskrevetPensjonUnderUtbetaling
import no.nav.pensjon.regler.domain.beregning2011.PensjonUnderUtbetaling
import java.io.Serializable

abstract class VilkarsprovInformasjon : Serializable {
    var isEktefelleInntektOver2g = false
    var isFlyktning = false
    var fullPensjonVed67: FremskrevetPensjonUnderUtbetaling? = null
    var pensjonVedUttak: PensjonUnderUtbetaling? = null
    var fremskrevetAfpLivsvarig: FremskrevetAfpLivsvarig? = null
    var afpLivsvarigVedUttak: AfpLivsvarig? = null
    var isAfpLivsvarigBrukt = false
    var fremskrevetPensjonVed67 = 0.0
    var samletPensjonVed67PerAr = 0.0
}