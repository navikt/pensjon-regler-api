package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.AvtaleDatoEnum
import no.nav.pensjon.regler.domain.enum.AvtaleKritEnum
import no.nav.pensjon.regler.domain.enum.AvtaletypeEnum
import no.nav.pensjon.regler.domain.enum.LandkodeEnum
import java.io.Serializable
import java.util.*

class Trygdeavtale : Serializable {
    /**
     * Hvilket land personen bor i. Se /2/, arkfane K_AVTALELAND_T
     */
    var bostedslandEnum: LandkodeEnum? = null

    /**
     * Hva slags type avtale som er inngått. Se /2/, arkfane K_AVTALE_T.
     */
    var avtaleTypeEnum: AvtaletypeEnum? = null

    /**
     * Felt for å registrere når avtalen tro i kraft, hvis avtaletypen tilsier at
     * landet har flere mulige avtaler med Norge. Se /2/, arkfane K_AVTALE_DATO.
     */
    var avtaledatoEnum: AvtaleDatoEnum? = null

    /**
     * Felt for å registrere kriterier som er oppfylt for å omfattes av trygdeavtalen.
     * Se /2/, arkfane K_AVTALE_KRIT_T.
     */
    var avtaleKriterieEnum: AvtaleKritEnum? = null

    /**
     * Angir om personen omfattes av avtalens personkrets
     */
    var omfattesavAvtalensPersonkrets = false

    /**
     * Dato for kravdato i avtale
     */
    var kravDatoIAvtaleland: Date? = null
}