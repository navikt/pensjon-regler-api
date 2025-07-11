package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.AfpPrivatLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2011
import no.nav.pensjon.regler.domain.krav.Kravhode
import java.util.*

class VilkarsprovAlderpensjonOvergangskullRequest : ServiceRequest() {
    var kravHode: Kravhode? = null
    var virkFom: Date? = null
    var afpPrivatLivsvarig: AfpPrivatLivsvarig? = null
    var afpVirkFom: Date? = null
    var sisteBeregning: SisteAldersberegning2011? = null

    /**
     * Read only property for vilkarsvedtakListe as array
     * @return array of VilkarsVedtak
     */
    var utforVilkarsberegning = false
}