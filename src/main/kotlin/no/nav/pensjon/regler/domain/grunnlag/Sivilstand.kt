package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.PenPerson
import no.nav.pensjon.regler.domain.enum.GrunnlagkildeEnum
import no.nav.pensjon.regler.domain.enum.SivilstandEnum
import no.nav.pensjon.regler.domain.kode.GrunnlagKildeCti
import no.nav.pensjon.regler.domain.kode.SivilstandTypeCti
import java.io.Serializable
import java.util.*

class Sivilstand : Serializable {
    /**
     * Kode som angir hvilken type sivilstand personen har.
     */
    var sivilstandType: SivilstandTypeCti? = null
    var sivilstandTypeEnum: SivilstandEnum? = null

    /**
     * Sivilstandens gyldighet fra-og-med dato.
     */
    var fom: Date? = null

    /**
     * Sivilstandens gyldighet til-og-med dato
     */
    var tom: Date? = null

    /**
     * Person sivilstanden refererer seg til, for eksempel ektefellen hvis *sivilstandType*="Ektefelle"
     */
    var relatertPerson: PenPerson? = null

    /**
     * Angir sivilstandens kilde.
     */
    var kilde: GrunnlagKildeCti? = null
    var kildeEnum: GrunnlagkildeEnum? = null

}