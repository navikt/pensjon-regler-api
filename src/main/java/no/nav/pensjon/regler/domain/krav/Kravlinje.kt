package no.nav.pensjon.regler.domain.krav

import no.nav.pensjon.regler.domain.PenPerson
import no.nav.pensjon.regler.domain.kode.KravlinjeTypeCti
import java.io.Serializable

/**
 * En Kravlinje er en del av et KravHode. Eksempler på Kravlinje er GP, ET, UP
 * osv.
 */
class Kravlinje : Serializable {
    /**
     * Hvilken type kravlinjen gjelder, spesifisert som VilkarsvedtakType.
     */
    var kravlinjeType: KravlinjeTypeCti? = null

    /**
     * Personen kravet relaterer seg til.
     */
    var relatertPerson: PenPerson? = null

}