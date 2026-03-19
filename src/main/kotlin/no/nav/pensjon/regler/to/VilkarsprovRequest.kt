package no.nav.pensjon.regler.to

import com.fasterxml.jackson.annotation.JsonAlias
import no.nav.pensjon.regler.domain.beregning2011.SisteBeregning
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*
import java.time.LocalDate

class VilkarsprovRequest : ServiceRequest {
    var kravhode: Kravhode? = null
    var sisteBeregning: SisteBeregning? = null
    @Deprecated("Use virkLd instead")
    @JsonAlias("fom")
    var virk: Date? = null
    @JsonAlias("fomLd")
    var virkLd: LocalDate? = null
    @Deprecated("Use tomLd instead")
    @JsonAlias("tom")
    var tom: Date? = null
    var tomLd: LocalDate? = null
    var vilkarsvedtakliste: List<VilkarsVedtak> = mutableListOf()

    constructor()

    @Deprecated("Use virkLd/tomLd constructor instead")
    constructor(kravhode: Kravhode?, sisteBeregning: SisteBeregning?, virk: Date?, tom: Date?) {
        this.kravhode = kravhode
        this.sisteBeregning = sisteBeregning
        this.virk = virk
        this.tom = tom
        this.vilkarsvedtakliste = mutableListOf()
    }

    constructor(kravhode: Kravhode?, sisteBeregning: SisteBeregning?, virk: LocalDate?, tom: LocalDate?) {
        this.kravhode = kravhode
        this.sisteBeregning = sisteBeregning
        this.virkLd = virk
        this.tomLd = tom
        this.vilkarsvedtakliste = mutableListOf()
    }
}