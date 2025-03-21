package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.PenPerson
import no.nav.pensjon.regler.domain.enum.KravlinjeTypeEnum
import java.io.Serializable
import java.util.*

class ForsteVirkningsdatoGrunnlag : Serializable {
    var virkningsdato: Date? = null
    var kravFremsattDato: Date? = null
    var bruker: PenPerson? = null
    var annenPerson: PenPerson? = null
    var kravlinjeTypeEnum: KravlinjeTypeEnum? = null
}