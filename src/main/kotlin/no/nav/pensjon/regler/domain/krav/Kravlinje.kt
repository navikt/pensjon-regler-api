package no.nav.pensjon.regler.domain.krav

import no.nav.pensjon.regler.domain.enum.KravlinjeTypeEnum
import no.nav.pensjon.regler.domain.PenPerson
import no.nav.pensjon.regler.domain.enum.YtelsetypeEnum
import no.nav.pensjon.regler.domain.kode.KravlinjeTypeCti
import java.io.Serializable

/**
 * En Kravlinje er en del av et KravHode. Eksempler på Kravlinje er GP, ET, UP
 * osv.
 */
open class Kravlinje : Serializable {
    /**
     * Hvilken type kravlinjen gjelder, spesifisert som VilkarsvedtakType.
     */
    var kravlinjeType: KravlinjeTypeCti? = null
    var kravlinjeTypeEnum: KravlinjeTypeEnum? = null
    /**
     * Personen kravet relaterer seg til.
     */
    var relatertPerson: PenPerson? = null

    constructor()
    constructor(kravlinjeType: KravlinjeTypeCti?, relatertPerson: PenPerson?) {
        this.kravlinjeType = kravlinjeType
        this.relatertPerson = relatertPerson
    }
    constructor(
        kravlinjeType: KravlinjeTypeCti?,
        kravlinjeTypeEnum: KravlinjeTypeEnum,
        relatertPerson: PenPerson?
    ) {
        this.kravlinjeType = kravlinjeType
        this.relatertPerson = relatertPerson
        this.kravlinjeTypeEnum = kravlinjeTypeEnum
    }

}