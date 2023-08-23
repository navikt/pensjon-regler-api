package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.AvkortingsArsakCti
import java.io.Serializable

abstract class AbstraktBarnetillegg protected constructor() : Ytelseskomponent(), Serializable {
    /**
     * Antall barn i kullet.
     */
    var antallBarn = 0

    /**
     * Angir om tillegget er avkortet.
     */
    var avkortet = false

    /**
     * Differansetillegg ved barnetillegg. Anvendes dersom primårt land for BT er et annet EØS land
     */
    var btDiff_eos = 0

    /**
     * Anvendt fribeløp.
     */
    var fribelop = 0

    /**
     * Angir minste pensjonsnivåsats for ektefelletillegget
     */
    var mpnSatsFT = 0.0

    /**
     * Nevneren i proratabrøken for EØS-avtaleberegnet tillegg
     */
    var proratanevner = 0

    /**
     * Telleren i proratabrøken for EØS-avtaleberegnet tillegg
     */
    var proratateller = 0

    /**
     * Summen av inntektene som kan bli lagt til grunn ved avkorting, selv når det ikke fører til avkorting.
     */
    var samletInntektAvkort = 0

    /**
     * Den anvendte trygdetiden i beregningen av tillegget. Kan være forskjellig fra tt_anv.
     */
    var tt_anv = 0

    /**
     * Nedtrappingsgrad brukt ved utfasing av forsærgingstillegg fom 2023.
     */
    var forsorgingstilleggNiva = 100

    /**
     * årsaken(e) til avkorting. Satt dersom avkortet er true.
     */
    var avkortingsArsakList: List<AvkortingsArsakCti> = mutableListOf()

}