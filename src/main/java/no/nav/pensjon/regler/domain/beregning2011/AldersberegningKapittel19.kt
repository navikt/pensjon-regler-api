package no.nav.pensjon.regler.domain.beregning2011

/**
 * @author årnulf Moen, Decisive, Pensjonsprosjektet
 * @author Lars Hartvigsen (Decisive) - PK-12169 HL3 2015
 * @author Magnus Bakken (Accenture), PK-20716
 */
class AldersberegningKapittel19 : Beregning2011() {
    var restpensjon: Basispensjon? = null
    var basispensjon: Basispensjon? = null

    /**
     * Basispensjon regnet uten gjenlevenderettighet.
     */
    var basispensjonUtenGJR: Basispensjon? = null

    /**
     * Restpensjon regnet uten gjenlevenderettighet.
     */
    var restpensjonUtenGJR: Basispensjon? = null
    var forholdstall = 0.0
    var ftBenyttetArsakListe: List<FtDtArsak> = mutableListOf()

}