package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.kode.AvtaleDatoCti
import no.nav.pensjon.regler.domain.kode.AvtaleKritCti
import no.nav.pensjon.regler.domain.kode.AvtaleTypeCti
import no.nav.pensjon.regler.domain.kode.LandCti
import java.io.Serializable
import java.util.*

class Trygdeavtale : Serializable {
    /**
     * Hvilket land personen bor i. Se /2/, arkfane K_AVTALELAND_T
     */
    var bostedsland: LandCti? = null

    /**
     * Hva slags type avtale som er inngått. Se /2/, arkfane K_AVTALE_T.
     */
    var avtaleType: AvtaleTypeCti? = null

    /**
     * Felt for å registrere når avtalen tro i kraft, hvis avtaletypen tilsier at
     * landet har flere mulige avtaler med Norge. Se /2/, arkfane K_AVTALE_DATO.
     */
    var avtaledato: AvtaleDatoCti? = null

    /**
     * Felt for å registrere kriterier som er oppfylt for å omfattes av trygdeavtalen.
     * Se /2/, arkfane K_AVTALE_KRIT_T.
     */
    var avtaleKriterie: AvtaleKritCti? = null

    /**
     * Angir om personen omfattes av avtalens personkrets
     */
    var isOmfattesavAvtalensPersonkrets = false

    /**
     * Dato for kravdato i avtale
     */
    var kravDatoIAvtaleland: Date? = null
}