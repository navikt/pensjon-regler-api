package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.AfpPrivatLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2011
import no.nav.pensjon.regler.domain.krav.Kravhode
import java.util.*
import java.time.LocalDate

class VilkarsprovAlderpensjonOvergangskullRequest : ServiceRequest() {
    var kravHode: Kravhode? = null
    @Deprecated("Use virkFomLd instead")
    var virkFom: Date? = null
    var virkFomLd: LocalDate? = null
    var afpPrivatLivsvarig: AfpPrivatLivsvarig? = null
    @Deprecated("Use afpVirkFomLd instead")
    var afpVirkFom: Date? = null
    var afpVirkFomLd: LocalDate? = null
    var sisteBeregning: SisteAldersberegning2011? = null

    /**
     * Read only property for vilkarsvedtakListe as array
     * @return array of VilkarsVedtak
     */
    var utforVilkarsberegning = false
}