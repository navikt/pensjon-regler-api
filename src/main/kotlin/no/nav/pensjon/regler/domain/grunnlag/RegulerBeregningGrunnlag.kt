package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.io.Serializable
import java.util.*
import java.time.LocalDate

class RegulerBeregningGrunnlag : Serializable {
    var beregning1967: Beregning? = null
    @Deprecated("Use virkFomLd instead")
    var virkFom: Date? = null
    var virkFomLd: LocalDate? = null
    var uttaksgradListe: List<Uttaksgrad> = mutableListOf()
    var brukersVilkarsvedtakListe: List<VilkarsVedtak> = mutableListOf()
    var sokersPersongrunnlag: Persongrunnlag? = null
    var epsPersongrunnlag: Persongrunnlag? = null
    var pakkseddel: Pakkseddel? = null
}