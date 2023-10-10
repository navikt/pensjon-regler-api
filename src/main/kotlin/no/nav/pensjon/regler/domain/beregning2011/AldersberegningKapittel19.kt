package no.nav.pensjon.regler.domain.beregning2011

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