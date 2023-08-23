package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.kode.AvkortingsArsakCti
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

class Ektefelletillegg : Ytelseskomponent() {
    /**
     * Fribeløpet
     */
    var fribelop = 0

    /**
     * Summen av inntektene som kan bli lagt til grunn ved avkorting, selv når det ikke fører til avkorting.
     */
    var samletInntektAvkort = 0

    /**
     * Angir om tillegget er avkortet.
     */
    var isAvkortet = false

    /**
     * årsaken(e) til avkorting. Satt dersom avkortet er true.
     */
     var arsaksList: MutableList<AvkortingsArsakCti> = mutableListOf()

    /**
     * Angir minste pensjonsnivåsats for ektefelletillegget
     */
    var mpnSatsFT = 0.0

    /**
     * Den anvendte trygdetiden i beregningen av tillegget. Kan være forskjellig fra Beregningen.tt_anv
     */
    var tt_anv = 0

    /**
     * Nedtrappingsgrad brukt ved utfasing av forsærgingstillegg fom 2023.
     */
    var forsorgingstilleggNiva = 100

    /**
     * Telleren i proratabrøken for EØS-avtaleberegnet tillegg
     */
    var proratateller = 0

    /**
     * Telleren i proratabrøken for EØS-avtaleberegnet tillegg
     */
    var proratanevner = 0

    /**
     * Flagg som forteller om ektefelletillegget er skattefritt.
     * Ektefelletillegg som utbetales til AFP og alderspensjonister skal utbetales skattefritt for de
     * som mottar ektefelletillegg pr 31. desember 2010. Fritaket gjelder ikke for de som mister
     * ektefelletillegget for ett eller flere inntektsår etter desember 2010, men senere før det tilbake.
     * Skattefritaket skal ikke gjelde alderspensjonister som tilstøs ektefelletillegg med virkning tidligst
     * 1. januar 2011
     */
    var isSkattefritak = false

    init {
        ytelsekomponentType = YtelsekomponentTypeCti("ET")
        formelKode = FormelKodeCti("ETx")
    }
}