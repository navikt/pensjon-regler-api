package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.beregning2011.Regelendring
import java.io.Serializable
import java.util.*

/**
 * Responseobjekt for BEF2001 Identifiser regelendringer.
 */
class IdentifiserRegelendringerResponse : Serializable {
    /**
     * Listen av regel- og satsendringer som tjenesten fant for tidsrommet og input den ble kalt med.
     * Listen er ikke sortert på dato, men hver dato i listen er unik.
     */
    var regelendringListe = mutableListOf<Regelendring>()

    /**
     * Pakkseddel som indikerer om det oppstod feil ved tjenestekallet.
     */
    var pakkseddel: Pakkseddel? = null

}