package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.BeregningsvilkarPeriode
import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag
import no.nav.pensjon.regler.domain.grunnlag.Uttaksgrad
import no.nav.pensjon.regler.domain.kode.KravlinjeTypeCti
import no.nav.pensjon.regler.domain.kode.RegelverkTypeCti
import java.util.*

/**
 * Dataoverføringsobjekt, inndata, for tjenesten fastsettTrygdetid.
 */
class TrygdetidRequest {
    /**
     * Virkningstidspunktets fom. for ønsket ytelse.
     */
    var virkFom: Date? = null

    /**
     * Tom for trygdetiden som skal beregnes. Kun for AP2011, AP2016 og AP2025.
     */
    var virkTom: Date? = null

    /**
     * Første virkningstidspunkt,denne må være satt dersom personen er SOKER i persongrunnlaget.
     */
    var brukerForsteVirk: Date? = null

    /**
     * Type ytelse (AP,UP osv)
     */
    var ytelsesType: KravlinjeTypeCti? = null

    /**
     * Persongrunnlag for personen.
     * Dersom ytelsesType er UP må uforegrunnlag og uforehistorikk være utfylt.
     */
    var persongrunnlag: Persongrunnlag? = null

    /**
     * Angir om personen har bodd eller arbeidet i utlandet.
     */
    var boddEllerArbeidetIUtlandet = false

    /**
     * Regelverktype bestemmer om trygdetid skal regnes etter gamle eller nye regler.
     */
    var regelverkType: RegelverkTypeCti? = null
    var uttaksgradListe: MutableList<Uttaksgrad> = mutableListOf()
        get() = field
        set(value) {
            sorterUttaksgradListe()
            field = value
        }
    var redusertFTTUT: Boolean? = null

    /**
     * Liste av beregningsvilkarPerioder, påkrevd ved uføretrygd.
     */
    var beregningsvilkarPeriodeListe: MutableList<BeregningsvilkarPeriode> = mutableListOf()

    /**
     * Sorterer på nyeste fomDato - denne blir uttaksgradListe.get(0)
     */
    private fun sorterUttaksgradListe() {
        Collections.sort(uttaksgradListe, Collections.reverseOrder())
        return
    }
}