package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.PenPerson
import no.nav.pensjon.regler.domain.enum.GrunnlagkildeEnum
import no.nav.pensjon.regler.domain.enum.SivilstandEnum
import java.io.Serializable
import java.util.*
import java.time.LocalDate

class Sivilstand : Serializable {
    /**
     * Kode som angir hvilken type sivilstand personen har.
     */
    var sivilstandTypeEnum: SivilstandEnum? = null

    /**
     * Sivilstandens gyldighet fra-og-med dato.
     */
    @Deprecated("Use fomLd instead")
    var fom: Date? = null
    var fomLd: LocalDate? = null

    /**
     * Sivilstandens gyldighet til-og-med dato
     */
    @Deprecated("Use tomLd instead")
    var tom: Date? = null
    var tomLd: LocalDate? = null

    /**
     * Person sivilstanden refererer seg til, for eksempel ektefellen hvis *sivilstandType*="Ektefelle"
     */
    var relatertPerson: PenPerson? = null

    /**
     * Angir sivilstandens kilde.
     */
    var kildeEnum: GrunnlagkildeEnum? = null

}