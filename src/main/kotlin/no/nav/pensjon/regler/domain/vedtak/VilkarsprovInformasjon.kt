package no.nav.pensjon.regler.domain.vedtak

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.beregning2011.AfpPrivatLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.FremskrevetAfpLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.FremskrevetPensjonUnderUtbetaling
import no.nav.pensjon.regler.domain.beregning2011.PensjonUnderUtbetaling
import java.io.Serializable

@JsonSubTypes(
    JsonSubTypes.Type(value = VilkarsprovInformasjon2011::class),
    JsonSubTypes.Type(value = VilkarsprovInformasjon2016::class),
    JsonSubTypes.Type(value = VilkarsprovInformasjon2025::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
abstract class VilkarsprovInformasjon : Serializable {
    var ektefelleInntektOver2g = false
    var flyktning = false
    @Deprecated("Avvikles.", replaceWith = ReplaceWith("fullPensjonVedNormertPensjonsalder"))
    var fullPensjonVed67: FremskrevetPensjonUnderUtbetaling? = null
    var fullPensjonVedNormertPensjonsalder: FremskrevetPensjonUnderUtbetaling? = null
    var pensjonVedUttak: PensjonUnderUtbetaling? = null
    var fremskrevetAfpLivsvarig: FremskrevetAfpLivsvarig? = null
    var afpPrivatLivsvarigVedUttak: AfpPrivatLivsvarig? = null
    var afpLivsvarigBrukt = false
    @Deprecated("Avvikles.", replaceWith = ReplaceWith("fremskrevetPensjonVedNormertPensjonsAlder"))
    var fremskrevetPensjonVed67 = 0.0
    var fremskrevetPensjonVedNormertPensjonsAlder = 0.0
    @Deprecated("Avvikles.", replaceWith = ReplaceWith("samletPensjonVedNormertPensjonsAlder"))
    var samletPensjonVed67PerAr = 0.0
    var samletPensjonVedNormertPensjonsAlder = 0.0
}