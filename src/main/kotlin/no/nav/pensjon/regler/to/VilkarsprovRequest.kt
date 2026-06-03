package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.SisteBeregning
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.time.LocalDate

class VilkarsprovRequest : ServiceRequest {
    var kravhode: Kravhode? = null
    var sisteBeregning: SisteBeregning? = null
    var fomLd: LocalDate? = null
    var tomLd: LocalDate? = null
    var vilkarsvedtakliste: List<VilkarsVedtak> = mutableListOf()

    constructor()


    constructor(kravhode: Kravhode?, sisteBeregning: SisteBeregning?, fom: LocalDate?, tom: LocalDate?) {
        this.kravhode = kravhode
        this.sisteBeregning = sisteBeregning
        this.fomLd = fom
        this.tomLd = tom
        this.vilkarsvedtakliste = mutableListOf()
    }
}