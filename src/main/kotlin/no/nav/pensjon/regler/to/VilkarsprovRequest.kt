package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.SisteBeregning
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*

class VilkarsprovRequest {
    var kravhode: Kravhode? = null
    var sisteBeregning: SisteBeregning? = null
    var fom: Date? = null
    var tom: Date? = null
    var vilkarsvedtakliste: MutableList<VilkarsVedtak> = mutableListOf()

    constructor()
    constructor(kravhode: Kravhode?, sisteBeregning: SisteBeregning?, fom: Date?, tom: Date?) {
        this.kravhode = kravhode
        this.sisteBeregning = sisteBeregning
        this.fom = fom
        this.tom = tom
        this.vilkarsvedtakliste = mutableListOf()
    }

}