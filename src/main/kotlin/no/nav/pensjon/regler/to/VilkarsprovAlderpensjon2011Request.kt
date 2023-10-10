package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.AfpLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2011
import no.nav.pensjon.regler.domain.grunnlag.ForholdstallUtvalg
import no.nav.pensjon.regler.domain.krav.Kravhode
import java.util.*

class VilkarsprovAlderpensjon2011Request {
    var kravHode: Kravhode? = null
    var fom: Date? = null
    var tom: Date? = null
    var afpVirkFom: Date? = null
    var forholdstallUtvalg: ForholdstallUtvalg? = null
    var afpLivsvarig: AfpLivsvarig? = null
    var sisteBeregning: SisteAldersberegning2011? = null
    var utforVilkarsberegning = false
}