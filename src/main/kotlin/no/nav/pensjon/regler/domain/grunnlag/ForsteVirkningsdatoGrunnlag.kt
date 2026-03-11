package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.PenPerson
import no.nav.pensjon.regler.domain.enum.KravlinjeTypeEnum
import java.io.Serializable
import java.util.*
import java.time.LocalDate

class ForsteVirkningsdatoGrunnlag : Serializable {
    @Deprecated("Use virkningsdatoLd instead")
    var virkningsdato: Date? = null
    var virkningsdatoLd: LocalDate? = null
    @Deprecated("Use kravFremsattDatoLd instead")
    var kravFremsattDato: Date? = null
    var kravFremsattDatoLd: LocalDate? = null
    var bruker: PenPerson? = null
    var annenPerson: PenPerson? = null
    var kravlinjeTypeEnum: KravlinjeTypeEnum? = null
}