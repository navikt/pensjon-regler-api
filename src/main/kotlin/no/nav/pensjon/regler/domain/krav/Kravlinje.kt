package no.nav.pensjon.regler.domain.krav

import no.nav.pensjon.regler.domain.enum.KravlinjeTypeEnum
import no.nav.pensjon.regler.domain.PenPerson
import java.io.Serializable

/**
 * En Kravlinje er en del av et KravHode. Eksempler på Kravlinje er GP, ET, UP
 * osv.
 */
open class Kravlinje : Serializable {
    /**
     * Hvilken type kravlinjen gjelder, spesifisert som VilkarsvedtakType.
     */
    var kravlinjeTypeEnum: KravlinjeTypeEnum? = null
    /**
     * Personen kravet relaterer seg til.
     */
    var relatertPerson: PenPerson? = null

    /**
     * Angir om det er hovedKravlinje
     * Erstatter hovedKravlinje på KravlinjeTypeCti
     */
    var hovedKravlinje: Boolean = false

    constructor()
    constructor(
        relatertPerson: PenPerson?,
        hovedKravlinje: Boolean = false
    ) {
        this.relatertPerson = relatertPerson
        this.hovedKravlinje = hovedKravlinje
    }
    constructor(
        kravlinjeTypeEnum: KravlinjeTypeEnum,
        relatertPerson: PenPerson?,
        hovedKravlinje: Boolean = false
    ) {
        this.relatertPerson = relatertPerson
        this.kravlinjeTypeEnum = kravlinjeTypeEnum
        this.hovedKravlinje = hovedKravlinje
    }

}