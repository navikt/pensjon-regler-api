package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.PenPerson
import no.nav.pensjon.regler.domain.enum.BorMedTypeEnum
import no.nav.pensjon.regler.domain.enum.GrunnlagkildeEnum
import no.nav.pensjon.regler.domain.enum.GrunnlagsrolleEnum
import no.nav.pensjon.regler.domain.enum.SivilstandEnum
import java.io.Serializable
import java.util.*

/**
 * PersonDetalj inneholder persondetaljer som er relevante for fastsettelse av vedtak i Pensjonsløsningen,
 * dvs detaljer om den faktiske rollen en bruker har i et krav, sivilstand , pensjonsfaglig vurdert
 * sivilstand og barn for en definert periode.
 */
open class PersonDetalj : Serializable {
    /**
     * Rollen denne personen har i kontekst av kravet.
     */
    var grunnlagsrolleEnum: GrunnlagsrolleEnum? = null

    /**
     * Fra-og-med dato for rollens gyldighet.
     */
    var rolleFomDato: Date? = null

    /**
     * Til-og-med dato for rollens gyldighet.
     */
    var rolleTomDato: Date? = null

    /**
     * Representerer personens sivilstand i henhold til TPS.
     */
    var sivilstandTypeEnum: SivilstandEnum? = null

    /**
     * Eventuell angivelse av hvilken annen person som sivilstandType relaterer seg til,
     * for eksempel ektefelle eller samboer.
     */
    var sivilstandRelatertPerson: PenPerson? = null

    /**
     * Representerer om og hvordan personen bor sammen med en annen person med persongrunnlag på kravet.
     * Refereres konseptuelt som pensjonsfaglig vurdert sivilstand.
     */
    var borMedEnum: BorMedTypeEnum? = null

    /**
     * Detaljer om barnet hvis rolle=BARN. Angir om barnet bor med en annen forelder.
     */
    var barnDetalj: BarnDetalj? = null

    /**
     * Angir om det er opprettet barne- eller ektefelletillegg kravlinje for persongrunnlaget
     * med gitt rolle.
     */
    var tillegg = false

    /**
     * Angir om persondetaljen brukes som grunnlag på kravet.
     */
    var bruk: Boolean = true

    /**
     * Angir kilden til persondetaljen.
     */
    var grunnlagKildeEnum: GrunnlagkildeEnum? = null

    var serskiltSatsUtenET: Boolean? = null
    var epsAvkallEgenPensjon: Boolean? = null
}