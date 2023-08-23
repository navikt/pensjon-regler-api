package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.vedtak.EtteroppgjorResultat
import java.io.Serializable

class FerdigstillEtteroppgjorUforetrygdResponse : Serializable {
    var etteroppgjorResultat: EtteroppgjorResultat? = null
    var pakkseddel: Pakkseddel? = null
}